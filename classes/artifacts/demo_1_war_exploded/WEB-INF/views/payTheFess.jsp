<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

	<title>充值电费</title>
	<style>
		form *{
			margin: 5px
		}
		.label{
			text-align:right;
			display:inline-block;
			width:100px;
		}
		.pngl{
			height:150px;
		}
	</style>
</head>
<body>
<div class="page-container">
	<form   action="insertMoney" method="post">
		<p>电费一元一度</p>
		<label class="label">本寝室号：</label>
		<INPUT class="input" tabIndex="1" type="text" maxLength="20" style="width: 150px" name="dorm_num" value="${eu.getE_dorm_num()}">
		</br>
		<label class="label">剩余电量：</label>
		<INPUT class="input" tabIndex="1" type="text" maxLength="20" style="width: 150px" name="lastmoney" value="${d}">
		</br>
		<label class="label">缴费金额：</label>
		<INPUT class="input" tabIndex="1" type="text" maxLength="20" style="width: 150px" name="setMoney">
		</br>
		<INPUT class="btn" tabIndex="4" type="submit" value="缴费">
	</form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

</script>
</body>
</html>