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

	<title>寝室详细信息</title>
	<style>
		.xx{
			FONT-SIZE: 25px;
			color: #0e90d2;
		}


	</style>
</head>
<body>
<div class="page-container">
	<table class="table table-border table-bordered table-bg table-sort">
		<thead>
		<tr class="text-c">
			<th width="30">序号</th>
			<th width="80">寝室号</th>
			<th width="60">寝室人员</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="f" varStatus="i">
			<tr class="text-c">
				<!-- <td><input name="" type="checkbox" value=""></td> -->
				<td height="30px">${f.getE_dorm_id()}</td>
				<td height="30px">
						${f.getE_dorm_num()}
				</td>
				<td height="30px">${lstr.get(i.index)}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
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
	// $('.table-sort').dataTable({
	// 	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	// 	"bStateSave": true,//状态保存
	// 	"aoColumnDefs": [
	// 	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	// 	  {"orderable":false,"aTargets":[0,5]}// 制定列不参与排序
	// 	]
	// });
</script>
</body>
</html>