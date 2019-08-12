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
        .layui-form-label{
            padding: 9px 0px;
        }
        .layui-input-block{
            width: 290px;
            margin-left: 90px;
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
        </div><br>
        <form class="layui-form" action="" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="请输入用户名" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-block">
                    <input type="password" name="password" lay-verify="password" autocomplete="off" placeholder="请输入密码" class="layui-input">
                </div>
            </div><br><br><br>
            <button type="button" class="layui-btn layui-btn-normal" style="margin-left: 315px;">登录</button>
        </form>
    </div>

    <div class="loginImg"></div>
</div>

<script src="../../layui/layui.js"></script>
<script type="application/javascript">
    layui.use('form', function() {
        var form = layui.form;
        //自定义验证规则
        form.verify({
            userName: function(value){
                if(value=='' || value==null){
                    return '用户名不能为空';
                }
            }
            ,password: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });
    });


</script>
</body>
</html>
