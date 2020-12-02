import java.util.HashMap;
import java.util.Map;

public class Capitals {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("United States", "Washington");
		map.put("France", "Paris");
		map.put("Zimbabwe", "Harare");
		map.put("Costa Rica", "San Jose");
		System.out.println(map.get("France")); // Paris
		
		for (String country : map.keySet()) 
			System.out.print(country + ", ");
		System.out.println();
		// United States, Zimbabwe, France, Costa Rica, 

		for (String capital : map.values()) 
			System.out.print(capital + ",  ");
		System.out.println();
		// Washington,  Harare,  Paris,  San Jose,  
		
		for (Map.Entry<String, String> entry : 
				map.entrySet())
			System.out.println(entry.getKey() + " = "
					+ entry.getValue());
		// United States = Washington
		// Zimbabwe = Harare
		// France = Paris
		// Costa Rica = San Jose
	}
}
