package com.revature.repo;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.utility.ConnectionUtility;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	//private ReimbursementDAO rDAO = new ReimbursementDAOImpl();
	private static Logger log = Logger.getLogger(ReimbursementDAOImpl.class);
	@Override
	public List<Reimbursement> viewAllReimbursements() throws BusinessException {

		// List<Reimbursement> list2 = new ArrayList<>();
		try (Connection connection = ConnectionUtility.getConnection()) {
			List<Reimbursement> list2 = new ArrayList<>();
			String sql = QueriesPlayer.VIEWLOG;
			Statement statement = connection.createStatement();
			//PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			//resultSet.getDate(sql)
			while (resultSet.next()) {

				Reimbursement r = new Reimbursement(resultSet.getInt("r_id"), resultSet.getInt("r_amount"),
						resultSet.getString("d_submitted"), resultSet.getString("d_resolved"),
						resultSet.getString("r_description"), resultSet.getInt("r_author"),
						resultSet.getInt("r_resolver"), resultSet.getInt("r_status_id"), resultSet.getInt("r_type_id"));
				list2.add(r);
			}
			if (list2.size() == 0) {

				throw new BusinessException(" ... No reimbursement records found in Reimbursement table ");

			}
			return list2;
		} catch (SQLException e) {

			 log.debug(e); // take off this line when in production
			//System.out.println(e);
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}

	}

	@Override
	public List<Reimbursement> viewReimbursementByStatus(Integer status) throws BusinessException {

		//List<Reimbursement> list1 = new ArrayList<>();
		// Reimbursement reim = null;
		try (Connection connection = ConnectionUtility.getConnection()) {
			
			List<Reimbursement> list1 = new ArrayList<>();
			String sql = QueriesPlayer.SELECTQUERY;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Reimbursement r = new Reimbursement(resultSet.getInt("r_id"), resultSet.getInt("r_amount"),
						resultSet.getString("d_submitted"), resultSet.getString("d_resolved"),
						resultSet.getString("r_description"), resultSet.getInt("r_author"),
						resultSet.getInt("r_resolver"), resultSet.getInt("r_status_id"), resultSet.getInt("r_type_id"));
				list1.add(r);
			}
			if (list1.size() == 0) {

				throw new BusinessException(" ... No reimbursement records found in Reimbursement table ");

			}return list1;
		} catch (SQLException e) {

			// log.debug(e); // take off this line when in production
			System.out.println(e);
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		
	}
}
