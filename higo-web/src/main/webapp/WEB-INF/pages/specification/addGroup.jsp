<%--
  Created by IntelliJ IDEA.
  User: 98216
  Date: 2019/8/28
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
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
<body>
<div class="layui-form" lay-filter="layuiadmin-form-admin" id="layuiadmin-form-admin">
    <input type="hidden" name="uuId" lay-verify="uuId" value="${uuId}" autocomplete="off"  class="layui-input">
    <input type="text" style="width: 80%;margin: 30px 0 0 40px;" name="groupName" lay-verify="groupName" autocomplete="off" placeholder="请输入分组名" class="layui-input">

    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-addGroup-back-submit" id="LAY-addGroup-back-submit" value="确认">
    </div>
</div>


<script src="../../../layuiadmin/layui/layui.js"></script>
<script src="../../../js/jquery-1.3.2.min.js"></script>
<script type="application/javascript">
    layui.use('form',function () {
        var form=layui.form;

        //自定义验证规则
        form.verify({
            groupName: function(value){
                if (value == null || value == '') {
                    return "分组名不能为空";
                }
            }
        });
    });
</script>
</body>
</html>
