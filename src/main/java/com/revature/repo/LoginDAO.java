package com.revature.repo;

import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.R_users;

public interface LoginDAO {
	
		//	public LoginDTO validateLoginPassword(String username, String pwd) throws BusinessException;

			public R_users validateLoginPassword(String username, String pwd) throws BusinessException;

			
}
