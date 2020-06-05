package servlet.model;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String addr;
	
	public MemberVO() {}
	public MemberVO(String id, String password, String name, String addr) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", addr=" + addr + "]";
	}
}
