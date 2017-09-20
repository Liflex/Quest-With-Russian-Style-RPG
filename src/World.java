import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dialogue.ChapterOne;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DebugGraphics;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JFormattedTextField;
public class World extends JFrame implements ActionListener{
	public static World world;
	final JTextPane textPane = new JTextPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws InterruptedException {
		World window = new World();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sound.playSound("M.wav").setVolume(1.0f);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ChapterOne chapterOne = new ChapterOne();	
		window.printText(chapterOne.welcome(), 150);
		//window.printText("SSSSSSSSSSSS", 500);
//		new Thread(new Runnable() {
//			public void run() {
//				
//			}}).start();
	}
//		new Thread(new Runnable() Sound.playSound("M.wav").setVolume(0.6f).start();
//	}
	/**
	 * Конструктор
	 */
	public World() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Россия 2033");
		setBounds(100, 100, 702, 451);
		setResizable(true);
		
		JLabel btnC = new JLabel(new ImageIcon("fon.jpg"));
		btnC.setHorizontalAlignment(SwingConstants.LEADING);
		btnC.setLayout(new BorderLayout());
		btnC.setBounds(0, 0, 582, 387);
		JLabel btnE = new JLabel();
		btnE.setBounds(579, 0, 117, 396);
		btnE.setLabelFor(btnC);
		btnE.setIcon(new ImageIcon("inventar.jpg"));
		getContentPane().setLayout(null);
		textPane.setEditable(false);
		textPane.setForeground(Color.LIGHT_GRAY);
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setText("sssssssssssssssssssssssssssssssssss");
		textPane.setBounds(53, 78, 475, 203);
		
		
		JTextPane txtpnSss = new JTextPane();
		txtpnSss.setText("1....."
				+ "2....."
				+ "3..... ");
		txtpnSss.setForeground(Color.LIGHT_GRAY);
		txtpnSss.setBackground(Color.DARK_GRAY);
		txtpnSss.setBounds(53, 296, 475, 75);
		JButton btnS = new JButton("Право выбора диалога");
		btnS.setBounds(10, 386, 696, 26);
		getContentPane().add(textPane);
		getContentPane().add(txtpnSss);
		getContentPane().add(btnC);
		getContentPane().add(btnS);
		getContentPane().add(btnE);
		printText("", 150);
	}


	public static void TimerPaused() throws InterruptedException {
		 int timer=5000;
		 Thread.sleep(timer);
		}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void printText(String msg, int maxPauseMsec) { //Метод который позволяет красиво печатать текст
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= msg.length(); i++) {
					final String s = msg.substring(0, i);
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							textPane.setText(s);
						}
					});
					try {
						Thread.sleep((int) (Math.random() * maxPauseMsec));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
