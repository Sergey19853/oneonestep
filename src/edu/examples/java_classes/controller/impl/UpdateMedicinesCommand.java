package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Medicine;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.MedicinesLogic;

public class UpdateMedicinesCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final MedicinesLogic logic = logicProvider.getMedicinesLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Medicine newMedicines;

		params = request.split("\n");
		newMedicines = new Medicine();

		newMedicines.setId(params[1].split("=")[1]);
		newMedicines.setNameMedicine(params[2].split("=")[1]);
		newMedicines.setPharmacy(params[3].split("=")[1]);
		newMedicines.setInstructions(params[4].split("=")[1]);
		newMedicines.setAmount(Integer.parseInt(params[5].split("=")[1]));
		newMedicines.setPrice(Double.parseDouble(params[6].split("=")[1]));
		newMedicines.setCity(params[7].split("=")[1]);
			
		try {
			logic.updateEntry(newMedicines);
			response = "Запись обновлена успешно.";
		} catch(LogicException e) {
			response = "Ошибка обновления записи.";
		}
		
		return response;
	}

}
