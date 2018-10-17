package staticInnerClass;


public class StaticInnerClassTest {
	public static void main(String[] args) {
		double[] d = new double[20];
		for (int i = 0; i < d.length; i++) {
			d[i] = 100 * Math.random();
		}
		
		ArrayIg.Pair p = ArrayIg.minmax(d);
		System.out.println("min=" + p.getFirst());
		System.out.println("max=" + p.getSecond());
	}
}

class ArrayIg {
	/**
	 * A pair of floating-point numbers
	 */
	public static class Pair {
		private double first;
		private double second;
		
		public Pair(double f, double s) {
			first = f;
			second = s;
		}
		
		/**
		 * Returns the first number of the pair
		 * @return the first number
		 */
		public double getFirst() {
			return first;
		}
		/**
		 * Returns the second number of the pair
		 * @return the second number
		 */
		public double getSecond() {
			return second;
		}
	}
	/**
	 * 
	 */
	public static Pair minmax(double[] values) {
		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;
		for (double v : values) {
			if (min > v) {
				min = v;
			}
			if (max < v) {
				max = v;
			}
		}
		return new Pair(min,max);
	}
}