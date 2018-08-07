package com.buss.base.check.service.impl;
import com.buss.base.check.service.CheckInoutChecklistServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.base.check.entity.CheckInoutChecklistEntity;
import com.buss.base.check.entity.CheckListTypeEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("checkInoutChecklistService")
@Transactional
public class CheckInoutChecklistServiceImpl extends CommonServiceImpl implements CheckInoutChecklistServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CheckInoutChecklistEntity)entity);
 	}
	
	public void addMain(CheckInoutChecklistEntity checkInoutChecklist,
	        List<CheckListTypeEntity> checkListTypeList){
			//保存主信息
			this.save(checkInoutChecklist);
		
			/**保存-入退住准备内容类型*/
			for(CheckListTypeEntity checkListType:checkListTypeList){
				//外键设置
				checkListType.setCheckoutListId(checkInoutChecklist.getId());
				this.save(checkListType);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(checkInoutChecklist);
	}

	
	public void updateMain(CheckInoutChecklistEntity checkInoutChecklist,
	        List<CheckListTypeEntity> checkListTypeList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(checkInoutChecklist.getId())){
			try {
				CheckInoutChecklistEntity temp = findUniqueByProperty(CheckInoutChecklistEntity.class, "id", checkInoutChecklist.getId());
				MyBeanUtils.copyBeanNotNull2Bean(checkInoutChecklist, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(checkInoutChecklist);
		}
		//===================================================================================
		//获取参数
		Object id0 = checkInoutChecklist.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-入退住准备内容类型
	    String hql0 = "from CheckListTypeEntity where 1 = 1 AND cHECKOUT_LIST_ID = ? ";
	    List<CheckListTypeEntity> checkListTypeOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-入退住准备内容类型
		if(checkListTypeList!=null&&checkListTypeList.size()>0){
		for(CheckListTypeEntity oldE:checkListTypeOldList){
			boolean isUpdate = false;
				for(CheckListTypeEntity sendE:checkListTypeList){
					//需要更新的明细数据-入退住准备内容类型
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-入退住准备内容类型
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-入退住准备内容类型
			for(CheckListTypeEntity checkListType:checkListTypeList){
				if(oConvertUtils.isEmpty(checkListType.getId())){
					//外键设置
					checkListType.setCheckoutListId(checkInoutChecklist.getId());
					this.save(checkListType);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(checkInoutChecklist);
	}

	
	public void delMain(CheckInoutChecklistEntity checkInoutChecklist) {
		//删除主表信息
		this.delete(checkInoutChecklist);
		//===================================================================================
		//获取参数
		Object id0 = checkInoutChecklist.getId();
		//===================================================================================
		//删除-入退住准备内容类型
	    String hql0 = "from CheckListTypeEntity where 1 = 1 AND cHECKOUT_LIST_ID = ? ";
	    List<CheckListTypeEntity> checkListTypeOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(checkListTypeOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CheckInoutChecklistEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CheckInoutChecklistEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CheckInoutChecklistEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CheckInoutChecklistEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{inout_type}",String.valueOf(t.getInoutType()));
 		sql  = sql.replace("#{attach_address}",String.valueOf(t.getAttachAddress()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}