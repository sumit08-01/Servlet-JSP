package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	static PreparedStatement ps, ps1, ps2, ps3;
	static Connection conn = DbConnection.getConnection();
	static {
		try {
			ps = conn.prepareStatement("select * from usertable where username=? and password=?");
			ps1 = conn.prepareStatement("select * from training");
			ps2 = conn.prepareStatement("insert into training values(?,?,?,?,?,?,?)");
			ps3 = conn.prepareStatement("delete from training where trainingid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean deleteTraining(String tid) throws SQLException {
		ps3.setInt(1, Integer.parseInt(tid));
		int result = ps3.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean addTraining(String tid,String tna,String std,String ed,String tnm,String  bnut,String ctid) throws SQLException {
		ps2.setInt(1, Integer.parseInt(tid));
		ps2.setString(2, tna);
		ps2.setString(3, std);
		ps2.setString(4, ed);
		ps2.setString(5, tnm);
		ps2.setString(6, bnut);
		ps2.setInt(7, Integer.parseInt(ctid));
		int rs = ps2.executeUpdate();
		
		if(rs>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String loginMe(String username, String password) throws SQLException {
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getString("usertype");
		}else {
			return null;
		}
	}
	
	public static ArrayList<ArrayList<Object>> getTrainingList() throws SQLException {
		ResultSet rs = ps1.executeQuery();
		ArrayList<ArrayList<Object>> list = new ArrayList<>();
		while(rs.next()) {
			ArrayList<Object> obj=new ArrayList<>();
			Object trainingId = rs.getInt(1);
			Object TrainingName = rs.getString(2);
			Object Start_Date = rs.getString(3);
			Object EndDate = rs.getString(4);
			Object TrainingMode = rs.getString(5);
			Object BusinisessUnit = rs.getString(6);
			Object ContactpersonID = rs.getInt(7);
			
			obj.add(trainingId);
			obj.add(TrainingName);
			obj.add(Start_Date);
			obj.add(EndDate);
			obj.add(TrainingMode);
			obj.add(BusinisessUnit);
			obj.add(ContactpersonID);

			list.add(obj);
		}
		return list;
	}
}
