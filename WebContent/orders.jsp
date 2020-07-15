<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table{
            width: 80%;
            margin-left: 10%;
            text-align: center;
            border-collapse: collapse;/*合并边框线*/
            margin-top: 20px;
            font-size: 15px;
        }
        table,td,th{
            border:1px #999 solid;
        }
        a{
            text-decoration: none;
            color: black;
        }
        .btn{
            display: inline-block;
            background-color: #C4102F;
            color: white;
            text-align: center;
            width: 100px;
            height: 30px;
            line-height: 30px;
        }
        tr{
            height: 40px;
        }
        td,th{
            width: 25%;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>订单编号</th>
            <th>价格</th>
            <th>下单时间</th>
            <th>订单详情</th>
        </tr>
        <!-- 遍历显示数据库中的书籍信息 -->
        <c:forEach items="${orders }" var="order">
        <tr>
            <td>${order.oid }</td>
            <td>${order.price }</td>
            <td>${order.otime }</td>
            <td>
            	 <a href="order/orderdetail?id=${order.id }" class="btn" target="main">查看订单详情</a>
            </td>
        </tr>
        </c:forEach>

    </table>
</body>
</html>