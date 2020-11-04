package order.jdbc.main;

import java.util.List;
import java.util.Scanner;

import order.jdbc.exception.BusinessException;
import order.jdbc.model.Orders;
import order.jdbc.service.OrderIdSearchService;
import order.jdbc.sevice.impl.OrderIdSearchServiceImpl;

public class OrderMain {

	public static void main(String[] args) {
		
		
				Scanner scanner= new Scanner(System.in);
				
				System.out.println(" Welcome to Order Search Service");
				System.out.println("---------------------------------");
				OrderIdSearchService orderidsearchservice = new OrderIdSearchServiceImpl();
				int ch=0;
				do {
					System.out.println("\n\n Order Search Menu");
					System.out.println("===================");
					System.out.println("Press 1.. to get order details by entering order id");
					System.out.println(" Press 2.. to display the list of all orders without any input");
					System.out.println(" Press 3.. to get order details by entering customer id");
					System.out.println(" Press 4... to exit the application");
					System.out.println("Please enter appropriate choices(1 to 4)");
					try {
						
					ch= Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e){
						System.out.println("Numberformatexception"+e);
					}
					
					switch(ch) {
					case 1:System.out.println("\nPlease enter orderid to get order details\n ");
						try {
							int id = Integer.parseInt(scanner.nextLine());
							// Code Here for SERVICE LAYER.
							Orders order=orderidsearchservice.getOrderById(id);
							if(order!=null) {
								System.out.println("We found details for order id " +id+ "\n");
								System.out.println(order);
							}
						}catch(NumberFormatException e) {
							
							System.out.println(" Id can be from 1 to 999...Kindly re-enter\n");
						
						}catch(BusinessException e) {
							//System.out.println("we are case 1's businessexception\n");
							System.out.println(e.getMessage());
						}
						break;
					case 2: System.out.println("Gets all the orders \n\n");
						
							try {
						List<Orders> orderslist= orderidsearchservice.getAllOrders();
							if( orderslist!=null && orderslist.size()>0) {
								System.out.println("We found "+orderslist.size()+" no-of orders in the database");
								for( Orders o:orderslist) {
									System.out.println(o);
								}}}
								catch(BusinessException e) {
								//	System.out.println("we are in case 2 business exception");
									System.out.println(e.getMessage());
								}			
								break;
					case 3: System.out.println("Please enter customer id, to get orderIds and order status. \n");
					
					try {
						int id = Integer.parseInt(scanner.nextLine());
						// Code Here for SERVICE LAYER.
						List<Orders> orderslist=orderidsearchservice.getOrdersByCustomerid(id);
						System.out.println("We found "+orderslist.size()+" orders for customerid= "+id+"\n");
						if(orderslist!=null && orderslist.size()>0) {
							for( Orders o:orderslist) {
								System.out.println(o);
							}}
							}
					catch(NumberFormatException e) {
						
						System.out.println(" Id should be number only...Kindly re-enter\n\n");
						System.out.println(e);
					}	catch(BusinessException e) {
						//System.out.println("we are case 3's businessexception\n\n");
						System.out.println(e.getMessage());
					}		
						break;
					case 4: System.out.println("Thank you for using this application\n\n");
						break;
					default:System.out.println("invalid number please enter 1 to 4\n\n");
						break;
					}
				} while( ch != 4);
	}
}
	

