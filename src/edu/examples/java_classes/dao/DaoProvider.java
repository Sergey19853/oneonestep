package edu.examples.java_classes.dao;

import edu.examples.java_classes.dao.impl.FileMedicinesDao;

public final class DaoProvider {
	private static final DaoProvider INSTANCE = new DaoProvider();
	
	private DaoProvider() {}
	
	private MedicinesDao medicinesDao = new FileMedicinesDao();
	
	
	public MedicinesDao getMedicinesDao() {
		return medicinesDao;
	}

	public static DaoProvider getInstance() {
		return INSTANCE;
	}
	

}
