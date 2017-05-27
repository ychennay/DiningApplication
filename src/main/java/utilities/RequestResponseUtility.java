package main.java.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import main.java.config.PropertyConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ychen4 on 5/26/2017.
 */
public class RequestResponseUtility {

    private static StringBuilder readStream(InputStream inputStream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        try {
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
       finally {
            try{
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder;
    }

    public static String prettyPrintJson(JSONObject jsonObject){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonObject.toString());
        return gson.toJson(je);

    }


    public static String convertStreamToString(InputStream inputStream) throws IOException {
        try {
            return readStream(inputStream).toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static JSONObject convertStreamToJson(InputStream inputStream) throws IOException {
        String response = readStream(inputStream).toString();
        try {
            JSONObject jsonObject = new JSONObject(response);
            return  jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    public static HttpURLConnection prepareGetRequest(URL url) throws IOException {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("configuration.xml");
        PropertyConfiguration properties = (PropertyConfiguration)
                context.getBean("propertyConfiguration");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + properties.getYelpAccessToken());
        return connection;
    }


}
