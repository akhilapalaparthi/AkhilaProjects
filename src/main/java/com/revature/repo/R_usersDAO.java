package com.revature.repo;

import java.util.List;


import com.revature.models.Reimbursement;

public interface R_usersDAO {
	
	
			public boolean addReimbursementRequest(Reimbursement r);
			public List<Reimbursement> viewUserAllPastTickets();

}
