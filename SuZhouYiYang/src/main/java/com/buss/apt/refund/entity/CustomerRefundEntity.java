package com.buss.apt.refund.entity;

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
 * @Description: 退款信息
 * @author onlineGenerator
 * @date 2018-07-11 11:11:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_refund", schema = "")
@SuppressWarnings("serial")
public class CustomerRefundEntity implements java.io.Serializable {
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
	/**标题*/
	@Excel(name="标题",width=15)
	private java.lang.String title;
	/**退款途径*/
	@Excel(name="退款途径",width=15,dicCode="refund_way")
	private java.lang.String returnWay;
	/**顾客编号*/
	@Excel(name="顾客编号",width=15,dictTable ="customer_base",dicCode ="customerNo,customerName",dicText ="no,name")
	private java.lang.String customerNo;
	/**顾客姓名*/
	@Excel(name="顾客姓名",width=15)
	private java.lang.String customerName;
	/**属于*/
	@Excel(name="属于",width=15,dicCode="cs_status")
	private java.lang.String belongTo;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.String money;
	/**退款状态*/
	private java.lang.String refundStatus;
	/**相关环节*/
	@Excel(name="相关环节",width=15)
	private java.lang.String originFlow;
	/**操作人*/
	@Excel(name="操作人",width=15)
	private java.lang.String charger;
	/**操作时间*/
	@Excel(name="操作时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date dealDate;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String des;
	
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
	 *@return: java.lang.String  标题
	 */

	@Column(name ="TITLE",nullable=true,length=32)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退款途径
	 */

	@Column(name ="RETURN_WAY",nullable=true,length=32)
	public java.lang.String getReturnWay(){
		return this.returnWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退款途径
	 */
	public void setReturnWay(java.lang.String returnWay){
		this.returnWay = returnWay;
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
	 *@return: java.lang.String  属于
	 */

	@Column(name ="BELONG_TO",nullable=true,length=32)
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  属于
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */

	@Column(name ="MONEY",nullable=true,length=32)
	public java.lang.String getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setMoney(java.lang.String money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退款状态
	 */

	@Column(name ="REFUND_STATUS",nullable=true,length=32)
	public java.lang.String getRefundStatus(){
		return this.refundStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退款状态
	 */
	public void setRefundStatus(java.lang.String refundStatus){
		this.refundStatus = refundStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  相关环节
	 */

	@Column(name ="ORIGIN_FLOW",nullable=true,length=32)
	public java.lang.String getOriginFlow(){
		return this.originFlow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相关环节
	 */
	public void setOriginFlow(java.lang.String originFlow){
		this.originFlow = originFlow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作人
	 */

	@Column(name ="CHARGER",nullable=true,length=32)
	public java.lang.String getCharger(){
		return this.charger;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作人
	 */
	public void setCharger(java.lang.String charger){
		this.charger = charger;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  操作时间
	 */

	@Column(name ="DEAL_DATE",nullable=true,length=32)
	public java.util.Date getDealDate(){
		return this.dealDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  操作时间
	 */
	public void setDealDate(java.util.Date dealDate){
		this.dealDate = dealDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="DES",nullable=true,length=200)
	public java.lang.String getDes(){
		return this.des;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setDes(java.lang.String des){
		this.des = des;
	}
}
