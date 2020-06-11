package patten.controller;

public class ControllerFactory {

	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("findMember")) {
			controller = new FindController();
		}
		
		return controller;
	}
	
	
}
