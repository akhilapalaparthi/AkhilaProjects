package order.jdbc.service;

import java.util.List;

import order.jdbc.exception.BusinessException;
import order.jdbc.model.Orders;

public interface OrderIdSearchService {
	
			
			public Orders getOrderById(int id) throws BusinessException;
			public List<Orders> getAllOrders() throws BusinessException;
			public List<Orders> getOrdersByCustomerid(int id) throws BusinessException;
			

}
