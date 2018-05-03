package en;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class in implements ActionListener{
	JFrame jr=new JFrame("notepad");
	JTextArea ja=new JTextArea(490,490);
	JTextField jf=new JTextField();
	JMenu jm=new JMenu("file");
	JMenuItem jio=new JMenuItem("open");
	JMenuItem jis=new JMenuItem("save");
	JMenuBar jb=new JMenuBar();
	JFileChooser jfi=new JFileChooser();
	JFrame jsf=new JFrame();
	JScrollPane jsp=new JScrollPane(ja);
	public void note()
	{
		jr.setSize(500, 500);
		jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jr.setVisible(true);
		jr.add(jsp);
		jb.add(jm);
		jm.add(jis);
		jm.add(jio);
		jr.setJMenuBar(jb);
		jis.addActionListener(this);
		jio.addActionListener(this);
		
	}
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(s.equals("open")) {
			jfi.setDialogTitle("open");
			//jsf.setVisible(true);
			jfi.setSize(600,600);
			jsf.add(jfi);
			int state=jfi.showOpenDialog(null);
			if(state==jfi.APPROVE_OPTION) {
				File f=jfi.getSelectedFile();
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String in;
				try {
					while((in=br.readLine())!=null)
					{
						ja.append(in+"\n");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(state==jfi.CANCEL_OPTION)
			{
				jfi.cancelSelection();
			}
		}
		else if(s.equals("save"))
		{
			jfi.setDialogTitle("specify position");
			jfi.setSize(700, 700);
			jsf.add(jfi);
			int state;
			state=jfi.showSaveDialog(null);
			File f;
			f=jfi.getSelectedFile();
			if(f.exists()) {
				state=jfi.showSaveDialog(null);
				f=jfi.getSelectedFile();
				@SuppressWarnings("unused")
				JPopupMenu pop=new JPopupMenu("file exists");
				System.out.println(f);
				if(state==jfi.CANCEL_OPTION)
				{
					jfi.cancelSelection();
				}
			}
			try {
				
				f.createNewFile();
				System.out.println("file is created");
				@SuppressWarnings("resource")
				PrintWriter pw=new PrintWriter(f);
				String s0 = ja.getText();
				System.out.println(s0+jfi.getSelectedFile());
				pw.print(s0);
				pw.flush();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
}




public class Notepad {
	public static void main(String a[])
	{
		in i=new in();
		i.note();
	}

}
