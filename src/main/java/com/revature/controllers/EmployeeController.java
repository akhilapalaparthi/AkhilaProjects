package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.NewRequestDTO;
import com.revature.models.R_users;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;

public class EmployeeController {

	private ObjectMapper om = new ObjectMapper();
	private EmployeeService empService = new EmployeeService();

	public void newReimbursementRequest(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ClassNotFoundException, BusinessException {

		if (req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();

			StringBuilder sb = new StringBuilder();

			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}

			String body = new String(sb);
			NewRequestDTO rDTO = om.readValue(body, NewRequestDTO.class);
			HttpSession ses = req.getSession(false);// if successful user then normal session else null..
			R_users userModel = (R_users) ses.getAttribute("user");
			System.out.println("userModel.getR_user_id()"+userModel.getR_user_id());
			empService.creatingNewRequest(rDTO, userModel.getR_user_id());
			
			res.setStatus(200);

		}
	}

	public void viewPastReinbursementById(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ClassNotFoundException, BusinessException {
			System.out.println("in empcontroller");
	//	if (req.getMethod().equals("POST")) {
			
//			BufferedReader reader = req.getReader();
//
//			StringBuilder sb = new StringBuilder();
//
//			String line = reader.readLine();
//
//			while (line != null) {
//				sb.append(line);
//				line = reader.readLine();
//			}
//
//			String body = new String(sb);
//			NewRequestDTO rDTO = om.readValue(body, NewRequestDTO.class);

			HttpSession ses = req.getSession(false);// if successful user then normal session else null..
			R_users userModel = (R_users) ses.getAttribute("user");
		
			System.out.println("user-id"+userModel.getR_user_id());

			List<Reimbursement> list = empService.reinbursementsById(userModel.getR_user_id());
			String json = om.writeValueAsString(list);
			res.getWriter().print(json);
			res.setStatus(200);

	}
}