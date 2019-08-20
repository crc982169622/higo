
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>HIGO商品类别管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">类别名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="categoryName" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <%--<div class="layui-inline">--%>
                    <%--<label class="layui-form-label">昵称</label>--%>
                    <%--<div class="layui-input-block">--%>
                        <%--<input type="text" name="nick" placeholder="请输入" autocomplete="off" class="layui-input">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                <%--<label class="layui-form-label">手机</label>--%>
                <%--<div class="layui-input-block">--%>
                <%--<input type="text" name="telphone" placeholder="请输入" autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                <%--<label class="layui-form-label">邮箱</label>--%>
                <%--<div class="layui-input-block">--%>
                <%--<input type="text" name="email" placeholder="请输入" autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
                <%--</div>--%>
                <div class="layui-inline">
                    <label class="layui-form-label">类别级别</label>
                    <div class="layui-input-block">
                        <select name="categoryLevel">
                            <option value="" selected>请选择</option>
                            <option value="1">一级</option>
                            <option value="2">二级</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">父级类别</label>
                    <div class="layui-input-block">
                        <select name="parentId">
                            <option selected value="">请选择</option>
                            <c:forEach items="${firstCategoryList}" var="firstCategory">
                                <option value="${firstCategory.id}" >${firstCategory.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-admin" lay-submit lay-filter="LAY-itemCategory-back-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>

        <div class="layui-card-body">
            <div style="padding-bottom: 10px;">
                <button class="layui-btn layuiadmin-btn-admin" data-type="batchdel">删除</button>
                <button class="layui-btn layuiadmin-btn-admin" data-type="add">添加</button>
            </div>

            <table id="LAY-itemCategory-back-manage" lay-filter="LAY-itemCategory-back-manage"></table>
            <%--<script type="text/html" id="buttonTpl">--%>
                <%--{{#  if(d.check == true){ }}--%>
                <%--<button class="layui-btn layui-btn-xs">已审核</button>--%>
                <%--{{#  } else { }}--%>
                <%--<button class="layui-btn layui-btn-primary layui-btn-xs">未审核</button>--%>
                <%--{{#  } }}--%>
            <%--</script>--%>
            <script type="text/html" id="table-itemcategory">
                <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
                {{#  if(d.role == '超级管理员'){ }}
                <a class="layui-btn layui-btn-disabled layui-btn-xs"><i class="layui-icon layui-icon-delete"></i>删除</a>
                {{#  } else { }}
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
                {{#  } }}
            </script>
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
    }).use(['index', 'itemcategory', 'table'], function(){
        var $ = layui.$
            ,form = layui.form
            ,table = layui.table;

        //监听搜索
        form.on('submit(LAY-itemCategory-back-search)', function(data){
            var field = data.field;

            //执行重载
            table.reload('LAY-itemCategory-back-manage', {
                where: field
            });
        });

        //事件
        var active = {
            batchdel: function(){
                var checkStatus = table.checkStatus('LAY-itemCategory-back-manage')
                    ,checkData = checkStatus.data; //得到选中的数据

                if(checkData.length === 0){
                    return layer.msg('请选择数据');
                }

                var categoryIds = [];
                checkData.forEach(function (element) {
                    categoryIds.push(element.id);
                });

                layer.confirm('确定删除吗？', function(index) {
                    $.ajax({
                        type: "post",
                        url: '/itemCategory/deleteItemCategoryList',
                        traditional: true,
                        async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                        data: {
                            categoryIds: categoryIds
                        },
                        dataType:'json',
                        success: function(result) {
                            if (result.stateInfo=='success') {
                                layer.msg('已删除');
                                table.reload('LAY-itemCategory-back-manage');
                            } else {
                                layer.msg(result.message);
                            }

                        },
                        error: function(error) {
                            alert(error.status);
                        }
                    });
                });

            }
            ,add: function(){
                layer.open({
                    type: 2
                    ,title: '添加商品类别'
                    ,content: '/itemCategory/toItemCategoryForm'
                    ,area: ['420px', '420px']
                    ,btn: ['确定', '取消']
                    ,yes: function(index, layero){
                        var submitID = 'LAY-itemCategory-back-submit';
                        var submit = layero.find('iframe').contents().find('#'+ submitID);
                        var iframeWindow = window['layui-layer-iframe'+ index];
                        //监听提交
                        iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                            var field = data.field; //获取提交的字段
                            // 如果为一级商品级别，则父级级别为空
                            if (field.categoryLevel==1){
                                field.parentId='';
                            }
                            //添加商品类别
                            $.ajax({
                                type: "post",
                                url: '/itemCategory/addItemCategory',
                                async:true,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                                data: {
                                    categoryName: field.categoryName,
                                    categoryLevel: field.categoryLevel,
                                    parentId: field.parentId,
                                },
                                dataType:'json',
                                success: function(result) {
                                    if (result.stateInfo=='success') {
                                        table.reload('LAY-itemCategory-back-manage'); //数据刷新
                                        layer.close(index); //关闭弹层
                                    } else {
                                        layer.msg(result.message);
                                    }

                                },
                                error: function(error) {
                                    alert(error.status);
                                }
                            });

                        });
                        submit.trigger('click');
                    }
                });
            }
        }
        $('.layui-btn.layuiadmin-btn-admin').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>

