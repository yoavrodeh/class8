import java.util.LinkedList;
import java.util.List;

public class MyHashSet<E> implements MySet<E> {
	private List<E>[] table;
	private int num = 0;

	@SuppressWarnings("unchecked")
	public MyHashSet(int size) {
		table = (List<E>[]) new List[size];
	}

	public MyHashSet() {
		this(10);
	}
	
	private int indexOf(E e) {
		return Math.abs(e.hashCode()) % table.length;
	}

	@Override
	public void add(E e) {
		if (num > table.length / 2)
			doubleSize();
		int i = indexOf(e);
		if (table[i] == null)
			table[i] = new LinkedList<>();
		table[i].add(e);
		num++;
	}

	@Override
	public boolean contains(E e) {
		List<E> list = table[indexOf(e)];
		return list != null && list.contains(e);
	}

	private void doubleSize() {
		MyHashSet<E> temp = new MyHashSet<>(
				table.length * 2);
		for (List<E> list : table)
			if (list != null)
				for (E e : list) 
					temp.add(e);
		table = temp.table;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('[');
		for (List<E> list : table) 
			if (list != null)
				for (E e : list) {
					b.append(e);
					b.append(" ");
				}
		b.append(']');
		return b.toString();
	}

	public static void main(String[] args) {
		MyHashSet<String> s = new MyHashSet<>();
		for (int i = 0; i < 10; i++)
			s.add(i + "E");
		System.out.println(s);
		// [4E 6E 8E 1E 3E 5E 7E 9E 0E 2E ]
	}
}
