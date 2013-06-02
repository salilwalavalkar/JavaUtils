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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

/**
 * Collection utility methods.  
 * 
 * Apache Commons Lang is required for this class. 
 * The latest version can be downloaded from: 
 * http://commons.apache.org/lang/
 * 
 * @author salil.walavalkar
 * @version 1.0.0 
 * 
 */
public final class CustomCollectionUtil {

	/**
	 * Blank character as string.
	 */
	public static final String BLANK_STRING = " ";

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
	 * CustomCollectionUtil constructor is hidden to ensure this class cannot be
	 * instantiated.
	 */
	private CustomCollectionUtil() {
        throw new AssertionError("Instantiation of this class in not allowed.");
	}
	
	/**
	 * Check whether List is empty.
	 * 
	 * @param list
	 *            - List to be checked.
	 * @return whether empty or not.
	 */
	public static boolean isListEmpty(final List<? extends Object> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Check whether List is empty.
	 * 
	 * @param set
	 *            - Set to be checked.
	 * @return whether empty or not.
	 */
	public static boolean isSetEmpty(final Set<? extends Object> set) {
		if (set == null || set.isEmpty()) {
			return true;
		}
		return false;
	}

    /**
     * Method used to sort map by values
     * 
     * @param <K>
     *            Map Key
     * @param <V>
     *            Map Value
     * @param map
     *            Map
     * @return sorted Map
     */
    public static < K, V extends Comparable < V >> Map < K, V > sortByValues(
            final Map < K, V > map) {
        Comparator < K > valueComparator = new Comparator < K >() {
            public int compare(final K k1, final K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));

                if (compare == 0) {
                    return 1;
                } else {
                    return compare;
                }
            }
        };

        Map < K, V > sortedByValues = new TreeMap < K, V >(valueComparator);
        sortedByValues.putAll(map);

