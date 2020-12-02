package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CountIgnoring {

	public static int countIgnoringCase(Collection<String> input) {
		Set<String> set = new HashSet<String>();
		for (String str : input)
			set.add( str.toUpperCase());
		return set.size();
	}
	
	public static void main(String[] args) {
		String[] arr = {"One", "one", "THREE", "two", "Three"};
		int answer = countIgnoringCase(Arrays.asList(arr));
		System.out.println(answer);
	}

}
