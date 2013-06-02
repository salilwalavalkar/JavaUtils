package com.tech.utils.ObjectPrinter;

/**
 * Copyright (c) 2012 Salil Walavalkar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
 * and associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial 
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ObjectPrinter class overrides toString() method of Object class 
 * and prints all the attributes that support java bean naming standards.
 * 
 * @author salil.walavalkar
 * @version 1.0.0
 */
public class ObjectPrinter implements Serializable {

	/**
	 * Serial version Id used by instances of this class.
	 */
	private static final long serialVersionUID = -1206212264628560951L;

	/**
	 * Length of "Get" string.
	 */
	private static final int GET_LENGTH = 3;

	/**
	 * "Get" Prefix string.
	 */
	private static final String GET_PREFIX = "get";

	/**
	 * Length of "Is" string.
	 */
	private static final int IS_LENGTH = 2;

	/**
	 * "Is" Prefix string.
	 */
	private static final String IS_PREFIX = "is";

	public ObjectPrinter() {
		super();
	}

	private StringBuffer valObj = null;

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		if (this.valObj == null) {
			Method method = null;
			String methodName = null;
			boolean isFirstMethod = true;
			String attributeName = null;
			Method declaredMethods[] = null;
			@SuppressWarnings("rawtypes")
			final Class clazz = this.getClass();
			final StringBuffer buffer = new StringBuffer();

			try {
				declaredMethods = clazz.getMethods();

				buffer.append(clazz.getName());
				buffer.append("[( Attribute Name-Values : ");

				buffer.append(super.toString());

				buffer.append(" ) ( Field Values : ");

				for (int index = 0; index < declaredMethods.length; index++) {
					method = declaredMethods[index];

					if (validateGetterMethod(method)) {
						methodName = method.getName();

						if (methodName.startsWith(GET_PREFIX)
								|| methodName.startsWith(IS_PREFIX)) {
							if (!isFirstMethod) {
								buffer.append(", ");
							}

							isFirstMethod = false;

							attributeName = methodName.substring(GET_LENGTH);

							if (methodName.startsWith(IS_PREFIX)) {
								attributeName = methodName.substring(IS_LENGTH);
							}

							buffer.append(attributeName);
							buffer.append(" = ");
							buffer.append(method.invoke(this, null));
						}
					}
				}
				buffer.append(")]");
				valObj = buffer;
			} catch (final Throwable currentEx) {
				buffer.append("Error in creating toString for : ");
				buffer.append(clazz);
				buffer.append(" with error message as : ");
				buffer.append(currentEx.getMessage());
				valObj = null;
			}
		}
		return valObj.toString();
	}

	/**
	 * Helper method to check if the given method is a valid getter method. It
	 * takes into consideration non-static methods only.
	 * 
	 * @param value
	 *            Method to check.
	 * @return true if is a valid getter method; false otherwise.
	 */
	private boolean validateGetterMethod(final Method value) {
		boolean result = true;

		if (value != null) {
			final int modifier = value.getModifiers();

			/*
			 * Validate method type.
			 */
			if ((modifier == Modifier.STATIC)
					|| (modifier == Modifier.ABSTRACT)
					|| (modifier != Modifier.PUBLIC)) {
				result = false;
			}

			/*
			 * Validate whether method is a getter with no inputs
			 */
			@SuppressWarnings("rawtypes")
			final Class parameters[] = value.getParameterTypes();

			if ((parameters != null) && (parameters.length > 0)) {
				result = false;
			}
		}
		return result;
	}
}
