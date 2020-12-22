package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.R_users;
import com.revature.models.Reimbursement;
import com.revature.services.LoginService;

public class LoginController {

	private ObjectMapper om = new ObjectMapper();
	private LoginService logService = new LoginService();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, BusinessException {

		if (req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();

			StringBuilder sb = new StringBuilder();

			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}

			String body = new String(sb);

			LoginDTO lDTO = om.readValue(body, LoginDTO.class);
			R_users ls = logService.login(lDTO.username, lDTO.password);
			System.out.println("in logincontrollers" + ls.getR_username());
			System.out.println("in logincontrollers" + ls.getR_username());
			// logService.login(lDTO.username, lDTO.password)
			if (ls != null) {
				System.out.println("in logincontrollers" + ls.getR_user_role_id());
					if(ls.getR_user_role_id() == 1) {
						res.getWriter().print(1);
					}else {
						res.getWriter().print(2);
					}
				
				HttpSession ses = req.getSession();
				//	ses.getAttribute(body)
				ses.setAttribute("user", ls);// username, password from frontpage
				ses.setAttribute("loggedin", true);

				res.setStatus(200);
			//	res.getWriter().print("Login Successful from MasterServlet");
			} else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().print("Login failed from MasterServlet");
			}
		} else if (req.getMethod().equals("GET")) {
			// This shows logging in with Query Params solely for the
			// example of using said parameters. Do not do this!

			if (req.getParameterMap().containsKey("username") && req.getParameterMap().containsKey("password")) {
				R_users l = logService.login(req.getParameter("username"), req.getParameter("password"));
				if (l != null) {
					HttpSession ses = req.getSession(true);

					ses.setAttribute("loggedin", true);

					res.setStatus(200);
					res.getWriter().print("Login Successful from M2");

				} else {
					HttpSession ses = req.getSession(false);
					if (ses != null) {
						ses.invalidate();
					}
					res.setStatus(401);
					res.getWriter().print("Login failed FROM M2");
				}
			}
		}

	}

	
}
