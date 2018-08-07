package com.buss.apt.feebill.entity;
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
 * @Description: 缴费情况
 * @author onlineGenerator
 * @date 2018-07-10 20:52:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "payment_list", schema = "")
@SuppressWarnings("serial")
public class PaymentListEntity implements java.io.Serializable {
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
	/**状态*/
	private java.lang.String bpmStatus;
	/**缴费编号*/
    @Excel(name="缴费编号",width=15)
	private java.lang.String no;
	/**支付途径*/
    @Excel(name="支付途径",width=15,dicCode="zf_model")
	private java.lang.String payWay;
	/**支付方*/
    @Excel(name="支付方",width=15)
	private java.lang.String paySubject;
	/**支付账号*/
    @Excel(name="支付账号",width=15)
	private java.lang.String payAccount;
	/**金额*/
    @Excel(name="金额",width=15)
	private java.lang.String money;
	/**收款方*/
    @Excel(name="收款方",width=15)
	private java.lang.String receiveSubject;
	/**收款账号*/
    @Excel(name="收款账号",width=15)
	private java.lang.String receiveAccount;
	/**支付时间*/
    @Excel(name="支付时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date payDate;
	/**到账时间*/
    @Excel(name="到账时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date receiveDate;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String remarks;
	/**收费单id*/
	private java.lang.String billId;
	
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
	 *@return: java.lang.String  状态
	 */
	
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缴费编号
	 */
	
	@Column(name ="NO",nullable=true,length=32)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缴费编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付途径
	 */
	
	@Column(name ="PAY_WAY",nullable=true,length=32)
	public java.lang.String getPayWay(){
		return this.payWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付途径
	 */
	public void setPayWay(java.lang.String payWay){
		this.payWay = payWay;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方
	 */
	
	@Column(name ="PAY_SUBJECT",nullable=true,length=32)
	public java.lang.String getPaySubject(){
		return this.paySubject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付方
	 */
	public void setPaySubject(java.lang.String paySubject){
		this.paySubject = paySubject;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付账号
	 */
	
	@Column(name ="PAY_ACCOUNT",nullable=true,length=32)
	public java.lang.String getPayAccount(){
		return this.payAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付账号
	 */
	public void setPayAccount(java.lang.String payAccount){
		this.payAccount = payAccount;
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
	 *@return: java.lang.String  收款方
	 */
	
	@Column(name ="RECEIVE_SUBJECT",nullable=true,length=32)
	public java.lang.String getReceiveSubject(){
		return this.receiveSubject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款方
	 */
	public void setReceiveSubject(java.lang.String receiveSubject){
		this.receiveSubject = receiveSubject;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款账号
	 */
	
	@Column(name ="RECEIVE_ACCOUNT",nullable=true,length=32)
	public java.lang.String getReceiveAccount(){
		return this.receiveAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款账号
	 */
	public void setReceiveAccount(java.lang.String receiveAccount){
		this.receiveAccount = receiveAccount;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  支付时间
	 */
	
	@Column(name ="PAY_DATE",nullable=true,length=32)
	public java.util.Date getPayDate(){
		return this.payDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  支付时间
	 */
	public void setPayDate(java.util.Date payDate){
		this.payDate = payDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到账时间
	 */
	
	@Column(name ="RECEIVE_DATE",nullable=true,length=32)
	public java.util.Date getReceiveDate(){
		return this.receiveDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到账时间
	 */
	public void setReceiveDate(java.util.Date receiveDate){
		this.receiveDate = receiveDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARKS",nullable=true,length=300)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费单id
	 */
	
	@Column(name ="BILL_ID",nullable=true,length=32)
	public java.lang.String getBillId(){
		return this.billId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费单id
	 */
	public void setBillId(java.lang.String billId){
		this.billId = billId;
	}
	
}
