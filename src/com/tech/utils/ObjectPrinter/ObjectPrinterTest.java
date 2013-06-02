package com.tech.utils.ObjectPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample implementation of ObjectPrinter class.
 * 
 * @author salil.walavalkar
 * @version 1.0.0
 */
public class ObjectPrinterTest {
	public static void main(String args[]) {
		
		/* Create person object */
		Person person = new Person();
		person.setName("Salil");
		person.setAge(27);
		List<String> langs = new ArrayList<String>();
		langs.add("English");
		langs.add("Geek");
		person.setLanguagesKnown(langs);
		
		/* Print object details */
		System.out.println(person.toString());
	}
}
/************************************** Output ***************************************
 * Person[( Attribute Name-Values : Person@addbf1 ) 
 * ( Field Values : Age = 27, LanguagesKnown = [English, Geek], Name = Salil)]
**************************************************************************************/
