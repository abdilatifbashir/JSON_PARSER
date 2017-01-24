import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Json {
	private static String student_name;
	private static  String unit_name;
	private static int marks;	
	private static Scanner scanner;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Enter Student Name");
		student_name = scanner.nextLine();
		
//		creating a root JSON Object		
		JSONObject root = new JSONObject();
//		creating JSON array for course object
		JSONArray coursesArray = new JSONArray();
		
//		putting the name name-value pair
		root.put("name", student_name);
		
		while (true){
			System.out.println("Enter Unit Name or (PRESS ENTER TO EXIT)");
			unit_name = scanner.nextLine();
			if(unit_name.length() == 0){
				break;
			}
			
			System.out.println("Marks Scored");
			marks = scanner.nextInt();	
			
			if(scanner.hasNextLine()){
				scanner.nextLine();
			}
			
//			creating a JSON Object and putting it in an Array
			JSONObject courseObject = new JSONObject();
			courseObject.put("marks", marks);
			courseObject.put("Unit", unit_name);
//			adding units to a JSON array		
			coursesArray.add(courseObject);
			
		}		
//		adding courseArray to the root object
		root.put("courses", coursesArray);
		
		System.out.println(root.toJSONString());
		
//		creating a file and writing in JSON format
		File file = new File("data.json");
		try (PrintWriter writer = new PrintWriter(file)){			
			writer.print(root.toJSONString());			 
		} catch (FileNotFoundException e) { 			
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
	}

}
