package exercise;

import java.util.HashSet;
import java.util.Set;

public class SubSets {
	
	public static <V> Set<Set<V>> subset3(Set<V> input) {
		Set<Set<V>> set = new HashSet<>();
		for (V v1 : input) 
			for (V v2 : input) 
				for (V v3 : input) { 
					Set<V> temp = new HashSet<>();
					temp.add(v1);
					temp.add(v2);
					temp.add(v3);
					if (temp.size() < 3)
						continue;
					set.add(temp);
				}
		return set;
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		System.out.println(subset3(set));
	}

}
