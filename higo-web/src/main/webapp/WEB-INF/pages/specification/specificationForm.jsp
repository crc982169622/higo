
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
    .layui-input {
        margin-top: 10px;
        width: 80%;
        margin-left: 36px;
        float: left;
    }
    .group {
        height: 50px;
        position: relative;
        border-bottom: 1px solid #E0E0E0;
    }
    .group label {
        font-size: 20px;
        position: absolute;
        top: 24%;
        left: 15px;
    }
    .group .add-group {
        position: absolute;
        left: 81%;
        top: 20%;
    }
    .group .delete-group {
        position: absolute;
        left: 86%;
        top: 20%;
    }
    .add-params {
        height: 35px;
        margin: 10px 0 10px 68%;
    }
    .delete-params {
        margin: 10px 0 0 10px;
        height: 36px;
    }
    .layui-card {
        margin-left: 25px;
    }
</style>
<body style="background: #F2F2F2">

<div class="layui-form" lay-filter="layuiadmin-form-admin" id="layuiadmin-form-admin" style="padding: 20px 30px 0 0;">
    <input type="hidden" id="id" name="id" value="${itemCategory.id}" autocomplete="off" class="layui-input"/>

    <div id="specificationBox">
        <%--<div class="layui-card">--%>
            <%--<div class="group">--%>
                <%--<label>基本信息</label>--%>
                <%--<input type="hidden" id="" name="groupName" value=""/>--%>
            <%--&lt;%&ndash;<button type="button" class="layui-btn layui-btn-primary layui-btn-sm add-group"><i class="layui-icon layui-icon-add-1"></i></button>&ndash;%&gt;--%>
                <%--<button type="button" class="layui-btn layui-btn-primary layui-btn-sm delete-group">删除分组</button>--%>
            <%--</div>--%>
            <%--<div class="params" id="params">--%>
                <%--<div class="param">--%>
                    <%--<input type="text" name="param" lay-verify="param" autocomplete="off" placeholder="请输入属性" class="layui-input">--%>
                    <%--<button type="button" onclick="delParam();" class="layui-btn layui-btn-primary layui-btn-sm delete-params"><i class="layui-icon layui-icon-delete"></i></button>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<button type="button" class="layui-btn layui-btn-primary add-params" onclick="addParam();">添加新属性</button>--%>
        <%--</div>--%>
    </div>
    <div id="addGroupDiv">
        <button type="button" id="addGroupButton" class="layui-btn layui-btn-primary" style="margin: 10px 0 0 23px;">添加新分组</button>
    </div>



    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-specification-back-submit" id="LAY-specification-back-submit" value="确认">
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

        function addGroup(groupName, id) {
            var str= '<div class="layui-card" id="'+id+'"><div class="group"><label>'+groupName+'</label><button type="button" onclick="delGroup(\''+id+'\');" class="layui-btn layui-btn-primary layui-btn-sm delete-group">删除分组</button></div>';
            str = str + '<div id="'+id+'params" class="params"><div class="param"><input type="text" name="param" lay-verify="param" autocomplete="off" placeholder="请输入属性" class="layui-input">';
            str = str + '<button type="button" onclick="delParam(\''+id+'\');" class="layui-btn layui-btn-primary layui-btn-sm delete-params"><i class="layui-icon layui-icon-delete"></i></button></div></div>';
            str = str + '<button type="button" class="layui-btn layui-btn-primary add-params" onclick="addParam(\''+id+'\');">添加新属性</button></div>';
            $("#specificationBox").append(str);
        }

        $("#addGroupButton").click(function () {
            layer.open({
                type: 2
                ,title: '添加新分组'
                ,content: '/specification/addGroup'
                ,area: ['400px', '200px']
                ,btn: ['确定', '取消']
                ,yes: function(index, layero){
                    var submitID = 'LAY-addGroup-back-submit';
                    var submit = layero.find('iframe').contents().find('#'+ submitID);
                    var iframeWindow = window['layui-layer-iframe'+ index];
                    //监听提交
                    iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                        var field = data.field; //获取提交的字段
                        var uuId=field.uuId;
                        var groupName=field.groupName;
                        addGroup(groupName, uuId);
                    });
                    submit.trigger('click');
                    layer.close(index); //关闭弹层

                }
            });
        });


    });

    function delGroup(id) {
        $('#'+id+'').remove();
    }

    function addParam(groupId) {
        var str = '<div class="param"><input type="text" name="'+groupId+'" lay-verify="param" autocomplete="off" placeholder="请输入属性" class="layui-input">';
        str = str + '<button type="button" onclick="delParam(\''+groupId+'\')" class="layui-btn layui-btn-primary layui-btn-sm delete-params"><i class="layui-icon layui-icon-delete"></i></button></div>';
        $('#'+groupId+'params').append(str);
    }

    function delParam(id) {
        $(event.currentTarget).parent().remove();
    }
</script>
</body>
</html>