<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qiaodan.smartball.controller.MediaController"%>
<%@ page import="com.qiaodan.smartball.service.MediaServiceI"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	width: 100%;
	height: 100%;
}

center {
	margin-top: 30;
}
</style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head> 
<body>
	<center>
		<form action="" method="get" onsubmit="return false">
			手机号：<input id="mobile" type="text" />
			<!-- 时&nbsp;&nbsp;间：<input id="time" type="date"/>
			</p> -->
			<input type="button" value="查询" onclick="getFiles();">
			
		</form>
		<p>
	</center>

</body>
<script type="text/javascript">
	
	function getFiles() {
		
		var hostname = window.location.host;//获取域名端口
		var mobile = document.getElementById("mobile").value;
		//var time = document.getElementById("time").value;
		//alert(time);
		if (mobile == null || mobile == undefined || mobile == '') {
			alert("手机号不能为空！");
			return false;
		} else {
			 if(!(/^1[34578]\d{9}$/.test(mobile))){ 
			        alert("手机号码有误，请重填");  
			        return false; 
			    } else{
			    	//判断时间
			    	// if(time == null || time == undefined || time == ''){
			    	//	var myDate = new Date();
			    	//	var year = myDate.getYear();
			    	//	var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
			    	//	var date = myDate.getDate();        //获取当前日(1-31)
			    	//	time = myDate.toLocaleDateString();     //获取当前日期;
			    	//	alert(time);
			    	//} 
			//document.forms[0].action = "mediaController/getMedias.do?mobile=" + mobile;
			//document.forms[0].submit();
			window.open("http://"+hostname+"/PullBallData/moveController/getMoveForUserMobile.do?mobile="+mobile);
			    }
		}
	}
</script>
</html>