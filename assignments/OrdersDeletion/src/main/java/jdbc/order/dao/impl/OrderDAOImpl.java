package jdbc.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.orders.dao.OrderDAO;
import jdbc.orders.dbutility.PostresSqlConnection;
import jdbc.orders.exception.BusinessException;
import jdbc.orders.model.Orders;
	
	
	public class OrderDAOImpl implements OrderDAO {
	
		
		@Override
		public void deleteOrder(int id) throws BusinessException {
				
			try(Connection connection = PostresSqlConnection.getConnection()) {
				
				String sql = QueriesPlayer.DELETEQUERY;
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, id);

					preparedStatement.executeUpdate();
					System.out.println("Order id  "+id+ " details are deleted");

			} catch (ClassNotFoundException | SQLException e) {
	
				System.out.println(e); // take off this line when in production
				throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
			}
		
		}

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
		
		throw new BusinessException("Invalid ID!!!... No matching records found for the ID = "+id);
		
		}
		} catch (ClassNotFoundException | SQLException e) {
		
			System.out.println(e); // take off this line when in production
				throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
			}
			return order;
		}

		
		
		@Override
		public int createOrders(Orders order) throws BusinessException {


			int c = 0;
			try (Connection connection = PostresSqlConnection.getConnection()) {
					String sql = QueriesPlayer.INSERTQUERY;	
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


