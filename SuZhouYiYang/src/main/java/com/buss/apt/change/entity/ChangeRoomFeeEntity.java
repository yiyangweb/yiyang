package com.buss.apt.change.entity;
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
 * @Description: 退缴费情况
 * @author onlineGenerator
 * @date 2018-07-22 17:24:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "change_room_fee", schema = "")
@SuppressWarnings("serial")
public class ChangeRoomFeeEntity implements java.io.Serializable {
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
	/**编号*/
    @Excel(name="编号",width=15)
	private java.lang.String no;
	/**退缴类型*/
    @Excel(name="退缴类型",width=15,dicCode="fee_type")
	private java.lang.String feeType;
	/**项目*/
    @Excel(name="项目",width=15)
	private java.lang.String name;
	/**费用*/
    @Excel(name="费用",width=15)
	private java.lang.String feeNum;
	/**状态*/
	private java.lang.String status;
	/**收费部门代码*/
	private java.lang.String belongDeptCode;
	/**收费部门名称*/
    @Excel(name="收费部门名称",width=15)
	private java.lang.String belongDeptName;
	/**描述*/
    @Excel(name="描述",width=15)
	private java.lang.String description;
	/**换房id*/
	private java.lang.String changeId;
	/**是否完成退缴费*/
	private java.lang.String isFinish;
	
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
	 *@return: java.lang.String  编号
	 */
	
	@Column(name ="NO",nullable=true,length=32)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退缴类型
	 */
	
	@Column(name ="FEE_TYPE",nullable=true,length=32)
	public java.lang.String getFeeType(){
		return this.feeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退缴类型
	 */
	public void setFeeType(java.lang.String feeType){
		this.feeType = feeType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目
	 */
	
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用
	 */
	
	@Column(name ="FEE_NUM",nullable=true,length=32)
	public java.lang.String getFeeNum(){
		return this.feeNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用
	 */
	public void setFeeNum(java.lang.String feeNum){
		this.feeNum = feeNum;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	
	@Column(name ="STATUS",nullable=true,length=32)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费部门代码
	 */
	
	@Column(name ="BELONG_DEPT_CODE",nullable=true,length=36)
	public java.lang.String getBelongDeptCode(){
		return this.belongDeptCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费部门代码
	 */
	public void setBelongDeptCode(java.lang.String belongDeptCode){
		this.belongDeptCode = belongDeptCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费部门名称
	 */
	
	@Column(name ="BELONG_DEPT_NAME",nullable=true,length=36)
	public java.lang.String getBelongDeptName(){
		return this.belongDeptName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费部门名称
	 */
	public void setBelongDeptName(java.lang.String belongDeptName){
		this.belongDeptName = belongDeptName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	
	@Column(name ="DESCRIPTION",nullable=true,length=36)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  换房id
	 */
	
	@Column(name ="CHANGE_ID",nullable=true,length=36)
	public java.lang.String getChangeId(){
		return this.changeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  换房id
	 */
	public void setChangeId(java.lang.String changeId){
		this.changeId = changeId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否完成退缴费
	 */
	
	@Column(name ="IS_FINISH",nullable=true,length=36)
	public java.lang.String getIsFinish(){
		return this.isFinish;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否完成退缴费
	 */
	public void setIsFinish(java.lang.String isFinish){
		this.isFinish = isFinish;
	}
	
}
