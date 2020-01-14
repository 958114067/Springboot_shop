<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<TITLE>学生宿舍用电管理系统</TITLE>
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<style>
form *{
	margin: 5px
}
.label{
	text-align:right;
	display:inline-block;
	width:100px
}
.pngl{
	height:150px;
}
</style>
</HEAD>

<BODY>

	<DIV class="pngl">
		<IMG src="image/1.png" width=100% height=100%>
	</DIV>
	<!--      用户信息、登录、注册        -->

	<DIV class="h">
	<% if(session.getAttribute("loginUser")!=null){
	%>

	<%}else{%>

			注册账号请点击：
			<A href="reg.jsp">注册</A>
	<% }%>		
	</DIV>