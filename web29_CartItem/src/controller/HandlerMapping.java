package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("itemList.do")) {
			controller = new ItemListController();
			System.out.println("itemListController 생성");
		}else if(command.equals("itemInfo.do")) {
			controller = new ItemInfoController();
			System.out.println("ItemInfoController 생성");
		}
		return controller;
	}
}
