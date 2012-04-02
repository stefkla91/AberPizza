package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Item {
	private Date date;
	private String customerName;
	private ArrayList<OrderItem> items;
	private int quantity;
	
	public Order(){
		items = new ArrayList<OrderItem>();
		customerName = "Unknown"; 
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
	}
	
	public void setCustomerName(String name){
		customerName = name;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public void addItem(Item item, int quantity){
		OrderItem orderItem = new OrderItem(item, quantity);
		items.add(orderItem);
	}
	
	public void updateItemQuantity(){
		
	}
	
	public BigDecimal getSubtotal(){
		return null;
	}
	
	public BigDecimal getDiscount(){
		return null;
	}
	
	public String getReceipt(){
		return null;
		
	}

	@Override
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDecription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription() {
		// TODO Auto-generated method stub
		
	}
}
