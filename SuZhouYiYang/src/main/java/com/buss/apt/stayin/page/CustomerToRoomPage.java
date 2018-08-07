
package com.buss.apt.stayin.page;
import com.buss.apt.stayin.entity.CustomerToRoomEntity;
import com.buss.apt.stayin.entity.CheckListDesEntity;
import com.buss.apt.stayin.entity.CustomerTrainInfoEntity;
import com.buss.apt.stayin.entity.CustomerRoomDesEntity;

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
 * @Description: 入住管理
 * @author onlineGenerator
 * @date 2018-07-10 13:17:31
 * @version V1.0   
 *
 */
public class CustomerToRoomPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
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
	/**入住编号*/
    @Excel(name="入住编号")
	private java.lang.String no;
	/**合同编号*/
    @Excel(name="合同编号")
	private java.lang.String contractNo;
	/**顾客id*/
	private java.lang.String customerId;
	/**顾客姓名*/
    @Excel(name="顾客姓名")
	private java.lang.String customerName;
	/**顾客编号*/
    @Excel(name="顾客编号")
	private java.lang.String customerNo;
	/**楼栋id*/
	private java.lang.String buildingId;
	/**楼栋名称*/
    @Excel(name="楼栋名称")
	private java.lang.String buildingName;
	/**房间id*/
	private java.lang.String roomId;
	/**房间名称*/
    @Excel(name="房间名称")
	private java.lang.String roomName;
	/**检查清单*/
	private java.lang.String checkInfo;
	/**入住状态*/
	private java.lang.String crStatus;
	/**培训状态*/
    @Excel(name="培训状态")
	private java.lang.String trainStatus;
	/**入住类型*/
    @Excel(name="入住类型")
	private java.lang.String stayinType;
	/**入住经办人*/
    @Excel(name="入住经办人")
	private java.lang.String inCharge;
	/**入住时间*/
    @Excel(name="入住时间",format = "yyyy-MM-dd")
	private java.util.Date inDate;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
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
	 *@return: java.lang.String  入住编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */
	public java.lang.String getContractNo(){
		return this.contractNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号
	 */
	public void setContractNo(java.lang.String contractNo){
		this.contractNo = contractNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客id
	 */
	public java.lang.String getCustomerId(){
		return this.customerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客id
	 */
	public void setCustomerId(java.lang.String customerId){
		this.customerId = customerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客姓名
	 */
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客姓名
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客编号
	 */
	public java.lang.String getCustomerNo(){
		return this.customerNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客编号
	 */
	public void setCustomerNo(java.lang.String customerNo){
		this.customerNo = customerNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼栋id
	 */
	public java.lang.String getBuildingId(){
		return this.buildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋id
	 */
	public void setBuildingId(java.lang.String buildingId){
		this.buildingId = buildingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼栋名称
	 */
	public java.lang.String getBuildingName(){
		return this.buildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋名称
	 */
	public void setBuildingName(java.lang.String buildingName){
		this.buildingName = buildingName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间id
	 */
	public java.lang.String getRoomId(){
		return this.roomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间id
	 */
	public void setRoomId(java.lang.String roomId){
		this.roomId = roomId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间名称
	 */
	public java.lang.String getRoomName(){
		return this.roomName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间名称
	 */
	public void setRoomName(java.lang.String roomName){
		this.roomName = roomName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查清单
	 */
	public java.lang.String getCheckInfo(){
		return this.checkInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查清单
	 */
	public void setCheckInfo(java.lang.String checkInfo){
		this.checkInfo = checkInfo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住状态
	 */
	public java.lang.String getCrStatus(){
		return this.crStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住状态
	 */
	public void setCrStatus(java.lang.String crStatus){
		this.crStatus = crStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训状态
	 */
	public java.lang.String getTrainStatus(){
		return this.trainStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训状态
	 */
	public void setTrainStatus(java.lang.String trainStatus){
		this.trainStatus = trainStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住类型
	 */
	public java.lang.String getStayinType(){
		return this.stayinType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住类型
	 */
	public void setStayinType(java.lang.String stayinType){
		this.stayinType = stayinType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住经办人
	 */
	public java.lang.String getInCharge(){
		return this.inCharge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住经办人
	 */
	public void setInCharge(java.lang.String inCharge){
		this.inCharge = inCharge;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入住时间
	 */
	public java.util.Date getInDate(){
		return this.inDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入住时间
	 */
	public void setInDate(java.util.Date inDate){
		this.inDate = inDate;
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

	/**保存-入住检查*/
    @ExcelCollection(name="入住检查")
	private List<CheckListDesEntity> checkListDesList = new ArrayList<CheckListDesEntity>();
		public List<CheckListDesEntity> getCheckListDesList() {
		return checkListDesList;
		}
		public void setCheckListDesList(List<CheckListDesEntity> checkListDesList) {
		this.checkListDesList = checkListDesList;
		}
	/**保存-入住培训*/
    @ExcelCollection(name="入住培训")
	private List<CustomerTrainInfoEntity> customerTrainInfoList = new ArrayList<CustomerTrainInfoEntity>();
		public List<CustomerTrainInfoEntity> getCustomerTrainInfoList() {
		return customerTrainInfoList;
		}
		public void setCustomerTrainInfoList(List<CustomerTrainInfoEntity> customerTrainInfoList) {
		this.customerTrainInfoList = customerTrainInfoList;
		}
	/**保存-入住情况*/
    @ExcelCollection(name="入住情况")
	private List<CustomerRoomDesEntity> customerRoomDesList = new ArrayList<CustomerRoomDesEntity>();
		public List<CustomerRoomDesEntity> getCustomerRoomDesList() {
		return customerRoomDesList;
		}
		public void setCustomerRoomDesList(List<CustomerRoomDesEntity> customerRoomDesList) {
		this.customerRoomDesList = customerRoomDesList;
		}
}
