package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 4/29/2017.
 */
public class WelcomeService implements GenericWelcomeService {

    public List<String> getWelcomeMessage(String name) {
        List<String> myWelcomeMessage = new ArrayList<>();

        // Add data to the list of String
        myWelcomeMessage.add("Hello! ");
        myWelcomeMessage.add(name);
        myWelcomeMessage.add(", welcome to the Spring course :-)");
        return myWelcomeMessage;
    }

}
