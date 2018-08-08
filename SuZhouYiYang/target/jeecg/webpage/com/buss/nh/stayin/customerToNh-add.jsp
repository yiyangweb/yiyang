<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>护理院入住</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript">
        //编写自定义JS代码
	</script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="customerToNhController.do?doAdd" >
	<input id="id" name="id" type="hidden" value="${customerToNhPage.id }"/>
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">
					入住编号:
				</label>
			</td>
			<td class="value">
				<input id="no" name="no" type="text" style="width: 150px" class="inputxt" readonly="true" value='${customerToNhPage.no}'	datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					顾客姓名:
				</label>
			</td>
			<td class="value">
				<input id="customerName" readonly="true" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="ignore"   onclick="popupClick(this,'customer_id,customer_name,customer_no,no,building_id,building_name,room_id,room_name,bed_id,bed_name,nurse_level_info,sex','customerId,customerName,customerNo,contractNo,buildingId,buildingName,roomId,roomName,bedId,bedName,nurseLevel,sex','contract_info_nh')"  />
				<input id="nurseLevel" name="nurseLevel" type="hidden"/>
				<input id="sex" name="sex" type="hidden"/>
				<input id="customerId" name="customerId" type="hidden"/>
				<input id="customerNo" name="customerNo" type="hidden"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					床位:
				</label>
			</td>
			<td class="value">
				<input id="bedName" name="bedName"  readonly="true" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="ignore" />
				<input id="bedId" name="bedId" type="hidden"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">床位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					合同编号:
				</label>
			</td>
			<td class="value">
				<input id="contractNo" name="contractNo"  readonly="true" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					楼栋:
				</label>
			</td>
			<td class="value">
				<input id="buildingName" name="buildingName"  readonly="true" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<input id="buildingId" name="buildingId" type="hidden"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼栋</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					房间名称:
				</label>
			</td>
			<td class="value">
				<input id="roomName" name="roomName"   readonly="true" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<input id="roomId" name="roomId" type="hidden"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					入住经办人:
				</label>
			</td>
			<td class="value">
				<input id="inCharge"  readonly="true" name="inCharge" type="text" style="width: 150px" class="inputxt" 	value="${user.realName}"	datatype="*" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住经办人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					入住时间:
				</label>
			</td>
			<td class="value">
				<input id="inDate" name="inDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 		datatype="*" ignore="ignore" />

				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住时间</label>
			</td>
		</tr>


	</table>
</t:formvalid>
</body>
<script src = "webpage/com/buss/nh/stayin/customerToNh.js"></script>
