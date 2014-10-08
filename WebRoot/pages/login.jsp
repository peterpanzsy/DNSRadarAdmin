<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	 <base href="<%=basePath%>">
    
    <title>登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="登录">
	
	<link rel="stylesheet" href="js/upload/uploadify.css">
	 
	<link rel="stylesheet" type="text/css" media="screen" href="js/jqueryUI/css/jquery-ui-1.10.3.custom.css" />
	 
	
	 <link rel="stylesheet" type="text/css" media="screen" href="js/jqGrid/css/ui.jqgrid.css" />
	 <link rel="stylesheet" type="text/css" media="screen" href="js/jqueryUI/themes/overcast/jquery.ui.theme.css" />  
	 <link rel="stylesheet" type="text/css" media="screen" href="js/jqueryUI/themes/black-tie/jquery.ui.theme.css" />
	 
	 
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/carousel.css">
	<link href="Flat-UI-master/css/flat-ui.css" rel="stylesheet">
    <link rel="Flat-UI-master/shortcut icon" href="images/favicon.ico">
	<!-- 自定义 -->
	
	<link rel="stylesheet" type="text/css" href="css/styles.css"/>
	<link rel="stylesheet" type="text/css" href="css/login.css" />  
	
	<script src="js/jquery/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="js/jquery/jquery-migrate-1.2.1.js"></script>
	
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/holder.min.js"></script>
	 
	<script src="js/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
	<script src="js/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
	
	<script src="Flat-UI-master/js/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="Flat-UI-master/js/jquery.ui.touch-punch.min.js"></script>
    <script src="Flat-UI-master/js/bootstrap-select.js"></script>
    <script src="Flat-UI-master/js/bootstrap-switch.js"></script>
    <script src="Flat-UI-master/js/flatui-checkbox.js"></script>
    <script src="Flat-UI-master/js/flatui-radio.js"></script>
    <script src="Flat-UI-master/js/jquery.tagsinput.js"></script>
    <script src="Flat-UI-master/js/jquery.placeholder.js"></script>
    
	<script type="text/javascript" src="js/upload/jquery.uploadify.min.js"></script>
	<script type="text/javascript" src="js/jquery-validation-1.11.1/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/jquery/jquery.message.js"></script>
	<!-- 自定义 -->
	<script src="js/global.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<script type="text/javascript">
	$(document).ready(function(){ 
	    
	});		
	</script>
	
	
	
</head>

<body style="padding-bottom: 40px; background: url(images/background.jpg)">
	<div class="container content">
	
		    <div class="login" style="background: url()">
		      
		   <!-- <h4 style="font-family:微软雅黑;font-size:40px;margin-left:130px;margin-top:100px;">BotWall 管理系统</h4> -->
		   	   <ul style="font-family:微软雅黑;font-size:40px;margin-left:130px;margin-top:100px;">
		      		<img style="width:40%;margin-left:-100px;" alt="BotWall 管理系统" src="images/eagleeye-dark.png">
		      	 	<h4 style="color:#eee">DNS-Radar管理系统</h4>
		      	</ul> 
		        <div  style="margin-rigtht:10px;margin-top:-100px;">
		       	 <div class="login-icon" style="width:auto;margin-top:150px;margin-right:10px;float:right;">		            
		            <img src="images/logo.ico" alt="DNS-Radar 管理系统" />		           
		         </div>
				 <form id="login-form" action="login.action" method="post" style="margin-left: 250;">
			          <div class="login-form"  style="margin-bottom:20px;float:right;width:300px;">
			            <div class="control-group">
			              <input type="text" class="login-field" value="" placeholder="输入用户名" id="username" name="username"/>
			              <label class="login-field-icon fui-man-16" for="username"></label>
			            </div>
			
			            <div class="control-group">
			              <input type="password" class="login-field" value="" placeholder="输入密码" id="password" name="password" />
			              <label class="login-field-icon fui-lock-16" for="password"></label>
			            </div>
			
			            <input type="submit" class="btn btn-primary btn-large btn-block" value="登录" />
			          </div>
		          </form>
		        </div>
		      </div>
		
	<!--  
	<form id="login-form" action="login.action" method="post">
		<fieldset>
		
			<legend>BotWall管理系统登陆</legend>
			
			<label for="login">邮箱</label>
			<input type="text" id="login" name="username"/>
			<div class="clear"></div>
			
			<label for="password">密码</label>
			<input type="password" id="password" name="password"/>
			<div class="clear"></div>
			
			<label for="remember_me" style="padding: 0;">记住我?</label>
			<input type="checkbox" id="remember_me" style="position: relative; top: 3px; margin: 0; " name="remember_me"/>
			<div class="clear"></div>
			
			<br />
			
			<div style="margin-top:-20px;" ><input type="submit" style="float:right" class="button" name="commit" value="登陆"/>				
			</div>
		</fieldset>
	</form>-->




<div style="width:550px;margin:20px auto;clear:both;">

</div>
</div>

</body>
<footer style="color: #999999;padding: 40px;text-align: center;color:white;background-color:rgba(149, 187, 224, 0.33)">
  		<span id="copyright">&copy; 2014 </span> 
</footer>
</html>