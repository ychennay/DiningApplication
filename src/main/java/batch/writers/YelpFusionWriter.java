package main.java.batch.writers;

import main.java.App;
import main.java.model.Restaurant;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by ychen4 on 6/9/2017.
 */
public class YelpFusionWriter implements ItemWriter<Restaurant> {

    private final Logger logger = Logger.getLogger(this.getClass().toString());


    @Override
    public void write(List<? extends Restaurant> list) throws Exception {
        logger.info("writer:\n");
        logger.info(list);
        logger.info("\n");

    }
}
