package com.buss.sale.visit.entity;
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
 * @Description: 来访者登记信息
 * @author onlineGenerator
 * @date 2018-07-10 14:01:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "mm_visitor_record", schema = "")
@SuppressWarnings("serial")
public class MmVisitorRecordEntity implements java.io.Serializable {
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
	/**来访编号*/
    @Excel(name="来访编号",width=15)
	private java.lang.String recordNo;
	/**客户姓名*/
    @Excel(name="客户姓名",width=15,dictTable ="customer_base",dicCode ="name,no,sex,age",dicText ="customer_name,customer_no,sex,age")
	private java.lang.String customerName;
	/**客户编号*/
    @Excel(name="客户编号",width=15)
	private java.lang.String customerNo;
	/**性别*/
    @Excel(name="性别",width=15,dicCode="c_sex")
	private java.lang.String sex;
	/**年龄*/
    @Excel(name="年龄",width=15)
	private java.lang.Integer age;
	/**联系方式*/
    @Excel(name="联系方式",width=15)
	private java.lang.String phoneNo;
	/**联系地址*/
    @Excel(name="联系地址",width=15)
	private java.lang.String adress;
	/**获知渠道*/
    @Excel(name="获知渠道",width=15,dicCode="learn_type")
	private java.lang.String learnChannel;
	/**介绍人*/
    @Excel(name="介绍人",width=15)
	private java.lang.String introducer;
	/**需求类型*/
    @Excel(name="需求类型",width=15,dicCode="cs_status")
	private java.lang.String requirementType;
	/**意向等级*/
    @Excel(name="意向等级",width=15,dicCode="yx_level")
	private java.lang.String intentionLevel;
	/**意向金*/
    @Excel(name="意向金",width=15)
	private java.lang.String intentionalGold;
	/**来访状态*/
    @Excel(name="来访状态",width=15,dicCode="lf_status")
	private java.lang.String visitStatus;
	/**来访次数*/
    @Excel(name="来访次数",width=15)
	private java.lang.Integer visitNum;
	/**健康状况*/
    @Excel(name="健康状况",width=15,dicCode="jk_status")
	private java.lang.String health;
	/**关注点*/
    @Excel(name="关注点",width=15,dicCode="focus_type")
	private java.lang.String focus;
	/**其他*/
    @Excel(name="其他",width=15)
	private java.lang.String others;
	/**兴趣爱好*/
    @Excel(name="兴趣爱好",width=15)
	private java.lang.String interests;
	/**特殊要求*/
    @Excel(name="特殊要求",width=15)
	private java.lang.String specialRequirements;
	/**业务接待*/
    @Excel(name="业务接待",width=15)
	private java.lang.String destClerk;
	/**登记日期*/
    @Excel(name="登记日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date vsitDate;
	
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
	 *@return: java.lang.String  来访编号
	 */
	
	@Column(name ="RECORD_NO",nullable=true,length=32)
	public java.lang.String getRecordNo(){
		return this.recordNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来访编号
	 */
	public void setRecordNo(java.lang.String recordNo){
		this.recordNo = recordNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */
	
	@Column(name ="CUSTOMER_NAME",nullable=true,length=32)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编号
	 */
	
	@Column(name ="CUSTOMER_NO",nullable=true,length=32)
	public java.lang.String getCustomerNo(){
		return this.customerNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编号
	 */
	public void setCustomerNo(java.lang.String customerNo){
		this.customerNo = customerNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	
	@Column(name ="SEX",nullable=true,length=2)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年龄
	 */
	
	@Column(name ="AGE",nullable=true,length=3)
	public java.lang.Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年龄
	 */
	public void setAge(java.lang.Integer age){
		this.age = age;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	
	@Column(name ="PHONE_NO",nullable=true,length=32)
	public java.lang.String getPhoneNo(){
		return this.phoneNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setPhoneNo(java.lang.String phoneNo){
		this.phoneNo = phoneNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系地址
	 */
	
	@Column(name ="ADRESS",nullable=true,length=200)
	public java.lang.String getAdress(){
		return this.adress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系地址
	 */
	public void setAdress(java.lang.String adress){
		this.adress = adress;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  获知渠道
	 */
	
	@Column(name ="LEARN_CHANNEL",nullable=true,length=32)
	public java.lang.String getLearnChannel(){
		return this.learnChannel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  获知渠道
	 */
	public void setLearnChannel(java.lang.String learnChannel){
		this.learnChannel = learnChannel;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  介绍人
	 */
	
	@Column(name ="INTRODUCER",nullable=true,length=32)
	public java.lang.String getIntroducer(){
		return this.introducer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  介绍人
	 */
	public void setIntroducer(java.lang.String introducer){
		this.introducer = introducer;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需求类型
	 */
	
	@Column(name ="REQUIREMENT_TYPE",nullable=true,length=32)
	public java.lang.String getRequirementType(){
		return this.requirementType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需求类型
	 */
	public void setRequirementType(java.lang.String requirementType){
		this.requirementType = requirementType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意向等级
	 */
	
	@Column(name ="INTENTION_LEVEL",nullable=true,length=32)
	public java.lang.String getIntentionLevel(){
		return this.intentionLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意向等级
	 */
	public void setIntentionLevel(java.lang.String intentionLevel){
		this.intentionLevel = intentionLevel;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意向金
	 */
	
	@Column(name ="INTENTIONAL_GOLD",nullable=true,length=32)
	public java.lang.String getIntentionalGold(){
		return this.intentionalGold;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意向金
	 */
	public void setIntentionalGold(java.lang.String intentionalGold){
		this.intentionalGold = intentionalGold;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来访状态
	 */
	
	@Column(name ="VISIT_STATUS",nullable=true,length=32)
	public java.lang.String getVisitStatus(){
		return this.visitStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来访状态
	 */
	public void setVisitStatus(java.lang.String visitStatus){
		this.visitStatus = visitStatus;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  来访次数
	 */
	
	@Column(name ="VISIT_NUM",nullable=true,length=10)
	public java.lang.Integer getVisitNum(){
		return this.visitNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  来访次数
	 */
	public void setVisitNum(java.lang.Integer visitNum){
		this.visitNum = visitNum;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  健康状况
	 */
	
	@Column(name ="HEALTH",nullable=true,length=32)
	public java.lang.String getHealth(){
		return this.health;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  健康状况
	 */
	public void setHealth(java.lang.String health){
		this.health = health;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关注点
	 */
	
	@Column(name ="FOCUS",nullable=true,length=32)
	public java.lang.String getFocus(){
		return this.focus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关注点
	 */
	public void setFocus(java.lang.String focus){
		this.focus = focus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	
	@Column(name ="OTHERS",nullable=true,length=100)
	public java.lang.String getOthers(){
		return this.others;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setOthers(java.lang.String others){
		this.others = others;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  兴趣爱好
	 */
	
	@Column(name ="INTERESTS",nullable=true,length=100)
	public java.lang.String getInterests(){
		return this.interests;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  兴趣爱好
	 */
	public void setInterests(java.lang.String interests){
		this.interests = interests;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊要求
	 */
	
	@Column(name ="SPECIAL_REQUIREMENTS",nullable=true,length=100)
	public java.lang.String getSpecialRequirements(){
		return this.specialRequirements;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特殊要求
	 */
	public void setSpecialRequirements(java.lang.String specialRequirements){
		this.specialRequirements = specialRequirements;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务接待
	 */
	
	@Column(name ="DEST_CLERK",nullable=true,length=32)
	public java.lang.String getDestClerk(){
		return this.destClerk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务接待
	 */
	public void setDestClerk(java.lang.String destClerk){
		this.destClerk = destClerk;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  登记日期
	 */
	
	@Column(name ="VSIT_DATE",nullable=true,length=32)
	public java.util.Date getVsitDate(){
		return this.vsitDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  登记日期
	 */
	public void setVsitDate(java.util.Date vsitDate){
		this.vsitDate = vsitDate;
	}
	
}
