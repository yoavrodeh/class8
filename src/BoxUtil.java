public class BoxUtil {
	public static <T> void move1(Box<T> from, Box<T> to) {
		to.set(from.get());
	}

	public static <E, T extends E> void move2(Box<T> from,
			Box<E> to) {
		to.set(from.get());
	}

	public static <T> void move3(Box<? extends T> from,
			Box<T> to) {
		to.set(from.get());
	}

	public static <T> void move4(Box<T> from,
			Box<? super T> to) {
		to.set(from.get());
	}
}
