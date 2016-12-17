package data.user_data;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.database.DBConnection;
import dataDao.user.ClientDao;
import po.ClientPO;

public class ClientData implements ClientDao{

	public boolean addClient(ClientPO po) {
		Connection conn;
		Statement statement;
		String sql = "";
		if (po.getVipType()!=0) {
			sql = "insert into client values('" 
					+po.getUserID() + "','" + po.getPhoneNumber() +"','"+po.getTrueName()+"','"+po.getIdentityID()
					+"','"+po.getVipType()+"','"+po.getVipLevel()+"','"+po.getVipInfo()+"')";		
		}else {
			sql = "insert into client values('" 
					+po.getUserID() + "','" + po.getPhoneNumber() +"','"+po.getTrueName()+"','"+po.getIdentityID()
					+"',0,0,null)";		
		}
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public ClientPO getClientInfo(String clientID) {
		Connection conn;
		Statement statement;
		ClientPO clientPO;
		String sql = "select * from client where userID='"+clientID+"'";
		
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				clientPO = new ClientPO(null, null, null, null,  0, 0, null);
				clientPO.setUserID(rs.getString("userID"));
				clientPO.setPhoneNumber(rs.getString("phoneNumber"));
				clientPO.setTrueName(rs.getString("trueName"));
				clientPO.setIdentityID(rs.getString("identityID"));
				clientPO.setVipType(rs.getInt("vipType"));
				clientPO.setVipLevel(rs.getInt("vipLevel"));
				clientPO.setVipInfo(rs.getString("vipInfo"));
				
				statement.close();
				conn.close();
				
				return clientPO;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean updateClientInfo(ClientPO clientPO) {
		Connection conn;
		Statement statement;
		String sql = "delete from client where userID='"+clientPO.getUserID()+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			addClient(clientPO);
			
			statement.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
