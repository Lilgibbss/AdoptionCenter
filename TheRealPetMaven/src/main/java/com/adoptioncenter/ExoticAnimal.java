package com.adoptioncenter;

public class ExoticAnimal {
	private String nam3;
	private int ag3;
	private String type;
	private boolean avalible;
	
	public ExoticAnimal(String name, int age, String type) {
		this.nam3 = name;
		this.ag3 = age;
		this.type = type;
		this.avalible = true;
	}

	public String getName() {
		return nam3;
	}

	public int getAge() {
		return ag3;
	}

	public String getType() {
		return type;
	}

	public boolean isAvalible() {
		return avalible;
	}
	
	public void adopted() {
		this.avalible = false;
	}
	
	
}
