<%--
  Created by IntelliJ IDEA.
  房间信息详情
  User: caijunrong
  Date: 2018/5/18
  Time: 10:22
--%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>建筑物房间信息</title>
    <style>
        .ui-button {
            display: inline-block;
            padding: 2px 2px;
            margin-bottom: 0;
            font-size: 8px;
            font-weight: normal;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }
    </style>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#tt').tabs({
                onSelect:function(title){
                    $('#tt .panel-body').css('width','auto');
                }
            });
            $(".tabs-wrap").css('width','100%');
        });
    </script>
</head>
<body style="overflow-x: hidden;">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="" >
    <input id="id" name="id" type="hidden" value="${baseBuildingRoomPage.id }"/>
    <table cellpadding="0" cellspacing="1" class="formtable">
        <tr>
            <td align="right">
                <label class="Validform_label">建筑名称:</label>
            </td>
            <td class="value">
                <t:dictSelect field="baseBuildingId" type="list"   dictTable="base_building" dictField="id" dictText="name"  defaultVal="${baseBuildingRoomPage.baseBuildingId}" hasLabel="false"  title="建筑名称" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">建筑名称</label>
            </td>
            <td align="right">
                <label class="Validform_label">楼层名称:</label>
            </td>
            <td class="value">
                <t:dictSelect field="baseBuildingStoreyId" type="list"   dictTable="base_building_storey" dictField="id" dictText="name"  defaultVal="${baseBuildingRoomPage.baseBuildingStoreyId}" hasLabel="false"  title="楼层名称" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">楼层名称</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">房间类型:</label>
            </td>
            <td class="value">
                <t:dictSelect field="baseBuildingRoomTypeId" type="list"   dictTable="base_building_room_type" dictField="id" dictText="name"  defaultVal="${baseBuildingRoomPage.baseBuildingRoomTypeId}" hasLabel="false"  title="房间类型" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">房间类型</label>
            </td>
            <td align="right">
                <label class="Validform_label">房间编号:</label>
            </td>
            <td class="value">
                <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.no}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">房间编号</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">房间名称:</label>
            </td>
            <td class="value">
                <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value='${baseBuildingRoomPage.name}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">房间名称</label>
            </td>
            <td align="right">
                <label class="Validform_label">管理员:</label>
            </td>
            <td class="value">
                <t:dictSelect field="manager" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${baseBuildingRoomPage.manager}" hasLabel="false"  title="管理员" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">管理员</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">负责人:</label>
            </td>
            <td class="value">
                <t:dictSelect field="keeper" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${baseBuildingRoomPage.keeper}" hasLabel="false"  title="负责人" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">负责人</label>
            </td>
            <td align="right">
                <label class="Validform_label">房间状态:</label>
            </td>
            <td class="value">
                <t:dictSelect field="status" type="list"   typeGroupCode="rom_status"  defaultVal="${baseBuildingRoomPage.status}" hasLabel="false"  title="房间状态" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">房间状态</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">房间信息描述:</label>
            </td>
            <td class="value">
                <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value='${baseBuildingRoomPage.description}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">房间信息描述</label>
            </td>
            <td align="right">
                <label class="Validform_label">备注:</label>
            </td>
            <td class="value">
                <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value='${baseBuildingRoomPage.remark}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">备注</label>
            </td>
        </tr>
    </table>
    <div style="width: auto;height: 200px;">
            <%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
        <div style="width:800px;height:1px;"></div>
        <t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
            <%--<t:tab href="baseBuildingRoomController.do?baseBuildingBedList&id=${baseBuildingRoomPage.id}" icon="icon-search" title="房间床位信息" id="baseBuildingBedList"></t:tab>--%>
            <t:tab href="propertyManageController.do?listOfRoom&roomId=${baseBuildingRoomPage.id}" icon="icon-search" title="房间维修历史信息" id="manageHistoryOfRoom"></t:tab>
            <%--<t:tab href="customerToRoomController.do?listOfRoom&roomId=${baseBuildingRoomPage.id}" icon="icon-search" title="房间居住历史信息" id="livingHistoryOfRoom"></t:tab>--%>
        </t:tabs>
    </div>
</t:formvalid>
</body>
