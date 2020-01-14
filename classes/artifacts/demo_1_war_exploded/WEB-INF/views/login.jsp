<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/header.jsp" %>
<!--      用户登录表单        -->
<DIV class="t" style="MARGIN-TOP: 15px" align="center">

	<FORM name="loginForm" action="login" method="post">
		<label class="label">用户名：</label>
		<INPUT class="input" tabIndex="1" type="text" maxLength="20" style="width: 150px" name="name">
		<br /> <label class="label">密码：</label>
		<INPUT class="input" tabIndex="2" type="password" maxLength="20" style="width: 150px" name="pwd">
		<br />
		<br/>
		<label class="label">&nbsp;&nbsp;</label>
		<INPUT class="btn" tabIndex="6" type="submit" value="登 录" style="width:70px;height:25px">
	</FORM>
</DIV>
<%@ include file = "/footer.jsp"%>