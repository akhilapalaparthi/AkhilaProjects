package jdbc.order.dao.impl;

	
	public class QueriesPlayer {
		
		
		public static final String DELETEQUERY= "Delete from test.orders where orderid= ? ";
		
		public static final String SELECTQUERY= "select orderid, customerid, order_status from test.orders where orderid=?";

		public static final String INSERTQUERY= "INSERT INTO test.Orders(orderid, customerid, order_status) "
				+ "VALUES(?,?,?)";
		}


