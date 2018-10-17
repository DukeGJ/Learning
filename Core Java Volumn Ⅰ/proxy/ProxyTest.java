package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * This program demonstrates the use of proxies
 * @version 1.00 2017-10-24
 * @author GJ
 *
 */
public class ProxyTest {
	
	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		
		//fill elements with proxies for the integers 1 ... 1000
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		//construct a random integer
		Integer key = new Random().nextInt(elements.length) + 1;
		
		//search for the key
		int result = Arrays.binarySearch(elements, key);
		
		//print mathc if found
		if (result > 0) {
			System.out.println(elements[result]);
		}
	}
}

class TraceHandler implements InvocationHandler {
	private Object target;
	
	public TraceHandler(Object t) {
		// TODO Auto-generated constructor stub
		target = t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//print implicit argument
		System.out.print(target);
		//print method name
		System.out.print("." + method.getName() + "(");
		//print explicit arguments
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println(")");
		
		//invoke actual method
		return method.invoke(target, args);
	}
	
}