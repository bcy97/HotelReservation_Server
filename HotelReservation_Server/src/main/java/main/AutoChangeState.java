package main;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import data.order_data.OrderAutoJob;
import data.room_data.RoomAutoJob;

public class AutoChangeState {

	public Scheduler getSchdeulerFactory() {  
		//通过schedulerFactory获取一个调度器  
		SchedulerFactory schedulerfactory=new StdSchedulerFactory();  
		Scheduler scheduler=null;  
		try{  
//      通过schedulerFactory获取一个调度器  
			scheduler=schedulerfactory.getScheduler();  
			return scheduler;
		}catch(Exception e){  
			e.printStackTrace();  
		}  
		return null;
	}
	
	public static void setRoomAutoJob(){
		JobDetail job=JobBuilder.newJob(RoomAutoJob.class).withIdentity("job1", "jgroup1").build();  
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")  
				.withSchedule(CronScheduleBuilder.cronSchedule("00 00 00 * * ? *"))  
				.startNow().build();   
		try {
			AutoChangeState changeState = new AutoChangeState();
			changeState.getSchdeulerFactory().scheduleJob(job, trigger);
			changeState.getSchdeulerFactory().start();  
		} catch (SchedulerException e) {
			e.printStackTrace();
		}  
	}
	
	public static void setOrderAutoJob(String time , String orderID){
		AutoChangeState changeState = new AutoChangeState();
		//处理设为异常订单时间，为startTime后四个小时，如果超过24则时间置为23:59:59
		int abnormalHour = Integer.valueOf(time.substring(11,13))+4;
		int abnormalMin=Integer.valueOf(time.substring(14,16));
		int abnormalSecond=Integer.valueOf(time.substring(17, 19));
		if (abnormalHour>=24) {
			abnormalHour=23;
			abnormalMin=59;
			abnormalMin=59;
		}
		JobDetail job=JobBuilder.newJob(OrderAutoJob.class).withIdentity("job"+orderID, "jgroup2").build();  
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger"+orderID, "triggerGroup")  
				.withSchedule(CronScheduleBuilder.cronSchedule(abnormalSecond+" "+abnormalMin+" "+
																abnormalHour+" "+time.substring(8, 10)+" "+
																time.substring(5, 7)+" ? "+time.substring(0,4)))  
				.startNow().build();  
		
		job.getJobDataMap().put(OrderAutoJob.ORDERID, orderID);
		try {
			changeState.getSchdeulerFactory().scheduleJob(job, trigger);
			changeState.getSchdeulerFactory().start();  
		} catch (SchedulerException e) {
			e.printStackTrace();
		}  
		
	}
}
