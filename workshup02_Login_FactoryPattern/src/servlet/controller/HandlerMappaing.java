package servlet.controller;

public class HandlerMappaing {
	//싱글톤
	private static HandlerMappaing handler = new HandlerMappaing();
	private HandlerMappaing() {}
	public static HandlerMappaing getInstance() {
		return handler;
	}
	
	
}
