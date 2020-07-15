<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .block{
            width: 23.5%;
            height: 50%;
            float: left;
            border: #D0D0D0 1px solid;
            margin-right: 1.2%;
            margin-top: 1%;
        }
        .block ul{
            list-style-type: none;
            width: 100%;
            height: 100%;
            margin-left: -25%;
            margin-top: 0%;
        }
        .block ul li{
            text-align: center;
            margin-bottom: 3%;
        }
        .block li a{
            display: inline-block;
            text-decoration: none;
            color: black;
            font-size: 14px;
            font-weight: bold;
            width: 100%;
        }
        .left li a:hover{
            background-color: #C4102F;
            color: white;
        }
        .block img{
            width: 99%;
            height: 50%;
        }
        .block .price{
            font-size: 14px;
            color: #C4102F;
        }
        .block .btn{
            display: inline-block;
            background-color: #C4102F;
            color: white;
            text-align: center;
            width: 80%;
            line-height: 30px;
        }
        #d1{
            width: 400px;
            height: 300px;
            z-index: 2;
            position: fixed;
            top: 50%;
            left: 50%;
            margin-left: -200px;
            margin-top: -150px;
            overflow: hidden;
            display: none;
            background-color: white;
        }
        #d2{
            position: fixed;
            left: 0;
            top:0;
            width: 100%;
            height: 100%;
            background-color: grey;
            z-index: 1;
            opacity: 0.8;
            display: none;
        }
        .top{
            width: 100%;
            height: 8%;
        }
        .main{
            width: 100%;
            height: 90%;
            margin-top: 2%;
            background-color: white;
        }
        .main .right{
            width: 40%;
            height:100%;
            float: left;
        }
        .main img{
            margin-top: 20%;
            margin-left: 5%;
            width: 90%;
            border: #D0D0D0 1px solid;
        }
        .main .left{
            margin-left: 5%;
            width: 55%;
            height:100%;
            float: left;
        }
        .main .name{
            margin-top: 15%;
            display: inline-block;
            text-decoration: none;
            color: black;
            font-size: 14px;
            font-weight: bold;
            width: 100%;
        }
        .main .price{
            margin-top: 5%;
            font-size: 14px;
            color: #C4102F;
            font-weight: bold;
        }
        .main .remark{
            margin-left: 3%;
            margin-top: 10%;
            display: inline-block;
            text-decoration: none;
            text-align: left;
            color: black;
            font-size: 12px;
            width: 100%;
        }
        .top a{
            float: left;
            margin-left: 95%;
            margin-top: 1%;
            text-align: left;
            text-decoration: none;
            color: #3A3C3D;
            opacity: 0.5;
        }
        
        .top a:hover{
            opacity: 1;
        }
        .button{
            cursor: pointer;
            background-color: white;
            outline: none;
            border: none;
        }
    </style>
    <!--    使用jquery需要引入jquery环境：CDN-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
     <script>
        function chickMe() {
            let d2=document.getElementById("d2");
            d2.style.display="block";
            let d1=document.getElementById("d1");
            d1.style.display="block";
        }
        function cancel() {
            let d2=document.getElementById("d2");
            d2.style.display="none";
            let d1=document.getElementById("d1");
            d1.style.display="none";
            console.log("您点击了取消");
        }
    </script>
</head>
<body>
<div id="d2"></div>
    <!-- 遍历显示数据库中的餐品信息 -->
    <c:forEach items="${currMeals }" var="meal">
    <div class="block">
        <ul>
            <li><img src="images/${meal.mimg}"></li>
            <!--<li><a href="meal/mealdetail?mid=${meal.id}">${meal.mname}</a></li>  -->
            <li>
            	<button onclick="chickMe()" class="button">${meal.mname}</button>
	            <div id="d1">
	                <div class="top">
	            		<a href="javascript:void(0)" onclick="cancel()" class="cancel">&#935;</a>
	        		</div>
	        		 <div class="main">
	            		<div class="right">
	                		<img src="images/${meal.mimg }">
	            		</div>
	        		 	<div class="left">
	            			<ul>
	                			<li class="name">${meal.mname}</li>
	                			<li class="price">${meal.price}<span>元起/份</span></li>
	                			<li class="remark">${meal.remark}</li>
	            			</ul>
	         			</div>
	     			</div>
	            </div>
            </li>
            <li class="price">${meal.price}<span>元起/份</span></li>
            <li>
                <a href="meal/addCar?mid=${meal.id}" class="btn" onclick="alert('添加成功！')">加入购物车</a>
            </li>
        </ul>
    </div>
    </c:forEach>
</body>
</html>