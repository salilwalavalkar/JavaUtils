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

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Provides general String manipulation and formatting utilities for String
 * objects.
 * 
 * @author salil.walavalkar
 * @version 1.0.0
 */
public final class CustomStringUtil {
	
	/**
	 * Empty non-null string.
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * Null string.
	 */
	public static final String NULL_STRING = null;

	/**
	 * Comma separator.
	 */
	public static final String COMMA_SEPARATOR = ",";
	
	/**
	 * CustomStringUtil constructor is hidden to ensure this class cannot be
	 * instantiated.
	 */
	private CustomStringUtil() {
		throw new AssertionError("Instantiation of this class in not allowed.");
	}

	/**
	 * Check of string is empty or blank.
	 * 
	 * @param str
	 *            String to be checked.
	 * @return True if string is empty or blank.
	 */
	public static boolean isEmptyOrBlank(final String str) {
		return (str == null) || str.trim().isEmpty();
	}

    /**
     * Convert empty parameter to null else return trimmed string.
     * 
     * @param param
     *            - Parameter to convert.
     * @return - Converted string.
     */
    public static String handleEmptyParameter(final String param) {
        return isEmptyOrBlank(param) ? null : param.trim();
    }
    
	/**
	 * Returns actual string or null string converted to empty string.
	 * 
	 * @param inputString
	 *            String to be converted, can be a null string.
	 * @return String that is guaranteed to be non null.
	 */
	public static String makeNullSafe(final String inputString) {
		return inputString == null ? EMPTY_STRING
				: inputString;
	}
	
	/**
	 * Returns actual string (trimmed) or null string converted to empty string.
	 * 
	 * @param inputString
	 *            String to be converted, can be a null string.
	 * @return String that is guaranteed to be non null and value if present is
	 *         trimmed.
	 */
	public static String makeNullSafeWithTrim(final String inputString) {
		return inputString == null ? EMPTY_STRING
				: inputString.trim();
	}	
    
	/**
	 * Gets the stack trace of all the nested exceptions in the form of a string
	 * for the given exception.
	 * 
	 * @param currentEx
	 *            Exception whose stack trace string is needed.
	 * @return String The String containing all the nested stack traces.
	 */
	public static String getStackTraceString(final Throwable currentEx) {
		String result = EMPTY_STRING;

		if (currentEx != null) {
			final StringWriter stringWriter = new StringWriter();

			currentEx.printStackTrace(new PrintWriter(stringWriter));

			result = stringWriter.toString();
		}
		return result;
	}
}
