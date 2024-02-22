package edu.examples.java_classes.dao;

import java.util.List;
import edu.examples.java_classes.entity.Medicine;

public interface MedicinesDao {
	void save(Medicine n) throws DaoException;

	void update(Medicine n) throws DaoException;

	List<Medicine> allMedicines() throws DaoException;

	void clearMedicines() throws DaoException;

	void deleteEntry(String id) throws DaoException;
}
