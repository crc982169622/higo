
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layuiAdmin 管理员 iframe 框</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-admin" id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
    <input type="hidden" id="id" name="id" value="${userDomain.id}" autocomplete="off" class="layui-input"/>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" id="userName" name="userName" value="${userDomain.userName}" lay-verify="userName||required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-inline">
            <input type="text" id="nick" name="nick" value="${userDomain.nick}" lay-verify="" placeholder="请输入昵称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-inline">
            <input type="text" id="mobile" name="mobile" value="${userDomain.mobile}" lay-verify="phone" placeholder="请输入号码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">邮箱</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" name="email" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">角色</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" name="role" lay-verify="required" placeholder="请输入角色类型" autocomplete="off" class="layui-input">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">审核状态</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="checkbox" lay-filter="switch" name="switch" lay-skin="switch" lay-text="通过|待审核">--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-user-back-submit" id="LAY-user-back-submit" value="确认">
    </div>
</div>

<script src="../../../layuiadmin/layui/layui.js"></script>
<script src="../../../js/jquery-1.3.2.min.js"></script>

<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form'], function(){
        var $ = layui.$
            ,form = layui.form ;
        var userId = $("#id").val();
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
                            if (userId==null || userId=='') {
                                //添加管理员
                                if (result.message != null) {
                                    flag=1;
                                }
                            } else {
                                //编辑管理员
                                if (result.message != null && result.message.id != userId) {
                                    flag=1;
                                }
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
        });

        //监听提交
        // form.on('submit(LAY-user-back-submit)', function(data){
        //     if (userId==null || userId=='') {
        //         //添加管理员
        //         $.ajax({
        //             type: "post",
        //             url: '/user/addAdminUserPro',
        //             async:true,//同步提交。不设置则默认异步，异步的话，最后执行ajax
        //             data: {
        //                 userName: $("#userName").val(),
        //                 nick: $("#nick").val(),
        //                 mobile: $("#mobile").val(),
        //             },
        //             dataType:'json',
        //             success: function(result) {
        //                 if (result.stateInfo=='success') {
        //                     // layer.close(index); //关闭弹层
        //                 } else {
        //                     layer.msg(result.message);
        //                 }
        //
        //             },
        //             error: function(error) {
        //                 alert(error.status);
        //             }
        //         });
        //     } else {
        //         //编辑管理员
        //
        //     }
        //
        //     return false;
        // });
    })
</script>
</body>
</html>