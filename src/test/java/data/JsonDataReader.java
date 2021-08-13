package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
public String fname , lname , email , pass , searchName , reviewTitle ,review ;
public void jsonReader() throws FileNotFoundException, IOException, ParseException {
	String filePath  =  System.getProperty("user.dir")+ "\\src\\test\\java\\data\\data.json";
	File srcFile = new File(filePath);
	JSONParser parser = new JSONParser();
	JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
	for(Object jsonObj : jArray) {
		JSONObject person = (JSONObject) jsonObj;
		fname = (String) person.get("fname");
		lname = (String) person.get("lname");
		email = (String) person.get("email");
		pass = (String) person.get("pass");
		searchName = (String) person.get("searchName");
		reviewTitle = (String) person.get("reviewTitle");
		review = (String) person.get("review");

		
	}
	
}
}
