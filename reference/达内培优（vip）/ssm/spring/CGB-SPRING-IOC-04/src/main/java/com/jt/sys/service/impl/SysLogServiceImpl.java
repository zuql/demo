package com.jt.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.sys.dao.SysLogDao;
import com.jt.sys.service.SysLogService;
/**<bean id="sysLogService" class="com.jt.sys.service.impl.SysLogServiceImpl">
 *     <property name="SysLogDao" ref="sysLogDao">
 * </bean>
 * 
 * @author ta
 *
 */
@Service("sysLogService") 
public class SysLogServiceImpl 
          implements SysLogService {
	  @Autowired
	  private SysLogDao sysLogDao;
	  
	/*public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	  }*/
	  public SysLogDao getSysLogDao() {
		return sysLogDao;
	  }
	  
}
