package edu.examples.java_classes.logic;

import java.util.List;

import edu.examples.java_classes.entity.Medicine;

public interface MedicinesLogic {

	public void add(Medicine medicines) throws LogicException;

	public void add(String nameMedicine, String pharmacy, String instructions, Integer amount, Double price, String city) throws LogicException;

	public void clear() throws LogicException;

	public void updateEntry(Medicine medicines) throws LogicException;

	public void deleteEntry(String id) throws LogicException;
	
	public List<Medicine> find(String text) throws LogicException;

	public List<Medicine> allMedicines() throws LogicException;
}
