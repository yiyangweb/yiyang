package com.buss.sale.visit.service;
import com.buss.sale.visit.entity.MmVisitorRecordEntity;
import com.buss.sale.visit.entity.MmVisitorReturnEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface MmVisitorRecordServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MmVisitorRecordEntity mmVisitorRecord,
	        List<MmVisitorReturnEntity> mmVisitorReturnList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MmVisitorRecordEntity mmVisitorRecord,
	        List<MmVisitorReturnEntity> mmVisitorReturnList);
	public void delMain (MmVisitorRecordEntity mmVisitorRecord);
	
 	/**
	 * 自定义按钮-sql增强-确认提交
	 * @param id
	 * @return
	 */
	 public boolean doVisitsbtSql(MmVisitorRecordEntity t);
 	/**
	 * 自定义按钮-sql增强-确认入住
	 * @param id
	 * @return
	 */
	 public boolean doVisitputSql(MmVisitorRecordEntity t);
 	/**
	 * 自定义按钮-sql增强-确认放弃
	 * @param id
	 * @return
	 */
	 public boolean doVisitputoutSql(MmVisitorRecordEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MmVisitorRecordEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MmVisitorRecordEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MmVisitorRecordEntity t);
}
