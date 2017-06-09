package main.java.batch.processors;

import com.sun.org.apache.regexp.internal.RE;
import main.java.App;
import main.java.model.Restaurant;
import org.apache.log4j.Logger;

import javax.batch.api.chunk.ItemProcessor;

/**
 * Created by ychen4 on 5/26/2017.
 */

/**
 * This class will contain the primary process() method to hold future business logic manipulations of the Restaurant page.
 */
public class RestaurantItemProcessor implements ItemProcessor {

    private static final Logger logger = Logger.getLogger(App.class.toString());

    /**
     * The main processing is accomplished within this processItem() method
     * @param o A Restaurant object that is inputted into the processor
     * @return another Restaurant object after processing
     * @throws Exception
     */
    @Override
    public Object processItem(Object o) throws Exception {
        return null;
    }
}
