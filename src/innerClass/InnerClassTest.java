package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes
 * @version 1.11 2017-10-16
 * @author GJ
 *
 */
public class InnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		
		//keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
class TalkingClock{
	private int interval;
	private boolean beep;
	
	/**
	 * Constructs a talking clock
	 * @param interval the interval between messages(in milliseconds)
	 * @param beep true if the clock should beep
	 */
	public TalkingClock(int interval,boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}
	
	/**
	 * Starts the clock
	 */
	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("At the tone,the time is " + new Date());
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
		
	}
}