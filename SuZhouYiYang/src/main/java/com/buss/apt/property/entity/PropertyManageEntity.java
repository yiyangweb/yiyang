package com.buss.apt.property.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 物业管理
 * @author onlineGenerator
 * @date 2018-06-16 14:12:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "property_manage", schema = "")
@SuppressWarnings("serial")
public class PropertyManageEntity implements java.io.Serializable {
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
	/**长者ID*/
	private java.lang.String customerId;
	/**长者姓名*/
	@Excel(name="长者姓名",width=15,dictTable ="customer_room_info",dicCode ="customerName",dicText ="customer_name")
	private java.lang.String customerName;
	/**房间ID*/
	private java.lang.String roomId;
	/**房间编号*/
	@Excel(name="房间编号",width=15)
	private java.lang.String roomNo;
	/**负责人*/
	@Excel(name="负责人",width=15)
	private java.lang.String keeper;
	/**负责人电话*/
	@Excel(name="负责人电话",width=15)
	private java.lang.Integer keeperTel;
	/**维修人*/
	@Excel(name="维修人",width=15)
	private java.lang.String repairman;
	/**维修人电话*/
	@Excel(name="维修人电话",width=15)
	private java.lang.Integer repairmanTel;
	/**流程状态*/
	@Excel(name="流程状态",width=15,dicCode="wy_status")
	private java.lang.String status;
	/**维修项目*/
	@Excel(name="维修项目",width=15)
	private java.lang.String detail;
	/**费用*/
	@Excel(name="费用",width=15)
	private java.math.BigDecimal charge;
	/**开始时间*/
	@Excel(name="开始时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date startTime;
	/**完成时间*/
	@Excel(name="完成时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date finishTime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
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

	@Column(name ="CREATE_NAME",nullable=true,length=50)
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

	@Column(name ="CREATE_BY",nullable=true,length=50)
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

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
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

	@Column(name ="UPDATE_BY",nullable=true,length=50)
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

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
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

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
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
	 *@return: java.lang.String  长者ID
	 */

	@Column(name ="CUSTOMER_ID",nullable=true,length=36)
	public java.lang.String getCustomerId(){
		return this.customerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长者ID
	 */
	public void setCustomerId(java.lang.String customerId){
		this.customerId = customerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  长者姓名
	 */

	@Column(name ="CUSTOMER_NAME",nullable=true,length=36)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长者姓名
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间ID
	 */

	@Column(name ="ROOM_ID",nullable=true,length=36)
	public java.lang.String getRoomId(){
		return this.roomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间ID
	 */
	public void setRoomId(java.lang.String roomId){
		this.roomId = roomId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间编号
	 */

	@Column(name ="ROOM_NO",nullable=true,length=36)
	public java.lang.String getRoomNo(){
		return this.roomNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间编号
	 */
	public void setRoomNo(java.lang.String roomNo){
		this.roomNo = roomNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人
	 */

	@Column(name ="KEEPER",nullable=true,length=36)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  负责人电话
	 */

	@Column(name ="KEEPER_TEL",nullable=true,length=15)
	public java.lang.Integer getKeeperTel(){
		return this.keeperTel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  负责人电话
	 */
	public void setKeeperTel(java.lang.Integer keeperTel){
		this.keeperTel = keeperTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维修人
	 */

	@Column(name ="REPAIRMAN",nullable=true,length=36)
	public java.lang.String getRepairman(){
		return this.repairman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维修人
	 */
	public void setRepairman(java.lang.String repairman){
		this.repairman = repairman;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  维修人电话
	 */

	@Column(name ="REPAIRMAN_TEL",nullable=true,length=15)
	public java.lang.Integer getRepairmanTel(){
		return this.repairmanTel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  维修人电话
	 */
	public void setRepairmanTel(java.lang.Integer repairmanTel){
		this.repairmanTel = repairmanTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="STATUS",nullable=true,length=36)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维修项目
	 */

	@Column(name ="DETAIL",nullable=true,length=36)
	public java.lang.String getDetail(){
		return this.detail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维修项目
	 */
	public void setDetail(java.lang.String detail){
		this.detail = detail;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  费用
	 */

	@Column(name ="CHARGE",nullable=true,length=32)
	public java.math.BigDecimal getCharge(){
		return this.charge;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  费用
	 */
	public void setCharge(java.math.BigDecimal charge){
		this.charge = charge;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */

	@Column(name ="START_TIME",nullable=true,length=32)
	public java.util.Date getStartTime(){
		return this.startTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  完成时间
	 */

	@Column(name ="FINISH_TIME",nullable=true,length=32)
	public java.util.Date getFinishTime(){
		return this.finishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  完成时间
	 */
	public void setFinishTime(java.util.Date finishTime){
		this.finishTime = finishTime;
	}
}
