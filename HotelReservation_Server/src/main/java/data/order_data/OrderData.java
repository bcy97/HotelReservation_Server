package data.order_data;

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
				||orderPO.getEndTime()==null||orderPO.getEndTime()==""||orderPO.getRoomIDs()==null){
			System.out.println("data.order_data.OrderData.addOrder参数异常");
			return false;
		}
		if (orderIDExist(orderPO.getOrderID())) {
			System.out.println("已存在该数据");
			return false;
		}
		Connection conn;
		Statement statement;
		String empty;
		String sql = "insert into orders values('" +
				orderPO.getUesrID() + "','" + orderPO.getOrderID() +"','"+orderPO.getHotelId()+"','"+
				orderPO.getStartTime()+"','"+orderPO.getEndTime()+"','"+orderPO.getRoomNum();
		
		//处理roomID的ArrayList
		String rooms = "";
		for (String  roomID : orderPO.getRoomIDs()) {
			rooms+=roomID+"###";
		}
		
		//处理double是否有小孩
		String hasChild = "";
		if (orderPO.isHasChild()) {
			hasChild = "1";
		}else {
			hasChild = "0";
		}
		sql = sql+"','"+rooms+"','"+hasChild+"','"+orderPO.getNumberOfPeople()+"','"+
				orderPO.getState()+"','"+orderPO.getBeforePromotionPrice()+"','"+
				orderPO.getAfterPromotionPrice()+"','"+orderPO.getPromotionNum();
		
		//处理promotionIDs的ArrayList
		String promotion = "";
		if (orderPO.getPromotionNum()!=0) {
			for (String promotionID : orderPO.getPromotionIDs()) {
				promotion += promotionID+"###";
			}
			sql = sql+"','"+promotion;
		}else {
			sql = sql+"',null";
		}
		
		//处理最后三个可能为null的参数
		if ((orderPO.getExecutedTime()==null||orderPO.getExecutedTime()=="")
				&&(orderPO.getUndoAbnormalTime()==null||orderPO.getUndoAbnormalTime()=="")
				&&(orderPO.getAbnormalTime()==null||orderPO.getAbnormalTime()=="")) {
			sql = sql+",null,null,null)";
		}else {
			if (orderPO.getExecutedTime()!=null&&orderPO.getExecutedTime()!="") {
				sql = sql+",'"+orderPO.getExecutedTime()+"',null,null)";
			}
			if (orderPO.getUndoAbnormalTime()!=null&&orderPO.getUndoAbnormalTime()!="") {
				sql = sql+",null,'"+orderPO.getUndoAbnormalTime()+"',null)";
			}
			if (orderPO.getAbnormalTime()!=null&&orderPO.getAbnormalTime()!="") {
				sql = sql+",null,null,'"+orderPO.getAbnormalTime()+"')";
			}
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
				||orderPO.getEndTime()==null||orderPO.getEndTime()==""||orderPO.getRoomIDs()==null){
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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addEvalution(EvaluationPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public EvaluationPO getEvaluationByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getBookedHotelList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}


}
