/**
 *建筑联动下拉框
 */
(function($) {
    $.fn.regionselect = function(argoptions) {
        var argdefault={
            building_id:'',
            buildingid:'',
            secondid:'',
            thirdid:'',
            second_search_value:'',
            third_search_value:''
        };
        var ajaxmethod=function(url,building_id,search_value,selectionclass){
            param={building_id:building_id,searchvalue:search_value};
            $.get(url,param,function(data){
                if(data != null){
                    var jsonData=JSON.parse(data);
                    $.each(jsonData,function(i,value){
                        if($('#'+selectionclass).val()==value['id']){
                            $("."+selectionclass).append("<option selected='selected' idq='"+value['id']+"' value='"+value['id']+"'>"+value['name']+"</option>");
                            $("."+selectionclass).trigger('change');
                        }else{
                            $("."+selectionclass).append("<option idq='"+value['id']+"' value='"+value['id']+"'>"+value['name']+"</option>");
                        }
                    });
                }
            });
        };
        var options = $.fn.extend({},argdefault,argoptions);
        return this.each(function() {
            var oo = $(this);
            var oowidth=oo.css("width");
            oo.after("<select class='form-control "+options.buildingid+"' name='"+options.buildingid+"' style='display:inline-block;width:"+oowidth+"'><option value='' idq=''>-- 请选择 --</option></select>");
            oo.css("display","none");

            var secondobj=$("#"+options.secondid);
            var secondwidth=secondobj.css("width");
            secondobj.after("<select class='form-control "+options.secondid+"' name='"+options.secondid+"' style='display:inline-block;width:"+secondwidth+"'><option value='' idq=''>-- 请选择 --</option></select>");
            secondobj.css("display","none");

            if(options.thirdid != null && options.thirdid != ''){
                var thirdobj=$("#"+options.thirdid);
                var thirdwidth=thirdobj.css("width");
                thirdobj.after("<select class='form-control "+options.thirdid+"' name='"+options.thirdid+"' style='display:inline-block;width:"+thirdwidth+"'><option value='' idq=''>-- 请选择 --</option></select>");
                thirdobj.css("display","none");
            }

            ajaxmethod(options['url'],options[''],options[''],options['buildingid']);

            $("."+options.buildingid).bind("change",function(){
                var provselected=$("."+options.buildingid+" option:selected").attr("idq");
                if($("."+options.secondid).length>0){
                    $("."+options.secondid).empty();
                    $("."+options.secondid).append("<option value=''>-- 请选择 --</option>");
                    ajaxmethod(options['url'],provselected,options['second_search_value'],options['secondid']);
                }

                if(options.thirdid != null && options.thirdid != ''){
                    if($("."+options.thirdid).length>0){
                        $("."+options.thirdid).empty();
                        $("."+options.thirdid).append("<option value=''>-- 请选择 --</option>");
                        ajaxmethod(options['url'],provselected,options['third_search_value'],options['thirdid']);
                    }
                }
            });

        });
    };
})(jQuery);