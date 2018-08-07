
package com.buss.apt.feebill.page;
import com.buss.apt.feebill.entity.FeeBillEntity;
import com.buss.apt.feebill.entity.CustomerFeeDesEntity;
import com.buss.apt.feebill.entity.PaymentListEntity;

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
 * @Description: 收费单
 * @author onlineGenerator
 * @date 2018-07-10 22:23:42
 * @version V1.0   
 *
 */
public class FeeBillPage implements java.io.Serializable {
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
	/**收费单编号*/
    @Excel(name="收费单编号")
	private java.lang.String no;
	/**费用单名称*/
    @Excel(name="费用单名称")
	private java.lang.String name;
	/**顾客编号*/
	private java.lang.String customerNo;
	/**顾客姓名*/
    @Excel(name="顾客姓名")
	private java.lang.String customerName;
	/**费用小计*/
    @Excel(name="费用小计")
	private java.lang.String totalFee;
	/**属于*/
    @Excel(name="属于")
	private java.lang.String belongTo;
	/**收费部门*/
    @Excel(name="收费部门")
	private java.lang.String belongDept;
	/**单据状态*/
	private java.lang.String fbStatus;
	/**收费人*/
    @Excel(name="收费人")
	private java.lang.String charger;
	/**收费时间*/
    @Excel(name="收费时间",format = "yyyy-MM-dd")
	private java.util.Date dealDate;
	/**审核人*/
    @Excel(name="审核人")
	private java.lang.String auditor;
	/**审核时间*/
    @Excel(name="审核时间",format = "yyyy-MM-dd")
	private java.util.Date auditorDate;
	/**审核内容*/
    @Excel(name="审核内容")
	private java.lang.String auditorDes;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remarks;
	/**业务类型*/
	private java.lang.String feeOriginType;
	/**业务ID*/
	private java.lang.String feeOriginId;

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
	 *@return: java.lang.String  收费单编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费单编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用单名称
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用单名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
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
	 *@return: java.lang.String  费用小计
	 */
	public java.lang.String getTotalFee(){
		return this.totalFee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用小计
	 */
	public void setTotalFee(java.lang.String totalFee){
		this.totalFee = totalFee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  属于
	 */
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
	 *@return: java.lang.String  收费部门
	 */
	public java.lang.String getBelongDept(){
		return this.belongDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费部门
	 */
	public void setBelongDept(java.lang.String belongDept){
		this.belongDept = belongDept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据状态
	 */
	public java.lang.String getFbStatus(){
		return this.fbStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据状态
	 */
	public void setFbStatus(java.lang.String fbStatus){
		this.fbStatus = fbStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费人
	 */
	public java.lang.String getCharger(){
		return this.charger;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费人
	 */
	public void setCharger(java.lang.String charger){
		this.charger = charger;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费时间
	 */
	public java.util.Date getDealDate(){
		return this.dealDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费时间
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
	public java.util.Date getAuditorDate(){
		return this.auditorDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setAuditorDate(java.util.Date auditorDate){
		this.auditorDate = auditorDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核内容
	 */
	public java.lang.String getAuditorDes(){
		return this.auditorDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核内容
	 */
	public void setAuditorDes(java.lang.String auditorDes){
		this.auditorDes = auditorDes;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
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

	public String getFeeOriginType() { return feeOriginType; }

	public void setFeeOriginType(String feeOriginType) { this.feeOriginType = feeOriginType; }

	public String getFeeOriginId() { return feeOriginId; }

	public void setFeeOriginId(String feeOriginId) { this.feeOriginId = feeOriginId; }

	/**保存-收费详细*/
    @ExcelCollection(name="收费详细")
	private List<CustomerFeeDesEntity> customerFeeDesList = new ArrayList<CustomerFeeDesEntity>();
		public List<CustomerFeeDesEntity> getCustomerFeeDesList() {
		return customerFeeDesList;
		}
		public void setCustomerFeeDesList(List<CustomerFeeDesEntity> customerFeeDesList) {
		this.customerFeeDesList = customerFeeDesList;
		}
	/**保存-缴费详情*/
    @ExcelCollection(name="缴费详情")
	private List<PaymentListEntity> paymentListList = new ArrayList<PaymentListEntity>();
		public List<PaymentListEntity> getPaymentListList() {
		return paymentListList;
		}
		public void setPaymentListList(List<PaymentListEntity> paymentListList) {
		this.paymentListList = paymentListList;
		}
}
