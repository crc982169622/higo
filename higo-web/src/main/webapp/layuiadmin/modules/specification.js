/**

 @Name：layuiAdmin 规格参数管理
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;

  //商品类别管理
  table.render({
    elem: '#LAY-itemCategory-back-manage'
    ,url: '../../../itemCategory/findItemCategoryList' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 80, title: 'ID', sort: true}
      ,{field: 'categoryName', title: '类别名称'}
      ,{field: 'categoryLevel', title: '级别'}
      ,{field: 'parentName', title: '父级类别'}
      // ,{field: 'email', title: '邮箱'}
      // ,{field: 'role', title: '角色'}
      ,{field: 'createDate', title: '创建时间', sort: true}
      // ,{field: 'check', title:'审核状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-itemcategory'}
    ]]
    ,page: true
    ,limit: 30
    ,height: 'full-170'
    ,response: {
       statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
    }
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-itemCategory-back-manage)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){

        layer.confirm('真的删除行么', function(index){
            $.ajax({
                type: "post",
                url: '/itemCategory/deleteItemCategory',
                async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                data: {
                    categoryId: data.id
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
            layer.close(index);
        });

    }else if(obj.event === 'edit'){
      var tr = $(obj.tr);

      layer.open({
        type: 2
        ,title: '编辑商品类别'
        ,content: '/itemCategory/toItemCategoryForm?itemCategoryId='+data.id
        ,area: ['420px', '420px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submitID = 'LAY-itemCategory-back-submit'
          ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
              // 如果为一级商品级别，则父级级别为空
              if (field.categoryLevel==1){
                  field.parentId='';
              }
              $.ajax({
                  type: "post",
                  url: '/itemCategory/editItemCategory',
                  async:false,//同步提交。不设置则默认异步，异步的话，最后执行ajax
                  data: {
                      id: field.id,
                      categoryLevel: field.categoryLevel,
                      parentId: field.parentId,
                      categoryName: field.categoryName
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
        ,success: function(layero, index){           
          
        }
      })
    }
  });

  exports('itemcategory', {})
});