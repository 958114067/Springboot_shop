<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

</DIV>

<DIV class="t" style="MARGIN-TOP: 15px" align="center">
	<FORM name="regForm" action="register" method="post" >
		<br /> <label>&nbsp;&nbsp;&nbsp;&nbsp;</label><label class="label">用户名：</label>
		<INPUT class="input" tabIndex="1" type="text" maxLength="20" style="width: 150px" name="name">
		<br/>
		<label class="label">密码：</label>
		<INPUT class="input" tabIndex="2" type="password" maxLength="20" style="width: 150px" name="password">
		<br/>
		<label class="label">寝室号&nbsp;:</label>
		<select name="dormnum"  maxLength="20">
			<option vlaue="999">999</option>
			<option vlaue="102">102</option>
			<option vlaue="203">203</option>
			<option vlaue="123">123</option>
		</select>

		<INPUT class="btn" tabIndex="4" type="submit" value="注 册">
	</FORM>
</DIV>
<script type="text/javascript">
	$(function() {
		$('input[name=reUpass]').blur(function() {
			var pwd = $('input[name=upass]').val();
			var cpwd = $(this).val();
			if (pwd != cpwd) {
				$(this).next('span').html('密码不一致');
			} else {
				$(this).next('span').html('√');
			}
		});
	});

	$('input[name = mail]').blur(function(){
		var mail =	$('input[name = mail]').val();
		var t1 = /^[a-zA-Z_]{0,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$/;
		if(t1.test(mail)){
			$(this).next('span').html('√');
		}else{
			$(this).next('span').html('邮箱格式不正确');
		}
	});


	$('input[name=tel]').blur(function() {
		var r8=/^1[3|4|5|8][0-9]\d{8}$/;
		var pwd = $('input[name=tel]').val();
		if (r8.test(pwd)) {
			$(this).next('span').html('√');
		} else {
			$(this).next('span').html('电话格式不对');
		}

	});




</script>

<%@ include file="/footer.jsp"%>