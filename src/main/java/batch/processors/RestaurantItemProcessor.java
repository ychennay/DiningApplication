package main.java.batch.processors;

import main.java.App;
import org.apache.log4j.Logger;

import javax.batch.api.chunk.ItemProcessor;

/**
 * Created by ychen4 on 5/26/2017.
 */
public class RestaurantItemProcessor implements ItemProcessor {

    private static final Logger logger = Logger.getLogger(App.class.toString());

    @Override
    public Object processItem(Object o) throws Exception {
        return null;
    }
}
