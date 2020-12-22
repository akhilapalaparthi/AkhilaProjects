package com.revature.repo;

public class QueriesPlayer {
	
	
	public static final String VIEWLOG  = "select r_id, r_amount, d_submitted, d_resolved, r_description, r_author, r_resolver, r_status_id, r_type_id from reimbursement;";
	public static final String SELECTQUERY = "select r_id, r_amount, d_submitted, d_resolved, r_description, r_author, r_resolver, r_status_id, r_type_id from reimbursement where r_status_id=?;";
	public static final String QUERYLOGPWD = "select r_user_id, r_username, r_password, r_first_name, r_last_name, email, r_user_role_id  from r_users where r_username=? and r_password=?;";
	public static final String RINSERTQUERY= "insert into reimbursement"
		+"(r_id, r_amount, d_submitted, d_resolved, r_description, r_author, r_status_id, r_type_id) values(?,?,?,?,?,?,?,?);";
	public static final String MAXOFRID = "SELECT max(r_id) as r_id from reimbursement;";
	
	public static final String SELECTRTABLE = "SELECT r_id, r_amount, d_submitted, d_resolved, r_description, r_author, r_resolver, r_status_id, r_type_id from reimbursement "
			+"where r_author=?;";
			

}
