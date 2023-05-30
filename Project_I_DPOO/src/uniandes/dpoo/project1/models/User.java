package uniandes.dpoo.project1.models;

public class User {
	//Attributes
	private String username;
	private String password;
	private String user_type;
	//constructor
	public User (String username, String password, String user_type) {
		this.username = username;
		this.password = password;
		this.user_type = user_type;
	}
	//Getters
	public String getUserName() {
		return username;
	} //end getUserName
	public String getPassword() {
		return password;
	} //end getPasswword
	public String getUser_type() {
		return user_type;
	} //end getUser_type
}
