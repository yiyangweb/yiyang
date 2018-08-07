<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools"></t:base>
<div>
	<t:tabs id="meterTabs" iframe="true" heigth="450px" tabPosition="top" fit="false">
		<t:tab href="chargeMeterController.do?getMeterTab&type=1" icon="icon-search" title="水费" id="tab1"></t:tab>
		<t:tab href="chargeMeterController.do?getMeterTab&type=2" icon="icon-save" title="电费" id="tab2"></t:tab>
		<t:tab href="chargeMeterController.do?getMeterTab&type=3" icon="icon-save" title="煤气费" id="tab3"></t:tab>
		<%--<t:tab href="cgReportController.do?list&id=water_meter_info" icon="icon-search" title="水费" id="tab1"></t:tab>
		<t:tab href="cgReportController.do?list&id=electronic_meter_info" icon="icon-save" title="电费" id="tab2"></t:tab>
		<t:tab href="cgReportController.do?list&id=gas_meter_info" icon="icon-save" title="煤气费" id="tab3"></t:tab>--%>
	</t:tabs>
</div>