package com.mydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mydata.model.UserLogin;
import com.mydata.util.CreateConnection;

public class UserLogindaoimple implements UserLogindao {
	Connection con = CreateConnection.initConnection();

	public String validuser(UserLogin ul) {

		String res = null;

		String entuser = ul.getUsername();
		String entpass = ul.getPassword();
		String dbpass = null;

		try {
			PreparedStatement ps = con.prepareStatement("select password from user where username=?");
			ps.setString(1, entuser);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dbpass = rs.getString("password");

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (entpass.equals(dbpass)) {
			res = "valid";
		} else {
			res = "invalid";
		}
		return res;
	}

}
