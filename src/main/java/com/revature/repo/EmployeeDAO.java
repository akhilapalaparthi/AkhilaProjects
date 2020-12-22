package com.revature.repo;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.NewRequestDTO;
import com.revature.models.Reimbursement;

public interface EmployeeDAO {
	
	//public Boolean addReimbursementRequest(LoginDTO dto, Reimbursement r) throws BusinessException, ClassNotFoundException;
	public List<Reimbursement> viewListOfAllReimbursementbyId(Integer id) throws BusinessException, ClassNotFoundException;
	//public boolean addReimbursementRequest(Reimbursement r) throws BusinessException, ClassNotFoundException;
	public boolean addReimbursementRequest(NewRequestDTO r, int id) throws BusinessException, ClassNotFoundException; 

}
