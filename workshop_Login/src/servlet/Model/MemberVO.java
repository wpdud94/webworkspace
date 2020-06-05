package servlet.Model;

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String addr;
	
	public MemberVO(String userid, String password, String name, String addr) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.addr = addr;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", name=" + name + ", addr=" + addr + "]";
	}
	
	

}
