
package com.buss.base.building.page;
import com.buss.base.building.entity.BaseBuildingRoomEntity;
import com.buss.base.building.entity.BaseBuildingBedEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 建筑物房间信息
 * @author onlineGenerator
 * @date 2018-07-02 14:34:36
 * @version V1.0   
 *
 */
public class BaseBuildingRoomPage implements java.io.Serializable {
	/**建筑名称*/
    @Excel(name="建筑名称")
	private java.lang.String baseBuildingId;
	/**楼层名称*/
    @Excel(name="楼层名称")
	private java.lang.String baseBuildingStoreyId;
	/**房间类型*/
    @Excel(name="房间类型")
	private java.lang.String baseBuildingRoomTypeId;
	/**id*/
	private java.lang.String id;
	/**房间编号*/
    @Excel(name="房间编号")
	private java.lang.String no;
	/**房间名称*/
    @Excel(name="房间名称")
	private java.lang.String name;
	/**管理员*/
    @Excel(name="管理员")
	private java.lang.String manager;
	/**负责人*/
    @Excel(name="负责人")
	private java.lang.String keeper;
	/**房间状态*/
    @Excel(name="房间状态")
	private java.lang.String status;
	/**房间信息描述*/
    @Excel(name="房间信息描述")
	private java.lang.String description;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remark;
	/**类型*/
    @Excel(name="类型")
	private java.lang.String belongTo;
	/**启用标记*/
	private java.lang.String enabled;
	/**审核标记*/
	private java.lang.String approved;
	/**删除标记*/
	private java.lang.String deleted;
	/**创建人*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**所属区域*/
    @Excel(name="所属区域")
	private java.lang.String baseBuildingAreaId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  建筑名称
	 */
	public java.lang.String getBaseBuildingId(){
		return this.baseBuildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  建筑名称
	 */
	public void setBaseBuildingId(java.lang.String baseBuildingId){
		this.baseBuildingId = baseBuildingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼层名称
	 */
	public java.lang.String getBaseBuildingStoreyId(){
		return this.baseBuildingStoreyId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼层名称
	 */
	public void setBaseBuildingStoreyId(java.lang.String baseBuildingStoreyId){
		this.baseBuildingStoreyId = baseBuildingStoreyId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间类型
	 */
	public java.lang.String getBaseBuildingRoomTypeId(){
		return this.baseBuildingRoomTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间类型
	 */
	public void setBaseBuildingRoomTypeId(java.lang.String baseBuildingRoomTypeId){
		this.baseBuildingRoomTypeId = baseBuildingRoomTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间名称
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理员
	 */
	public java.lang.String getManager(){
		return this.manager;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理员
	 */
	public void setManager(java.lang.String manager){
		this.manager = manager;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人
	 */
	public java.lang.String getKeeper(){
		return this.keeper;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责人
	 */
	public void setKeeper(java.lang.String keeper){
		this.keeper = keeper;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间状态
	 */
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间信息描述
	 */
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间信息描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  启用标记
	 */
	public java.lang.String getEnabled(){
		return this.enabled;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  启用标记
	 */
	public void setEnabled(java.lang.String enabled){
		this.enabled = enabled;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核标记
	 */
	public java.lang.String getApproved(){
		return this.approved;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核标记
	 */
	public void setApproved(java.lang.String approved){
		this.approved = approved;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  删除标记
	 */
	public java.lang.String getDeleted(){
		return this.deleted;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  删除标记
	 */
	public void setDeleted(java.lang.String deleted){
		this.deleted = deleted;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属区域
	 */
	public java.lang.String getBaseBuildingAreaId(){
		return this.baseBuildingAreaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属区域
	 */
	public void setBaseBuildingAreaId(java.lang.String baseBuildingAreaId){
		this.baseBuildingAreaId = baseBuildingAreaId;
	}

	/**保存-建筑物床位信息*/
    @ExcelCollection(name="建筑物床位信息")
	private List<BaseBuildingBedEntity> baseBuildingBedList = new ArrayList<BaseBuildingBedEntity>();
		public List<BaseBuildingBedEntity> getBaseBuildingBedList() {
		return baseBuildingBedList;
		}
		public void setBaseBuildingBedList(List<BaseBuildingBedEntity> baseBuildingBedList) {
		this.baseBuildingBedList = baseBuildingBedList;
		}
}
