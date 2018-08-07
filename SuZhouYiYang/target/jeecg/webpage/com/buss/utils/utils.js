
function getNo(code) {
    var result = "";
    $.ajax({
        url: "utilController.do?getNo",
        data: {code:code},
        async:false,
        success: function(data){
            //console.log("data: "+data);
            result =  data;
        }
    });
    return result;
}