package com.buss.sale.customer.entity;
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
 * @Description: 详细信息
 * @author onlineGenerator
 * @date 2018-07-14 16:21:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_profile", schema = "")
@SuppressWarnings("serial")
public class CustomerProfileEntity implements java.io.Serializable {
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
	/**阳历生日*/
    @Excel(name="阳历生日",width=15,format = "yyyy-MM-dd")
	private java.util.Date birthDate;
	/**阴历生日*/
    @Excel(name="阴历生日",width=15,format = "yyyy-MM-dd")
	private java.util.Date lunarBirthDate;
	/**配偶姓名*/
    @Excel(name="配偶姓名",width=15)
	private java.lang.String mateName;
	/**生活习惯*/
    @Excel(name="生活习惯",width=15)
	private java.lang.String lifeHabit;
	/**手机号码*/
    @Excel(name="手机号码",width=15)
	private java.lang.String cellPhone;
	/**固定电话*/
    @Excel(name="固定电话",width=15)
	private java.lang.String telephone;
	/**邮箱*/
    @Excel(name="邮箱",width=15)
	private java.lang.String email;
	/**语言*/
    @Excel(name="语言",width=15)
	private java.lang.String language;
	/**交通工具*/
    @Excel(name="交通工具",width=15)
	private java.lang.String vehicle;
	/**户籍地址*/
    @Excel(name="户籍地址",width=15)
	private java.lang.String registerAddress;
	/**所属街道*/
    @Excel(name="所属街道",width=15)
	private java.lang.String subDistrict;
	/**居住地址*/
    @Excel(name="居住地址",width=15)
	private java.lang.String liveAddress;
	/**公司*/
    @Excel(name="公司",width=15)
	private java.lang.String company;
	/**职业*/
    @Excel(name="职业",width=15)
	private java.lang.String job;
	/**教育程度*/
    @Excel(name="教育程度",width=15)
	private java.lang.String educatioin;
	/**居住情况*/
    @Excel(name="居住情况",width=15)
	private java.lang.String olderLiveInfo;
	/**紧急联系人*/
    @Excel(name="紧急联系人",width=15)
	private java.lang.String urgentContact;
	/**电话*/
    @Excel(name="电话",width=15)
	private java.lang.String contactPhone;
	/**客户主表id*/
	private java.lang.String customerId;
	
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  阳历生日
	 */
	
	@Column(name ="BIRTH_DATE",nullable=true,length=32)
	public java.util.Date getBirthDate(){
		return this.birthDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  阳历生日
	 */
	public void setBirthDate(java.util.Date birthDate){
		this.birthDate = birthDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  阴历生日
	 */
	
	@Column(name ="LUNAR_BIRTH_DATE",nullable=true,length=32)
	public java.util.Date getLunarBirthDate(){
		return this.lunarBirthDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  阴历生日
	 */
	public void setLunarBirthDate(java.util.Date lunarBirthDate){
		this.lunarBirthDate = lunarBirthDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配偶姓名
	 */
	
	@Column(name ="MATE_NAME",nullable=true,length=32)
	public java.lang.String getMateName(){
		return this.mateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配偶姓名
	 */
	public void setMateName(java.lang.String mateName){
		this.mateName = mateName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生活习惯
	 */
	
	@Column(name ="LIFE_HABIT",nullable=true,length=32)
	public java.lang.String getLifeHabit(){
		return this.lifeHabit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生活习惯
	 */
	public void setLifeHabit(java.lang.String lifeHabit){
		this.lifeHabit = lifeHabit;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */
	
	@Column(name ="CELL_PHONE",nullable=true,length=15)
	public java.lang.String getCellPhone(){
		return this.cellPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setCellPhone(java.lang.String cellPhone){
		this.cellPhone = cellPhone;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  固定电话
	 */
	
	@Column(name ="TELEPHONE",nullable=true,length=32)
	public java.lang.String getTelephone(){
		return this.telephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  固定电话
	 */
	public void setTelephone(java.lang.String telephone){
		this.telephone = telephone;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	
	@Column(name ="EMAIL",nullable=true,length=32)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  语言
	 */
	
	@Column(name ="LANGUAGE",nullable=true,length=32)
	public java.lang.String getLanguage(){
		return this.language;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  语言
	 */
	public void setLanguage(java.lang.String language){
		this.language = language;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交通工具
	 */
	
	@Column(name ="VEHICLE",nullable=true,length=32)
	public java.lang.String getVehicle(){
		return this.vehicle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交通工具
	 */
	public void setVehicle(java.lang.String vehicle){
		this.vehicle = vehicle;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍地址
	 */
	
	@Column(name ="REGISTER_ADDRESS",nullable=true,length=100)
	public java.lang.String getRegisterAddress(){
		return this.registerAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地址
	 */
	public void setRegisterAddress(java.lang.String registerAddress){
		this.registerAddress = registerAddress;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属街道
	 */
	
	@Column(name ="SUB_DISTRICT",nullable=true,length=100)
	public java.lang.String getSubDistrict(){
		return this.subDistrict;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属街道
	 */
	public void setSubDistrict(java.lang.String subDistrict){
		this.subDistrict = subDistrict;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住地址
	 */
	
	@Column(name ="LIVE_ADDRESS",nullable=true,length=100)
	public java.lang.String getLiveAddress(){
		return this.liveAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住地址
	 */
	public void setLiveAddress(java.lang.String liveAddress){
		this.liveAddress = liveAddress;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司
	 */
	
	@Column(name ="COMPANY",nullable=true,length=32)
	public java.lang.String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司
	 */
	public void setCompany(java.lang.String company){
		this.company = company;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职业
	 */
	
	@Column(name ="JOB",nullable=true,length=32)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教育程度
	 */
	
	@Column(name ="EDUCATIOIN",nullable=true,length=32)
	public java.lang.String getEducatioin(){
		return this.educatioin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教育程度
	 */
	public void setEducatioin(java.lang.String educatioin){
		this.educatioin = educatioin;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住情况
	 */
	
	@Column(name ="OLDER_LIVE_INFO",nullable=true,length=32)
	public java.lang.String getOlderLiveInfo(){
		return this.olderLiveInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住情况
	 */
	public void setOlderLiveInfo(java.lang.String olderLiveInfo){
		this.olderLiveInfo = olderLiveInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人
	 */
	
	@Column(name ="URGENT_CONTACT",nullable=true,length=32)
	public java.lang.String getUrgentContact(){
		return this.urgentContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人
	 */
	public void setUrgentContact(java.lang.String urgentContact){
		this.urgentContact = urgentContact;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	
	@Column(name ="CONTACT_PHONE",nullable=true,length=32)
	public java.lang.String getContactPhone(){
		return this.contactPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setContactPhone(java.lang.String contactPhone){
		this.contactPhone = contactPhone;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户主表id
	 */
	
	@Column(name ="CUSTOMER_ID",nullable=true,length=36)
	public java.lang.String getCustomerId(){
		return this.customerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户主表id
	 */
	public void setCustomerId(java.lang.String customerId){
		this.customerId = customerId;
	}
	
}
