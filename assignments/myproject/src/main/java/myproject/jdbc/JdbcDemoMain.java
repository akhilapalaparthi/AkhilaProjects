package myproject.jdbc;

import myproject.jdbc.dbUtility.PostresSqlConnection;
import myproject.jdbc.dao.OrderDAO;
import myproject.jdbc.dao.impl.OrderDAOImpl;
import myproject.jdbc.exception.BusinessException;
import myproject.jdbc.model.Orders;

public class JdbcDemoMain {

			
		public static void main(String[] args) {
			
			
//			Orders order = new Orders (567, 987 , " Pending ");
//		
			//System.out.println("i am in myproject main()");	
			OrderDAO orderDAO = new OrderDAOImpl();
//			Creating a row in the table test.orders.	
//				try {
//					if(orderDAO.createOrders(order)>0) {
//						System.out.println("Order created in DB with below details");
//						System.out.println(order);
//					}
//				} catch (BusinessException e) {
//					System.out.println(e.getMessage());
//				}
				
	//     displaying a row on the cosole by retrieving with orderid 					
					try {
						
						int id=456;
						Orders order= orderDAO.getOrderById(id);
						if(order!=null) {
							System.out.println("Order found with id "+id+" details are : ");
							System.out.println(order);
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());
					}
				
		
	}

}
