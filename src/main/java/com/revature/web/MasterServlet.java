package com.revature.web;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;

public class MasterServlet extends HttpServlet {

	/**
	* 
		*/
	private static final long serialVersionUID = 1L;
	private ReimbursementController reimbursementController = new ReimbursementController();
	private LoginController logController = new LoginController();
	private EmployeeController employeeController = new EmployeeController();
	Logger log = Logger.getLogger(MasterServlet.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("application/json");
		res.setStatus(404); // default status has been set to 404 instead of null.
		//System.out.println(req.getRequestURI());
		final String URI = req.getRequestURI().replace("/RevEmployeeReinbursement/", "");

		//System.out.println(URI);

		switch (URI) {
		case "reimbursement":
			if (req.getSession(false) != null) {
				try {
					reimbursementController.getAllReimbursements(res);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.debug("e= "+e);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.debug("e= "+e);
				}
			} else {
				res.setStatus(403); // 403 is forbidden.
			}
			break;
		case "login":
			try {
				logController.login(req, res);
			} catch (IOException e) {
				res.setStatus(401);
				e.printStackTrace();
				log.debug("e= "+e);
			} catch (BusinessException e) {
				res.setStatus(401);
				e.printStackTrace();
				log.debug("e= "+e);
			}break;
		case "newRequest":
			try {
				employeeController.newReimbursementRequest(req, res);
			} catch (ClassNotFoundException | IOException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug("e= "+e);
			}
			break;
		case "empPastTickets":
			try {
				employeeController.viewPastReinbursementById(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug("e= "+e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug("e= "+e);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug("e= "+e);
			}
		case "status":
			try {
				reimbursementController.getAllReimbursementsByStatus(req, res);
			} catch (IOException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug("e= "+e);
			}
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("successful in doPost()");
		try {
			doGet(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("e= "+e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("e= "+e);
		}
	}
}
