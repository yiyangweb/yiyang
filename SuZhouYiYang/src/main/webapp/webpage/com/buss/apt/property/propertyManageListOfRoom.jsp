<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
    $(document).ready(function(){
        $(".datagrid-toolbar").parent().css("width","auto");
        if(location.href.indexOf("load=detail")!=-1){
            $(":input").attr("disabled","true");
        }
    });
</script>
<table border="0" cellpadding="2" cellspacing="0" id="propertyManageListOfRoom_table">
 <tr bgcolor="#E6E6E6">
  <td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
  <td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   长者姓名
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   房间编号
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   负责人
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   维修人
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   流程状态
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   维修项目
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   费用
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   开始时间
  </td>
  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
   结束时间
  </td>
 </tr>
 <tbody id="add_baseBuildingBed_table">
 <%--
 <c:if test="${fn:length(propertyManageEntityList)  <= 0 }">
  <tr>
   <td align="center"><div style="width: 25px;" name="xh">1</div></td>
   <td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
   <td align="left">
    <input name="propertyManageEntityList[0].customerName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
    <label class="Validform_label" style="display: none;">长者姓名</label>
   </td>
   <td align="left">
    <input name="propertyManageEntityList[0].roomNo" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
    <label class="Validform_label" style="display: none;">房间编号</label>
   </td>
   <td align="left">
       <input name="propertyManageEntityList[0].keeper" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
    <label class="Validform_label" style="display: none;">负责人</label>
   </td>
   <td align="left">
    <input name="propertyManageEntityList[0].repairman" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
    <label class="Validform_label" style="display: none;">维修人</label>
   </td>
   <td align="left">
    <input name="propertyManageEntityList[0].status" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
    <label class="Validform_label" style="display: none;">流程状态</label>
   </td>
   <td align="left">
       <input name="propertyManageEntityList[0].detail" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
       <label class="Validform_label" style="display: none;">维修项目</label>
   </td>
   <td align="left">
       <input name="propertyManageEntityList[0].charge" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
       <label class="Validform_label" style="display: none;">费用</label>
   </td>
   <td align="left">
       <input name="propertyManageEntityList[0].startTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
    <label class="Validform_label" style="display: none;">开始时间</label>
   </td>
   <td align="left">
       <input name="propertyManageEntityList[0].finishTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
       <label class="Validform_label" style="display: none;">结束时间</label>
   </td>
  </tr>
 </c:if>
 --%>
 <c:if test="${fn:length(propertyManageEntityList)  > 0 }">
  <c:forEach items="${propertyManageEntityList}" var="poVal" varStatus="stuts">
      <tr>
          <td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
          <td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].customerName" value="${poVal.customerName }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">长者姓名</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].roomNo" value="${poVal.roomNo }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">房间编号</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].keeper" value="${poVal.keeper }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">负责人</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].repairman" value="${poVal.repairman }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">维修人</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].status" value="${poVal.status }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">流程状态</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].detail" value="${poVal.detail }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">维修项目</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].charge" value="${poVal.charge }" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
              <label class="Validform_label" style="display: none;">费用</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].startTime" value="${poVal.startTime }" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
              <label class="Validform_label" style="display: none;">开始时间</label>
          </td>
          <td align="left">
              <input name="propertyManageEntityList[${stuts.index }].finishTime" value="${poVal.finishTime }" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
              <label class="Validform_label" style="display: none;">结束时间</label>
          </td>
      </tr>
  </c:forEach>
 </c:if>
 </tbody>
</table>
