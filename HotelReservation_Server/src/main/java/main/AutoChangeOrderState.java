package main;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class AutoChangeOrderState {

	public static Scheduler getSchdeulerFactory() {  
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
	
}
