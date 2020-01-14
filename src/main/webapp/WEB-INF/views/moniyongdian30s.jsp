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
    <h3>本寝室供电状态：<span id="status">供电中</span></h3>
    <h3>本寝室剩余电费：<span id="rest"></span></h3>
    <h3>正在使用模拟用电功能。。。。。</h3>
    <a></a>
</div>
<footer class="footer mt-20">

</footer>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
    var id = getQueryString("id");
    var status1 = document.getElementById("status");
    var rest = document.getElementById("rest");
    var aTag = document.getElementsByTagName("a")[0];
    rest.innerText = getQueryString("ele");
    var interval = setInterval(update,3000);
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
    function update(){
        $.ajax({
            type: 'POST',
            url: "moni30s",
            data: {
                id:id
            },
            dataType: "json",
            success: function(obj) {
                console.log(obj);
                if(obj.e_ele < -9) {
                    window.clearInterval(interval);
                    aTag.setAttribute("href","gomoni30s?id="+id);
                    aTag.click();
                }else {
                    status1.innerText = obj.status;
                    rest.innerText = obj.e_ele;
                }
            }
        });
    }
</script>
</body>
</html>
