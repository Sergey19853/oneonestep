package edu.examples.java_classes.util;

import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.entity.Medicine;

public class MedicinesСonverter {
	
	public static Medicine toMedicines (String data) {
		Medicine medicine = new Medicine();

		String[] arrayMedicines = data.split(";");
		medicine.setId(arrayMedicines[0]);
		medicine.setNameMedicine(arrayMedicines[1]);
		medicine.setPharmacy(arrayMedicines[2]);
		medicine.setInstructions(arrayMedicines[3]);
		medicine.setAmount(Integer.parseInt(arrayMedicines[4]));
		medicine.setPrice(Double.parseDouble(arrayMedicines[5]));
		medicine.setCity(arrayMedicines[6]);
		
		return medicine;
	}

	public static List<String> medicinesToString(List<Medicine> data) {
		
		final String DELIMITER = ";";
		
		List<String> strNotes = new ArrayList<>();

		for (Medicine medicine: data){
			String strNote = medicine.getId() + DELIMITER + medicine.getNameMedicine() + DELIMITER + medicine.getPharmacy() + DELIMITER
					+ medicine.getInstructions() + DELIMITER + medicine.getAmount() + DELIMITER + medicine.getPrice() + DELIMITER + medicine.getCity() + DELIMITER + "\n";
			strNotes.add(strNote);
		}
		return strNotes;
	}
}
