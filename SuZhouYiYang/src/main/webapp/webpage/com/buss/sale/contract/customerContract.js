
$.getScript("webpage/com/buss/utils/utils.js");

//补0
function pad(num, n) {
    var len = num.toString().length;
    while (len < n) {
        num = "0" + num;
        len++;
    }
    return num;
}

//初始化下标
function resetTrNum(tableId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('>tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this),validtype_str = $this.attr('validType'), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val();
			if(name!=null){
				if (name.indexOf("#index#") >= 0){
					$this.attr("name",name.replace('#index#',i));

                    //新增收费列表 编号自动填值
                    if(tableId == "add_contractChargeList_table"){
                        if(name.indexOf("no") >= 0){
                            $this.val(getNo($("#no").val().substring(0,2)+"C"));
                        }
                    }
                    //新增附属合同 编号自动填值
                    if(tableId == "add_customerContractSub_table"){
                        if(name.indexOf("no") >= 0){
                            $this.val(getNo($("#no").val().substring(0,2)+"S"));
                        }
                    }
                    //新增分期情况 编号自动填值
                    if(tableId == "add_chargeList_table"){
                        if(name.indexOf("no") >= 0){
                            $this.val(getNo($("#no").val().substring(0,2)+"F"));
                        }
                        //默认第一行分期是第一个序号是1
                        if(name.indexOf("orderNo") >= 0 && i == 0){
                            $this.val(i+1);
						}
                        //默认第一行分期是下个月开始付款
                        if(name.indexOf("chargeDate") >= 0 && i == 0){
                        	if($("#signDate").val() != "") {
                                var signDateArr = $("#signDate").val().split("-");
                                var year = signDateArr[0];
                                var month = signDateArr[1];
                                var nextMonth = month;
                                if (parseInt(month) == 12) {
                                    year = parseInt(year) + 1;
                                    nextMonth = 1;
                                } else {
                                    nextMonth = parseInt(month) + 1;
                                }
                                $this.val(year + "-" + pad(nextMonth, 2) + "-01");
                            }
						}
                    }
				}else{
					var s = name.indexOf("[");
					var e = name.indexOf("]");
					var new_name = name.substring(s+1,e);
					$this.attr("name",name.replace(new_name,i));
				}
			}
			if(id!=null){
				if (id.indexOf("#index#") >= 0){
					$this.attr("id",id.replace('#index#',i));
				}else{
					var s = id.indexOf("[");
					var e = id.indexOf("]");
					var new_id = id.substring(s+1,e);
					$this.attr("id",id.replace(new_id,i));
				}
			}
			if(onclick_str!=null){
				if (onclick_str.indexOf("#index#") >= 0){
					$this.attr("onclick",onclick_str.replace(/#index#/g,i));
				}else{
				}
			}
			if(validtype_str!=null){
				if(validtype_str.indexOf("#index#") >= 0){
					$this.attr("validType",validtype_str.replace('#index#',i));
				}
			}
		});
		$(this).find('div[name=\'xh\']').html(i+1);
	});
}
//通用弹出式文件上传
function commonUpload(callback,inputId){
    $.dialog({
           content: "url:systemController.do?commonUpload",
           lock : true,
           title:"文件上传",
           zIndex:getzIndex(),
           width:700,
           height: 200,
           parent:windowapi,
           cache:false,
       ok: function(){
               var iframe = this.iframe.contentWindow;
               iframe.uploadCallback(callback,inputId);
               return true;
       },
       cancelVal: '关闭',
       cancel: function(){
       } 
   });
}
//通用弹出式文件上传-回调
function commonUploadDefaultCallBack(url,name,inputId){
	$("#"+inputId+"_href").attr('href',url).html('下载');
	$("#"+inputId).val(url);
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

$(document).ready(function(){

    //是否分期
    $("select[name='isInstalments']").bind('change', function() {
        $("#numOfPeriods").val("0");//清空分期数
        if($("select[name='isInstalments']").val().toString() == "1") //是
            $("#numOfPeriods").attr("readonly",false);
        else
            $("#numOfPeriods").attr("readonly",true);
    });

});

function checkValid() {
	var numOfPeriods = $("#numOfPeriods").val();
    var tableRows = $("#add_chargeList_table").find("tr").length;
    var valid = true;
    if(numOfPeriods.toString() != tableRows.toString()) {
        valid = false;
        $.messager.alert("错误", "请检查：分期期数和分期情况不符！");
    }
	return valid;
}