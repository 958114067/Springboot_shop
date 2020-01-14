<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
	<title>帖子详情</title>
	<style>
		#reply{
			background: #ddd;
			color: #333;
			text-align: center;
			width: 80px;
			padding: 5px 0;
			border: 1px solid #eee;
			cursor: pointer;
		}
		#reply:hover{
			background: blue;
			color: #fff;
		}
		#title{
			border: 1px solid #999;
			margin-top: 5px;
			padding: 2px 4px;
			font-size: 20px;
			color: #666;
		}
		table tr td{
			border:1px solid #489cc2;
		}
		table tr td:first-child{
			width: 10%;
		}
	</style>
</head>
<body >
<div class="page-container">
	<div id="reply"> <a href="myreply.do?topicid=${topicdata.topicid}">我要回帖</a></div>
	<div id="title">标题：${topicdata.title}</div>
	<table style="border:1px solid #999;width:100%;">
		<tr>
			<td>
				<div>
					<div style="color: #00a0e9;">发帖人：${eu.e_name}</div>
					<div style="color:#00a0e9;">寝室号：${eu.e_dorm_num}</div>
				</div>
			</td>
			<td>
				<div>
					<div style="color:red;">内容：</div>
					<div>${topicdata.content}</div>
			    </div>
			</td>
		</tr>

		<c:forEach items="${replydata}" var="f">
		<tr height="60">
			<td>
				<div>
					<div>回帖人：${f.e_name}</div>
				</div>
			</td>
			<td>
				<div>
					<div style="color:red;">内容：</div>
					<div>${f.content}</div>
				</div>
			</td>
		</tr>
		</c:forEach>
	</table>
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