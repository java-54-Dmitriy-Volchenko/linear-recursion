package telran.recursion;

public class LinearRecursionMethods {
public static int factorial(int n) {
	if (n < 0) {
		throw new IllegalArgumentException("n cannot be a negative");
	}
	int res = 1;
	if(n != 0) {
		res = n * factorial(n - 1);
	} 
	return res;
	
}
/*
 * a - any integer
 * b - positive integer
 */
public static int pow1(int a, int b) {
	if (b < 0) {
		throw new IllegalArgumentException();
	}
	int res = 1;
	if (b != 0) {
		res = a * pow1(a, b - 1);
	}
	return res;
}
/**
 * 
 * @param a - any integer number
 * @param b - positive integer number
 * @return a ^ b
 * no cycles
 * only arithmetic operations +, -
 * additional functions if any with the same limitations
 */

public static int pow(int a, int b) {
	int res = 1;
	if (b < 0) {
		throw new IllegalArgumentException();
	}
	
	if (b > 0) {
		res = product(a, pow(a, b - 1));
	}
	return res;
}

public static int product(int a, int b) {

	int res = 0;
	if (b<0) {b=Math.abs(b); a=0-a;}
	if (b != 0) {
		res =  a + product(a, b - 1);
	}
	

	return res;
}


public static void displayArray(int [] array) {
	displayArray(0, array, false);
}

public static void  displayArrayReversed(int [] array) {
	displayArray(0, array, true);
}
private static void displayArray(int index, int[] array, boolean isReversed) {
	if(index < array.length) {
		if (isReversed) {
			displayArray(index + 1, array, isReversed);
			System.out.print(array[index] + " ");
		} else {
			System.out.print(array[index] + " ");
			displayArray(index + 1, array, isReversed);
		}
	}
	
	
}
public static int sum(int [] array) {
	return sum(0, array);
}
private static int sum(int index, int[] array) {
	int res = 0;
	if(index < array.length) {
		res = array[index] + sum(index + 1, array);
	}
	return res;
}
public static void reverse(int [] array) {
	reverse(0, array.length - 1, array);
}
private static void reverse(int left, int right, int[] array) {
	if (left < right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
		reverse(left + 1, right - 1, array);
	}
	
}
/**
 * 
 * @param x - any integer number
 * @return x ^ 2
 * no cycles
 * allowed only arithmetic operations +, -
 * no additional functions allowed
 * no static fields
 */

    public static int square(int x) {
    	int res = 0; 
    	int moduleX = x<0?0-x:x;
    	if(moduleX>0) {
    		res =  square(moduleX - 1) + (moduleX + moduleX - 1) ;//solution found in internet and based on algebraic dependence  
    	}

    return res; 
    }


/**
 * 
 * @param str - string
 * @param substr - substring
 * @return true if substr is a substring of a string, false otherwise
 * no cycles
 * allowed only three String methods are charAt(int index);substring(int beginIndex);
 * length()
 */
public static boolean isSubstring(String str, String substr) {
	boolean res = false;
	if (str.length() >= substr.length()) {//exit from recursion
		if (firstLettersEquals(str, substr)) {res = true;}
		else {
			res = isSubstring(str.substring(1), substr); //cutting first letter from string
		};
	}
	
	
	return res;
}

private static boolean firstLettersEquals(String str, String substr) {
	boolean res = false;
	
	if(substr.length() == 0) {
	res = true;
	}
	
	else if (str.charAt(0) == substr.charAt(0)) {
		res = firstLettersEquals(str.substring(1), substr.substring(1));
	}
	
	
	return res;
	
}
}
