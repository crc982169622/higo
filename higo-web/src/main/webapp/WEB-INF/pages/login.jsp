<%--
  Created by IntelliJ IDEA.
  User: 98216
  Date: 2019/8/12
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HIGO登录界面</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <style>
        body{
            background-image: url(/images/loginBack.jpg);
            background-size:cover;
            height: 100%;
            width: 100%;
            overflow: hidden;
            position: relative;
        }
        .loginBox{
            height: 50%;
            width: 50%;
            position: absolute;
            top: 19%;
            left: 25%;

        }
        .loginMessage{
            background: aliceblue;
            height: 100%;
            width: 60%;
            float: left;
        }
        .loginImg{
            height: 100%;
            width: 40%;
            background-image: url(/images/loginImg.png);
            float: left;
        }
        .layui-row{
            margin-left: 20px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="loginBox">
    <div class="loginMessage">
        <div class="layui-row" style="">
            <div class="layui-col-xs12">
                <div class="grid-demo grid-demo-bg1" style="font-size: 25px;color: #1F76D1;font-weight: bold;">
                    <a style="font-size: 40px;color: #1F76D1;font-weight: bold;position: relative;top: 3px;">HIGO</a> 后台管理系统
                </div>
            </div>
        </div>
    </div>
    <div class="loginImg"></div>
</div>

<script src="../../layui/layui.js"></script>
<script type="application/javascript">

</script>
</body>
</html>
