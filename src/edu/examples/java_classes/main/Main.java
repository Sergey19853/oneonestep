package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ALLMEDICINES\n";
		response = controller.doAction(request);
		System.out.println(response);
		
//		request = "ADD\nnameMedicine=Аспирин\npharmacy=Центральная аптека\ninstructions=от головы\namount=2\nprice=20.2\ncity=Минск";
//		response = controller.doAction(request);
//		System.out.println(response);

//		request = "FINDBYTEXT\nfind=Минск";
//		response = controller.doAction(request);
//		System.out.println(response);
		
//		request = "UPDATE\nid=1771fad7-e787-47b1-aab3-bd31b1e330cf\nnameMedicine=Аспирин\npharmacy=Центральная аптека\ninstructions=от головы\namount=2\nprice=20.2\ncity=Барановичи";
//		response = controller.doAction(request);
//		System.out.println(response);
		
//		request = "DELETEENTRY\nid=02651bcf-0060-4676-8cc3-7e917ba05b5b";
//		response = controller.doAction(request);
//		System.out.println(response);
		
//		request = "CLEAR\n";
//		response = controller.doAction(request);
//		System.out.println(response);
	}

}
