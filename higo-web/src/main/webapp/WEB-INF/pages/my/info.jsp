<%--
  Created by IntelliJ IDEA.
  User: 98216
  Date: 2019/8/14
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的资料</title>
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
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>

                    <form class="layui-form" id="editUser" lay-filter="editUser" action="">
                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">我的角色</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<select name="type" lay-verify="">--%>
                                    <%--<option value="0" <c:if test="${userDomain.type==0}">selected</c:if>>管理员</option>--%>
                                    <%--<option value="1" <c:if test="${userDomain.type==1}">selected</c:if>>普通用户</option>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                            <%--<div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>--%>
                        <%--</div>--%>
                        <input type="hidden" id="userId" name="id" value="${userDomain.id}" />
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                                <input type="text" id="userName" lay-verify="userName" name="userName" value="${userDomain.userName}" class="layui-input">
                            </div>
                            <%--<div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>--%>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="nick" id="nick" value="${userDomain.nick}" lay-verify="nick" autocomplete="off" placeholder="请输入昵称" class="layui-input">
                            </div>
                        </div>
                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">性别</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input type="radio" name="sex" value="男" title="男">--%>
                                <%--<input type="radio" name="sex" value="女" title="女" checked>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-inline">
                                <input name="avatar" lay-verify="required" id="LAY_avatarSrc" placeholder="图片地址" value="http://cdn.layui.com/avatar/168.jpg" class="layui-input">
                            </div>
                            <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                <button type="button" class="layui-btn layui-btn-primary" id="LAY_avatarUpload">
                                    <i class="layui-icon">&#xe67c;</i>上传图片
                                </button>
                                <button class="layui-btn layui-btn-primary" layadmin-event="avartatPreview">查看图片</button >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="mobile" id="mobile" value="${userDomain.mobile}" lay-verify="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">邮箱</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<input type="text" name="email" value="" lay-verify="email" autocomplete="off" class="layui-input">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="layui-form-item layui-form-text">--%>
                            <%--<label class="layui-form-label">备注</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<textarea name="remarks" placeholder="请输入内容" class="layui-textarea"></textarea>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit id="edit" lay-filter="edit">确认修改</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重新填写</button>
                            </div>
                        </div>
                    </form>

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

    layui.use('form', function() {
        var form = layui.form;
        var userId=$("#userId").val();
        var flag=0;//用户名是否存在（0：不存在  1：已存在）

        //自定义验证规则
        form.verify({
            userName: function(value){
                $.ajax({
                    type: "post",
                    url: '/user/findUserByName',
                    async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                    data: {
                        userName: $("#userName").val()
                    },
                    dataType:'json',
                    success: function(result) {
                        if (result.stateInfo=='success') {
                            flag=0;
                            if (result.message != null && result.message.id != userId) {
                                flag=1;
                            }
                        } else {
                            layer.msg(result.message);
                        }
                    },
                    error: function(error) {
                        alert(error.status);
                    }
                });
                if (flag==1) {
                    return "此用户名已存在";
                }
            }
            // ,password: [
            //     /^[\S]{6,12}$/
            //     ,'密码必须6到12位，且不能出现空格'
            // ]
        });

        //监听提交
        form.on('submit(edit)', function(data){
            $.ajax({
                type: "post",
                url: '/user/editInfo',
                async:true,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                data: {
                    id: $("#userId").val(),
                    nick: $("#nick").val(),
                    userName: $("#userName").val(),
                    mobile: $("#mobile").val()
                },
                dataType:'json',
                success: function(result) {
                    if (result.stateInfo=='success') {
                        layer.msg(result.message);
                    } else {
                        layer.msg(result.message);
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
