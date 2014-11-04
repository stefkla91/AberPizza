package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Menu class which creates the Menu for the MainFrame
 * 
 * @author stk4
 * 
 */
public class Menu {
	private DataManager dataManager;
	private NewTillListener newTillListener;
	private Quit quit;

	/**
	 * Constructor of the Menu class. creates a JMenuBar and a couple of JMenu
	 * and JMenuItem
	 * 
	 * @param f
	 */
	public Menu(MainFrame f) {
		JMenuBar menubar = new JMenuBar();
		f.setJMenuBar(menubar);

		// setting the menus.
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenu admin = new JMenu("ADMIN");
		menubar.add(admin);

		// editing the menus
		JMenuItem newTill = new JMenuItem("New Till");
		file.add(newTill);
		newTill.addActionListener(newTillListener = new NewTillListener());

		JMenuItem close = new JMenuItem("Close");
		admin.add(close);
		close.addActionListener(quit = new Quit());
	}

	/**
	 * @return dataManager - DataManager
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
	 * inner class which implements ActionListener reacts when the newTill
	 * object get clicked in the Menu calls newOrder() method in DataManger
	 * class
	 * 
	 * @author stk4
	 * 
	 */
	class NewTillListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dataManager.newOrder();
		}
	}

	/**
	 * inner class which implements ActionListener reacts when the close object
	 * get clicked in the Menu Terminates the program
	 * 
	 * @author stk4
	 * 
	 */
	class Quit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
