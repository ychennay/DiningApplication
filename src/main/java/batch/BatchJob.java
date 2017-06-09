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

/**
 * The main executable class. In the future, the Yelp Service implementation should be modularized and abstracted away
 * into its own service client. For now, this batch job can be executed a multiple of ways- either through hitting the
 * /yelp/search endpoint, or by executing this specific class within the WAR or JAR file.
 */
public class BatchJob {

    /**
     * Main entry point into the batch job. The job will grab the application context and then get the simpleJob bean and
     * execute it using the jobLauncher.run() method. There are no job parameters, so an anonymous JobParameter object
     * is instantiated and passed into the run() method.
     * @param args
     */
    public static void main(String[] args){
        String configFile = "batch-update-restaurants-workflow.xml";
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(configFile);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("simpleJob");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }
}
