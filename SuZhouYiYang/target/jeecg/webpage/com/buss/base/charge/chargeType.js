

//通用弹出式文件上传
function commonUpload(callback){
    $.dialog({
           content: "url:systemController.do?commonUpload",
           lock : true,
           title:"文件上传",
           zIndex:2100,
           width:700,
           height: 200,
           parent:windowapi,
           cache:false,
       ok: function(){
               var iframe = this.iframe.contentWindow;
               iframe.uploadCallback(callback);
                   return true;
       },
       cancelVal: '关闭',
       cancel: function(){
       } 
   });
}
function browseImages(inputId, Img) {// 图片管理器，可多个上传共用
}
function browseFiles(inputId, file) {// 文件管理器，可多个上传共用
}
function decode(value, id) {//value传入值,id接受值
	var last = value.lastIndexOf("/");
	var filename = value.substring(last + 1, value.length);
	$("#" + id).text(decodeURIComponent(filename));
}

function openDepartmentSelect() {
    $.dialog.setting.zIndex = getzIndex();
    var orgIds = $("#orgIds").val();
    // update-begin--Author:LiShaoQing  Date:20170802 for：z-index被覆盖的问题---------
    $.dialog({content: 'url:departController.do?departSelect&orgIds='+orgIds, zIndex: getzIndex(), title: '组织机构列表', lock: true, width: '400px', height: '350px', opacity: 0.4, button: [
            {name: '确定', callback: callbackDepartmentSelect, focus: true},
            {name: '关闭', callback: function (){}}
        ]}).zindex();
    // update-end--Author:LiShaoQing  Date:20170802 for：z-index被覆盖的问题---------
}
function callbackDepartmentSelect() {
    var iframe = this.iframe.contentWindow;
    var treeObj = iframe.$.fn.zTree.getZTreeObj("departSelect");
    var nodes = treeObj.getCheckedNodes(true);
    if(nodes.length == 1){
        var node = nodes[0];
        var ids = node.code;
        var names = node.name;
        $('#belongDeptName').val(names);
        $('#belongDeptName').blur();
        $('#belongDeptCode').val(ids);
    }else if(nodes.length > 1){
        $.messager.alert('错误', '请勿选择多个，请检查！');
    }
}