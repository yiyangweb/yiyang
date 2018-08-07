package com.buss.nh.student.service;
import com.buss.nh.student.entity.TestStudentEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TestStudentServiceI extends CommonService{
	
 	public void delete(TestStudentEntity entity) throws Exception;
 	
 	public Serializable save(TestStudentEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TestStudentEntity entity) throws Exception;
 	
}
