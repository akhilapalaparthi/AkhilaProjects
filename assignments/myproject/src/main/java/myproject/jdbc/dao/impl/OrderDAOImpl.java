package myproject.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myproject.jdbc.dbUtility.PostresSqlConnection;
import myproject.jdbc.dao.OrderDAO;
import myproject.jdbc.exception.BusinessException;
import myproject.jdbc.model.Orders;

public class OrderDAOImpl implements OrderDAO {

				@Override
				public int updateOrderContact(int id) throws BusinessException {
		
					return 0;
				}

				
				
				
				@Override
				public void deleteOrder(int id) throws BusinessException {
				
				
					try (Connection connection = PostresSqlConnection.getConnection()) {
						
						String sql = QueriesPlayer.DELETEQUERY;
							
							PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, order.getOrderid());
//			preparedStatement.setInt(2, order.getCustomerid());
//			preparedStatement.setString(3, order.getOrderstatus());
	
							preparedStatement.executeUpdate();

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
