package com.aaa.vo;

public class User{

 private int uid;

 private String username;

 private String password;

 private String email;

 private String telephone;

 public User() {

}
 
 public User (int uid, String username, String password, String email, String telephone) {
this.uid = uid;
this.username = username;
this.password = password;
this.email = email;
this.telephone = telephone;
}
 public void setUid(int uid) {
	    this.uid = uid;
 }

 public int getUid() {
		return uid;
}

 public void setUsername(String username) {
	    this.username = username;
 }

 public String getUsername() {
		return username;
}

 public void setPassword(String password) {
	    this.password = password;
 }

 public String getPassword() {
		return password;
}

 public void setEmail(String email) {
	    this.email = email;
 }

 public String getEmail() {
		return email;
}

 public void setTelephone(String telephone) {
	    this.telephone = telephone;
 }

 public String getTelephone() {
		return telephone;
}

 public String toString() {
 return "User [uid=" + uid + ", username=" + username + ", password=" + password + 
", email=" + email + ", telephone=" + telephone + "]";
}
}
