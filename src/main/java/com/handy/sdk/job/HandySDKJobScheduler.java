package com.handy.sdk.job;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.handy.sdk.exceptions.HandySDKException;

public class HandySDKJobScheduler {
	
	public static void startJob() throws HandySDKException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {

            Scheduler scheduler = schedulerFactory.getScheduler();

            JobDetail job = JobBuilder.newJob(HandySDKJob.class).withIdentity("handyJob", "group1").build();

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("handyTrigger", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(10).repeatForever()).build();

            scheduler.scheduleJob(job, trigger);
            scheduler.start();

        } catch (SchedulerException e) {
            throw new HandySDKException("Error during HandySDKJob scheduling.", e);
        }
	}
}
