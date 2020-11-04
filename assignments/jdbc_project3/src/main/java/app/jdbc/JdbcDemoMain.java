package app.jdbc;

import app.jdbc.dao.OrderDAO;
import app.jdbc.dao.impl.OrderDAOImpl;
import app.jdbc.exception.BusinessException;
import app.jdbc.model.Orders;

public class JdbcDemoMain {

	public static void main(String[] args) {
		
		
			Orders order = new Orders(77, 67 , "delivered ");
		
				OrderDAO orderDAO=new OrderDAOImpl();
				
				try {
					if(orderDAO.createOrders(order)>0) {
						System.out.println("Order created in DB with below details");
						System.out.println(order);
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				

	}

}
