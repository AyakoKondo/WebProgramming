package model;

import java.util.Date;

public class User {
	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;
	private String password2;
	
	
	public User() {
		
	}
	
	// ログインセッションを保存するためのコンストラクタ
	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}
	//ID検索用のコンストラクタ
	public User(String loginId) {
		this.loginId = loginId;
	}
	
	
	//新規登録のためのコンストラクタ
	public User(String loginId, String password,  String password2, String name, Date birthDate)
	//,String createDate,String updateDate) 
	{
		this.loginId = loginId;
		this.password = password;
		this.password2 = password2;
		this.name = name;
		this.birthDate = birthDate;
//		this.createDate = createDate;
//		this.updateDate = updateDate;		
	}
	
	//詳細参照用のコンストラクタ
	public User(String loginId,String name,Date birthDate,String createDate,String updateDate) {
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	//更新データ参照用のコンストラクタ
	public User(String id,String loginId,String name, Date birthDate) {
		this.id = Integer.parseInt(id);
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	
	// 全てのデータをセットするコンストラクタ
	public User(int id, String loginId, String name, Date birthDate, String password, String createDate,
			String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
	