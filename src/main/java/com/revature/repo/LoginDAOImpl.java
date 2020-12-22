package com.revature.repo;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exception.BusinessException;
import com.revature.models.LoginDTO;
import com.revature.models.R_users;
import com.revature.models.Reimbursement;
import com.revature.utility.ConnectionUtility;

public class LoginDAOImpl implements LoginDAO {
	
	private static Logger log = Logger.getLogger(LoginDAOImpl.class);

	@Override
	public R_users validateLoginPassword(String username, String pwd) throws BusinessException {

		R_users dto = null;

		try (Connection connection = ConnectionUtility.getConnection()) {

			String sql = QueriesPlayer.QUERYLOGPWD;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pwd);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

							 dto =  new R_users(
									resultSet.getInt("r_user_id"),
									resultSet.getString("r_username"), 
									resultSet.getString("r_password"),
									resultSet.getString("r_first_name"),
									resultSet.getString("r_last_name"),
									resultSet.getString("email"),
									resultSet.getInt("r_user_role_id"));
									
									
				return dto;
			} else {

				throw new BusinessException(" ... invalid username or password ");

			}
		} catch (SQLException e) {

			 log.debug(e); // take off this line when in production
			System.out.println(e);
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		// return dto;

	}


	

}
