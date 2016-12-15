package data.order_data;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.database.DBConnection;
import dataDao.order.OrderDao;
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
		
		//处理最后三个可能为null的参数
		if (orderPO.getExecutedTime()!=null&&orderPO.getExecutedTime()!="") {
			sql = sql+",'"+orderPO.getExecutedTime()+"'";
		}else{
			sql = sql+",null";
		}
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
		sql = sql+",'"+orderPO.getRoomType()+"','"+orderPO.getPromotionID()+"')";
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
				orderPO = new OrderPO(null, null, null, null, null, 0, 0, false, 0, 0, 0, 0, null, null, null, null,null);
				orderPO.setUesrID(rs.getString("userID"));
				orderPO.setOrderID(orderID);
				orderPO.setHotelId(rs.getString("hotelID"));
				orderPO.setStartTime(rs.getString("startTime"));
				orderPO.setEndTime(rs.getString("endTime"));
				orderPO.setRoomNum(rs.getInt("roomNum"));
				orderPO.setRoomType(rs.getInt("roomType"));
				orderPO.setHasChild(rs.getInt("hasChild")==1);
				orderPO.setNumberOfPeople(rs.getInt("numberOfPeople"));
				orderPO.setState(rs.getInt("state"));
				orderPO.setBeforePromotionPrice(rs.getDouble("beforPromotionPrice"));
				orderPO.setAfterPromotionPrice(rs.getDouble("afterPromotionPrice"));
				orderPO.setPromotionID(rs.getString("promotionID"));
				
				orderPO.setExecutedTime(rs.getString("executedTime"));
				orderPO.setUndoAbnormalTime(rs.getString("undoAbnormalTime"));
				orderPO.setAbnormalTime(rs.getString("abnormalTime"));
				orderPO.setUndoUnexecutedTime(rs.getString("undoUnexecutedTime"));
				
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
			System.out.println("不存在该数据");
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
		String sql = "select * from orders where userID='"+userID+"'";
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
			
			return orderIDs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
