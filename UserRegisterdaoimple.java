package com.mydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mydata.model.UserRegister;
import com.mydata.util.CreateConnection;

public class UserRegisterdaoimple implements UserRegisterdao {
	Connection con = CreateConnection.initConnection();

	public int saveuser(UserRegister u) {

		int x = 0;

		try {

			PreparedStatement ps = con.prepareStatement("insert into user value(?,?,?,?,?)");

			ps.setString(1, u.getName());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPhone());

			x = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

}
