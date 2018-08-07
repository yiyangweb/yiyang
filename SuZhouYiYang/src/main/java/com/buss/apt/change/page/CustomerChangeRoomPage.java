
package com.buss.apt.change.page;
import com.buss.apt.change.entity.CustomerChangeRoomEntity;
import com.buss.apt.change.entity.CheckChangeDesEntity;
import com.buss.apt.change.entity.ChangeRoomFeeEntity;

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
 * @Description: 换房管理
 * @author onlineGenerator
 * @date 2018-07-23 10:09:59
 * @version V1.0   
 *
 */
public class CustomerChangeRoomPage implements java.io.Serializable {
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
	/**换房编号*/
    @Excel(name="换房编号")
	private java.lang.String no;
	/**入住id*/
	private java.lang.String originId;
	/**顾客姓名*/
    @Excel(name="顾客姓名")
	private java.lang.String customerName;
	/**原房间id*/
	private java.lang.String originRoomId;
	/**原房间*/
    @Excel(name="原房间")
	private java.lang.String originRoom;
	/**原楼栋id*/
	private java.lang.String originBuildingId;
	/**原楼栋*/
    @Excel(name="原楼栋")
	private java.lang.String originBuildingName;
	/**交换房间id*/
	private java.lang.String newRoomId;
	/**交换房间*/
    @Excel(name="交换房间")
	private java.lang.String newRoomName;
	/**交换楼栋id*/
	private java.lang.String newBuildingId;
	/**交换楼栋*/
    @Excel(name="交换楼栋")
	private java.lang.String newBuildingName;
	/**换房状态*/
    @Excel(name="换房状态")
	private java.lang.String status;
	/**办理人*/
    @Excel(name="办理人")
	private java.lang.String inCharge;
	/**办理时间*/
    @Excel(name="办理时间",format = "yyyy-MM-dd")
	private java.util.Date dealDate;
	/**审核人*/
    @Excel(name="审核人")
	private java.lang.String auditor;
	/**审核时间*/
    @Excel(name="审核时间",format = "yyyy-MM-dd")
	private java.util.Date auditDate;
	/**审核意见*/
    @Excel(name="审核意见")
	private java.lang.String auditDes;
	/**顾客编号*/
	private java.lang.String customerNo;
	/**所属*/
	private java.lang.String belongTo;
	
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
	 *@return: java.lang.String  换房编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  换房编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住id
	 */
	public java.lang.String getOriginId(){
		return this.originId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住id
	 */
	public void setOriginId(java.lang.String originId){
		this.originId = originId;
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
	 *@return: java.lang.String  原房间id
	 */
	public java.lang.String getOriginRoomId(){
		return this.originRoomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原房间id
	 */
	public void setOriginRoomId(java.lang.String originRoomId){
		this.originRoomId = originRoomId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原房间
	 */
	public java.lang.String getOriginRoom(){
		return this.originRoom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原房间
	 */
	public void setOriginRoom(java.lang.String originRoom){
		this.originRoom = originRoom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原楼栋id
	 */
	public java.lang.String getOriginBuildingId(){
		return this.originBuildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原楼栋id
	 */
	public void setOriginBuildingId(java.lang.String originBuildingId){
		this.originBuildingId = originBuildingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原楼栋
	 */
	public java.lang.String getOriginBuildingName(){
		return this.originBuildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原楼栋
	 */
	public void setOriginBuildingName(java.lang.String originBuildingName){
		this.originBuildingName = originBuildingName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交换房间id
	 */
	public java.lang.String getNewRoomId(){
		return this.newRoomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交换房间id
	 */
	public void setNewRoomId(java.lang.String newRoomId){
		this.newRoomId = newRoomId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交换房间
	 */
	public java.lang.String getNewRoomName(){
		return this.newRoomName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交换房间
	 */
	public void setNewRoomName(java.lang.String newRoomName){
		this.newRoomName = newRoomName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交换楼栋id
	 */
	public java.lang.String getNewBuildingId(){
		return this.newBuildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交换楼栋id
	 */
	public void setNewBuildingId(java.lang.String newBuildingId){
		this.newBuildingId = newBuildingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交换楼栋
	 */
	public java.lang.String getNewBuildingName(){
		return this.newBuildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交换楼栋
	 */
	public void setNewBuildingName(java.lang.String newBuildingName){
		this.newBuildingName = newBuildingName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  换房状态
	 */
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  换房状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办理人
	 */
	public java.lang.String getInCharge(){
		return this.inCharge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办理人
	 */
	public void setInCharge(java.lang.String inCharge){
		this.inCharge = inCharge;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  办理时间
	 */
	public java.util.Date getDealDate(){
		return this.dealDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  办理时间
	 */
	public void setDealDate(java.util.Date dealDate){
		this.dealDate = dealDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	public java.lang.String getAuditor(){
		return this.auditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setAuditor(java.lang.String auditor){
		this.auditor = auditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */
	public java.util.Date getAuditDate(){
		return this.auditDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setAuditDate(java.util.Date auditDate){
		this.auditDate = auditDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核意见
	 */
	public java.lang.String getAuditDes(){
		return this.auditDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核意见
	 */
	public void setAuditDes(java.lang.String auditDes){
		this.auditDes = auditDes;
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
	 *@return: java.lang.String  所属
	 */
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
	}

	/**保存-换房检查*/
    @ExcelCollection(name="换房检查")
	private List<CheckChangeDesEntity> checkChangeDesList = new ArrayList<CheckChangeDesEntity>();
		public List<CheckChangeDesEntity> getCheckChangeDesList() {
		return checkChangeDesList;
		}
		public void setCheckChangeDesList(List<CheckChangeDesEntity> checkChangeDesList) {
		this.checkChangeDesList = checkChangeDesList;
		}
	/**保存-退缴费情况*/
    @ExcelCollection(name="退缴费情况")
	private List<ChangeRoomFeeEntity> changeRoomFeeList = new ArrayList<ChangeRoomFeeEntity>();
		public List<ChangeRoomFeeEntity> getChangeRoomFeeList() {
		return changeRoomFeeList;
		}
		public void setChangeRoomFeeList(List<ChangeRoomFeeEntity> changeRoomFeeList) {
		this.changeRoomFeeList = changeRoomFeeList;
		}
}
