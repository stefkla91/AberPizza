package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderItem {
	private int quantity;
	private ArrayList<Item> item;
	
	public OrderItem(Item items, int quantitys){
		quantity = quantitys;
		item = new ArrayList<Item>();
	}
	
	public int getQuantity(){
		return (Integer) null;
		
	}
	
	public BigDecimal getOrderItem(){
		return null;
		
	}
}
