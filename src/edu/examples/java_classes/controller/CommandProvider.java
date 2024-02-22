package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;

import edu.examples.java_classes.controller.impl.AddMedicinesCommand;
import edu.examples.java_classes.controller.impl.AllMedicinesCommand;
import edu.examples.java_classes.controller.impl.ClearMedicinesCommand;
import edu.examples.java_classes.controller.impl.DeleteEntryMedicinesCommand;
import edu.examples.java_classes.controller.impl.FindByTextNoteCommand;
import edu.examples.java_classes.controller.impl.NoSuchCommand;
import edu.examples.java_classes.controller.impl.UpdateMedicinesCommand;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.ADD, new AddMedicinesCommand());
		repository.put(CommandName.UPDATE, new UpdateMedicinesCommand());
		repository.put(CommandName.CLEAR, new ClearMedicinesCommand());
		repository.put(CommandName.DELETEENTRY, new DeleteEntryMedicinesCommand());
		repository.put(CommandName.FINDBYTEXT, new FindByTextNoteCommand());
		repository.put(CommandName.ALLMEDICINES, new AllMedicinesCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}
	
	Command getCommand(String name){
		CommandName commandName =null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}
}
