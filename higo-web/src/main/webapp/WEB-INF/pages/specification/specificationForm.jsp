
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
    .parentId .layui-form-selected dl{
        height: 200px;
    }
</style>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-admin" id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
    <input type="hidden" id="id" name="id" value="${itemCategory.id}" autocomplete="off" class="layui-input"/>

    <div id="specificationBox">
        <div>
            <input type="text" placeholder="请输入分组名" /><br>
            <input type="text" placeholder="请输入属性名" />
        </div>
    </div>
    <div id="addGroupDiv"><button id="addGroupButton">新分组</button></div>
    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">手机</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" id="mobile" name="mobile" value="${userDomain.mobile}" lay-verify="phone" placeholder="请输入号码" autocomplete="off" class="layui-input">--%>
        <%--</div>--%>
    <%--</div>--%>
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
        <input type="button" lay-submit lay-filter="LAY-itemCategory-back-submit" id="LAY-itemCategory-back-submit" value="确认">
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
        var categoryId = $("#id").val();
        var level = $("#categoryLevel").val();
        var flag = 0;//该商品类别是否存在的标志（0：不存在  1：已存在）

        // 修改类别时，当类别级别为二级时，显示父级级别
        if ($("#categoryLevel").val()==2){
            $("#parentCategory").css('display','inline');
        }

        form.on('select(categoryLevel)', function(data){
            if (data != null) {
                if (data.value==1) {
                    $("#parentCategory").css('display','none');
                } else if (data.value==2) {
                    $("#parentCategory").css('display','inline');
                }
            }
        });
        //自定义验证规则
        form.verify({
            categoryName: function(value){
                $.ajax({
                    type: "post",
                    url: '/itemCategory/findCategoryByNameAndLevel',
                    async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                    data: {
                        categoryName: value,
                        categoryLevel: level
                    },
                    dataType:'json',
                    success: function(result) {
                        if (result.stateInfo=='success') {
                            flag=0;
                            if (categoryId==null || categoryId=='') {
                                //添加商品类别
                                if (result.message != null) {
                                    flag=1;
                                }
                            } else {
                                //编辑商品类别
                                if (result.message != null && result.message.id != categoryId) {
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
                    return "该级别的商品类别已存在";
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