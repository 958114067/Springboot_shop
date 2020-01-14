<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />

<title>评论列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		全部评论 <span class="c-gray en">&gt;</span> 查看评论<a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr class="text-c">
						<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
						<th width="20">评论ID</th>
						<th width="30">商品名</th>
						<th width="30">顾客名</th>
						<th width="80">顾客评论</th>
						<th width="80">我的回复</th>
						<th width="50">回复</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="f">
						<tr class="text-c">
							<!-- <td><input name="" type="checkbox" value=""></td> -->
							<td>${f.optionid }</td>
							<td>${f.getGoods().goodsname }</td>
							<td>${f.getCus().customername}</td>
							<td>${f.content}</td>
							<td>${f.getReply().content }</td>
							<c:choose>
								
								<c:when test="${f.getReply().content != null}">
								<td style="color: red">已评论</td>
								</c:when>
								<c:when test="${f.getReply().content == null}">
									<td class="f-14 product-brand-manage"><a
										style="text-decoration: none"
										href="huifu.do?optionid=${f.optionid}" title="编辑"> <i class="Hui-iconfont">&#xe6df;</i></a>
									</td>
								</c:when>
									
							</c:choose>
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
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		$('.table-sort').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			// {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
			]
		});
	</script>
</body>
</html>