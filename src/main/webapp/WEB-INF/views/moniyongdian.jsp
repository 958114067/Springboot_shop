<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2019/5/26
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>模拟用电</title>
    <style>
    .button {
    display: inline-block;
    color: #f8f8f9;
    background-color: #2985f7;
    padding: .5rem 1rem;
    border-color: #2184ff;
    border-radius: 4px;
    cursor: pointer;
    }
    .button:hover {
    background-color: #549df9;
    }
    .button:active {
    background-color: #549df9;
    box-shadow: 0 0 5px 2px #bfdafd;
    }
    </style>
</head>
<body>
<div class="page-container">
    <h3>本寝室供电状态：${eamm.status} </h3>
    <h3>本寝室剩余电费：${eamm.e_ele}</h3>
    <div class="button"><a href="gomoni30s?id=${eu.getE_dorm_num()}&ele=${eamm.e_ele}&sta=${eamm.status}">30秒模拟用电</a></div>

</div>
<footer class="footer mt-20">

</footer>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>

</body>
</html>
