<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用详细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="customerFeeDesController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${customerFeeDesPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								顾客编号:
							</label>
						</td>
						<td class="value">
						    <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerFeeDesPage.customerNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">顾客编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								顾客姓名:
							</label>
						</td>
						<td class="value">
						    <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerFeeDesPage.customerName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">顾客姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收费编号:
							</label>
						</td>
						<td class="value">
						    <input id="chargeNo" name="chargeNo" type="text" style="width: 150px" class="inputxt" 		validType="customer_fee_des,charge_no,id" datatype="*" ignore="checked"  value='${customerFeeDesPage.chargeNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								收费项目:
							</label>
						</td>
						<td class="value">
						    <input id="chargeName" name="chargeName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerFeeDesPage.chargeName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费项目</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								费用:
							</label>
						</td>
						<td class="value">
						    <input id="fee" name="fee" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${customerFeeDesPage.fee}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								属于:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="belongTo" type="list"  typeGroupCode="cs_status"   defaultVal="${customerFeeDesPage.belongTo}" hasLabel="false"  title="属于" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">属于</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收费部门:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="belongDept" type="list"  dictTable="t_s_depart" dictField="org_code" dictText="departname"   defaultVal="${customerFeeDesPage.belongDept}" hasLabel="false"  title="收费部门" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费部门</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								费用状态:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fdStatus" type="list"  typeGroupCode="sf_status"   defaultVal="${customerFeeDesPage.fdStatus}" hasLabel="false"  title="费用状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收费说明:
							</label>
						</td>
						<td class="value">
						    <input id="feeDes" name="feeDes" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerFeeDesPage.feeDes}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费说明</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								计费人:
							</label>
						</td>
						<td class="value">
						    <input id="countPerson" name="countPerson" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerFeeDesPage.countPerson}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生成时间:
							</label>
						</td>
						<td class="value">
									   <input id="countDate" name="countDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${customerFeeDesPage.countDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生成时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								收费人:
							</label>
						</td>
						<td class="value">
						    <input id="charger" name="charger" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerFeeDesPage.charger}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收费日期:
							</label>
						</td>
						<td class="value">
									   <input id="chargeDate" name="chargeDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${customerFeeDesPage.chargeDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费日期</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/apt/feedes/customerFeeDes.js"></script>		
