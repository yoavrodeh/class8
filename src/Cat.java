public class Cat implements Comparable<Cat> {
	private String name;
	private long ownerId;
	
	public Cat(String name, long ownerId) {
		this.name = name;
		this.ownerId = ownerId;
	}
	
	@Override
	public String toString() {
		return name + "(" + ownerId + ")";
	}
	
	@Override
	public int compareTo(Cat other) {
		if (ownerId == other.ownerId)
			return name.compareTo(other.name);
		else
			return ownerId > other.ownerId ? 1 : -1;
	}	
	
	@Override
	public int hashCode() {
		return name.hashCode() * 31 + 
				Long.hashCode(ownerId);
	}

	@Override
	public boolean equals(Object obj) {
		Cat other = (Cat) obj;
		return name.equals(other.name) &&
				ownerId == other.ownerId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
