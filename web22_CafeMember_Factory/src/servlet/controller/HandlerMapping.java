package servlet.controller;

public class HandlerMapping {
	//싱글톤 
	private static HandlerMapping handler =new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find.do")) {
			controller=new FindController();
			System.out.println("FindController생성됨....find do...");
		}
		else if(command.equals("login.do")) {
			controller=new LoginController();
			System.out.println("LoginController생성됨....login do...");
		}
		else if(command.equals("logout.do")) {
			controller=new LogoutController();
			System.out.println("LogoutController생성됨....logout do...");
		}
		else if(command.equals("register.do")) {
			controller=new RegisterController();
			System.out.println("RegisterController생성됨....register do...");
		}
		else if(command.equals("update.do")) {
			controller=new UpdateController();
			System.out.println("UpdateController생성됨....update do...");
		}
		else if(command.equals("idcheck.do")) {
			controller=new IdCheckController();
			System.out.println("IdCheckController생성됨....idcheck do...");
		}
		
		return controller;
	}
}
