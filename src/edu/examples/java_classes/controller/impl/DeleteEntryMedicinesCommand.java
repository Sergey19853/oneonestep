package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.MedicinesLogic;

public class DeleteEntryMedicinesCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final MedicinesLogic logic = logicProvider.getMedicinesLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		String id;

		params = request.split("\n");
		id = params[1].split("=")[1];

		try {
			logic.deleteEntry(id);
			response = "Запись удалена успешно.";
		} catch (LogicException e) {
			response = "Ошибка удаления записи.";
		}
		
		return response;
	}
	
}
