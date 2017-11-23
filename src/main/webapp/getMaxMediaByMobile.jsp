<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
    img{
    	width: 20%;
    	height: 20%;
    }
    </style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户分享数据</title>

<script type="text/javascript"> 

window.onload=function(){ 



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
     
// var date = new Date();      
// window.alert(date.pattern("yyyy-MM-dd hh:mm:ss"));


function download(id){
        //cavas 保存图片到本地  js 实现
        //------------------------------------------------------------------------
        //1.确定图片的类型  获取到的图片格式 data:image/Png;base64,...... 
	  var type ='png';//你想要什么图片格式 就选什么吧
        var d=document.getElementById("img"+id);
        var imgdata=d.toDataURL(type);
        //2.0 将mime-type改为image/octet-stream,强制让浏览器下载
        var fixtype=function(type){
            type=type.toLocaleLowerCase().replace(/jpg/i,'jpeg');
            var r=type.match(/png|jpeg|bmp|gif/)[0];
            return 'image/'+r;
        };
        imgdata=imgdata.replace(fixtype(type),'image/octet-stream');
        //3.0 将图片保存到本地
        var savaFile=function(data,filename)
        {
            var save_link=document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
            save_link.href=data;
            save_link.download=filename;
            var event=document.createEvent('MouseEvents');
            event.initMouseEvent('click',true,false,window,0,0,0,0,0,false,false,false,false,0,null);
            save_link.dispatchEvent(event);
        };
        var filename=''+new Date().getSeconds()+'.'+type;  
        //我想用当前秒是可以解决重名的问题了 不行你就换成毫秒
        savaFile(imgdata,filename);
        };
</script> 
</head>
<body>
	<center>
	<c:forEach items="${requestScope.medias}" var="m" varStatus="status">  
      <h1>${m.createTime}</h1>
     <!--  <img src="http://smartball.qiaodan.com:9090/qiaodan/upload/${m.folder}/${m.path}">
      
      <a href="http://smartball.qiaodan.com:9090/qiaodan/upload/${m.folder}/${m.path}">点击下载</a>
       -->
       <c:if test="${m !=null}">
       <h2>${m.name}</h2>
		<a style="cursor:pointer" href="http://smartball.qiaodan.com:9090/qiaodan/upload/${m.folder}/${m.path}" download="图片">
　　			<img src="http://smartball.qiaodan.com:9090/qiaodan/upload/${m.folder}/${m.path}" alt="图片">
		</a></c:if>
       <c:if test="${status.index%4 == 0}">
      
      </c:if>
   	</c:forEach>
    
	</center>

</body>

</body>
</html>

