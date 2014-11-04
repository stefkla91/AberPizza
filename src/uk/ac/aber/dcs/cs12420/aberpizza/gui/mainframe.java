package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * MainFrame class which inherits from JFrame get's created in the main() method
 * of the Main() class creates the Mainframe, ItemPanel, OrderPanel and
 * DataManager
 * 
 * @author stk4
 * 
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private Menu m;
	private ItemPanel itemPanel;
	private OrderPanel orderPanel;
	private DataManager dataManager;

	/**
	 * constructor of the MainFrame class creates ItemPanel, OrderPanel and the
	 * Menu and set's them on the frame creates an DataManager and set's it in
	 * ItemPanel and OrderPanel to created relationships between them calls a
	 * couple of DataManager methods to ensure a good start of the program
	 */
	public MainFrame() {
		m = new Menu(this);
		itemPanel = new ItemPanel();
		orderPanel = new OrderPanel();
		dataManager = new DataManager(itemPanel, orderPanel);
		m.setDataManager(dataManager);
		itemPanel.setDataManager(dataManager);

		try {
			dataManager.loadDrinkMenu();
			dataManager.loadPizzaMenu();
			dataManager.loadSidesMenu();
			dataManager.loadStandartStartMenu();
			dataManager.newOrder();
		} catch (Exception e) {
		}

		try {
			itemPanel.loadPizzaMenu();

		} catch (IOException e) {
			e.printStackTrace();
		}
		orderPanel.setDataManager(dataManager);

		setSize(800, 600);
		setTitle("Aber-Pizza");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		this.setLayout(new GridLayout(1, 1));
		this.add(itemPanel);
		this.add(orderPanel);
	}
}
