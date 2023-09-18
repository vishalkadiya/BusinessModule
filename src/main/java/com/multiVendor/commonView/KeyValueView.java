package com.multiVendor.commonView;

public class KeyValueView implements Comparable<KeyValueView>{

	private String name; 
	
	private int id;
	
	public KeyValueView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static KeyValueView create(int id, String name) {
	        return new KeyValueView(name, id);
	}
	 
	public KeyValueView(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(KeyValueView that) {
		return name.compareTo(that.getName());
	}

	@Override
    public String toString() {
        return "KeyValueView [Id=" + getId() + ", name=" + getName() + "]";
    }
}
