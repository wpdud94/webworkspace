package pattern.action;
/*
AddAction:: 캄포넌트

인터페이스 기반으로 작성된 재사용성이 강한 자바클래스
 */
public class UpdateAction implements Action{

	@Override
	public void execute() {
		//1. 폼값 받기
		//2. DAO리넡
		//3. BIZ호출
		//4. 리턴값 바인딩
		//5. path 최종적으로 리턴
		update();
	}
	
	public void update() {
		// 위의 로직들이 수행됐다고 치고...
		System.out.println("update OK!!");
	}

}
