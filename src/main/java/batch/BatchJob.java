package main.java.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ychen4 on 6/9/2017.
 */
public class BatchJob {

    public static void main(String[] args){
        String configFile = "batch-update-restaurants-workflow.xml";
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(configFile);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("simpleDojJob");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }
}
