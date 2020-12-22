package com.revature.services;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.repo.ReimbursementDAO;
import com.revature.repo.ReimbursementDAOImpl;

public class ReimbursementService {

	private ReimbursementDAO rDAO = new ReimbursementDAOImpl();

	public List<Reimbursement> ReimbursementsAssemble() throws BusinessException {
		return rDAO.viewAllReimbursements();
	}

	public List<Reimbursement> ReimbursementsByStatus(int status) throws BusinessException {
		return rDAO.viewReimbursementByStatus(status);

	}
}
