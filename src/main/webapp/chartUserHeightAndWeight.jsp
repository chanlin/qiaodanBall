
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
    <title>Title</title>
    <style>

        table td{
            border:1px solid #000;
            line-height:30px;
            text-align:center;
            width:150px;
        }
    </style>
</head>
<body>
<table  border="1" style="border-collapse: collapse">
    <tr>
        <td></td>
    <td>总人数</td>
    <td>男女比例</td>
    <td>男身高均值</td>
    <td>女身高均指</td>
    <td>男体重均值</td>
    <td>女体重均值</td>
    </tr>
    <tr>
        <td>注册</td>
       
            <td>${s.Number}</td>
            <td>${s.scale}</td>
            <td>${s.Wheight}</td>
            <td>${s.Mheight}</td>
            <td>${s.Weight}</td>
            <td>${s.Brggr}</td>
    </tr>
    <tr>
        <td>活跃</td>
            <td>${D.Number}</td>
            <td>${D.scale}</td>
            <td>${D.Wheight}</td>
            <td>${D.Mheight}</td>
            <td>${D.Weight}</td>
            <td>${D.Brggr}</td>
    </tr>
</table>
</body>
</html>