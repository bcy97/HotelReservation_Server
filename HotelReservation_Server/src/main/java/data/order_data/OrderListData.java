package data.order_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.database.DBConnection;
import dataDao.order.OrderListDao;
import po.OrderPO;

public class OrderListData implements OrderListDao{

	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		String sql = "select * from orders where userID='"+userID+"'";
		return getHotelList(sql);
	}

	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {
		String sql = "select * from orders where hotelID='"+hotelID+"'";
		return getHotelList(sql);
	}

	public ArrayList<OrderPO> getAllDailyOrders(String time) {
		String sql = "select * from orders where startTime regexp '^"+time+"'";
		return getHotelList(sql);
	}

	private ArrayList<OrderPO> getHotelList(String sql) {
		ArrayList<OrderPO> orderPOs;
		Connection conn;
		Statement statement;
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			orderPOs = new ArrayList<OrderPO>();
			
			ResultSet rs=statement.executeQuery(sql);
			
			while (rs.next()) {
				OrderPO orderPO = new OrderPO(null, null, null, null, null, 0, null, false, 0, 0, 0, 0, 0, null, null, null, null);
				orderPO.setUesrID(rs.getString("userID"));
				orderPO.setOrderID(rs.getString("orderID"));
				orderPO.setHotelId(rs.getString("hotelID"));
				orderPO.setStartTime(rs.getString("startTime"));
				orderPO.setEndTime(rs.getString("endTime"));
				orderPO.setRoomNum(rs.getInt("roomNum"));
				
				//处理roomID的ArrayList
				String[] roomIds = rs.getString("roomIDs").split("###");
				ArrayList<String> roomIDs = new ArrayList<String>();
				for(int i = 0 ; i < orderPO.getRoomNum() ; i++){
					roomIDs.add(roomIds[i]);
				}
				orderPO.setRoomIDs(roomIDs);
				
				orderPO.setHasChild(rs.getInt("hasChild")==1);
				orderPO.setNumberOfPeople(rs.getInt("numberOfPeople"));
				orderPO.setState(rs.getInt("state"));
				orderPO.setBeforePromotionPrice(rs.getDouble("beforPromotionPrice"));
				orderPO.setAfterPromotionPrice(rs.getDouble("afterPromotionPrice"));
				orderPO.setPromotionNum(rs.getInt("promotionNum"));
				
				//处理promtoinIDs的ArrayList
				if (orderPO.getPromotionNum()!=0) {
					String [] promotions = rs.getString("promtoinIDs").split("###");
					ArrayList<String> promotionIDs = new ArrayList<String>();
					for (String promtoinID : promotions) {
						promotionIDs.add(promtoinID);
					}
					orderPO.setPromotionIDs(promotionIDs);
				}else {
					orderPO.setPromotionIDs(null);
				}
				
				orderPO.setExecutedTime(rs.getString("executedTime"));
				orderPO.setUndoAbnormalTime(rs.getString("undoAbnormalTime"));
				orderPO.setAbnormalTime(rs.getString("abnormalTime"));
				
				orderPOs.add(orderPO);
			}
			statement.close();
			conn.close();
			
			return orderPOs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;	
	}
}
