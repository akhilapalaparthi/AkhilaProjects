package com.revature.services;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.NewRequestDTO;
import com.revature.models.Reimbursement;
import com.revature.repo.EmployeeDAO;
import com.revature.repo.EmployeeDAOImpl;
import com.revature.repo.ReimbursementDAO;
import com.revature.repo.ReimbursementDAOImpl;

public class EmployeeService {
	
	
	private EmployeeDAO eDAO = new EmployeeDAOImpl();

	public List<Reimbursement> reinbursementsById(Integer id) throws BusinessException, ClassNotFoundException {
		return eDAO.viewListOfAllReimbursementbyId(id);
	}

	public boolean creatingNewRequest(NewRequestDTO r, int id) throws BusinessException, ClassNotFoundException{
        return eDAO.addReimbursementRequest(r, id);
	}}

