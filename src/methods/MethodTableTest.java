package methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This program show how to invoke methods through reflection
 * @version 1.2 2017-10-12
 * @author GJ
 *
 */
public class MethodTableTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		//get Method pointers to the square and sqrt methods
		Method square = MethodTableTest.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		
		//print tables of x- and y-values
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
	}
	/**
	 * returns the square of a number
	 * @param x 
	 * 		a number
	 * @return x
	 * `	square
	 */
	public static double square(double x) {
		return x * x;
	}
	
	public static void printTable(double from, double to, int n, Method f) {
		//print out the method as table header
		System.out.println(f);
		double dx = (to - from) / (n - 1);
		
		for (double x = from; x <= to; x += dx) {
			
			try {
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.1f%n" ,x,y);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
