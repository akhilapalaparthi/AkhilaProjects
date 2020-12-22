package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.NewRequestDTO;
import com.revature.models.Reimbursement;
import com.revature.utility.ConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	
			
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public boolean addReimbursementRequest(NewRequestDTO r, int id1) throws BusinessException, ClassNotFoundException {

		try (Connection connection = ConnectionUtility.getConnection()) {

//				String custSql = QueriesPlayer.ADDREIMREQUEST;
//				
//				PreparedStatement ps = connection.prepareStatement(custSql);
//				ps.setString(1, cust.getFirstname());
//				ps.setString(2, cust.getLastname());
//				ps.setString(3, cust.getMiddleInitial());
//				ps.setDate(4, java.sql.Date.valueOf(cust.getDateOfBirth()));
//				ResultSet rs = ps.executeQuery();
			int id =0;
			Boolean isSuccess = Boolean.FALSE;

			String sql = QueriesPlayer.RINSERTQUERY;
			Timestamp formattedDate = this.currentDate();

			String sql2 = QueriesPlayer.MAXOFRID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("r_id") + 1;

			}
			preparedStatement = connection.prepareStatement(sql);
			// r.getD_resolved()=java.sql.Date;
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, r.getR_amount());
			preparedStatement.setTimestamp(3, formattedDate);
			preparedStatement.setDate(4, null);
			preparedStatement.setString(5, r.getR_description());
			preparedStatement.setInt(6, id1);
		//	preparedStatement.setInt(7, 0);
			preparedStatement.setInt(7, 1);
			preparedStatement.setInt(8, r.getR_type_id());

			/// preparedStatement.setTimestamp(11, formattedDate);
			// preparedStatement.setDate(12, java.sql.Date.valueOf(cust.getDateOfBirth()));

			preparedStatement.executeUpdate();

			isSuccess = Boolean.TRUE;
			return isSuccess;
		} catch (SQLException e) {
			 log.debug(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}

	}

	private Timestamp currentDate() {
		Date date = new Date(); // Date object
		long time = date.getTime(); // getTime() returns current time in milliseconds
		Timestamp ts = new Timestamp(time); // Passed the milliseconds to constructor of Timestamp class
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// hh:mm:ss a");
		String formattedDate = sdf.format(date);// format takes the dateobj and prints the formatted date as String
		java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
		return ts;
	}

	@Override
	public List<Reimbursement> viewListOfAllReimbursementbyId(Integer id)
			throws  ClassNotFoundException, BusinessException {
		List<Reimbursement> rlist = new ArrayList<>();
		try (Connection connection = ConnectionUtility.getConnection()) {
			//List<Reimbursement> rlist = new ArrayList<>();
			String sql = QueriesPlayer.SELECTRTABLE;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Reimbursement rlist1 = new Reimbursement(resultSet.getInt("r_id"), resultSet.getInt("r_amount"),
						resultSet.getString("d_submitted"), resultSet.getString("d_resolved"),
						resultSet.getString("r_description"), resultSet.getInt("r_author"),
						resultSet.getInt("r_resolver"), resultSet.getInt("r_status_id"), resultSet.getInt("r_type_id"));
				rlist.add(rlist1);
			}
			if (rlist.size() == 0) {

				//throw new BusinessException(" ... No order records found in the orders table ");

			}
			
		} catch (SQLException e) {
				
			System.out.println(e);
			log.debug(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return rlist;
	}
}
