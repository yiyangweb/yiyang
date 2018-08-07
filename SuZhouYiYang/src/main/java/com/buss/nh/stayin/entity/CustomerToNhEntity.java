package com.buss.nh.stayin.entity;

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
 * @Description: 护理院入住
 * @author onlineGenerator
 * @date 2018-07-14 22:12:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_to_nh", schema = "")
@SuppressWarnings("serial")
public class CustomerToNhEntity implements java.io.Serializable {
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
	@Excel(name="入住编号",width=15)
	private java.lang.String no;
	/**顾客id*/
	private java.lang.String customerId;
	/**顾客姓名*/
	@Excel(name="顾客姓名",width=15,dictTable ="contract_info_nh",dicCode ="customerName",dicText ="customer_name")
	private java.lang.String customerName;
	/**顾客编号*/
	private java.lang.String customerNo;
	/**床位*/
	@Excel(name="床位",width=15)
	private java.lang.String bedName;
	/**顾客性别*/
	private java.lang.String sex;
	/**合同编号*/
	@Excel(name="合同编号",width=15)
	private java.lang.String contractNo;
	/**护理等级*/
	private java.lang.String nurseLevel;
	/**楼栋id*/
	private java.lang.String buildingId;
	/**楼栋*/
	@Excel(name="楼栋",width=15)
	private java.lang.String buildingName;
	/**房间id*/
	private java.lang.String roomId;
	/**房间名称*/
	@Excel(name="房间名称",width=15)
	private java.lang.String roomName;
	/**床位id*/
	private java.lang.String bedId;
	/**入住状态*/
	private java.lang.String crStatus;
	/**入住经办人*/
	@Excel(name="入住经办人",width=15)
	private java.lang.String inCharge;
	/**入住时间*/
	@Excel(name="入住时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date inDate;
	
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
	 *@return: java.lang.String  入住编号
	 */

	@Column(name ="NO",nullable=false,length=32)
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
	 *@return: java.lang.String  顾客id
	 */

	@Column(name ="CUSTOMER_ID",nullable=true,length=32)
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

	@Column(name ="CUSTOMER_NAME",nullable=true,length=32)
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

	@Column(name ="CUSTOMER_NO",nullable=true,length=32)
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
	 *@return: java.lang.String  床位
	 */

	@Column(name ="BED_NAME",nullable=true,length=32)
	public java.lang.String getBedName(){
		return this.bedName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位
	 */
	public void setBedName(java.lang.String bedName){
		this.bedName = bedName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客性别
	 */

	@Column(name ="SEX",nullable=true,length=32)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */

	@Column(name ="CONTRACT_NO",nullable=true,length=32)
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
	 *@return: java.lang.String  护理等级
	 */

	@Column(name ="NURSE_LEVEL",nullable=true,length=50)
	public java.lang.String getNurseLevel(){
		return this.nurseLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  护理等级
	 */
	public void setNurseLevel(java.lang.String nurseLevel){
		this.nurseLevel = nurseLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼栋id
	 */

	@Column(name ="BUILDING_ID",nullable=true,length=32)
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
	 *@return: java.lang.String  楼栋
	 */

	@Column(name ="BUILDING_NAME",nullable=true,length=32)
	public java.lang.String getBuildingName(){
		return this.buildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋
	 */
	public void setBuildingName(java.lang.String buildingName){
		this.buildingName = buildingName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间id
	 */

	@Column(name ="ROOM_ID",nullable=true,length=32)
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

	@Column(name ="ROOM_NAME",nullable=true,length=32)
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
	 *@return: java.lang.String  床位id
	 */

	@Column(name ="BED_ID",nullable=true,length=32)
	public java.lang.String getBedId(){
		return this.bedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位id
	 */
	public void setBedId(java.lang.String bedId){
		this.bedId = bedId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住状态
	 */

	@Column(name ="CR_STATUS",nullable=true,length=32)
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
	 *@return: java.lang.String  入住经办人
	 */

	@Column(name ="IN_CHARGE",nullable=true,length=32)
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

	@Column(name ="IN_DATE",nullable=true,length=32)
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
}
