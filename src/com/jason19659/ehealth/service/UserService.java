/**
 * 
 */
package com.jason19659.ehealth.service;

import java.util.List;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.model.User;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.service
 *
 * 2015年4月19日
 */
public interface UserService extends BaseService<User>{
	 User selectByUsername(String username);
	 List<User> selectAll();
}
