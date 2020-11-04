package order.jdbc.dao;

import java.util.List;

import order.jdbc.exception.BusinessException;
import order.jdbc.model.Orders;


public interface OrderSearchDAO {
	

	public Orders getOrderById(int id) throws BusinessException;
	public List<Orders> getAllOrders() throws BusinessException;
	public List<Orders> getOrdersByCustomerid(int id) throws BusinessException;
	

}
