<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <style>
        body{
            /*  background-color: green;*/
            height: 650px;
        }
        *{
            margin: 0;
            padding: 0;
        }
        .top{
            width: 90%;
            margin-left: 5%;
            height:20% ;
            /*background-color: orange;*/
        }
        .main{
            width:90%;
            margin-left: 5%;
            height: 70%;
            border-top: #C4102F 1px solid;
        }
        .end{
            width:90%;
            margin-left: 5%;
            height: 10%;
            border-top: #DFDFDF 1px solid;
        }
        .personal{
            width: 100%;
            height: 20%;
            /*border-bottom: #C4102F 1px solid;*/
            /*background-color: white;*/
        }
        .top_main{
            width: 100%;
            height: 80%;
            /*background-color: #999;*/
        }
        .personal ul{
            list-style-type: none;
            float: right;
        }
        .personal li{
            float: left;
            margin-left: 10px;
            font-size: 14px;

        }

        .personal .btn{
            text-decoration: none;
            color: #000;
            display: inline-block;
            width: 70px;
            text-align: center;
            background-color: #F0F0F0;
        }
        .personal .btn:hover{
            color: white;
            background-color: #C4102F;
        }
        .logo{
            width: 20%;
            height: 100%;
            /*background-color: deeppink;*/
            float: left;
        }
        .logo img{
            width: 100%;
            height: 100%;
        }
        .search{
            width: 70%;
            height: 100%;
            margin-left: 30%;
            /*background-color: greenyellow;*/
        }
        .search input{
            margin-top: 5%;
            border:1px #C4102F solid;

        }
        .search .txt{
            width: 300px;
            height: 30px;
        }
        .search .btn{
            width: 70px;
            height: 32px;
            background-color: #C4102F;
            color: white;
            position: relative;
            left: -4px;
        }
        .left{
            width: 18%;
            height: 90%;
            margin-top: 1%;
            border: #C4102F 1px solid;
            float: left;
        }
        .right{
            width: 62%;
            height: 90%;
            margin-top: 0%;
            margin-left: 19%;
        }

        .right .right_top{
            margin-top: 1%;
            height:7%;
            border: #F0F0F0 1px solid;
            border-radius: 5px;
            background-color: #F0F0F0;
        }
        .right .right_top ul{
            list-style-type: none;
        }
        .right .right_top ul li{
            float:left;
            line-height: 25px;
        }
        .right .right_top img{
            height: 20px;
            wdith: 20px;
            margin-top: 4px;
        }
        .right .right_text{
            color:#505050;
            font-size: 14px;
            font-weight: bold
        }
        .right .right_end{
            margin-top: 1%;
            height:90%;
        }
        .left ul{
            list-style-type: none;
            margin-top: 2%;
        }
        .left .title{
            margin-right: 1%;
            margin-left: 1%;
            background-color: #C4102F;
            color: white;
        }
        .left .main_title{
            margin-top: 1%;
            margin-right: 1%;
            margin-left: 1%;
            color: white;
            background-color: #00B025;
        }
        .left .main_title2{
            margin-top: 1%;
            margin-right: 1%;
            margin-left: 1%;
            color: white;
            background-color: #F58316;
        }
        .left .main_title3{
            margin-top: 1%;
            margin-right: 1%;
            margin-left: 1%;
            color: white;
            background-color: #0C1A43;
        }
        .left li{
            text-align: center;
            line-height: 30px;
        }
        .left li a{
            display: inline-block;
            text-decoration: none;
            color: black;
            width: 100%;
        }
        .left li a:hover{
            background-color: #C4102F;
            color: white;
        }
        .left .column li{
            text-align: center;
            line-height: 30px;
        }
        .right iframe{
            width: 100%;
            height: 100%;
        }
        .end ul{
            list-style-type: none;
            margin-top: 1%;
        }
        .end ul li{
            font-size: 12px;
            float: left;
            text-align: center;
            line-height: 30px;
        }
        .end li a{
            color: #9EA5A5;
            display: inline-block;
            text-decoration: none;
        }
        .end li a:hover{
            text-decoration: underline;
        }
        .end .bg{
            width: 6%;
            line-height: 80%;
            border-right: #9EA5A5 1px solid;
        }
        .end .noBg{
            width: 6%;
            line-height: 80%;
            margin-left: 1%;
        }
        .end .record_li{
            width: 12%;
            line-height: 80%;
            margin-left: 1%;
        }

        .left .column{
            display: none;
        }
        .left input[type='checkbox']{
            display: none;
        }
        .left input[type="checkbox"]:checked ~ ul{
            display: block;
        }
        .left .check{
            /*border-right: #C4102F 1px solid;*/
            /*border-left: #C4102F 1px solid;*/
            color: black;
            background-color: white;
            border-top: #F0DFD4 1px solid;
        }
        .left .check:hover{
            background-color: #C4102F;
            color: white;
        }
    </style>
    <!--    使用jquery需要引入jquery环境：CDN-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <!--    javascript代码-->
    <script>
        // jquery
        $(function(){
            $("input[name='meal']").click(function(){
                if($(this).prop("checked")){
                    $("input[name='meal']").prop("checked",false);
                    $(this).prop("checked",true);
                }
            });
        })
    </script>
