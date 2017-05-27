package main.java.utilities;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.JsonParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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


    public static String convertStreamToString(InputStream inputStream) throws IOException {
        try {
            return readStream(inputStream).toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static JSONObject convertStreamtoJson(InputStream inputStream) throws IOException {
        String response = readStream(inputStream).toString();
        try {
            JSONObject jsonObject = new JSONObject(response);
            return  jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
