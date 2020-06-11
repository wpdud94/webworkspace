package pattern.controller;

public class ControllerFactory {
	private static ControllerFactory cf = new ControllerFactory();
	private ControllerFactory() {
		
	}
	public static ControllerFactory getInstance() {
		return cf;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("findModel")) {
			controller = new FindController();
		}
		
		return controller;
	}
}
