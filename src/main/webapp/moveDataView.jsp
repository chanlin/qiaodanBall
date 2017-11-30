<!--<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>-->
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
<title>用户运动轨迹数据</title>
<script type="text/javascript"> 

window.onload=function(){ 

	pullSetp();

	var times = document.getElementsByTagName("h1");
	for(var i = 0 ;i < times.length; i++){
		var time = times.item(i).innerHTML;
		
		//var d = new Date(time);
		/*
		var sd = d.getFullYear() 
				+ '-' 
				+ (d.getMonth() + 1) 
				+ '-' 
				+ d.getDate()
				+ ' '
				+ d.getHours() //小时 
        		+ ":"
				+ d.getMinutes() //分 
        		+ ":"
				+ d.getSeconds(); //秒 		
				*/	
				
				//var sd = d.pattern("yyyy-MM-dd HH:mm:ss");
				
				var sd = getTaskTime(time);
		document.getElementsByTagName("h1").item(i).innerHTML = sd;
	}
	
	
	
		
} 


//Thu Aug 18 20:38:54 CST 2016，时间格式转换
//输出格式：yyyy-MM-dd HH:mm:ss
// Thu Aug 18 2016 20:38:54 GMT+0800
function getTaskTime(strDate) {	
    if(null==strDate || ""==strDate){
        return "";
    }
    var dateStr=strDate.trim().split(" ");
    var strGMT = dateStr[0]+" "+dateStr[1]+" "+dateStr[2]+" "+dateStr[5]+" "+dateStr[3]+" GMT+0800";
    var date = new Date(Date.parse(strGMT));
    var y = date.getFullYear();
    var m = date.getMonth() + 1;  
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
	h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();  
    minute = minute < 10 ? ('0' + minute) : minute;
    var second = date.getSeconds();
    second = second < 10 ? ('0' + second) : second;
    
    return y+"-"+m+"-"+d+" "+h+":"+minute+":"+second;
};

Date.prototype.pattern=function(fmt) {         
    var o = {         
    "M+" : this.getMonth()+1, //月份         
    "d+" : this.getDate(), //日         
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时         
    "H+" : this.getHours(), //小时         
    "m+" : this.getMinutes(), //分         
    "s+" : this.getSeconds(), //秒         
    "q+" : Math.floor((this.getMonth()+3)/3),         
    "S" : this.getMilliseconds() //毫秒         
    };         
    var week = {         
    "0" : "/u65e5",         
    "1" : "/u4e00",         
    "2" : "/u4e8c",         
    "3" : "/u4e09",         
    "4" : "/u56db",         
    "5" : "/u4e94",         
    "6" : "/u516d"        
    };         
    if(/(y+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));         
    }         
    if(/(E+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);         
    }         
    for(var k in o){         
        if(new RegExp("("+ k +")").test(fmt)){         
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
        }         
    }         
    return fmt;         
}     
function pullSetp(){
	var stepStrs = document.getElementsByName("totalStep");
	for(var i = 0;i<stepStrs.length;i++){
		var stepStr = stepStrs.item(i).innerHTML;
		if(stepStr == null || stepStr == undefined || stepStr == ''){
			continue;
		}else{
			//var stepInt = Integer.parseInt(stepStr);
			if(stepStr > 10000){
				 stepStrs.item(i).style.color = "#E10601";
			}
		}
	}
}
</script> 
<body>
<center>
<h2>用户的运动数据列表</h2>
<c:forEach items="${moveDatas}" var="move" varStatus="moveIndex">
<p style="color: red;">-------------------------------------------------------------------</p>
beginTime:<h1>${move.beginTime}</h1> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;endTime:<h1>${move.endTime}</h1>
<h2>jump数据：</h2>
	<span>弹跳count:${move.verJumpCount}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>弹跳avg:${move.verJumpAvgHigh}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>弹跳max:${move.verJumpMaxHigh}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>弹跳的数据：（单位：米）</span><p></p>
	<c:forEach items="${move.height}" var="jump" varStatus="jumpIndex">
		<span>${jump}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>

<h2>trail数据：</h2>
	<c:if test="${move.point.size()>0}">
    	
		总步数：<span name="totalStep">${move.totalStep}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>trak:${move.point.size()}个</span><p>
	</c:if>
	<c:forEach items="${move.point}" var="point" varStatus="pointIndex">
		<span>${point.x},${point.y}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>

</c:forEach>

</center>
</body>
</html>
