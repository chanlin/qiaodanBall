<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.qiaodan.smartball.controller.MediaController" %>
<%@ page import="com.qiaodan.smartball.service.MediaServiceI" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
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
    <form action="" method = "post" onsubmit="return false">
		<input id="mobile" type="text"/>
        <input type="button" value ="查询" onclick="getFiles();">

        </form>
        <p>
        <h2 id="createTime">20170519<a href="">点击下载</a></h2>
	</center>

</body>
<script type="text/javascript">
	function getFiles(){
		var hostname = window.location.host;//获取域名端口
		var mobile = document.getElementById("mobile").value;
		
		//document.forms[0].action="moveController/getMoveForUserMobile.do?mobile="+mobile;
 		// document.forms[0].submit();
		window.location.href = "http://"+hostname+"/PullBallData/moveController/getMoveForUserMobile.do?mobile="+mobile;
	}
	
</script>
</html>