package com.buss.base.building.dao;

import java.util.List;
import java.util.Map;
import org.jeecgframework.minidao.annotation.*;

@MiniDao
public interface BuildingMinidaoDao {

    @Arguments("building_id")
    @Sql("select id,name from base_building_storey where base_building_id=:building_id order by no")
    List<Map<String, String>> getStoreyList(String building_id);

    @Arguments("building_id")
    @Sql("select id,name from base_building_room where base_building_id=:building_id order by no")
    List<Map<String, String>> getRoomList(String building_id);

    @Arguments("building_id")
    @Sql("select id,name from base_building_room_type where base_building_id=:building_id order by no")
    List<Map<String, String>> getRoomTypeList(String building_id);

    @Sql("select id,name from base_building order by no")
    List<Map<String, String>> getBuildinglist();
}