package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Drinks;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Sides;

/**
 * ItemPanel class which inherits from JPanel holds several arrayList, button
 * and List objects to show the different Menus and passing data on to the Order
 * and OrderPanel using the DataManager class and it methods
 * 
 * @author stk4
 * 
 */
@SuppressWarnings("serial")
public class ItemPanel extends JPanel {
	private JButton pizza, drinks, sides, add;
	private JList<String> itemMenu;
	private ArrayList<Pizza> pizzaMenu;
	private ArrayList<Sides> sidesMenu;
	private ArrayList<Drinks> drinksMenu;
	private LoadPizzaMenu loadPizzaMenu;
	private LoadDrinksMenu drinksListener;
	private LoadSidesMenu sidesListener;
	private AddItem addListener;
	private DataManager dataManager;
	private DefaultListModel<String> listModel;
	private JRadioButton large, medium, small;
	private String choosenMenu;
	private int choosen;
	private SizeButtonListener sbl;

	/**
	 * constructor of the ItemPanel class creates the JButtons, JRadioButtons
	 * and the JList and placed it on the Panel
	 */
	@SuppressWarnings("unchecked")
	public ItemPanel() {
		choosen = 0;
		choosenMenu = null;
		listModel = new DefaultListModel<String>();
		pizzaMenu = new ArrayList<Pizza>();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		pizza = new JButton("Pizza");
		pizza.addActionListener(loadPizzaMenu = new LoadPizzaMenu());
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(pizza, gbc);

		drinks = new JButton("drinks");
		drinks.addActionListener(drinksListener = new LoadDrinksMenu());
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(drinks, gbc);

		sides = new JButton("sides");
		sides.addActionListener(sidesListener = new LoadSidesMenu());
		gbc.gridx = 3;
		gbc.gridy = 1;
		add(sides, gbc);

		add = new JButton("add");
		add.addActionListener(addListener = new AddItem());
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		add(add, gbc);

		itemMenu = new JList<String>(listModel);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(itemMenu, gbc);
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		large = new JRadioButton("Large");
		gbc.gridx = 1;
		gbc.gridy = 2;
		large.addActionListener(sbl = new SizeButtonListener());
		add(large, gbc);

		medium = new JRadioButton("Medium");
		gbc.gridx = 2;
		gbc.gridy = 2;
		medium.addActionListener(sbl = new SizeButtonListener());
		add(medium, gbc);

		small = new JRadioButton("Small");
		gbc.gridx = 3;
		gbc.gridy = 2;
		small.addActionListener(sbl = new SizeButtonListener());
		add(small, gbc);

		ButtonGroup group = new ButtonGroup();
		group.add(large);
		group.add(medium);
		group.add(small);

		itemMenu.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		itemMenu.setVisibleRowCount(-1);
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
	 * selects the JRadioButton - Large and calls the loadPizzaMenu() method
	 * used for loading the LargePizza menu when the program starts/restarts
	 * 
	 * @throws IOException
	 */
	public void startupMenu() throws IOException {
		large.setSelected(true);
		loadPizzaMenu();
	}

	/**
	 * checks which JRadioButton is selected and loads the right pizzaMenu from
	 * the DataManager class accordingly and updates the JList to it
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void loadPizzaMenu() throws IOException {
		String temporaryPizza = null;
		listModel.clear();

		for (int i = 0; i < dataManager.PizzaArraySize(); i++) {
			if (large.isSelected() == true) {
				pizzaMenu.clear();
				pizzaMenu = dataManager.getlargePizza();
				choosenMenu = "large";
				temporaryPizza = pizzaMenu.get(i).getDecription() + " - "
						+ pizzaMenu.get(i).getLargePrice() + " £";
				listModel.addElement(temporaryPizza);
			} else if (medium.isSelected() == true) {
				pizzaMenu.clear();
				pizzaMenu = dataManager.getmediumPizza();
				choosenMenu = "medium";
				temporaryPizza = pizzaMenu.get(i).getDecription() + " - "
						+ pizzaMenu.get(i).getMediumPrice() + " £";
				listModel.addElement(temporaryPizza);
			} else if (small.isSelected() == true) {
				pizzaMenu.clear();
				pizzaMenu = dataManager.getSmallPizza();
				choosenMenu = "small";
				temporaryPizza = pizzaMenu.get(i).getDecription() + " - "
						+ pizzaMenu.get(i).getSmallPrice() + " £";
				listModel.addElement(temporaryPizza);
			}
		}
	}

	/**
	 * loads the sideMenu from the DataManager class and updates the JList to it
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void loadSideMenu() throws IOException {
		String temporarySide = null;
		listModel.clear();
		sidesMenu = new ArrayList<Sides>();
		sidesMenu = dataManager.getSidesArray();
		choosenMenu = "side";
		for (int i = 0; i < sidesMenu.size(); i++) {
			temporarySide = sidesMenu.get(i).getDecription() + " - "
					+ sidesMenu.get(i).getPrice() + " £";
			listModel.addElement(temporarySide);
		}
	}

	/**
	 * loads the drinkMenu from the DataManager class and updates the JList to
	 * it
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void loadDrinkMenu() throws IOException {
		String temporaryDrink = null;
		listModel.clear();
		drinksMenu = new ArrayList<Drinks>();
		drinksMenu = dataManager.getDrinkArray();
		choosenMenu = "drink";
		for (int i = 0; i < drinksMenu.size(); i++) {
			temporaryDrink = drinksMenu.get(i).getDecription() + " - "
					+ drinksMenu.get(i).getPrice() + " £";
			listModel.addElement(temporaryDrink);
		}
	}

	/**
	 * @return choosenMenu - String
	 */
	public String getChoosenMenu() {
		return choosenMenu;
	}

	/**
	 * set the choosenMenu
	 * 
	 * @param choosenMenu
	 *            - String
	 */
	public void setChoosenMenu(String choosenMenu) {
		this.choosenMenu = choosenMenu;
	}

	/**
	 * @return choosen - int
	 */
	public int getChoosen() {
		return choosen;
	}

	/**
	 * @param choosen
	 *            - int
	 */
	public void setChoosen(int choosen) {
		this.choosen = choosen;
	}

	/**
	 * inner class which implements ActionListener reacts when the "Pizza"
	 * button is pressed calls the loadPizzaMenu() method
	 * 
	 * @author stk4
	 * 
	 */
	class LoadPizzaMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				loadPizzaMenu();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * inner class which implements ActionListener reacts when the "Drink"
	 * button is pressed calls the loadDrinkMenu() method
	 * 
	 * @author stk4
	 * 
	 */
	class LoadDrinksMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				loadDrinkMenu();
			} catch (IOException ei) {
				ei.printStackTrace();
			}
		}
	}

	/**
	 * inner class which implements ActionListener reacts when the "Sides"
	 * button is pressed calls the loadSidesMeny() method
	 * 
	 * @author stk4
	 * 
	 */
	class LoadSidesMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				loadSideMenu();
			} catch (IOException ei) {
				ei.printStackTrace();
			}
		}
	}

	/**
	 * inner class that implements ActionListener reacts when the "Add" button
	 * is pressed pass data about the selected object to the DataManager class
	 * 
	 * @author stk4
	 * 
	 */
	class AddItem implements ActionListener {
		String order;

		@Override
		public void actionPerformed(ActionEvent e) {
			order = (String) itemMenu.getSelectedValue();
			int i = itemMenu.getSelectedIndex();

			if (order == null) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
						"Please choose an Item first");
				return;
			}

			if (choosenMenu == "large") {
				choosen = itemMenu.getSelectedIndex();
				try {
					dataManager.addOrder(choosen, 1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (choosenMenu == "medium") {
				choosen = itemMenu.getSelectedIndex();
				try {
					dataManager.addOrder(choosen, 1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (choosenMenu == "small") {
				choosen = itemMenu.getSelectedIndex();
				try {
					dataManager.addOrder(choosen, 1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (choosenMenu == "side") {
				choosen = itemMenu.getSelectedIndex();
				try {
					dataManager.addOrder(choosen, 1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (choosenMenu == "drink") {
				choosen = itemMenu.getSelectedIndex();
				try {
					dataManager.addOrder(choosen, 1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * inner class which implements ActionListener reacts to changes on the
	 * JRadioButtons
	 * 
	 * @author stk4
	 * 
	 */
	class SizeButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (large.isSelected()) {
				try {
					loadPizzaMenu();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (medium.isSelected()) {
				try {
					loadPizzaMenu();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (small.isSelected()) {
				try {
					loadPizzaMenu();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}