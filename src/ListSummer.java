import java.util.Arrays;
import java.util.List;

public class ListSummer {

	public static double sumOfList(
			List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	public static <T extends Number> double sumOfList2(
			List<T> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 
				6, 7, 8, 9, 10);
		System.out.println("sum = " + sumOfList(li));

		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + sumOfList(ld));
	}
}
