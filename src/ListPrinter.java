import java.util.Arrays;
import java.util.List;

public class ListPrinter {

	public static void printListAttempt(List<Object> l) {
		for (Object elem : l)
			System.out.print(elem + " ");
		System.out.println();
	}

	public static <T> void printList1(List<T> l) {
		for (T elem : l)
			System.out.print(elem + " ");
		System.out.println();
	}

	public static void printList2(List<?> l) {
		for (Object elem : l)
			System.out.print(elem + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5);
		List<String> ls = 
				Arrays.asList("one", "two", "three");
		printList1(li);
		// 1 2 3 4 5 
		printList2(ls);
		// one two three 		
	}
}
