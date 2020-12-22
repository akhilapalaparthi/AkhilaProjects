package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exception.BusinessException;
import com.revature.models.R_users;
import com.revature.models.ReimStatusDTO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;


public class ReimbursementController {
		
	
	private ReimbursementService reimbursementService = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();

	public void getAllReimbursements(HttpServletResponse res) throws IOException, BusinessException {
		
		List<Reimbursement> list = reimbursementService.ReimbursementsAssemble();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);

		
	}


public void getAllReimbursementsByStatus(HttpServletRequest req, HttpServletResponse res) throws IOException, BusinessException {
			if (req.getMethod().equals("POST")) {
					
					BufferedReader reader = req.getReader();
				
					StringBuilder sb = new StringBuilder();
				
					String line = reader.readLine();
	
					while (line != null) {
						sb.append(line);
						line = reader.readLine();
					}
				
					String body = new String(sb);
					ReimStatusDTO sDTO = om.readValue(body, ReimStatusDTO.class);
					System.out.println("sDTO.getR_status_id()"+sDTO.r_status_id);
					List<Reimbursement> list = reimbursementService.ReimbursementsByStatus(sDTO.r_status_id);
				
					
							
			//	HttpSession ses = req.getSession(false);// if successful user then normal session else null..
			//	ReimStatusDTO status =  (ReimStatusDTO) ses.getAttribute("status");
			
		//		System.out.println("sDTO.getR_status_id()"+sDTO.getR_status_id());

			//	List<Reimbursement> list = ReimbursementsByStatus(status); 
				String json = om.writeValueAsString(list);
				res.getWriter().print(json);
				res.setStatus(200);
}}
}