package jdbc.orders.main;

import jdbc.order.dao.impl.OrderDAOImpl;
import jdbc.orders.dao.OrderDAO;
import jdbc.orders.exception.BusinessException;
import jdbc.orders.model.Orders;

public class OrdersMain {
	
	public static void main(String[] args) {
	OrderDAO orderDAO = new OrderDAOImpl();
	try{
		
		int id=46;
		Orders order= orderDAO.getOrderById(id);
		if(order!=null) {
			System.out.println("Order found with id "+id+" details are : ");
			System.out.println(order);
			orderDAO.deleteOrder(id);
		}
	} catch (BusinessException e) {
		System.out.println(e.getMessage());
	}
}
}
