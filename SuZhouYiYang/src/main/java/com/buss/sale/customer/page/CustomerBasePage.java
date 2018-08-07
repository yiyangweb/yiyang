
package com.buss.sale.customer.page;
import com.buss.sale.customer.entity.CustomerBaseEntity;
import com.buss.sale.customer.entity.CustomerProfileEntity;
import com.buss.sale.customer.entity.CustomerRelativesEntity;
import com.buss.sale.customer.entity.CustomerEducatioinEntity;
import com.buss.sale.customer.entity.CustomerJobEntity;
import com.buss.sale.customer.entity.CustomerCommonChargeEntity;

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
 * @Description: 客户信息
 * @author onlineGenerator
 * @date 2018-07-14 16:21:19
 * @version V1.0   
 *
 */
public class CustomerBasePage implements java.io.Serializable {
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
	/**客户编号*/
    @Excel(name="客户编号")
	private java.lang.String no;
	/**客户姓名*/
    @Excel(name="客户姓名")
	private java.lang.String name;
	/**身份证号*/
    @Excel(name="身份证号")
	private java.lang.String idCardNo;
	/**客户状态*/
	private java.lang.String customerStatus;
	/**性别*/
    @Excel(name="性别")
	private java.lang.String sex;
	/**年龄*/
    @Excel(name="年龄")
	private java.lang.Integer age;
	/**客户从属*/
    @Excel(name="客户从属")
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
	 *@return: java.lang.String  客户编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	public java.lang.String getIdCardNo(){
		return this.idCardNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdCardNo(java.lang.String idCardNo){
		this.idCardNo = idCardNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户状态
	 */
	public java.lang.String getCustomerStatus(){
		return this.customerStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户状态
	 */
	public void setCustomerStatus(java.lang.String customerStatus){
		this.customerStatus = customerStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
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
	 *@return: java.lang.String  客户从属
	 */
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户从属
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
	}

	/**保存-详细信息*/
    @ExcelCollection(name="详细信息")
	private List<CustomerProfileEntity> customerProfileList = new ArrayList<CustomerProfileEntity>();
		public List<CustomerProfileEntity> getCustomerProfileList() {
		return customerProfileList;
		}
		public void setCustomerProfileList(List<CustomerProfileEntity> customerProfileList) {
		this.customerProfileList = customerProfileList;
		}
	/**保存-亲属关系*/
    @ExcelCollection(name="亲属关系")
	private List<CustomerRelativesEntity> customerRelativesList = new ArrayList<CustomerRelativesEntity>();
		public List<CustomerRelativesEntity> getCustomerRelativesList() {
		return customerRelativesList;
		}
		public void setCustomerRelativesList(List<CustomerRelativesEntity> customerRelativesList) {
		this.customerRelativesList = customerRelativesList;
		}
	/**保存-教育情况*/
    @ExcelCollection(name="教育情况")
	private List<CustomerEducatioinEntity> customerEducatioinList = new ArrayList<CustomerEducatioinEntity>();
		public List<CustomerEducatioinEntity> getCustomerEducatioinList() {
		return customerEducatioinList;
		}
		public void setCustomerEducatioinList(List<CustomerEducatioinEntity> customerEducatioinList) {
		this.customerEducatioinList = customerEducatioinList;
		}
	/**保存-工作经历*/
    @ExcelCollection(name="工作经历")
	private List<CustomerJobEntity> customerJobList = new ArrayList<CustomerJobEntity>();
		public List<CustomerJobEntity> getCustomerJobList() {
		return customerJobList;
		}
		public void setCustomerJobList(List<CustomerJobEntity> customerJobList) {
		this.customerJobList = customerJobList;
		}
	/**保存-周期收费*/
    @ExcelCollection(name="周期收费")
	private List<CustomerCommonChargeEntity> customerCommonChargeList = new ArrayList<CustomerCommonChargeEntity>();
		public List<CustomerCommonChargeEntity> getCustomerCommonChargeList() {
		return customerCommonChargeList;
		}
		public void setCustomerCommonChargeList(List<CustomerCommonChargeEntity> customerCommonChargeList) {
		this.customerCommonChargeList = customerCommonChargeList;
		}
}
