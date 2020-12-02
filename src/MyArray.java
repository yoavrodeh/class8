import java.util.Arrays;
import java.util.Collection;

public class MyArray<E> {
	E[] elements;
	int num = 0;
	
	@SuppressWarnings("unchecked")
	public MyArray() {
		elements = (E[])new Object[10];
	}

	public void add(E e) {
		if (num == elements.length)
			elements = Arrays.copyOf(elements, num * 2);
		elements[num++] = e;
	}

	public E get(int i) {
		if (i > num)
			throw new IndexOutOfBoundsException();
		return elements[i];
	}
	
	public int length() {
		return num;
	}
	
	public void addAll(MyArray<? extends E> other) {
		for (int i = 0; i < other.length(); i++)
			add(other.get(i));
	}

	public <T extends E> void addAll2(MyArray<T> other) {
		for (int i = 0; i < other.length(); i++)
			add(other.get(i));
	}

	public static void main(String[] args) {
		MyArray<Number> a = new MyArray<>();
		MyArray<Double> b = new MyArray<>();
		b.add(3.2);
		a.addAll(b);
	}
}
