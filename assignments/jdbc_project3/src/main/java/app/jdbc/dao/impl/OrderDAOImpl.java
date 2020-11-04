package app.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.jdbc.dao.OrderDAO;
import app.jdbc.dbutil.PostresSqlConnection;
import app.jdbc.exception.BusinessException;
import app.jdbc.model.Orders;

public class OrderDAOImpl implements OrderDAO {
	
	public int updateOrderContact(int id)throws BusinessException{
		return id;
		
	}

	public void deleteOrder(int id)throws BusinessException{
		
	}

	public Orders getOrderById(int id)throws BusinessException{
		return null;
			}
	
	public int createOrders(Orders order) throws BusinessException{
		
			int c = 0;
			try (Connection connection = PostresSqlConnection.getConnection()) {
				String sql = "INSERT INTO test.Orders(orderid, customerid, order_status) "
						+ "VALUES(?,?,?)";
			
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, order.getOrderid());
				preparedStatement.setInt(2, order.getCustomerid());
				preparedStatement.setString(3, order.getOrderstatus());
		
				c = preparedStatement.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e); // take off this line when in production
				throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
			}
			return c;
		
	}
	

	

}
