package data.order_data;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import data.credit_data.CreditData;
import po.CreditHistoryPO;
import po.OrderPO;

public class OrderAutoJob implements Job{

	public static final String ORDERID = "orderID";

	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		String orderID = dataMap.getString(ORDERID);
		
		//从数据库获取该订单信息
		OrderData orderData = new OrderData();
		OrderPO orderPO = orderData.getOrderByOrderID(orderID);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		orderPO.setAbnormalTime(time);
		orderPO.setState(2);
		CreditData creditData = new CreditData();
		CreditHistoryPO creditHistoryPO = new CreditHistoryPO(orderPO.getUesrID(), time, orderPO.getOrderID(), 1,
			-(int)orderPO.getAfterPromotionPrice(), creditData.getCredit(orderPO.getUesrID())-(int)orderPO.getAfterPromotionPrice());
		creditData.changeCredit(creditHistoryPO);
		orderData.updateOrder(orderPO);
	}

}
