package com.buss.nh.nurse.entity;

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
 * @Description: 护理记录
 * @author onlineGenerator
 * @date 2018-07-15 11:58:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "nurse_record", schema = "")
@SuppressWarnings("serial")
public class NurseRecordEntity implements java.io.Serializable {
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
	/**床号*/
	private java.lang.String bedId;
	/**房间*/
	@Excel(name="房间",width=15,dictTable ="stayin_info_nh",dicCode ="bed_name",dicText ="bed_name")
	private java.lang.String roomName;
	/**床位*/
	@Excel(name="床位",width=15)
	private java.lang.String bedName;
	/**顾客姓名*/
	@Excel(name="顾客姓名",width=15)
	private java.lang.String customerName;
	/**顾客编号*/
	private java.lang.String customerNo;
	/**记录日期*/
	@Excel(name="记录日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date recordDate;
	/**记录状态*/
	private java.lang.String jlStatus;
	/**血压*/
	@Excel(name="血压",width=15)
	private java.lang.String bloodPressure;
	/**脉搏*/
	@Excel(name="脉搏",width=15)
	private java.lang.String pulse;
	/**体温*/
	@Excel(name="体温",width=15)
	private java.lang.String animalHeat;
	/**呼吸*/
	@Excel(name="呼吸",width=15)
	private java.lang.String breath;
	/**是否吸氧*/
	@Excel(name="是否吸氧",width=15,dicCode="sf_yn")
	private java.lang.String isOxygen;
	/**口服药*/
	@Excel(name="口服药",width=15,dicCode="sf_yn")
	private java.lang.String takeMedicine;
	/**心理护理*/
	@Excel(name="心理护理",width=15,dicCode="sf_yn")
	private java.lang.String mentalHelp;
	/**护士*/
	@Excel(name="护士",width=15)
	private java.lang.String charger;
	/**交班事项*/
	@Excel(name="交班事项",width=15)
	private java.lang.String handoverDes;
	/**附件*/
	@Excel(name="附件",width=15)
	private java.lang.String attachment;
	
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
	 *@return: java.lang.String  床号
	 */

	@Column(name ="BED_ID",nullable=true,length=32)
	public java.lang.String getBedId(){
		return this.bedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床号
	 */
	public void setBedId(java.lang.String bedId){
		this.bedId = bedId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间
	 */

	@Column(name ="ROOM_NAME",nullable=true,length=32)
	public java.lang.String getRoomName(){
		return this.roomName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间
	 */
	public void setRoomName(java.lang.String roomName){
		this.roomName = roomName;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  记录日期
	 */

	@Column(name ="RECORD_DATE",nullable=true,length=32)
	public java.util.Date getRecordDate(){
		return this.recordDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  记录日期
	 */
	public void setRecordDate(java.util.Date recordDate){
		this.recordDate = recordDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  记录状态
	 */

	@Column(name ="JL_STATUS",nullable=true,length=32)
	public java.lang.String getJlStatus(){
		return this.jlStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  记录状态
	 */
	public void setJlStatus(java.lang.String jlStatus){
		this.jlStatus = jlStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  血压
	 */

	@Column(name ="BLOOD_PRESSURE",nullable=true,length=32)
	public java.lang.String getBloodPressure(){
		return this.bloodPressure;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  血压
	 */
	public void setBloodPressure(java.lang.String bloodPressure){
		this.bloodPressure = bloodPressure;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  脉搏
	 */

	@Column(name ="PULSE",nullable=true,length=32)
	public java.lang.String getPulse(){
		return this.pulse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脉搏
	 */
	public void setPulse(java.lang.String pulse){
		this.pulse = pulse;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体温
	 */

	@Column(name ="ANIMAL_HEAT",nullable=true,length=32)
	public java.lang.String getAnimalHeat(){
		return this.animalHeat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体温
	 */
	public void setAnimalHeat(java.lang.String animalHeat){
		this.animalHeat = animalHeat;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  呼吸
	 */

	@Column(name ="BREATH",nullable=true,length=32)
	public java.lang.String getBreath(){
		return this.breath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  呼吸
	 */
	public void setBreath(java.lang.String breath){
		this.breath = breath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否吸氧
	 */

	@Column(name ="IS_OXYGEN",nullable=true,length=32)
	public java.lang.String getIsOxygen(){
		return this.isOxygen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否吸氧
	 */
	public void setIsOxygen(java.lang.String isOxygen){
		this.isOxygen = isOxygen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  口服药
	 */

	@Column(name ="TAKE_MEDICINE",nullable=true,length=32)
	public java.lang.String getTakeMedicine(){
		return this.takeMedicine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  口服药
	 */
	public void setTakeMedicine(java.lang.String takeMedicine){
		this.takeMedicine = takeMedicine;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  心理护理
	 */

	@Column(name ="MENTAL_HELP",nullable=true,length=32)
	public java.lang.String getMentalHelp(){
		return this.mentalHelp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  心理护理
	 */
	public void setMentalHelp(java.lang.String mentalHelp){
		this.mentalHelp = mentalHelp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  护士
	 */

	@Column(name ="CHARGER",nullable=true,length=32)
	public java.lang.String getCharger(){
		return this.charger;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  护士
	 */
	public void setCharger(java.lang.String charger){
		this.charger = charger;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交班事项
	 */

	@Column(name ="HANDOVER_DES",nullable=true,length=200)
	public java.lang.String getHandoverDes(){
		return this.handoverDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交班事项
	 */
	public void setHandoverDes(java.lang.String handoverDes){
		this.handoverDes = handoverDes;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */

	@Column(name ="ATTACHMENT",nullable=true,length=32)
	public java.lang.String getAttachment(){
		return this.attachment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setAttachment(java.lang.String attachment){
		this.attachment = attachment;
	}
}
