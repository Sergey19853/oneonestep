package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.MedicinesDao;
import edu.examples.java_classes.entity.Medicine;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.MedicinesLogic;

public class MedicinesLogicImpl implements MedicinesLogic {
	private final DaoProvider provider = DaoProvider.getInstance();
	private final MedicinesDao dao = provider.getMedicinesDao();
	
	@Override
	public void add(Medicine medicines) throws LogicException{
		try {
			dao.save(medicines);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	@Override
	public void add(String nameMedicine, String pharmacy, String instructions, Integer amount, Double price, String city) throws LogicException{
		Medicine medicines = new Medicine(nameMedicine, pharmacy, instructions, amount, price, city);
		try {
			dao.save(medicines);
		} catch (DaoException e) {
			throw new LogicException(e);
		}	
	}

	@Override
	public void clear() throws LogicException {
		try {
			dao.clearMedicines();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void updateEntry(Medicine medicines) throws LogicException {
		try {
			dao.update(medicines);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void deleteEntry(String id) throws LogicException{
		try {
			dao.deleteEntry(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	@Override
	public List<Medicine> find(String text) throws LogicException{
		
		List<Medicine> result = new ArrayList<Medicine>();
		
		List<Medicine> myMedicines;
		try {
			myMedicines = dao.allMedicines();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		for(Medicine n : myMedicines) {
			if(isTextInNote(n, text)) {
				result.add(n);
			}
		}
		
		return result;

	}
	
	@Override
	public List<Medicine> allMedicines() throws LogicException{
		try {
			return dao.allMedicines();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	private boolean isTextInNote(Medicine medicines, String text) throws LogicException{
		return medicines.getNameMedicine().contains(text) || medicines.getPharmacy().contains(text) || medicines.getCity().contains(text) || medicines.getInstructions().contains(text);
	}
	
}
