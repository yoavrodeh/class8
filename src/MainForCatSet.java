import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class MainForCatSet {
	public static void main(String[] args) {
		Set<Cat> set = new HashSet<Cat>();
		Cat cat1 = new Cat("Mitsi", 1);
		Cat cat2 = new Cat("Mitski", 2);
		Cat cat3 = new Cat("Mitsush", 2);
		Cat cat4 = new Cat("Mitsi", 1);
		set.addAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		System.out.println(set);
		// [Mitsi(1), Mitsush(2), Mitski(2)]
		System.out.println(
				set.contains(new Cat("Mitski", 2)));
		// true
		
		cat2.setName("Mitsalul");
		System.out.println(
				set.contains(new Cat("Mitsalul", 2)));
		// false
	}
}
