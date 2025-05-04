package com.adoptioncenter.view;

import javax.swing.*;

import com.adoptioncenter.Pet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetView extends JFrame {
	private JButton addButton = new JButton("Add");
	private JButton adoptButton = new JButton("Adopt");
	private JButton removeButton = new JButton("Remove");
	private JButton viewButton = new JButton("View details");
	private JButton saveButton = new JButton("Save");
	
	private JComboBox<String> sortCombo = new JComboBox<>(new String[] {"Name", "Age", "Species"});
	private DefaultListModel<Pet> petListModel = new DefaultListModel<>();
    private JList<Pet> petList = new JList<>(petListModel);
    
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
    public void updatePetList(java.util.List<Pet> pets) {
    	petListModel.clear();
    	for(Pet pet : pets) {
    		petListModel.addElement(pet);
    	}
    }
    
    public Pet getSelectedPet() {
    	return petList.getSelectedValue();
    }
    
    public String getSelectedSort() {
    	return (String) sortCombo.getSelectedItem();
    }
    
    public void addSortListener(ActionListener listener) {
        sortCombo.addActionListener(listener);
    }

    public void addButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
        adoptButton.addActionListener(listener);
        removeButton.addActionListener(listener);
        viewButton.addActionListener(listener);
        saveButton.addActionListener(listener);
    }
    	
}

