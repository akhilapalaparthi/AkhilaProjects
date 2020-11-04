package jdbc.orders.model;

public class Orders {
	private int orderid;
	private int customerid;
	private String orderstatus;
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(int orderid, int customerid, String orderstatus) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.orderstatus = orderstatus;
	}
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", customerid=" + customerid + ", orderstatus=" + orderstatus + "]";
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	

}
