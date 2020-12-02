import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListExamples {
	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		for (int i=0; i<10; i++)
			l.add(i);
		l.subList(3, 6).clear();
		System.out.println(l);
		// [0, 1, 2, 6, 7, 8, 9]

		Integer[] a = {100, 101, 102};
		List<Integer> l2 = Arrays.asList(a);
		System.out.println(l2);
		// [100, 101, 102]
		a[0] = 103;
		System.out.println(l2);
		// [103, 101, 102]
		
		l.addAll(4, l2);
		System.out.println(l);
		// [0, 1, 2, 6, 103, 101, 102, 7, 8, 9]

		Collections.sort(l);
		System.out.println(l);
		// [0, 1, 2, 6, 7, 8, 9, 101, 102, 103]
	}
}
