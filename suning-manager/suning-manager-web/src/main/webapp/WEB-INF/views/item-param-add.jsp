<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table cellpadding="5" style="margin-left: 30px" id="itemParamAddTable" class="itemParam">
	<tr>
		<td>商品类目:</td>
		<td><a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a> 
			<input type="hidden" name="cid" style="width: 280px;"></input>
		</td>
	</tr>
	<tr class="hide addGroupTr">
		<td>规格参数:</td>
		<td>
			<ul>
				<li><a href="javascript:void(0)" class="easyui-linkbutton addGroup">添加分组</a></li>
			</ul>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a href="javascript:void(0)" class="easyui-linkbutton submit">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton close">关闭</a>
		</td>
	</tr>
</table>
<div  class="itemParamAddTemplate" style="display: none;">
	<li class="param">
		<ul>
			<li>
				<input class="easyui-textbox" style="width: 150px;" name="group"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton addParam"  title="添加参数" data-options="plain:true,iconCls:'icon-add'"></a>
			</li>
			<li>
				<span>|-------</span><input  style="width: 150px;" class="easyui-textbox" name="param"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton delParam" title="删除" data-options="plain:true,iconCls:'icon-cancel'"></a>						
			</li>
		</ul>
	</li>
</div>
<script style="text/javascript">
	$(function(){
		//选择类目结束后的一个回调
		Suning.initItemCat({
			Function : function(node){
			//将添加分组的按钮隐藏 并且将下面的参数给删除
			$(".addGroupTr").hide().find(".param").remove();
			  $.ajax({
				   type: "GET",
				   url: "/item/param/template/" + node.id,
				   statusCode : {
					   200 : function() {
							  $.messager.alert("提示", "该类目已经添加，请选择其他类目。", undefined, function(){
								  	//重新打开菜单
								  	$("#itemParamAddTable .selectItemCat").click();
								  });
					   },
					   404 : function() {
						   $(".addGroupTr").show();
					   },
					   500 : function() {
							$.messager.alert('错误','创建失败!','error');
					   }
				   }
				});
			}
		});
		
		$(".addGroup").click(function(){
			  var temple = $(".itemParamAddTemplate li").eq(0).clone();
			  $(this).parent().parent().append(temple);
			  temple.find(".addParam").click(function(){
				  var li = $(".itemParamAddTemplate li").eq(2).clone();
				  li.find(".delParam").click(function(){
					  $(this).parent().remove();
				  });
				  li.appendTo($(this).parentsUntil("ul").parent());
			  });
			  temple.find(".delParam").click(function(){
				  $(this).parent().remove();
			  });
		 });
		
		//关闭页面
		$("#itemParamAddTable .close").click(function(){
			$(".panel-tool-close").click();
		});
		
		
		//提交
		$("#itemParamAddTable .submit").click(function(){
			var params = [];
			var groups = $("#itemParamAddTable [name=group]");	//获取所有名字叫做group的input
			//一共两组数据
			groups.each(function(i,e){
				var p = $(e).parentsUntil("ul").parent().find("[name=param]");//根据当前的group找到最近的ul找到下面所有的paraminput
				var _ps = [];
				p.each(function(_i,_e){
					var _val = $(_e).siblings("input").val();
					if($.trim(_val).length>0){
						_ps.push(_val);						
					}
				});
				var _val = $(e).siblings("input").val();
				if($.trim(_val).length>0 && _ps.length > 0){
					params.push({
						"group":_val,
						"params":_ps
					});					
				}
			});
			var url = "/item/param/template/"+$("#itemParamAddTable [name=cid]").val();
			$.post(url,{"paramData":JSON.stringify(params)},function(data){
				$.messager.alert('提示','新增商品规格成功!',undefined,function(){
					$(".panel-tool-close").click();
   					$("#itemParamList").datagrid("reload");
   				});
			});
		});
	});
</script>