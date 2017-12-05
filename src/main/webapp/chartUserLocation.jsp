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
    <style>

        table td{
            border:1px solid #000;
            line-height:30px;
            text-align:center;
            width:180px;
        }
    </style>
</head>
<body>
    <table border="1" style="border-collapse:collapse">
        <tr>
            <th>省份/地区</th>
            <th>注册数量</th>
            <th>活跃数量</th>
        </tr>
        <%-- <c:forEach itmes="${moveDatas}" var="move" varStatus="moveIndex"> --%>
            <tr>
                <td>${move.provice}</td>
                <td>${move.number}</td>
                <td>${move.user}</td>
            </tr>

        <%-- </c:forEach> --%>
    </table>
</body>
</html>