package com.revature.repo;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	
			public List<Reimbursement> viewAllReimbursements() throws BusinessException;
			public List<Reimbursement> viewReimbursementByStatus(Integer r_status_id) throws BusinessException;

}
