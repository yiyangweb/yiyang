package com.buss.sale.visit.service.impl;
import com.buss.sale.visit.service.MmVisitorRecordServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.sale.visit.entity.MmVisitorRecordEntity;
import com.buss.sale.visit.entity.MmVisitorReturnEntity;

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


@Service("mmVisitorRecordService")
@Transactional
public class MmVisitorRecordServiceImpl extends CommonServiceImpl implements MmVisitorRecordServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MmVisitorRecordEntity)entity);
 	}
	
	public void addMain(MmVisitorRecordEntity mmVisitorRecord,
	        List<MmVisitorReturnEntity> mmVisitorReturnList){
			//保存主信息
			this.save(mmVisitorRecord);
		
			/**保存-回访记录*/
			for(MmVisitorReturnEntity mmVisitorReturn:mmVisitorReturnList){
				//外键设置
				mmVisitorReturn.setRecordId(mmVisitorRecord.getId());
				this.save(mmVisitorReturn);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(mmVisitorRecord);
	}

	
	public void updateMain(MmVisitorRecordEntity mmVisitorRecord,
	        List<MmVisitorReturnEntity> mmVisitorReturnList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(mmVisitorRecord.getId())){
			try {
				MmVisitorRecordEntity temp = findUniqueByProperty(MmVisitorRecordEntity.class, "id", mmVisitorRecord.getId());
				MyBeanUtils.copyBeanNotNull2Bean(mmVisitorRecord, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(mmVisitorRecord);
		}
		//===================================================================================
		//获取参数
		Object id0 = mmVisitorRecord.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-回访记录
	    String hql0 = "from MmVisitorReturnEntity where 1 = 1 AND rECORD_ID = ? ";
	    List<MmVisitorReturnEntity> mmVisitorReturnOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-回访记录
		if(mmVisitorReturnList!=null&&mmVisitorReturnList.size()>0){
		for(MmVisitorReturnEntity oldE:mmVisitorReturnOldList){
			boolean isUpdate = false;
				for(MmVisitorReturnEntity sendE:mmVisitorReturnList){
					//需要更新的明细数据-回访记录
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-回访记录
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-回访记录
			for(MmVisitorReturnEntity mmVisitorReturn:mmVisitorReturnList){
				if(oConvertUtils.isEmpty(mmVisitorReturn.getId())){
					//外键设置
					mmVisitorReturn.setRecordId(mmVisitorRecord.getId());
					this.save(mmVisitorReturn);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(mmVisitorRecord);
	}

	
	public void delMain(MmVisitorRecordEntity mmVisitorRecord) {
		//删除主表信息
		this.delete(mmVisitorRecord);
		//===================================================================================
		//获取参数
		Object id0 = mmVisitorRecord.getId();
		//===================================================================================
		//删除-回访记录
	    String hql0 = "from MmVisitorReturnEntity where 1 = 1 AND rECORD_ID = ? ";
	    List<MmVisitorReturnEntity> mmVisitorReturnOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(mmVisitorReturnOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-确认提交
	 * @param id
	 * @return
	 */
	 public boolean doVisitsbtSql(MmVisitorRecordEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update mm_visitor_record set visit_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-确认入住
	 * @param id
	 * @return
	 */
	 public boolean doVisitputSql(MmVisitorRecordEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update mm_visitor_record set visit_status = '3' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-确认放弃
	 * @param id
	 * @return
	 */
	 public boolean doVisitputoutSql(MmVisitorRecordEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update mm_visitor_record set visit_status = '5' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MmVisitorRecordEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MmVisitorRecordEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MmVisitorRecordEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MmVisitorRecordEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{record_no}",String.valueOf(t.getRecordNo()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{phone_no}",String.valueOf(t.getPhoneNo()));
 		sql  = sql.replace("#{adress}",String.valueOf(t.getAdress()));
 		sql  = sql.replace("#{learn_channel}",String.valueOf(t.getLearnChannel()));
 		sql  = sql.replace("#{introducer}",String.valueOf(t.getIntroducer()));
 		sql  = sql.replace("#{requirement_type}",String.valueOf(t.getRequirementType()));
 		sql  = sql.replace("#{intention_level}",String.valueOf(t.getIntentionLevel()));
 		sql  = sql.replace("#{intentional_gold}",String.valueOf(t.getIntentionalGold()));
 		sql  = sql.replace("#{visit_status}",String.valueOf(t.getVisitStatus()));
 		sql  = sql.replace("#{visit_num}",String.valueOf(t.getVisitNum()));
 		sql  = sql.replace("#{health}",String.valueOf(t.getHealth()));
 		sql  = sql.replace("#{focus}",String.valueOf(t.getFocus()));
 		sql  = sql.replace("#{others}",String.valueOf(t.getOthers()));
 		sql  = sql.replace("#{interests}",String.valueOf(t.getInterests()));
 		sql  = sql.replace("#{special_requirements}",String.valueOf(t.getSpecialRequirements()));
 		sql  = sql.replace("#{dest_clerk}",String.valueOf(t.getDestClerk()));
 		sql  = sql.replace("#{vsit_date}",String.valueOf(t.getVsitDate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}