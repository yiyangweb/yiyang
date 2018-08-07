<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>退款信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="customerRefundController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${customerRefundPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								编号:
							</label>
						</td>
						<td class="value">
						    <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.no}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								标题:
							</label>
						</td>
						<td class="value">
						    <input id="title" name="title" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.title}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标题</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								退款途径:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="returnWay" type="list"  typeGroupCode="refund_way"   defaultVal="${customerRefundPage.returnWay}" hasLabel="false"  title="退款途径" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退款途径</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								顾客编号:
							</label>
						</td>
						<td class="value">
							<input id="customerNo" name="customerNo" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'no,name','customerNo,customerName','customer_base')" value='${customerRefundPage.customerNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">顾客编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								顾客姓名:
							</label>
						</td>
						<td class="value">
						    <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.customerName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">顾客姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								属于:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="belongTo" type="list"  typeGroupCode="cs_status"   defaultVal="${customerRefundPage.belongTo}" hasLabel="false"  title="属于" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">属于</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								金额:
							</label>
						</td>
						<td class="value">
						    <input id="money" name="money" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.money}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								相关环节:
							</label>
						</td>
						<td class="value">
						    <input id="originFlow" name="originFlow" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.originFlow}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">相关环节</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								操作人:
							</label>
						</td>
						<td class="value">
						    <input id="charger" name="charger" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.charger}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								操作时间:
							</label>
						</td>
						<td class="value">
									  <input id="dealDate" name="dealDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${customerRefundPage.dealDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="des" name="des" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerRefundPage.des}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
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
  <script src = "webpage/com/buss/apt/refund/customerRefund.js"></script>		
