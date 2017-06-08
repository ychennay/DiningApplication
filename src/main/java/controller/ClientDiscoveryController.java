package main.java.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by ychen4 on 6/3/2017.
 */
@Controller
public class ClientDiscoveryController {

    @Autowired
    DiscoveryClient client;

    @RequestMapping("/sentence")
    public @ResponseBody String getSentence(){
        return getWord("ACCOUNT");
    }


    public String getWord(String service){
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0){
            URI uri = list.get(0).getUri();
            System.out.println(uri);
            if (uri != null){
              String stringUri = new StringBuilder().append(uri.toString()).append("/ws-account/api").toString();
                try {
                    uri = new URI(stringUri);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                System.out.println(uri);
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return service;
    }
}
