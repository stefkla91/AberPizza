package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 * OrderPanel class which inherits from JPanel holds an JList, JTextField,
 * Button and ArrayList to processing the "basket"
 * 
 * @author stk4
 * 
 */
public class OrderPanel extends JPanel {
	private JList orderList;
	private DefaultListModel<String> listModel;
	private DataManager dataManager;
	private JButton pay;
	private PayButtonListener payListener;
	private JTextField customer;
	private JFrame frame;
	private boolean isEmpty;

	/**
	 * Constructor of the OrderPanel class creates an JTextField, JList and a
	 * button and placed it using an GridBagLayout Initializes a boolean value
	 * and an arrayList<String>
	 */
	public OrderPanel() {
		isEmpty = true;
		listModel = new DefaultListModel();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		customer = new JTextField();
		customer.setText("Customer Name");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(customer, gbc);

		orderList = new JList(listModel);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(orderList, gbc);
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		pay = new JButton("pay");
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(pay, gbc);
		pay.addActionListener(payListener = new PayButtonListener());
	}

	/**
	 * adds the passed in String to the listModel which by that updates the
	 * JList
	 * 
	 * @param item
	 *            - String
	 */
	public void addItem(String item) {
		listModel.addElement(item);
		isEmpty = false;
	}

	/**
	 * clears the customer JTextField and put in the standard message
	 * "Customer Name" also resets isEmpty to true
	 */
	public void clearCustomerName() {
		customer.setText("Customer Name");
		isEmpty = true;
	}

	/**
	 * returns the DataManager for this class
	 * 
	 * @return dataManger - DataManager
	 */
	public DataManager getDataManager() {
		return dataManager;
	}

	/**
	 * set's the DataManager for this class
	 * 
	 * @param dataManager
	 *            - DataManager
	 */
	public void setDataManager(DataManager dataManager) {
		this.dataManager = dataManager;
	}

	/**
	 * clears the listModel and by that clears the JList
	 */
	public void clear() {
		listModel.clear();
	}

	/**
	 * inner class which implements ActionListener reacts when the "Pay" button
	 * gets clicked creates frames which MessageDialogs when certain
	 * requirements are not fulfilled like the Customer name has not been sat
	 * 
	 * @author stk4
	 * 
	 */
	class PayButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (customer.getText().equals("Customer Name")
					|| "".equals(customer.getText())) {
				frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Please enter a Name");
				return;
			}
			if (isEmpty == true) {
				frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Order is empty");
				return;
			}
			dataManager.setCustomerName(customer.getText());
			try {
				dataManager.saveTill();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			dataManager.newOrder();
			customer.setText("Customer Name");
			listModel.clear();
			try {
				dataManager.loadStandartStartMenu();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
