package testQuartz;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public void test(){
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = factory.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		 // 计算任务的开始时间，DateBuilder.evenMinuteDate方法是取下一个整数分钟  
        Date runTime = DateBuilder.evenMinuteDate(new Date());  
        
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();
        
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").build();
        
        try {
			scheduler.scheduleJob(trigger);
			scheduler.start();
			scheduler.shutdown(true);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
