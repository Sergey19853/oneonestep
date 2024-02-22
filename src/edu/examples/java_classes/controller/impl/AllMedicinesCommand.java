package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.MedicinesLogic;

public class AllMedicinesCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final MedicinesLogic logic = logicProvider.getMedicinesLogic();

	@Override
	public String execute(String request) {
		String response = null;

		try {
			response = "Вывод записей" + logic.allMedicines();
		} catch (LogicException e) {
			response = "Ошибка вывода записей";
		}
		
		return response;
	}

}
