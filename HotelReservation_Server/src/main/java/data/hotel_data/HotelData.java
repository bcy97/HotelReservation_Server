package data.hotel_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.database.DBConnection;
import dataDao.hotel.HotelDao;
import po.HotelPO;

public class HotelData implements HotelDao{

	public boolean hotelIDExist(String hotelID){
		Connection conn;
		Statement statement;
		String sql = "select * from hotel where hotelID='"+hotelID+"'";
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				statement.close();
				conn.close();
				
				return true;
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean addHotel(HotelPO po) {
		if (po.getHoteID()==null||po.getHotelName()==null||po.getCity()==null||po.getDistract()==null
				||po.getTradingArea()==null||po.getLocationOfHotel()==null
				||po.getFacilities()==null||po.getEmptyRoomNum()==null) {
			System.out.println("data.hotel_data.HotelData.addHotel参数错误");
			return false;
		}
		if (hotelIDExist(po.getHoteID())) {
			System.out.println("已存在该数据");
			return false;
		}
		Connection conn;
		Statement statement;
		String pictures;
		String empty;
		String sql = "insert into hotel values('" +
				po.getHoteID() + "','" + po.getHotelName() +"','"+po.getCity()+"','"+
				po.getDistract()+"','"+po.getTradingArea()+"','"+po.getLocationOfHotel()+"','"+
				po.getEvaluationGrades()+"','"+po.getLevelOfHotel()+"','"+po.getIntroduction()+"','"+
				po.getFacilities();
		//处理picture的ArrayList
		pictures = "";
		if (po.getPicturesPath()!=null) {
			for (String  picture : po.getPicturesPath()) {
				pictures+=picture+"###";
			}
			sql = sql+"','"+pictures+"','";
		}else {
			sql = sql+"',null,'";
		}
		//处理emptyRoomNum的map格式为"key1##value1###key2##value2###...key_n##value_n###"
		empty = "";
		HashMap<Integer, Integer> emptyRoom = po.getEmptyRoomNum();
		for(Map.Entry<Integer, Integer> entry:emptyRoom.entrySet()){
			empty+=entry.getKey()+"##"+entry.getValue()+"###";
		}
		sql = sql+empty;
		//处理bussiness以防为空
		if (po.getBussiness()!=null) {
			sql = sql+"','"+po.getBussiness()+"')";
		}else {
			sql = sql+"',null)";
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

	public boolean updateHotel(HotelPO po) {
		if (po.getHoteID()==null||po.getHotelName()==null||po.getCity()==null||po.getDistract()==null
				||po.getTradingArea()==null||po.getLocationOfHotel()==null
				||po.getFacilities()==null||po.getEmptyRoomNum()==null) {
			System.out.println("data.hotel_data.HotelData.updateHotel参数错误");
			return false;
		}
		if (!hotelIDExist(po.getHoteID())) {
			System.out.println("data.hotel_data.HotelData.updateHotel无待更新数据");
			return false;
		}
		//删除现有数据
		Connection conn;
		Statement statement;
		String sql = "delete from hotel where hotelID="+po.getHoteID();
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			statement.execute(sql);
			
			statement.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		//加入更新后的数据
		if (addHotel(po)) {
			return true;
		}
		
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		Connection conn;
		Statement statement;
		HotelPO hotel;
		String sql = "select * from hotel where hotelID='"+hotelID+"'";
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				hotel = new HotelPO(hotelID, null, null, null, null, null, 0, null, null, null, null, null);
				hotel.setHotelName(rs.getString("hotelName"));
				hotel.setCity(rs.getString("city"));
				hotel.setDistract(rs.getString("distract"));
				hotel.setTradingArea(rs.getString("tradingArea"));
				hotel.setLocationOfHotel(rs.getString("locationOfHotel"));
				hotel.setEvaluationGrades(rs.getDouble("evaluationGrades"));
				hotel.setLevelOfHotel(rs.getInt("levelOfHotel"));
				hotel.setIntroduction(rs.getString("introduction"));
				hotel.setFacilities(rs.getString("facilities"));
				hotel.setBussiness(rs.getString("bussiness"));
				
				//解析图片路径
				if (rs.getString("picturesPath")!=null) {
					String[] pictures = rs.getString("picturesPath").split("###");
					ArrayList<String> picturesPath = new ArrayList<String>();
					for (String string : pictures) {
						picturesPath.add(string);
					}
					hotel.setPicturesPath(picturesPath);
				}
				
				//解析空余房间
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				String[] emptyRooms = rs.getString("emptyRoomNum").split("###");
				for (String string : emptyRooms) {
					String[] temp = string.split("##");
					map.put(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
				}
				hotel.setEmptyRoomNum(map);
				
				statement.close();
				conn.close();
				
				return hotel;
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<String> getTradingAreas(String city) {
		Connection conn;
		Statement statement;
		ArrayList<String> tradingAreas;
		String sql = "select * from locations where city='"+city+"'";
		try {
			tradingAreas = new ArrayList<String>();
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
		
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				tradingAreas.add(rs.getString("tradingArea"));
			}
			statement.close();
			conn.close();
			return tradingAreas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String city,String tradingArea) {
		Connection conn;
		Statement statement;
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		String sql = "select * from hotel where city='"+city+"'and tradingArea='"+tradingArea+"'";
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				HotelPO hotel = new HotelPO(null, null, city, null, tradingArea, null, 0, null, null, null, null, null);
				hotel.setHoteID(rs.getString("hotelID"));
				hotel.setHotelName(rs.getString("hotelName"));
				hotel.setDistract(rs.getString("distract"));
				hotel.setLocationOfHotel(rs.getString("locationOfHotel"));
				hotel.setEvaluationGrades(rs.getDouble("evaluationGrades"));
				hotel.setLevelOfHotel(rs.getInt("levelOfHotel"));
				hotel.setIntroduction(rs.getString("introduction"));
				hotel.setFacilities(rs.getString("facilities"));
				hotel.setBussiness(rs.getString("bussiness"));
				
				//解析图片路径
				if (rs.getString("picturesPath")!=null) {
					String[] pictures = rs.getString("picturesPath").split("###");
					ArrayList<String> picturesPath = new ArrayList<String>();
					for (String string : pictures) {
						picturesPath.add(string);
					}
					hotel.setPicturesPath(picturesPath);
				}
				
				//解析空余房间
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				String[] emptyRooms = rs.getString("emptyRoomNum").split("###");
				for (String string : emptyRooms) {
					String[] temp = string.split("##");
					map.put(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
				}
				hotel.setEmptyRoomNum(map);
				
				
				hotelList.add(hotel);
			}
			statement.close();
			conn.close();
			
			return hotelList;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