</head>
<body>
<div class="top">
    <div class="personal">
        <ul>
            <!-- 获取session域中当前用户 -->
            <li><span>${currUser.username }</span></li>
            <li><a href="car.jsp" target="main" class="btn">购物车</a></li>
            <li><a href="order/selectByUser" target="main" class="btn">历史订单</a></li>
            <li><a href="user/logout" class="btn">LOGOUT</a></li>
        </ul>
    </div>
    <div class="top_main">
        <div class="logo">
            <img src="images/kfclogo.png" alt="KFCLOGO.png">
        </div>
        <div class="search">
            <form action="meal/search" method="post" target="main">
                <input type="text" name="input" placeholder="请输入食品名称" class="txt" >
                <input type="submit" value="搜索" class="btn">
            </form>
        </div>
    </div>

</div>
<div class="main">
    <div class="left">
        <ul>
            <li class="title">网上订餐 天天优惠</li>
            <li class="main_title">
                    <input type="checkbox" id="check" name="meal"/>
                    <label for="check" >早餐（05:45-09:14）</label>
                    <ul class="column">
                        <c:forEach items="${breakfasttypes }" var="breakfasttype">
                    		<li><a href="meal/findByType?typeid=${breakfasttype.id }" target="main" class="check">${breakfasttype.typeName }</a></li>
                	    </c:forEach>
                    </ul>
            </li>
            <li class="main_title2">
                <input type="checkbox" id="check2" name="meal"/>
                <label for="check2" >正餐（09:15-22:44）</label>
                <ul class="column">
                    <c:forEach items="${lunchtypes }" var="lunchtype">
                    	<li><a href="meal/findByType?typeid=${lunchtype.id }" target="main" class="check">${lunchtype.typeName }</a></li>
                	</c:forEach>
                </ul>
            </li>
            <li class="main_title3">
                <input type="checkbox" id="check3" name="meal"/>
                <label for="check3" >晚餐（22:45-次日05:44）</label>
                <ul class="column">
                   <c:forEach items="${dinnertypes }" var="dinnertype">
                    	<li><a href="meal/findByType?typeid=${dinnertype.id }" target="main" class="check">${dinnertype.typeName }</a></li>
                   </c:forEach>
                </ul>
            </li>
        </ul>
    </div>
    <div class="right">
        <div class="right_top">
            <ul>
                <li><img src="images/speaker.png" alt="喇叭" class="speaker"></li>
                <li><span class="right_text">>最新活动:</span></li>
            </ul>
        </div>
        <div class="right_end">
            <iframe name="main"  src="meals.jsp" scrolling="auto" frameborder="no"></iframe>
        </div>
    </div>
</div>
<div class="end">
    <ul>
        <li class="bg" ><a href="" target="_blank">使用条款 </a></li>
        <li class="bg"><a href="" target="_blank">隐私政策 </a></li>
        <li class="bg"><a href="" target="_blank">经营公式 </a></li>
        <li class="bg"><a href="" target="_blank">联系我们 </a></li>
        <li class="bg"><a href="" target="_blank">加入我们 </a></li>
        <li class="noBg"><a href="" target="_blank">ICP备案信息 </a></li>
        <li class="record_li"><a href="" target="_blank">沪ICP备 17029211-1号</a></li>
    </ul>
</div>
</body>
</html>