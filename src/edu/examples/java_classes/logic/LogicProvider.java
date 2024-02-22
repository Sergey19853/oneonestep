package edu.examples.java_classes.logic;

import edu.examples.java_classes.logic.impl.MedicinesLogicImpl;

public final class LogicProvider {
	private static final LogicProvider instance = new LogicProvider();
	
	private LogicProvider() {}
	
	private MedicinesLogic logic = new MedicinesLogicImpl();
	
	public MedicinesLogic getMedicinesLogic() {
		return logic;
	}
	
	public static LogicProvider getInstance() {
		return instance;
	}
}
