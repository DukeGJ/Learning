package anonymousInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This program demonstrates anonymous inner classes
 * @version 1.11 2017-10-24
 * @author GJ
 *
 */

public class AnonymousInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		
		//keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock {
	/**
	 * Starts the clock
	 * @param interval the interval between messages (in millisecondes)
	 * @param beep true if the clock should beep
	 */
	public void start(int interval, boolean beep) {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("At the tone, the time is " + new Date());
				if (beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
}