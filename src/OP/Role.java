package OP;

public class Role {
	int MaRole;
	String TenRole;
	public int getMaRole() {
		return MaRole;
	}
	public void setMaRole(int maRole) {
		MaRole = maRole;
	}
	public String getTenRole() {
		return TenRole;
	}
	public void setTenRole(String tenRole) {
		TenRole = tenRole;
	}
	public Role(int maRole, String tenRole) {
		super();
		MaRole = maRole;
		TenRole = tenRole;
	}
	
}
