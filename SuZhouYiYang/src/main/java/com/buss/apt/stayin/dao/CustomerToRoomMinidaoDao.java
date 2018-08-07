package com.buss.apt.stayin.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;
import java.util.List;
import java.util.Map;

@MiniDao
public interface CustomerToRoomMinidaoDao {

    @Arguments("customer_id")
    @Sql("select a.id,a.name,b.relation_type from customer_base a " +
         "left join customer_relatives b on b.relative_id = a.id " +
         "left join customer_base c on b.customer_id = c.id " +
         "where c.id = :customer_id")
    List<Map<String, String>> getRelativeList(String customer_id);

}