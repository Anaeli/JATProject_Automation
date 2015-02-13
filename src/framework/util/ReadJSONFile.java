package framework.util;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
/**
 * 
 * @author Eliana Navia
 *
 */
 
public class ReadJSONFile {
 
    public String readJSON(String data) {
        JSONParser parser = new JSONParser();
        String value = "";
        String filePath = System.getProperty("user.dir")+"/src/framework/resources/config.json";
         try {
             Object obj = parser.parse(new FileReader(filePath));
             JSONObject jsonObject = (JSONObject) obj;
             value = (String) jsonObject.get(data); 
        } catch (Exception e) {
            e.printStackTrace();
        }
         return value;
    }
}
