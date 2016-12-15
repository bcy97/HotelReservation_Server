package data.promotion_data;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import data.database.DBConnection;
import dataDao.promotion.PromotionDao;
import po.PromotionPO;

public class PromotionData implements PromotionDao{

	public ArrayList<PromotionPO> getHotelPromotions(String hotelID, int promotionType) {
		
		String sql="select * from promotion where hotelID='"+hotelID+"' and promotionType='"+promotionType+"'";
		
		return getPromotions(sql);
		
	}

	public ArrayList<PromotionPO> getWebPromotions(int promotionType) {
		
		String sql = "select * from promotion where promotionType='"+promotionType+"'";
		
		return getPromotions(sql);
	}

	public PromotionPO getPromotion(String promotionID) {
		PromotionPO promotionPO;
		Statement statement;
		Connection conn;
		String sql="select * from promotion where promotionID='"+promotionID+"'";
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				promotionPO = new PromotionPO(0, null, null, null, 0, null, null, null, null, null, null);
				promotionPO.setPromotionType(rs.getInt("promotionType"));
				promotionPO.setPromotionID(rs.getString("promotionID"));
				promotionPO.setPromotionName(rs.getString("promotionName"));
				promotionPO.setDiscount(rs.getDouble("discount"));
				promotionPO.setStartTime(rs.getString("startTime"));
				promotionPO.setEndTime(rs.getString("endTime"));
				promotionPO.setCooperateBusiness(rs.getString("cooperateBusiness"));
				
				//解析roomsAndDiscount数组
				if (rs.getString("roomsAndDiscount")!=null) {
					String[] discounts = rs.getString("roomsAndDiscount").split("###");
					double[] roomsAndDiscount = new double[discounts.length];
					for (int i =0 ; i<discounts.length ; i++) {
						roomsAndDiscount[i] = Double.parseDouble(discounts[i]);
					}
					promotionPO.setRoomsAndDiscount(roomsAndDiscount);
				}else {
					promotionPO.setRoomsAndDiscount(null);
				}
				
				//处理vipTradeAreaDiscount的map
				HashMap<String, double[]> vipTradeAreaDiscount;
				if (rs.getString("vipTradeAreaDiscount")!=null) {
					vipTradeAreaDiscount = new HashMap<String, double[]>();
					String[] strings = rs.getString("vipTradeAreaDiscount").split("###");
					for (String string : strings) {
						String[] temp = string.split("##");
						String[] discount = temp[1].split("&");
						double[] discounts = new double[discount.length];
						for (int i =0 ; i<discounts.length ; i++) {
							discounts[i] = Double.parseDouble(discount[i]);
						}
						vipTradeAreaDiscount.put(temp[0], discounts);
					}
					promotionPO.setVipTradeAreaDiscount(vipTradeAreaDiscount);
				}
				
				//处理vipLevelDiscount的数组
				double[] vipLevelDiscount;
				if (rs.getString("vipLevelDiscount")!=null) {
					String[] temp = rs.getString("vipLevelDiscount").split("###");
					vipLevelDiscount = new double[temp.length];
					for (int i =0 ; i<temp.length ; i++) {
						vipLevelDiscount[i] = Double.parseDouble(temp[i]);
					}
					promotionPO.setVipLevelDiscount(vipLevelDiscount);
				}
				
				statement.close();
				conn.close();
				
				return promotionPO;
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean addPromotion(PromotionPO promotionPO) {
		if (promotionPO==null||promotionPO.getPromotionID()==""||promotionPO.getPromotionID()==null) {
			System.out.println("data.promotion_data.PromotionData.updatePromotion参数错误");
			return false;
		}
		if (getPromotion(promotionPO.getPromotionID())!=null) {
			System.out.println("已存在该数据");
			return false;
		}
		
		String sql = "insert into promotion values('"+promotionPO.getPromotionType()+"','"+promotionPO.getPromotionID()+"',";
		
		//判断hotelID是否为空
		if (promotionPO.getHotelID()==null) {
			sql = sql+"null,";
		}else {
			sql = sql +"'"+promotionPO.getHotelID()+"',";
		}
		
		sql = sql+"'"+promotionPO.getPromotionName()+"','"+promotionPO.getDiscount()+"','"+promotionPO.getStartTime()+"','"
				+promotionPO.getEndTime()+"',";
		
		//判断cooperateBusiness是否为空
		if (promotionPO.getCooperateBusiness()==null) {
			sql = sql+"null,";
		}else {
			sql = sql+"'"+promotionPO.getCooperateBusiness()+"',";
		}
		
		//处理roomsAndDiscount的数组
		if (promotionPO.getRoomsAndDiscount()==null) {
			sql = sql+"null,";
		}else {
			String roomsAndDiscount = "";
			for (double discount : promotionPO.getRoomsAndDiscount()) {
				roomsAndDiscount = roomsAndDiscount+discount+"###";
			}
			sql = sql+"'"+roomsAndDiscount+"',";
		}
		
		//处理vipTradeAreaDiscount的Map
		if (promotionPO.getVipTradeAreaDiscount()==null) {
			sql = sql+"null,";
		}else {
			String vipTradeAreaDiscount = "";
			Iterator<Entry<String, double[]>> iterator = promotionPO.getVipTradeAreaDiscount().entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, double[]> entry = (Entry<String, double[]>) iterator.next();
				double[] discouts = entry.getValue();
				String discount = "";
				for (double d : discouts) {
					discount = discount+d+"&";
				}
				vipTradeAreaDiscount=vipTradeAreaDiscount+entry.getKey()+"##"+discount+"###";
			}
			sql = sql+"'"+vipTradeAreaDiscount+"',";
		}
		
		//处理vipLevelDiscount的数组
		if (promotionPO.getVipLevelDiscount()==null) {
			sql = sql+"null)";
		}else {
			String vipLevelDiscount="";
			for (double d : promotionPO.getVipLevelDiscount()) {
				vipLevelDiscount = vipLevelDiscount+d+"###";
			}
			sql = sql+"'"+vipLevelDiscount+"')";
		}
		//获得完整sql指令

		Connection conn;
		Statement statement;
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			statement.executeUpdate(sql);
			
			statement.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	public boolean updatePromotion(PromotionPO promotionPO) {
		if (promotionPO==null||promotionPO.getPromotionID()==""||promotionPO.getPromotionID()==null) {
			System.out.println("data.promotion_data.PromotionData.updatePromotion参数错误");
			return false;
		}
		if (getPromotion(promotionPO.getPromotionID())==null) {
			System.out.println("不存在该数据");
			return false;
		}
		
		//删除现有数据
		Connection conn;
		Statement statement;
		String sql = "delete from promotion where promotionID="+promotionPO.getPromotionID();
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
		if (addPromotion(promotionPO)) {
			return true;
		}
		
		return false;
	}

	private ArrayList<PromotionPO> getPromotions(String sql){
		ArrayList<PromotionPO> promotionPOs;
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			promotionPOs = new ArrayList<PromotionPO>();
			
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				PromotionPO promotionPO = new PromotionPO(0, null, null, null, 0, null, null, null, null, null, null);
				promotionPO.setPromotionType(rs.getInt("promotionType"));
				promotionPO.setPromotionID(rs.getString("promotionID"));
				promotionPO.setPromotionName(rs.getString("promotionName"));
				promotionPO.setDiscount(rs.getDouble("discount"));
				promotionPO.setStartTime(rs.getString("startTime"));
				promotionPO.setEndTime(rs.getString("endTime"));
				promotionPO.setCooperateBusiness(rs.getString("cooperateBusiness"));
				
				//解析roomsAndDiscount数组
				if (rs.getString("roomsAndDiscount")!=null) {
					String[] discounts = rs.getString("roomsAndDiscount").split("###");
					double[] roomsAndDiscount = new double[discounts.length];
					for (int i =0 ; i<discounts.length ; i++) {
						roomsAndDiscount[i] = Double.parseDouble(discounts[i]);
					}
					promotionPO.setRoomsAndDiscount(roomsAndDiscount);
				}else {
					promotionPO.setRoomsAndDiscount(null);
				}
				
				//处理vipTradeAreaDiscount的map
				HashMap<String, double[]> vipTradeAreaDiscount;
				if (rs.getString("vipTradeAreaDiscount")!=null) {
					vipTradeAreaDiscount = new HashMap<String, double[]>();
					String[] strings = rs.getString("vipTradeAreaDiscount").split("###");
					for (String string : strings) {
						String[] temp = string.split("##");
						String[] discount = temp[1].split("&");
						double[] discounts = new double[discount.length];
						for (int i =0 ; i<discounts.length ; i++) {
							discounts[i] = Double.parseDouble(discount[i]);
						}
						vipTradeAreaDiscount.put(temp[0], discounts);
					}
					promotionPO.setVipTradeAreaDiscount(vipTradeAreaDiscount);
				}
				
				//处理vipLevelDiscount的数组
				double[] vipLevelDiscount;
				if (rs.getString("vipLevelDiscount")!=null) {
					String[] temp = rs.getString("vipLevelDiscount").split("###");
					vipLevelDiscount = new double[temp.length];
					for (int i =0 ; i<temp.length ; i++) {
						vipLevelDiscount[i] = Double.parseDouble(temp[i]);
					}
					promotionPO.setVipLevelDiscount(vipLevelDiscount);
				}
				
				promotionPOs.add(promotionPO);
				
			}
			statement.close();
			conn.close();
			
			return promotionPOs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int getPromotinoNum(){
		String sql = "select count(*) from promotion";
		Connection conn;
		Statement statement;
		try {
			int count=0;
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
			statement.close();
			conn.close();
			return count;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}
	
}
