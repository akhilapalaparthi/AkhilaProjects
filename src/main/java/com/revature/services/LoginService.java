package com.revature.services;

import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.R_users;
import com.revature.repo.LoginDAO;
import com.revature.repo.LoginDAOImpl;

public class LoginService {
	
	
					private LoginDAO gDAO = new LoginDAOImpl();
					
					
						public R_users login(String username, String password) throws BusinessException {
					
						String pwd = encrypt(password);
						R_users lo = gDAO.validateLoginPassword(username, pwd);
					
					return lo;
	}


						private String encrypt(String password) {
							
							StringBuffer sb = new StringBuffer();
							char[] chars = password.toCharArray();
							
							for(char c : chars) {
								c +=1;
								sb.append(c);
							}
							String s1 = new String(sb);
							return s1;
						}


}
