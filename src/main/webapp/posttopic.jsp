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
        .xiaowei{
            color: rgba(255, 255, 255, 1);
            border: 1px solid #999;
            background-color: rgba(58, 132, 242, 1);
            font-size: 24px;
            padding: 4px 4px;
            width: 87px;
            border-radius: 4px;
        }

    </style>
</head>
<body>
<div class="page-container">
    <form >
        <h3>标题</h3>
        <div><input name="title" style="width:100%;height:20px;line-height:20px;font-size:18px;"/></div>
        <h3>内容</h3>
        <div><textarea name="content" style="width:100%;height:150px;"></textarea></div>
        <div style="text-align:center;padding:4px;">
            <input type="submit" value="发帖" class="xiaowei">
        </div>
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