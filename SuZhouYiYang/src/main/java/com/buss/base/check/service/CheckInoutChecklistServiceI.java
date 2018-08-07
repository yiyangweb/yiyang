package com.buss.base.check.service;
import com.buss.base.check.entity.CheckInoutChecklistEntity;
import com.buss.base.check.entity.CheckListTypeEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CheckInoutChecklistServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CheckInoutChecklistEntity checkInoutChecklist,
	        List<CheckListTypeEntity> checkListTypeList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CheckInoutChecklistEntity checkInoutChecklist,
	        List<CheckListTypeEntity> checkListTypeList);
	public void delMain (CheckInoutChecklistEntity checkInoutChecklist);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CheckInoutChecklistEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CheckInoutChecklistEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CheckInoutChecklistEntity t);
}
