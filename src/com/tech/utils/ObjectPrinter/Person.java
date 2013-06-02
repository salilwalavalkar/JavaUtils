package com.tech.utils.ObjectPrinter;

import java.util.List;

/**
 * Sample java bean standard class.
 * 
 * @author salil.walavalkar
 * @version 1.0.0
 */
public class Person extends ObjectPrinter {

	private static final long serialVersionUID = 8236738666098748544L;

	private String name;

	private int age;

	private List<String> languagesKnown;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the languagesKnown
	 */
	public List<String> getLanguagesKnown() {
		return languagesKnown;
	}

	/**
	 * @param languagesKnown
	 *            the languagesKnown to set
	 */
	public void setLanguagesKnown(List<String> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

}
