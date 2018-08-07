<%--
  Created by IntelliJ IDEA.
  房间信息一览
  User: caijunrong
  Date: 2018/5/18
  Time: 10:22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools"></t:base>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        .status1{
            background-color:pink;
        }
        .status2{
            background-color:deepskyblue;
        }
        .status3{
            background-color:orange;
        }
        .status4{
            background-color:darkseagreen;
        }
        .status5{
            background-color:mediumpurple;
        }
        .status6{
            background-color:lightyellow;
        }
        .status7{
            background-color:lightgrey;
        }
    </style>
    <link type="text/css" rel="stylesheet" href="plug-in/fontAwesome/css/font-awesome.min.css" />
</head>
<body>
<div id="main">
    <div>楼栋房间信息一览</div>

    <!-- 人数统计以及楼号查询 -->
    <div style="display: flex;justify-content: space-between;">
        <div>
            入住总户数：<text id="rooms">0</text>;
            长期入住房：<text id="longLivingRooms">0</text>;
            短期入住房：<text id="shortLivingRooms">0</text>;
            入住总人数：<text id="people">0</text>;
            男性长者数：<text id="males">0</text>;
            女性长者数：<text id="females">0</text>; 
        </div>
        <div>
            楼号：
            <select id="buildingSelected" onchange="changeSelected(this.value)">
            </select>
            <text>&nbsp&nbsp&nbsp</text>
        </div>
    </div>

    <!-- 房间信息展示 -->
    <div id="roomInfo"></div>

    <!-- 背景颜色说明 -->
    <div>
        <table cellspacing="10" style="margin:auto">
            <tr>
                <td class="status1" width="125px" height="125px" align="center">准备房</td>
                <td class="status2" width="125px" height="125px" align="center">长期入住房</td>
                <td class="status3" width="125px" height="125px" align="center">短期入住房</td>
                <td class="status4" width="125px" height="125px" align="center">OK房</td>
                <td class="status5" width="125px" height="125px" align="center">保留房</td>
                <td class="status6" width="125px" height="125px" align="center">空房</td>
                <td class="status7" width="125px" height="125px" align="center">维修房</td>
            </tr>
        </table>
    </div>

</div>
<script type="text/javascript">

    var echartsWarp= document.getElementById('main');
    var resizeWorldMapContainer = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        echartsWarp.style.width = window.innerWidth-20+'px';
        echartsWarp.style.height = window.innerHeight-20+'px';
    };
    resizeWorldMapContainer ();//设置容器高宽

    doCreateSelectItems();
    function changeSelected(value){
        var building_id = value;
        doFillTextData(building_id);
        doCreateRoom(building_id);
    }

    //填充楼号下拉框(默认选中第一个)
    function doCreateSelectItems() {
        $.ajax({
            type: "GET",
            url: "baseBuildingController.do?datagrid&field=id,no,name",
            success: function(data){
                createSelectItems(data);
            }
        });
        function createSelectItems(obj){
            var building_id = obj.rows[0].id;
            var str ='';
            for (i in obj.rows) {
                str += '<option value ="'+obj.rows[i].id+'"';
                if(i == 0) str += ' selected>';
                else str += '>';
                str += obj.rows[i].name;
                str += '</option>'
            }
            document.getElementById("buildingSelected").innerHTML = str;
            doFillTextData(building_id);
            doCreateRoom(building_id);
        }
    }

    //填充人数
    function doFillTextData(building_id) {
        $.ajax({
            type: "GET",
            url: "baseBuildingRoomController.do?getPeopleInfoData&building_id="+building_id,
            success: function(data){
                fillTextData(JSON.parse(data));
            }
        });
        function fillTextData(obj){
            var data = obj[0];
            document.getElementById("rooms").innerText = (data.rooms);
            document.getElementById("longLivingRooms").innerText = (data.longlivingrooms);
            document.getElementById("shortLivingRooms").innerText = (data.shortlivingrooms);
            document.getElementById("people").innerText = (data.people);
            document.getElementById("males").innerText = (data.males);
            document.getElementById("females").innerText = (data.females);
        }
    }

    //创建房间视图
    function doCreateRoom(building_id) {
        $.ajax({
            type: "GET",
            url: "baseBuildingRoomController.do?getRoomInfoData&building_id="+building_id,
            success: function(data){
                createRoom(JSON.parse(data));
            }
        });
        function createRoom(obj) {
            var length = 8; //默认一行显示8个房间
            var str = '<table cellspacing="10" style="margin:auto">';
            for (i in obj) {
                if(i%length == 0) str += '<tr>';
                var value = obj[i];
                str += '<td class="status'+value.room_status+'" width="125px" height="125px" align="center" ' +
                    "onclick='goDetails(\""+value.room_id+"\")'>"
                str += '<div>'+value.room_name+'</div>';
                var roomInfo = '';
                if(value.room_info != null) roomInfo = value.room_info.split(';');
                for (j in roomInfo) {
                    if(roomInfo[j] != '') {
                        var roomInfoList = roomInfo[j].split(',');
                        str += '<div>';
                        str += roomInfoList[0];
                        if(roomInfoList[1].indexOf('男性')>=0){
                            str += '&nbsp<i class="fa fa-mars" aria-hidden="true"></i>';
                        }else if(roomInfoList[1].indexOf('女性')>=0){
                            str += '&nbsp<i class="fa fa-venus" aria-hidden="true"></i>';
                        }
                        str += '</div>';
                    }
                }
                str += '</td>'
                if(i%length == length-1) str += '</tr>';
            }
            str += '</table>'
            document.getElementById("roomInfo").innerHTML = str;
        }
    }

    function goDetails(id) {
        //var popupFw = 980,popupFh = 500;
        createwindow('查看','baseBuildingRoomController.do?getDetails&load=detail&&id='+id,'100%','100%');
    }

</script>
</body>
</html>