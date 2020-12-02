import java.util.*;
public class CountWords {
	public static void main(String[] args) {
		String[] strs = {"yes", "no", "yes", "black", "no",
				"white", "yes"};
		Map<String, Integer> map = new HashMap<>();
		for (String s : strs) {
			Integer count = map.get(s);
			map.put(s, count == null ? 1 : count + 1);
		}
		System.out.println(map);
		// {no=2, white=1, yes=3, black=1}
	}
}
