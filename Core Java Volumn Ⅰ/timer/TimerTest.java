package timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListener listener = new TimerPrinter();
		
		//construct a timer that calls the listener
		//once every 10 seconds
		Timer t = new Timer(10000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
class TimerPrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("At the tone,the time is " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
	
}
