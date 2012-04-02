package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.io.IOException;
import java.util.ArrayList;

public class Till {
		private ArrayList<Order> orders;
	public Till(){
		orders = new ArrayList<Order>();
	}

	
	public void addOrder(Order orders){
		Order order = new Order();
		orders.add(order);
	}
	
	public void getTotalForDay(){
		
	}
	
	public void save(){
		
	}
	
	public void load() throws IOException{
		
	}
	
}
