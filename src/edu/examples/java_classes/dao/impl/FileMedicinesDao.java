package edu.examples.java_classes.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.MedicinesDao;
import edu.examples.java_classes.entity.Medicine;
import edu.examples.java_classes.util.MedicinesСonverter;
import edu.examples.java_classes.util.ReaderWriterFilesUtil;

public class FileMedicinesDao implements MedicinesDao{
 
	private List<Medicine> medicinesList = new CopyOnWriteArrayList<>();
	
	@Override
	public void save(Medicine medicines) throws DaoException {

		medicinesList.add(medicines);
		writeMedicinesToFile();
		
	}

	@Override
	public void update(Medicine medicines) throws DaoException {
	
		medicinesList.removeIf(medicine -> medicine.getId().equals(medicines.getId()));
		medicinesList.add(medicines);
		writeMedicinesToFile();

	}
	
	@Override
	public List<Medicine> allMedicines() throws DaoException{

		medicinesList.clear();
		List<Medicine> medicines = readMedicineFromFile()
				.stream()
				.map(MedicinesСonverter::toMedicines)
				.collect(Collectors.toList());
			medicinesList.addAll(medicines);
			return medicinesList;
			
	}
	
	public void clearMedicines() throws DaoException{
		
		medicinesList.clear();
		writeMedicinesToFile();
		
	}

	public void deleteEntry(String id) throws DaoException{

		medicinesList.removeIf(medicine -> medicine.getId().equals(id));
		writeMedicinesToFile();
	}

	private List<String> readMedicineFromFile() throws DaoException{
		try {
			return ReaderWriterFilesUtil.importMedicines();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	private void writeMedicinesToFile() throws DaoException {
		try {
			ReaderWriterFilesUtil.export(MedicinesСonverter.medicinesToString(medicinesList));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}
	
}
