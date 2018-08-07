<%--
  Created by IntelliJ IDEA.
  User: caijunrong
  Date: 2018/5/25
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
    $(function(){$('#water_meter_infoList').datagrid(
        {
            idField: 'id',
            title: '',
            url:'${url}',
            fit:true,
            fitColumns:false,
            pageSize: 10,
            pagination:true,
            pageList:[10,30,50,100],
            singleSelect:true,
            checkbox:false,
            sortOrder:'asc',
            rownumbers:true,
            showFooter:true,
            frozenColumns:[[]],
            columns:[
                [
                    {field:'no',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'记录编号'},
                    {field:'customer_name',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'长者姓名'},
                    {field:'room_name',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'房间号'},
                    {field:'building_name',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'楼号'},
                    {field:'reading',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'读数'},
                    {field:'reading_time',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'抄表时间'},
                    {field:'last_reading',
                        //update-begin-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应

                        title:'上期读数'},
                    {field:'last_reading_time',title:'上期抄表时间'}
                    //update-end-- author:YanDong ---date:20171026 ----for:#2381 【Online开发】 在线开发报表配置的列宽无法根据列的内容自适应
                ]
            ],
            onLoadSuccess:function(data){$("#water_meter_infoList").datagrid("clearSelections");},
            onClickRow:function(rowIndex,rowData)
            {rowid=rowData.id;gridname='water_meter_infoList';}
        });
        $('#water_meter_infoList').datagrid('getPager').pagination({beforePageText:'',afterPageText:'/{pages}',displayMsg:'{from}-{to}共{total}条',showPageList:true,showRefresh:true});
        $('#water_meter_infoList').datagrid('getPager').pagination({onBeforeRefresh:function(pageNumber, pageSize){ $(this).pagination('loading');$(this).pagination('loaded'); }});});
    function reloadTable(){
        try{
            $('#'+gridname).datagrid('reload');
            $('#'+gridname).treegrid('reload');
        }catch(ex){
            //donothing
        }
    }
    function water_meter_infoListsearch(){var queryParams=$('#water_meter_infoList').datagrid('options').queryParams;$('#water_meter_infoListtb').find('*').each(function(){queryParams[$(this).attr('name')]=$(this).val();});$('#water_meter_infoList').datagrid({url:'${url}',pageNumber:1});}
    function water_meter_infoListsearchbox(value,name){var queryParams=$('#water_meter_infoList').datagrid('options').queryParams;queryParams[name]=value;queryParams.searchfield=name;$('#water_meter_infoList').datagrid('reload');}$('#water_meter_infoListsearchbox').searchbox({searcher:function(value,name){water_meter_infoListsearchbox(value,name);},menu:'#water_meter_infoListmm',prompt:'请输入查询关键字'});
    function searchReset_water_meter_info(name){ $("#"+name+"tb").find(":input").val("");water_meter_infoListsearch();}
</script>
<table width="100%"   id="water_meter_infoList" toolbar="#water_meter_infoListtb"></table>
<div id="water_meter_infoListtb" style="padding:3px; height: auto">
	<div name="searchColums">
		<span style="display:-moz-inline-box;display:inline-block;">
		<span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 100px;text-align:right;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap;" title="长者姓名">长者姓名：</span>
				<input type="text" name="name"  style="width: 100px"   />
		</span>
		<span style="display:-moz-inline-box;display:inline-block;">
		<span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 100px;text-align:right;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap;" title="房间号">房间号：</span>
				<input type="text" name="room_no"  style="width: 100px"   />
		</span>
		<span style="float:right">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="water_meter_infoListsearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="searchReset_water_meter_info('water_meter_infoList')">重置</a>
		</span>
	</div>
</div>


