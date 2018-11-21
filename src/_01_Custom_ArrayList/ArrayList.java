package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
	
	private T[] list;
	
	public ArrayList() {
		list = (T[]) new Object[5];
	}
	
	public T get(int loc) throws IndexOutOfBoundsException {
		
		return list[loc];
	}
	
	public void add(T val) {
		T[] temp = (T[]) new Object[list.length+1];
		for (int i = 0; i < temp.length; i++) {
			if(i < temp.length-1) {
				temp[i] = list [i];
			} else {
				temp[i] = val;
			}
		}
		list = temp;
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		
	}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
		
	}
	
	public boolean contains(T val) {
		
		return false;
	}
}