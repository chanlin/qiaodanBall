<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><style>
	body{
		width:100%;
		height:100%;
	}
   	center{
		margin-top:30;
	}
    
    </style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
    	request:${requestScope.result}<br/>
	<c:forEach items="${requestScope.medias}"var="m">
      ${m.createTime}<br/>
      <a href=${m.createTime}>点击下载</a>
   	</c:forEach>
    
        
        <h2 id="createTime">20170519</h2>
        <p>
        
	</center>

</body>

</body>
</html>