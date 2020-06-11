package pattern.client;

import pattern.action.Action;
import pattern.factory.ActionFactory;

/*
Factory Method Pattern
::
1) 첫 번째 Dispatcher로서 역할
(제일 중요)뭘 주고 뭘 받냐: Command 주고 인터페이스로 받음
- 실체는 구상객체이지만 소통은 인터페이스로 함

추상화된 클래스(Action)의 객체(구상객체, 실체 클래스)를 생성하고 반환받는 방법
구상객체를 실질적으로 생성하는 곳은 싱글톤으로 Factory에서 진행된다
이때 인자값으로 넘겨져 오는 Command값에 따라서 서로 다른 구상객체가 만들어진다.
하지마 정작 사용자(Server side에서의 클라이언트=DispatcherServlet)에게는 구상객체명이 hiding되어져서 넘겨진다.
-->  추상화된 클래스(Action)로 날라간다

--> 결국 클라이언트는 Factory로 하여 구상객체를 만들도록 요청
	Factory는 요청에 해당하는 제품을 만들고 Interfacefh 전달

2) 두 번째 Dispatcher로서 역할
(제일 중요)뭘 주고 뭘 받냐: execute()를 주고 path를 받음

인터페이스의 메소드를 호출하면 실질적으로 생성된 구상객체가 드디어 핵심적인 일을 진행한다.
최종적으로 View의 화면 경로를 리턴받는다.

3) 네비게이션(forward, sendRedirect)

 */
public class DispatcherMainTest {

	public static void main(String[] args) {
		String command="INSERT";
		
		
		//1.
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.createAction(command);
		
		//2.
		action.execute();
		

	}

}
