
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

class time implements ActionListener{
	JFrame jr=new JFrame("TIMER");
	JLabel jl=new JLabel("hi");
	JLabel jl1=new JLabel("hi");
	Timer t=new Timer();
	int sec=10;
	int min=10;
	int hour=10;
	public void timer() {
		
		jr.setSize(400, 400);
		jl.setSize(100,100);
		jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jr.setVisible(true);
		jr.getContentPane().setBackground(Color.white);
		jr.add(jl);
		jr.add(jl1);
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				times();
				jl.setText(Integer.toString(hour)+":"+Integer.toString(min)+":"+Integer.toString(sec));
				
			}
		}, 1000, 1000);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void times(){
		if(sec!=0) {
			sec= sec-1;
		}
		else
		{
			jl1.setText("time over");
			t.cancel();
		}
		
		
	}
}

public class Timer {
	public static void main(String a[]) {
		time t=new time();
		t.timer();
	}

}
