<%--
  Created by IntelliJ IDEA.
  User: 98216
  Date: 2019/8/22
  Time: 14:40
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
    <link href="../../../ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
</head>
<style>
    .ztree * {
        font-size: 15px;
    }
</style>
<body>
<div class="layui-fluid" style="padding: 15px;">
    <div class="layui-card">
        <div style="width: 350px;height: 610px;border-right: 2px solid #F2F2F2;">
            <ul id="categoryTree" class="ztree" name="demo" style="padding: 15px 0 0 29px;"></ul>
        </div>
    </div>
</div>

<script src="../../../layuiadmin/layui/layui.js"></script>
<script src="../../../js/jquery-1.3.2.min.js"></script>
<script src="../../../ztree/js/jquery.ztree.all.js"></script>
<script type="application/javascript">
    layui.use('tree', function() {
        var layer = layui.layer;

        var zTreeObj;
// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        var zNodes=[];

        $.ajax({
            type: "post",
            url: '/itemCategory/findCategoryList',
            traditional: true,
            async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
            dataType:'json',
            success: function(result) {
                if (result.stateInfo=='success') {
                    result.message.forEach(function (value, index) {
                        zNodes.push({"id":value.id,"pId":value.parentId,"name":value.categoryName});
                    });
                    console.log(zNodes);
                } else {
                    layer.msg(result.message);
                }
            },
            error: function(error) {
                alert(error.status);
            }
        });
        <%--console.log('itemCategorieList',${itemCategorieList});--%>

// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            view: {
                fontCss : {fontSize:"10px"}
            },
            callback: {
                onCheck: function (event, treeId, treeNode) {

                }
            }
        };
        zTreeObj = $.fn.zTree.init($("#categoryTree"), setting, zNodes);

    });
</script>
</body>
</html>
