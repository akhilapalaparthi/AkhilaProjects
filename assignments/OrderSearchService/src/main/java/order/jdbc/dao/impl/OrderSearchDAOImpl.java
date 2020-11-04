package order.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import order.jdbc.dao.OrderSearchDAO;
import order.jdbc.dao.dbutilities.PostresSqlConnection;
import order.jdbc.dao.dbutilities.QueriesPlayer;
import order.jdbc.exception.BusinessException;
import order.jdbc.model.Orders;

public class OrderSearchDAOImpl implements OrderSearchDAO {

	@Override
	public Orders getOrderById(int id) throws BusinessException {
	
		Orders order = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {

			String sql = QueriesPlayer.SELECTQUERY;			
					
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
						ResultSet resultSet = preparedStatement.executeQuery();
	if (resultSet.next()) {
	
		order = new Orders(id, resultSet.getInt("customerid"), resultSet.getString("order_status"));
									
	}else {
	
	throw new BusinessException("Invalid ID!!!... No matching records found for the ID =  "+id);
	
	}
	} catch (ClassNotFoundException | SQLException e) {
	
		System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return order;
	}

	@Override
	public List<Orders> getAllOrders() throws BusinessException{
		
		List<Orders> orderlist = new ArrayList<>();
		
		try (Connection connection = PostresSqlConnection.getConnection()) {

			String sql = QueriesPlayer.FETCHALLRECORDS;			
					
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
						ResultSet resultSet = preparedStatement.executeQuery();
	while (resultSet.next()) {
	
		Orders order = new Orders(resultSet.getInt("orderid"),resultSet.getInt("customerid"), resultSet.getString("order_status"));
		orderlist.add(order);							
	}
	          if(orderlist.size()==0) {
	
	        	  throw new BusinessException(" ... No order records found in the orders table ");
	
	          }
	} catch (ClassNotFoundException | SQLException e) {
	
		System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}	
		return orderlist;
	}
	@Override
	public List<Orders> getOrdersByCustomerid(int id) throws BusinessException {
		
				List<Orders> orderlist = new ArrayList<>();
		
				try (Connection connection = PostresSqlConnection.getConnection()) {
						
					String sql = QueriesPlayer.ORDERSQUERY;			
					
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
							preparedStatement.setInt(1, id);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {
	
							Orders order = new Orders(resultSet.getInt("orderid"),resultSet.getInt("customerid"), resultSet.getString("order_status"));
							orderlist.add(order);							
						}
						if(orderlist.size()==0) {
	
							throw new BusinessException(" ... No order records found for customerid "+id);
	
						}
				} catch (ClassNotFoundException | SQLException e) {
	
					System.out.println(e); // take off this line when in production
					throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
					}
			
					return orderlist;
	}
}
	
	


