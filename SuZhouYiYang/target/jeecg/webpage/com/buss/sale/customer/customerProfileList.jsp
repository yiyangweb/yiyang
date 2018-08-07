<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
		}
    });
</script>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:auto;">
<table cellpadding="0" cellspacing="1" class="formtable" id="customerProfile_table" >
	<tbody id="add_customerProfile_table" >	
	<c:if test="${fn:length(customerProfileList)  <= 0 }">
			<tr>
					<input name="customerProfileList[0].id" type="hidden"  value="${poVal.id}"/>
					<input name="customerProfileList[0].createName" type="hidden"  value="${poVal.createName}"/>
					<input name="customerProfileList[0].createBy" type="hidden"  value="${poVal.createBy}"/>
					<input name="customerProfileList[0].createDate" type="hidden"  value="${poVal.createDate}"/>
					<input name="customerProfileList[0].updateName" type="hidden"  value="${poVal.updateName}"/>
					<input name="customerProfileList[0].updateBy" type="hidden"  value="${poVal.updateBy}"/>
					<input name="customerProfileList[0].updateDate" type="hidden"  value="${poVal.updateDate}"/>
					<input name="customerProfileList[0].sysOrgCode" type="hidden"  value="${poVal.sysOrgCode}"/>
					<input name="customerProfileList[0].sysCompanyCode" type="hidden"  value="${poVal.sysCompanyCode}"/>
					<input name="customerProfileList[0].customerId" type="hidden"  value="${poVal.customerId}"/>
			</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										阳历生日:
									</label>
					</td>
				  <td class="value">
						<input name="customerProfileList[0].birthDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">阳历生日</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										阴历生日:
									</label>
					</td>
				  <td class="value">
						<input name="customerProfileList[0].lunarBirthDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">阴历生日</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										配偶姓名:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].mateName" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">配偶姓名</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										生活习惯:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].lifeHabit" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">生活习惯</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										手机号码:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].cellPhone" maxlength="15" type="text" class="inputxt" 		datatype="m" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">手机号码</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										固定电话:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].telephone" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">固定电话</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										邮箱:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].email" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">邮箱</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										语言:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].language" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">语言</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										交通工具:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].vehicle" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">交通工具</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										户籍地址:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].registerAddress" maxlength="100" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">户籍地址</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										所属街道:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].subDistrict" maxlength="100" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属街道</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										居住地址:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].liveAddress" maxlength="100" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">居住地址</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										公司:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].company" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">公司</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										职业:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].job" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">职业</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										教育程度:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].educatioin" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">教育程度</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										居住情况:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].olderLiveInfo" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">居住情况</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										紧急联系人:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].urgentContact" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">紧急联系人</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										电话:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].contactPhone" maxlength="32" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				</tr>
	</c:if>
	<c:if test="${fn:length(customerProfileList)  > 0 }">
		<c:forEach items="${customerProfileList}" var="poVal" varStatus="stuts" begin="0" end="0">
			<tr>
					<input name="customerProfileList[0].id" type="hidden" value="${poVal.id}"/>
					<input name="customerProfileList[0].createName" type="hidden" value="${poVal.createName}"/>
					<input name="customerProfileList[0].createBy" type="hidden" value="${poVal.createBy}"/>
					<input name="customerProfileList[0].createDate" type="hidden" value="${poVal.createDate}"/>
					<input name="customerProfileList[0].updateName" type="hidden" value="${poVal.updateName}"/>
					<input name="customerProfileList[0].updateBy" type="hidden" value="${poVal.updateBy}"/>
					<input name="customerProfileList[0].updateDate" type="hidden" value="${poVal.updateDate}"/>
					<input name="customerProfileList[0].sysOrgCode" type="hidden" value="${poVal.sysOrgCode}"/>
					<input name="customerProfileList[0].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode}"/>
					<input name="customerProfileList[0].customerId" type="hidden" value="${poVal.customerId}"/>
			</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										阳历生日:
									</label>
					</td>
				  <td class="value">
							<input name="customerProfileList[0].birthDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()" 		datatype="*" ignore="checked"  value="<fmt:formatDate value='${poVal.birthDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">阳历生日</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										阴历生日:
									</label>
					</td>
				  <td class="value">
							<input name="customerProfileList[0].lunarBirthDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  ignore="ignore"  value="<fmt:formatDate value='${poVal.lunarBirthDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">阴历生日</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										配偶姓名:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].mateName" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.mateName }"/>
					  <label class="Validform_label" style="display: none;">配偶姓名</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										生活习惯:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].lifeHabit" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.lifeHabit }"/>
					  <label class="Validform_label" style="display: none;">生活习惯</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										手机号码:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].cellPhone" maxlength="15" type="text" class="inputxt" 		datatype="m" ignore="ignore"  value="${poVal.cellPhone }"/>
					  <label class="Validform_label" style="display: none;">手机号码</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										固定电话:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].telephone" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.telephone }"/>
					  <label class="Validform_label" style="display: none;">固定电话</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										邮箱:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].email" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.email }"/>
					  <label class="Validform_label" style="display: none;">邮箱</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										语言:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].language" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.language }"/>
					  <label class="Validform_label" style="display: none;">语言</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										交通工具:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].vehicle" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.vehicle }"/>
					  <label class="Validform_label" style="display: none;">交通工具</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										户籍地址:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].registerAddress" maxlength="100" type="text" class="inputxt"  ignore="ignore"  value="${poVal.registerAddress }"/>
					  <label class="Validform_label" style="display: none;">户籍地址</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										所属街道:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].subDistrict" maxlength="100" type="text" class="inputxt"  ignore="ignore"  value="${poVal.subDistrict }"/>
					  <label class="Validform_label" style="display: none;">所属街道</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										居住地址:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].liveAddress" maxlength="100" type="text" class="inputxt"  ignore="ignore"  value="${poVal.liveAddress }"/>
					  <label class="Validform_label" style="display: none;">居住地址</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										公司:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].company" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.company }"/>
					  <label class="Validform_label" style="display: none;">公司</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										职业:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].job" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.job }"/>
					  <label class="Validform_label" style="display: none;">职业</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										教育程度:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].educatioin" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.educatioin }"/>
					  <label class="Validform_label" style="display: none;">教育程度</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										居住情况:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].olderLiveInfo" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.olderLiveInfo }"/>
					  <label class="Validform_label" style="display: none;">居住情况</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										紧急联系人:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].urgentContact" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.urgentContact }"/>
					  <label class="Validform_label" style="display: none;">紧急联系人</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										电话:
									</label>
					</td>
				  <td class="value">
					  	<input name="customerProfileList[0].contactPhone" maxlength="32" type="text" class="inputxt"  ignore="ignore"  value="${poVal.contactPhone }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>