<%--
  Created by IntelliJ IDEA.
  User: crc
  Date: 2019/8/14
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改密码</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <input type="hidden" id="userId" name="userId" value="${userId}" />
                        <div class="layui-form-item">
                            <label class="layui-form-label">当前密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="oldPassword" name="oldPassword" value="" lay-verify="oldPassword||required" lay-verType="tips" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password" lay-verify="pass" lay-verType="tips" autocomplete="off" id="LAY_password" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="password" name="repassword" lay-verify="repass" lay-verType="tips" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="edit">确认修改</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../layuiadmin/layui/layui.js"></script>
<script src="../../../js/jquery-1.3.2.min.js"></script>
<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set']);

    layui.use('form', function () {
        var form = layui.form;
        var flag=0;//原密码是否正确标志（0：正确  1：不正确）

        //自定义验证规则
        form.verify({
            oldPassword: function(value){
                $.ajax({
                    type: "post",
                    url: '/user/judgePassword',
                    async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                    data: {
                        id: $("#userId").val(),
                        password: $("#oldPassword").val()
                    },
                    dataType:'json',
                    success: function(result) {
                        if (result.stateInfo=='success') {
                            flag=0;
                        } else {
                            flag=1
                            // layer.msg(result.message);
                        }
                    },
                    error: function(error) {
                        alert(error.status);
                    }
                });
                if (value==null || value=='') {
                    return "原密码不能为空";
                } else if (flag==1) {
                    return "原密码不正确";
                }
            }
        });

        //监听提交
        form.on('submit', function(data){
            $.ajax({
                type: "post",
                url: '/user/editPasswordPro',
                async:true,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                data: {
                    id: $("#userId").val(),
                    password: $("#password").val()
                },
                dataType:'json',
                success: function(result) {
                    if (result.stateInfo=='success') {
                        window.parent.location.href='/'
                    }
                },
                error: function(error) {
                    alert(error.status);
                }
            });
            return false;
        });

    })
</script>
</body>
</html>
