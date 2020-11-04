package order.jdbc.sevice.impl;

import java.util.List;

import order.jdbc.dao.OrderSearchDAO;
import order.jdbc.dao.impl.OrderSearchDAOImpl;
import order.jdbc.exception.BusinessException;
import order.jdbc.model.Orders;

import order.jdbc.service.OrderIdSearchService;

public class OrderIdSearchServiceImpl implements OrderIdSearchService{
		
		private OrderSearchDAO searchDAO= new OrderSearchDAOImpl();
	
			@Override
			public Orders getOrderById(int id) throws BusinessException {
			Orders order1= null;
			if (id>0 && id < 1000){
				order1=searchDAO.getOrderById(id);
				
					}else {
				throw new BusinessException("Entered Order id "+id+" is invalid!!! Valid ids are from 1 to 999...Kindly re-enter");
						}
			return order1;
			}

			@Override
				public List<Orders> getAllOrders() throws BusinessException {
				List<Orders> orderslist = null;
				orderslist = searchDAO.getAllOrders();
				return orderslist;
			}

				@Override
				public List<Orders> getOrdersByCustomerid(int id) throws BusinessException {
					List<Orders> orderslist = null;
					if (id>0 && id < 1000){
						orderslist=searchDAO.getOrdersByCustomerid(id);
						
							}else {
						throw new BusinessException("Entered customer id "+id+" is invalid!!! please enter between 1 to 999\n");
								}
					//orderslist = searchDAO.getOrdersByCustomerid(id);
					return orderslist;	
	}
	}
