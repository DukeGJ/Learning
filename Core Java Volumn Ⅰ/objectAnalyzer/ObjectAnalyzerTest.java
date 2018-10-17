package objectAnalyzer;

import java.util.ArrayList;

/**
 * This program uses reflection to spy on objects
 * @version 1.12 2017-10-12
 * @author GJ
 *
 */
public class ObjectAnalyzerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> squares = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			squares.add(i * i);
		}
		System.out.println(new ObjectAnalyzer().toString(squares));
	}

}
