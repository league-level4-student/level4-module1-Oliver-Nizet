package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList<T> {

	private T[] list;

	public ArrayList() {
		list = (T[]) new Object[0];
	}

	public T get(int loc) throws IndexOutOfBoundsException {
		return list[loc];
	}

	public void add(T val) {
		T[] temp = (T[]) new Object[list.length + 1];
		for (int i = 0; i < temp.length; i++) {
			if (i < temp.length - 1) {
				temp[i] = list[i];
			} else {
				temp[i] = val;
			}
		}
		list = temp;
	}

	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		T[] temp = (T[]) new Object[list.length + 1];
		for (int i = 0; i < temp.length; i++) {
			if (i < loc) {
				temp[i] = list[i];
			} else if (i == loc) {
				temp[i] = val;
			} else {
				temp[i] = list[i - 1];
			}
		}
		list = temp;
	}

	public void set(int loc, T val) throws IndexOutOfBoundsException {
		list[loc] = val;
	}

	public void remove(int loc) throws IndexOutOfBoundsException {
		T[] temp = (T[]) new Object[list.length - 1];
		for (int i = 0; i < temp.length; i++) {
			if (i < loc) {
				temp[i] = list[i];
			} else if (i >= loc) {
				temp[i] = list[i + 1];
			}
		}
		list = temp;
	}

	public boolean contains(T val) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(val)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return list.length;
	}
}