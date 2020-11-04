package app.jdbc.dao;
import app.jdbc.exception.*;
import app.jdbc.model.Orders;
public interface OrderDAO {

	//DAO - Data Access Object
	//A DAO represents that all the code which is related  to your DB or persistence or
	//storage will be written inside this.
	

		public int updateOrderContact(int id)throws BusinessException;

		public void deleteOrder(int id)throws BusinessException;

		public Orders getOrderById(int id)throws BusinessException;
		
		public int createOrders(Orders order) throws BusinessException;

	
}
