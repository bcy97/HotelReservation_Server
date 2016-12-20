package data.order_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.database.DBConnection;
import dataDao.order.OrderDao;
import main.AutoChangeState;
import po.EvaluationPO;
import po.OrderPO;

public class OrderData implements OrderDao{

	public boolean orderIDExist(String orderID){
		Connection conn;
		Statement statement;
		String sql = "select * from orders where orderID='"+orderID+"'";
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
	
	public boolean addOrder(OrderPO orderPO) {
		if(orderPO==null||orderPO.getUesrID()==null||orderPO.getUesrID()==""||orderPO.getOrderID()==null||orderPO.getOrderID()==""
			||orderPO.getHotelId()==null||orderPO.getHotelId()==""||orderPO.getStartTime()==null||orderPO.getStartTime()==""
				||orderPO.getEndTime()==null||orderPO.getEndTime()==""){
			System.out.println("data.order_data.OrderData.addOrder参数异常");
			return false;
		}
		if (orderIDExist(orderPO.getOrderID())) {
			System.out.println("已存在该数据");
			return false;
		}
		
		if (orderPO.getState()==0) {
			//开始准备自动执行订单
			AutoChangeState.setOrderAutoJob(orderPO.getStartTime(), orderPO.getOrderID());
		}
		
		Connection conn;
		Statement statement;
		String sql = "insert into orders values('" +
				orderPO.getUesrID() + "','" + orderPO.getOrderID() +"','"+orderPO.getHotelId()+"','"+
				orderPO.getStartTime()+"','"+orderPO.getEndTime()+"','"+orderPO.getRoomNum();
		
		//处理double是否有小孩
		String hasChild = "";
		if (orderPO.isHasChild()) {
			hasChild = "1";
		}else {
			hasChild = "0";
		}
		sql = sql+"','"+hasChild+"','"+orderPO.getNumberOfPeople()+"','"+
				orderPO.getState()+"','"+orderPO.getBeforePromotionPrice()+"','"+
				orderPO.getAfterPromotionPrice()+"'";
		
		//处理undoAbnormalTime/abnormalTime/undoUnexecutedTime可能为null的参数
		if (orderPO.getUndoAbnormalTime()!=null&&orderPO.getUndoAbnormalTime()!="") {
			sql = sql+",'"+orderPO.getUndoAbnormalTime()+"'";
		}else {
			sql = sql+",null";
		}
		if (orderPO.getAbnormalTime()!=null&&orderPO.getAbnormalTime()!="") {
			sql = sql+",'"+orderPO.getAbnormalTime()+"'";
		}else {
			sql = sql+",null";
		}
		if (orderPO.getUndoUnexecutedTime()!=null&&orderPO.getUndoUnexecutedTime()!="") {
			sql = sql +",'"+orderPO.getUndoUnexecutedTime()+"'";
		}else {
			sql = sql+",null";
		}
		sql = sql+",'"+orderPO.getRoomType()+"','"+orderPO.getPromotionID()+"'";
		
		//处理roomIDs
		String roomIDs = "";
		if (orderPO.getRoomIDs()!=null) {
			for (String string : orderPO.getRoomIDs()) {
				roomIDs = roomIDs+string+"###";
			}
			sql = sql+",'"+roomIDs+"'";
		}else {
			sql = sql+",null";
		}
		//处理checkInTime/checkOutTime/可能为null的参数
		if (orderPO.getCheckInTime()!=null&&orderPO.getCheckInTime()!="") {
			sql = sql+",'"+orderPO.getCheckInTime()+"'";
		}else{
			sql = sql+",null";
		}
		if (orderPO.getCheckOutTime()!=null&&orderPO.getCheckOutTime()!="") {
			sql = sql+",'"+orderPO.getCheckOutTime()+"')";
		}else{
			sql = sql+",null)";
		}
		//获得完整的sql指令
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

	public boolean updateOrder(OrderPO orderPO) {
		if(orderPO==null||orderPO.getUesrID()==null||orderPO.getUesrID()==""||orderPO.getOrderID()==null||orderPO.getOrderID()==""
				||orderPO.getHotelId()==null||orderPO.getHotelId()==""||orderPO.getStartTime()==null||orderPO.getStartTime()==""
				||orderPO.getEndTime()==null||orderPO.getEndTime()==""){
			System.out.println("data.order_data.OrderData.addOrder参数异常");
			return false;
		}
		if (!orderIDExist(orderPO.getOrderID())) {
			System.out.println("不存在该数据");
			return false;
		}
		
		//删除现有数据
		Connection conn;
		Statement statement;
		String sql = "delete from orders where orderID='"+orderPO.getOrderID()+"'";
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
		if (addOrder(orderPO)) {
			return true;
		}
		return false;
	}

	public OrderPO getOrderByOrderID(String orderID) {
		//判断是否存在
		if (!orderIDExist(orderID)) {
			System.out.println("不存在该数据");
			return null;
		}
		
		//获取数据
		OrderPO orderPO;
		Connection conn;
		Statement statement;
		String sql = "select * from orders where orderID='"+orderID+"'";
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			
			if (rs.next()) {
				orderPO = new OrderPO(null, null, null, null, null, null, 0, 0, false, 0, 0, 0, 0, null, null, null, null, null, null);
				orderPO.setUesrID(rs.getString("userID"));
				orderPO.setOrderID(orderID);
				orderPO.setHotelId(rs.getString("hotelID"));
				orderPO.setStartTime(rs.getString("startTime").substring(0,19));
				orderPO.setEndTime(rs.getString("endTime").substring(0,19));
				if (rs.getString("roomIDs")==null) {
					orderPO.setRoomIDs(null);
				}else {
					orderPO.setRoomIDs(rs.getString("roomIDs").split("###"));
				}
				orderPO.setRoomNum(rs.getInt("roomNum"));
				orderPO.setRoomType(rs.getInt("roomType"));
				orderPO.setHasChild(rs.getInt("hasChild")==1);
				orderPO.setNumberOfPeople(rs.getInt("numberOfPeople"));
				orderPO.setState(rs.getInt("state"));
				orderPO.setBeforePromotionPrice(rs.getDouble("beforPromotionPrice"));
				orderPO.setAfterPromotionPrice(rs.getDouble("afterPromotionPrice"));
				orderPO.setPromotionID(rs.getString("promotionID"));
				
				if (rs.getString("checkInTime")==null) {
					orderPO.setCheckInTime(null);
				}else {
					orderPO.setCheckInTime(rs.getString("checkInTime").substring(0,19));
				}
				
				if (rs.getString("checkOutTime")==null) {
					orderPO.setCheckOutTime(null);
				}else {
					orderPO.setCheckOutTime(rs.getString("checkOutTime").substring(0,19));
				}
				
				if (rs.getString("undoAbnormalTime")==null) {
					orderPO.setUndoAbnormalTime(null);
				}else {
					orderPO.setUndoAbnormalTime(rs.getString("undoAbnormalTime").substring(0,19));
				}
				
				if (rs.getString("abnormalTime")==null) {
					orderPO.setAbnormalTime(null);
				}else {
					orderPO.setAbnormalTime(rs.getString("abnormalTime").substring(0,19));
				}
				
				if (rs.getString("undoUnexecutedTime")==null) {
					orderPO.setUndoUnexecutedTime(null);
				}else {
					orderPO.setUndoUnexecutedTime(rs.getString("undoUnexecutedTime").substring(0,19));
				}
				
				statement.close();
				conn.close();
				
				return orderPO;
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean addEvaluation(EvaluationPO po) {
		if (po==null||po.getOrderID()==null||po.getOrderID()=="") {
			System.out.println("data.order_data.OrderData.addEvaluation参数错误");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql = "insert into evaluation values('" +
				po.getOrderID() + "','" + po.getCommentLevel() +"','"+po.getEvaluationContent()+"')";		
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

	public EvaluationPO getEvaluationByOrderID(String orderID) {
		EvaluationPO evaluationPO;
		Connection conn;
		Statement statement;
		String sql = "select * from evaluation where orderID='"+orderID+"'";
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			
			if (rs.next()) {
				evaluationPO = new EvaluationPO(orderID, 0, null);
				evaluationPO.setCommentLevel(rs.getDouble("commentLevel"));
				evaluationPO.setEvaluationContent(rs.getString("evaluationContent"));
				statement.close();
				conn.close();
				
				return evaluationPO;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		ArrayList<String> orderIDs = getHotelOrderID(hotelID);
		ArrayList<EvaluationPO> evaluationPOs = new ArrayList<EvaluationPO>();
		if (orderIDs==null) {
			System.out.println("不存在该数据"+hotelID);
			return null;
		}
		for (String orderID : orderIDs) {
			evaluationPOs.add(getEvaluationByOrderID(orderID));
		}
		
		return evaluationPOs;
	}

	public ArrayList<String> getBookedHotelList(String userID) {
		ArrayList<String> bookedHotels;
		Connection conn;
		Statement statement;
		String sql = "select distinct hotelID from orders where userID='"+userID+"'";
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			bookedHotels = new ArrayList<String>();
			
			ResultSet rs=statement.executeQuery(sql);
			
			while (rs.next()) {
				bookedHotels.add(rs.getString("hotelID"));
			}
			statement.close();
			conn.close();
			
			return bookedHotels;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int getOrderNum(){
		String sql = "select count(*) from orders";
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
	
	private ArrayList<String> getHotelOrderID(String hotelID) {
		
		System.out.println(hotelID);
		ArrayList<String> orderIDs;
		Connection conn;
		Statement statement;
		String sql = "select * from orders where hotelID='"+hotelID+"'";
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			orderIDs = new ArrayList<String>();
			
			ResultSet rs=statement.executeQuery(sql);
			
			while (rs.next()) {
				orderIDs.add(rs.getString("orderID"));
			}
			statement.close();
			conn.close();
			System.out.println(orderIDs==null);
			return orderIDs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
