<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>护理记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
  <script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="nurseRecordController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${nurseRecordPage.id }"/>
	  <input id="bedId" name="bedId" type="hidden" />
	  <input id="customerNo" name="customerNo" type="hidden" />
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							房间:
						</label>
					</td>
					<td class="value">
						<input id="roomName" name="roomName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="ignore"   onclick="popupClick(this,'customer_no,customer_name,room_name,bed_id,bed_name','customerNo,customerName,roomName,bedId,bedName','stayin_info_nh')"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							床位:
						</label>
					</td>
					<td class="value">
							<input id="bedName" name="bedName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"    />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">床位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							顾客姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">顾客姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							记录日期:
						</label>
					</td>
					<td class="value">
							   <input id="recordDate" name="recordDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">记录日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							血压:
						</label>
					</td>
					<td class="value">
					     	 <input id="bloodPressure" name="bloodPressure" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">血压</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							脉搏:
						</label>
					</td>
					<td class="value">
					     	 <input id="pulse" name="pulse" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">脉搏</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							体温:
						</label>
					</td>
					<td class="value">
					     	 <input id="animalHeat" name="animalHeat" type="text" style="width: 150px" class="inputxt" 		datatype="d" ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体温</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							呼吸:
						</label>
					</td>
					<td class="value">
					     	 <input id="breath" name="breath" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">呼吸</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否吸氧:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="isOxygen" type="list"  typeGroupCode="sf_yn"  defaultVal="${nurseRecordPage.isOxygen}" hasLabel="false"  title="是否吸氧" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否吸氧</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							口服药:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="takeMedicine" type="list"  typeGroupCode="sf_yn"  defaultVal="${nurseRecordPage.takeMedicine}" hasLabel="false"  title="口服药" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">口服药</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							心理护理:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="mentalHelp" type="list"  typeGroupCode="sf_yn"  defaultVal="${nurseRecordPage.mentalHelp}" hasLabel="false"  title="心理护理" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">心理护理</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							护士:
						</label>
					</td>
					<td class="value">
					     	 <input id="charger" name="charger" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${user.realName}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">护士</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交班事项:
						</label>
					</td>
					<td class="value">
					     	 <input id="handoverDes" name="handoverDes" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交班事项</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							附件:
						</label>
					</td>
					<td class="value">
								<table></table>
								<div class="form jeecgDetail"> 
									<script type="text/javascript">
										var serverMsg="";
										$(function(){
											$('#attachment').uploadify({
												buttonText:'添加文件',
												auto:false,
												progressData:'speed',
												multi:true,
												height:25,
												overrideEvents:['onDialogClose'],
												fileTypeDesc:'文件格式:',
												queueID:'filediv_attachment',
												fileSizeLimit:'15MB',
												swf:'plug-in/uploadify/uploadify.swf',	
												uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
												onUploadStart : function(file) { 
													var cgFormId=$("input[name='id']").val();
													$('#attachment').uploadify("settings", "formData", {
														'cgFormId':cgFormId,
														'cgFormName':'nurse_record',
														'cgFormField':'ATTACHMENT'
													});
												} ,
												onQueueComplete : function(queueData) {
													 var win = frameElement.api.opener;
													 win.reloadTable();
													 win.tip(serverMsg);
													 frameElement.api.close();
												},
												onUploadSuccess : function(file, data, response) {
													var d=$.parseJSON(data);
													if(d.success){
														var win = frameElement.api.opener;
														serverMsg = d.msg;
													}
												},
												onFallback: function() {
								                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
								                },
								                onSelectError: function(file, errorCode, errorMsg) {
								                    switch (errorCode) {
								                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
								                        break;
								                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
								                        break;
								                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
								                        break;
								                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
								                        break;
								                    }
								                },
								                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
											});
										});
									</script>
									<span id="file_uploadspan"><input type="file" name="attachment" id="attachment" /></span> 
								</div> 
								<div class="form" id="filediv_attachment"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附件</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/nh/nurse/nurseRecord.js"></script>		
	  	<script type="text/javascript">
	  		function jeecgFormFileCallBack(data){
	  			if (data.success == true) {
					uploadFile(data);
				} else {
					if (data.responseText == '' || data.responseText == undefined) {
						$.messager.alert('错误', data.msg);
						$.Hidemsg();
					} else {
						try {
							var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
							$.messager.alert('错误', emsg);
							$.Hidemsg();
						} catch(ex) {
							$.messager.alert('错误', data.responseText + '');
						}
					}
					return false;
				}
				if (!neibuClickFlag) {
					var win = frameElement.api.opener;
					win.reloadTable();
				}
	  		}
	  		function upload() {
					$('#attachment').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#attachment').uploadify('cancel', '*');
			}
			function uploadFile(data){
				if(!$("input[name='id']").val()){
					if(data.obj!=null && data.obj!='undefined'){
						$("input[name='id']").val(data.obj.id);
					}
				}
				if($(".uploadify-queue-item").length>0){
					upload();
				}else{
					if (neibuClickFlag){
						alert(data.msg);
						neibuClickFlag = false;
					}else {
						var win = frameElement.api.opener;
						win.reloadTable();
						win.tip(data.msg);
						frameElement.api.close();
					}
				}
			}
	  	</script>
