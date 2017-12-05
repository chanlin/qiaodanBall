<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Index</title>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body onLoad="read();">

	<h1 style="margin-top:50px; margin-left:50px;">数据报表</h1>
	<a id="u_1">用户增长</a><p>
	<a id="u_2">活跃用户增长</a><p>
    <a id="u_3">身高体重</a><p>
    <a id="u_4">注册用户和年龄</a><p>
    <a id="u_5">活跃注册用户年龄</a><p>
    <a id="u_6">用户省份</a><p>
    <a id="u_7">球场位置</a><p>
    <a id="u_8">活跃用户球场位置</a><p>
    <a id="u_9">用户运动能力分析</a>
</body>

<script type="text/javascript">
	function read(){
		var hostname = window.location.host;//获取域名端口
		$("#u_1").attr("href","http://"+hostname+"/PullBallData/chartUser.jsp"); 
		$("#u_2").attr("href","http://"+hostname+"/PullBallData/chartActiveUser.jsp"); 
		$("#u_3").attr("href","http://"+hostname+"/PullBallData/chartUserHeightAndWeight.jsp"); 
		$("#u_4").attr("href","http://"+hostname+"/PullBallData/chartUserAges.jsp"); 
		$("#u_5").attr("href","http://"+hostname+"/PullBallData/chartActiveUserAges.jsp"); 
		$("#u_6").attr("href","http://"+hostname+"/PullBallData/chartUserLocation.jsp"); 
		$("#u_7").attr("href","http://"+hostname+"/PullBallData/chartUserPosition.jsp"); 
		$("#u_8").attr("href","http://"+hostname+"/PullBallData/chartActiveUserPosition.jsp");// + "chartActiveUserPosition.jsp"); 
		$("#u_9").attr("href","http://"+hostname+"/PullBallData/chartUserData.jsp"); 
			
	}	
</script>
</html>