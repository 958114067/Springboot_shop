<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>电表管理</title>
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <style>
        html {
            height: 100%;
            width: 100%;
            box-sizing: border-box;
        }
        *,
        *:before,
        *:after {
            box-sizing: inherit;
        }
        body {
            height: 100%;
            width: 100%;
            margin: 0;
            font-family: Microsoft YaHei, Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Arial, sans-serif;
        }
        @media screen and (max-width: 1366px) {
            body {
                font-size: 12px;
            }
        }
        @media screen and (min-width: 1366px) and (max-width: 1600px) {
            body {
                font-size: 14px;
            }
        }
        @media screen and (min-width: 1600px) and (max-width: 1919px) {
            body {
                font-size: 16px;
            }
        }
        @media screen and (min-width: 1920px) {
            body {
                font-size: 16px;
            }
        }
        .main-container {
            height: 100%;
            width: 100%;
            background-color: #cfd6e4;
            color: #333333;
            padding: .5rem;
        }
        .main-block {
            padding: 1.5rem;
            margin-bottom: .5rem;
            background-color: #fff;
        }
        .block-title {
            /*display: flex;
            flex-flow: row nowrap;
            align-items: center;
            justify-content: space-between;*/
        }
        .card-container {
            padding: .8rem;
        }
        .card-container .card {
            padding: .8rem;
            margin: 0 .5rem .5rem 0;
            box-shadow: 0 1px 4px 0 rgba(106, 106, 106, 0.45);
            display: inline-flex;
            flex-direction: column;
            align-items: flex-start;
        }
        .card .card-item {
            line-height: 2;
        }
        .card .card-control {
            width: 100%;
            padding: .5rem 0;
        }
        .title-right {
            float: right;
            margin-left: 1em;
        }
        .title {
            font-size: 1.5rem;
            font-weight: bold;
        }
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
<div class="main-container">
    <div class="main-block">
        <div class="block-title">
            <span class="title-left title">智能电表</span>
            <div class="title-right button"><a href="yijiantingdian">一键断电</a></div>
            <div class="title-right button"><a href="yijianlaidian">一键来电</a></div>
        </div>
        <div class="card-container">
            <c:forEach items="${eam1}" var="f">
            <div class="card" style="box-shadow: 0 1px 4px 0 dodgerblue;">
                <div class="card-item">寝室号：${f.e_dorm_num}</div>
                <div class="card-item">电表编号：${f.bh}</div>
                <div class="card-item">剩余电量：${f.e_ele}</div>
                <c:if test="${f.status=='供电中'}">
                    <div class="card-item" style="color:green;">供电状态：${f.status}</div>
                </c:if>
                <c:if test="${f.status=='断电中'}">
                    <div class="card-item" style="color:red;" >供电状态：${f.status}</div>
                </c:if>
                <div class="card-control">
                    <div class="button"><a href="tingdian?id=${f.bh}">停电</a></div>
                    <div class="button"><a href="huifu?id=${f.bh}">恢复</a></div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <div class="main-block">
        <div class="block-title">
            <span class="title-left title">传统电表</span>
        </div>
        <div class="card-container">
            <c:forEach items="${eam2}" var="f">
            <div class="card">
                <div class="card-item" >寝室号：${f.e_dorm_num}</div>
                <div class="card-item" name = "id">电表编号：${f.bh}</div>
                <div class="card-item">剩余电量：${f.e_ele}</div>
                <c:if test="${f.status=='供电中'}">
                    <div class="card-item" style="color:green;">供电状态：${f.status}</div>
                </c:if>
                <c:if test="${f.status=='断电中'}">
                    <div class="card-item" style="color:red;" >供电状态：${f.status}</div>
                </c:if>
                <div class="card-control">
                    <div class="button"><a href="tingdian?id=${f.bh}">停电</a></div>
                    <div class="button"><a href="huifu?id=${f.bh}"> 恢复 </a> </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
</html>