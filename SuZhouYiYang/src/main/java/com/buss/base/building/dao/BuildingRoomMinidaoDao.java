package com.buss.base.building.dao;

import java.util.List;
import java.util.Map;
import org.jeecgframework.minidao.annotation.*;

@MiniDao
public interface BuildingRoomMinidaoDao {

    @Arguments("building_id")
    @Sql("select (" +
            "STUFF((select e.name+',', " +
            "(SELECT typename FROM t_s_type where typegroupid = '8a80cb81634da3a501634ddacdb7003b' and typecode = e.sex)+';' "+
            "from customer_to_room d " +
            "left join customer_room_des f on f.in_id = d.id " +
            "left join customer_base e on f.customer_id = e.id " +
            "where d.room_id = a.id and d.cr_status = '3' for xml path('')),1,0,'')) as room_info," +
            "a.id as room_id,a.no as room_no,a.name as room_name,a.status as room_status,b.name as storey_name,c.name as building_name " +
            "FROM base_building_room a " +
            "left join base_building_storey b on a.base_building_storey_id = b.id " +
            "left join base_building c on a.base_building_id = c.id " +
            "where c.id = :building_id order by a.no")
    List<Map<String, String>> getRoomInfoData(String building_id);

    @Arguments("building_id")
    @Sql("select count(distinct b.id) as rooms," +
            "count(e.id) as people," +
            "count(case when e.sex='0' then e.sex else null end) as males," +
            "count(case when e.sex='1' then e.sex else null end) as females," +
            "count(case when b.status='2' then e.id else null end) as longLivingRooms," +
            "count(case when b.status='3' then e.id else null end) as shortLivingRooms " +
            "from customer_to_room a " +
            "left join base_building_room b on a.room_id = b.id " +
            "left join base_building d on b.base_building_id = d.id " +
            "left join customer_room_des f on f.in_id = a.id " +
            "left join customer_base e on f.customer_id = e.id " +
            "where d.id = :building_id")
    List<Map<String, String>> getPeopleInfoData(String building_id);

}