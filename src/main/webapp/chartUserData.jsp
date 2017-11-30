<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<style>

    table td{
        border:1px solid #000;
        line-height:30px;
        text-align:center;
        width:50px;
    }
</style>
<body>
<table border="1" style="border-collapse:collapse">
    <tr>
        <td>用户名</td>
        <td>昵称</td>
        <td>性别</td>
        <td>年龄</td>
        <td>身高体重</td>
        <td>球场位置</td>
        <td>运动记录时间</td>
        <td>打球时长</td>
        <td>活跃度</td>
        <td>平均速度</td>
        <td>卡路里</td>
        <td>总步数</td>
        <td>纵向距离</td>
        <td>横向距离</td>
        <td>纵跳次数</td>
    </tr>
    <c:forEach itmes="${moveDates}" var="m">
        <tr>
            <td>${m.userNmae}</td>
            <td>${m.Nickname}</td>
            <td>${m.gender}</td>
            <td>${m.age}</td>
            <td>${m.weight}</td>
            <td>${m.location}</td>
            <td>${m.lastTime}</td>
            <td>${m.bsTime}</td>
            <td>${m.live}</td>
            <td>${m.speed}</td>
            <td>${m.calorie}</td>
            <td>${m.step}</td>
            <td>${m.long}</td>
            <td>${m.cross}</td>
            <td>${m.degree}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>