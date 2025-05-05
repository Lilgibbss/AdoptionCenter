package com.adoptioncenter.view;

import javax.swing.*;

import com.adoptioncenter.Pet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Swing based GUI for adopt me
 * displays the options of add, remove, adopt, save, and show details
 */
public class PetView extends JFrame {
	private JButton addButton = new JButton("Add");
	private JButton adoptButton = new JButton("Adopt");
	private JButton removeButton = new JButton("Remove");
	private JButton viewButton = new JButton("View details");
	private JButton saveButton = new JButton("Save");
	
	private JComboBox<String> sortCombo = new JComboBox<>(new String[] {"Name", "Age", "Species"});
	private DefaultListModel<Pet> petListModel = new DefaultListModel<>();
    private JList<Pet> petList = new JList<>(petListModel);
    
    //setting the buttons up as well as UI/UX
    public PetView() {
    	setTitle("Adopt Me");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(500,500);
    	setLayout(new BorderLayout());
    	
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.add(addButton);
        buttonPanel.add(adoptButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(sortCombo);
        
        add(new JScrollPane(petList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    /**
     * updates the pet list
     * 
     * @param pets the of pets to display
     */
    
    public void updatePetList(java.util.List<Pet> pets) {
    	petListModel.clear();
    	for(Pet pet : pets) {
    		petListModel.addElement(pet);
    	}
    }
    
    /**
     * returns the selected pet
     * @return the selection pet or null if non
     */
    public Pet getSelectedPet() {
    	return petList.getSelectedValue();
    }
    
    /**
     * returns the sorting option.
     * 
     * @return the sort catagory
     */
    public String getSelectedSort() {
    	return (String) sortCombo.getSelectedItem();
    }
    
    /**
     * adds action lister to dropdown
     * 
     * @param listener the actionListener attached 
     */
    public void addSortListener(ActionListener listener) {
        sortCombo.addActionListener(listener);
    }
    
    /**
     * Adds actionListener to all actions
     *@param listener the actionLister to attach
     * 
     */
    public void addButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
        adoptButton.addActionListener(listener);
        removeButton.addActionListener(listener);
        viewButton.addActionListener(listener);
        saveButton.addActionListener(listener);
    }
    
    	
}

