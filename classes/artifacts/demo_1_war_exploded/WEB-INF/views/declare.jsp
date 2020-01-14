<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
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
	<title>电器报修</title>
	<style>
		#machine{
			width: 100%;
			font-size: 20px;
			height: 40px;
			line-height: 40px;
			padding: 5px;
			margin: 10px 0px;
		}
	</style>
</head>
<body>
<div class="page-container">
	<A href="mydeclare.do" style="color: #0f9ae0 ; font-size:15px; text-decoration:underline">我的申请</A>
	<form  action="mydeclare1.do" method="post">
		<div style="color:red;font-size: 20px;">请选择需要维修的物品</div>
		<select name="type" id="machine">
			<option vlaue="洗衣机">洗衣机</option>
			<option vlaue="空调">空调</option>
			<option vlaue="电风扇">电风扇</option>
			<option vlaue="热水器">热水器</option>
			<option vlaue="其它">其它</option>
		</select>
		<div style="font-size: 20px;color:#999;">备注</div>
		<textarea style="width:100%;height:100px;padding:5px;border:1px solid ;margin-top:5px;" name="remark"></textarea>
		<div style="text-align: center;">
			<input style="width:120px;background: #00a2d4;border: 0;color:white;padding:5px 0;border-radius:5px;font-size: 25px;margin-top:5px;" type="submit" value="提交申请"/>
		</div>
	</form>
</div>

	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>

</body>
</html>