        return sortedByValues;
    }
    
	/**
	 * Method to calculate standard set intersection operation. Example
	 * :Consider set1 = {1,2,3,4,5} set2 = {2,4,5,6,7} then, the output of this
	 * method will be setIntersection = {2,4,5}
	 * 
	 * @param set1
	 * @param set2
	 * @return setIntersection
	 */
	public static Set<Long> setIntersection(Set<Long> ietmSet1, Set<Long> itemSet2) {
		Set<Long> setIntersection = new HashSet<Long>();
		/*
		 * Perform set intersection operation only if both the set are not
		 * empty.
		 */
		if (ietmSet1 != null && !ietmSet1.isEmpty() && itemSet2 != null
				&& !itemSet2.isEmpty()) {
			for (Long item : ietmSet1) {
				if (itemSet2.contains(item)) {
					setIntersection.add(item);
				}
			}
		}
		return setIntersection;
	}

	/**
	 * Method to calculate standard set difference operation. Example : Consider
	 * set1 = {1,2,3,4,5} set2 = {1,2,3} then, the output of this method will be
	 * setDifference = {4,5}
	 * 
	 * @param set1
	 * @param set2
	 * @return setDifference
	 */
	public static Set<Long> setDifference(Set<Long> itemSet1, Set<Long> itemSet2) {
		Set<Long> setDifference = new HashSet<Long>();
		/*
		 * Perform set difference operation only if the set1 are not empty.
		 */
		if (itemSet1 != null && !itemSet1.isEmpty()) {
			if (itemSet2 != null && !itemSet2.isEmpty()) {
				for (Long item : itemSet1) {
					if (!itemSet2.contains(item)) {
						setDifference.add(item);
					}
				}
			} else {
				for (Long item : itemSet1) {
					setDifference.add(item);
				}
			}
		}
		return setDifference;
	}

	/**
	 * Method to calculate standard set union operation. Example : Consider set1
	 * = {1,2,3} and set2 = {2,3,4,5} then output of this method will be
	 * setUnion = {1,2,3,4,5}
	 * 
	 * @param set1
	 * @param set2
	 * @return setUnion
	 */
	public static Set<Long> setUnion(Set<Long> itemSet1, Set<Long> itemSet2) {
		Set<Long> setUnion = new HashSet<Long>();
		if (itemSet1 != null && !itemSet1.isEmpty()) {
			for (Long item : itemSet1) {
				setUnion.add(item);
			}
		}
		if (itemSet2 != null && !itemSet2.isEmpty()) {
			for (Long item : itemSet2) {
				setUnion.add(item);
			}
		}
		return setUnion;
	}

	/**
	 * Converts comma separated value string to set of long values
	 * 
	 * @param csvString
	 * @param seperator
	 * @return itemSet
	 */
	public static Set<Long> convertStringToSet(String csvStr, String fieldSeperator) {
		Set<Long> itemSet = new HashSet<Long>();
		if (StringUtils.isNotEmpty(csvStr) && StringUtils.isNotBlank(csvStr)) {
			String[] itemsArray = StringUtils.split(csvStr, fieldSeperator);
			if (itemsArray != null && itemsArray.length > 0) {
				for (int i = 0; i < itemsArray.length; i++) {
					if (StringUtils.isNotEmpty(itemsArray[i])
							&& StringUtils.isNotBlank(itemsArray[i])) {
						itemSet.add(Long.valueOf(StringUtils
								.trim(itemsArray[i])));
					}
				}
			}
		}
		return itemSet;
	}

	/**
	 * Converts comma separated value string to set of long values
	 * 
	 * @param csvString
	 * @param seperator
	 * @return itemSet
	 */
	public static List<Long> convertStringToList(String csvStr, String fieldSeperator) {
		List<Long> itemSet = new ArrayList<Long>();
		if (StringUtils.isNotEmpty(csvStr) && StringUtils.isNotBlank(csvStr)) {
			String[] itemsArray = StringUtils.split(csvStr, fieldSeperator);
			if (itemsArray != null && itemsArray.length > 0) {
				for (int i = 0; i < itemsArray.length; i++) {
					if (StringUtils.isNotEmpty(itemsArray[i])
							&& StringUtils.isNotBlank(itemsArray[i])) {
						itemSet.add(Long.valueOf(StringUtils
								.trim(itemsArray[i])));
					}
				}
			}
		}
		return itemSet;
	}

	/**
	 * Converts comma separated value string to set of long values
	 * 
	 * @param csvString
	 * @param seperator
	 * @return itemSet
	 */
	public static Set<String> convertStringToSetString(String csvStr,
			String fieldSeperator) {
		Set<String> itemSet = new HashSet<String>();
		if (StringUtils.isNotEmpty(csvStr) && StringUtils.isNotBlank(csvStr)) {
			String[] itemsArray = StringUtils.split(csvStr, fieldSeperator);
			if (itemsArray != null && itemsArray.length > 0) {
				for (int i = 0; i < itemsArray.length; i++) {
					if (StringUtils.isNotEmpty(itemsArray[i])
							&& StringUtils.isNotBlank(itemsArray[i])) {
						itemSet.add(StringUtils.trim(itemsArray[i]));
					}
				}
			}
		}
		return itemSet;
	}

	/**
	 * Method to return comma separated value String for set of long values.
	 * 
	 * @param itemSet
	 * @return csvString
	 */
	public static String convertSetToString(Set<Long> set) {
		StringBuilder csvString = new StringBuilder();
		if (set != null && !set.isEmpty()) {
			for (Long item : set) {
				if (csvString.length() > 0) {
					csvString.append(COMMA_SEPARATOR);
					csvString.append(item.toString());
				} else {
					csvString.append(item.toString());
				}
			}
		}
		if (csvString.length() > 0) {
			return csvString.toString();
		} else {
			return BLANK_STRING;
		}
	}

	/**
	 * Method to create the comma separated String for the array of Long Values
	 * 
	 * @param longArray
	 * @return
	 */

	public static String convertLongArrayToString(Long[] longArray) {
		String csvString = "";
		if (longArray != null && (longArray.length) > 0) {
			for (int i = 0; i < longArray.length; i++) {
				if (longArray[i] == null || longArray[i] == 0) {
					csvString += (i) + COMMA_SEPARATOR;

				}
			}
		}
		if (csvString.length() > 0) {
			return csvString;
		} else {
			return BLANK_STRING;
		}
	}

	/**
	 * Method to convert list of items to set
	 * 
	 * @param itemsList
	 * @return
	 */
	public static Set<Long> convertListToSet(List<Long> list) {
		Set<Long> itemsSet = new HashSet<Long>();
		if (list != null && !list.isEmpty()) {
			for (Long item : list) {
				itemsSet.add(item);
			}
		}
		return itemsSet;
	}

	/**
	 * Generic Method to convert set to list of objects
	 * 
	 * @param set
	 * @return
	 */
	public static List<?> convertSetToList(Set<?> set) {
		if (set != null && !set.isEmpty()) {
			List<Object> list = new ArrayList<Object>();
			for (Object obj : set) {
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	/**
	 * Will convert the Long[] into Set.
	 * 
	 * @param longObjects
	 * @return This method will return set<Long>.
	 */
	public static Set<Long> convertLongToSet(Long[] longObjects) {
		Set<Long> longObjectsSet = new HashSet<Long>();
		if (longObjects != null && longObjects.length > 0) {
			for (int i = 0; i < longObjects.length; i++) {
				longObjectsSet.add(longObjects[i]);
			}
		}
		return longObjectsSet;
	}

	public static String convertListToCSVString(List<Long> itemsList) {
		StringBuilder csvString = new StringBuilder();
		if (itemsList != null && !itemsList.isEmpty()) {
			for (Long item : itemsList) {
				if (csvString.length() > 0) {
					csvString.append(COMMA_SEPARATOR);
					csvString.append(item.toString());
				} else {
					csvString.append(item.toString());
				}
			}
		}
		return csvString.toString();
	}

	/**
	 * Converts comma separated value string to Long array
	 * 
	 * @param csvString
	 * @param seperator
	 * @return itemSet
	 */
	public static Long[] convertStringToLongArray(String csvString, String seperator) {
		String[] itemsArray = StringUtils.split(csvString, seperator);
		Long[] arrLong = new Long[itemsArray.length];
		if (StringUtils.isNotEmpty(csvString)
				&& StringUtils.isNotBlank(csvString)) {
			if (itemsArray != null && itemsArray.length > 0) {
				for (int i = 0; i < itemsArray.length; i++) {
					if (StringUtils.isNotEmpty(itemsArray[i])
							&& StringUtils.isNotBlank(itemsArray[i])) {
						arrLong[i] = Long.valueOf(StringUtils
								.trim(itemsArray[i]));
					}
				}
			}

		}
		return arrLong;
	}
}
