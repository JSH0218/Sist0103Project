package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingImageIcon_06 extends JFrame implements ActionListener {

	Container cp;

	// 이미지 아이콘 가져온다
	ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\LEFT.GIF");
	ImageIcon icon2 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\leftDown.gif");
	ImageIcon icon3 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\leftRollover.gif");
	ImageIcon icon4 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\chick.gif");
	ImageIcon icon5 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\an07.gif");

	JButton btn1, btn2, btn3, btn4;

	public SwingImageIcon_06(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(1200, 200, 300, 300);
		cp.setBackground(new Color(255, 255, 255));
		initDesign();

		this.setVisible(true);
	}

	public void initDesign() {
		// 2행2열
		this.setLayout(new GridLayout(2, 2));
		btn1 = new JButton("hello", icon1);
		btn1.setHorizontalTextPosition(JButton.CENTER); // 텍스트가로방향
		btn1.setVerticalTextPosition(JButton.BOTTOM); // 텍스트세로방향
		this.add(btn1);

		btn1.setRolloverIcon(icon2);
		btn1.setPressedIcon(icon3);

		// 버튼2
		btn2 = new JButton(icon4);
		this.add(btn2);

		// 버튼3
		btn3 = new JButton("스윙버튼");
		this.add(btn3);

		// 버튼4
		btn4 = new JButton("안녕", icon5);
		this.add(btn4);

		// 버튼에 이벤트 발생..이벤트 핸들러와 이벤트발생객체 연결
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); // 버튼의 어떤 메서드 호출인지 정확히 지정해주어야함

		// 버튼마다 다른 메세지 출력하려면?
		if (ob == btn1)
			JOptionPane.showMessageDialog(this, "색깔이 변하는 화살표");
		else if (ob == btn2)
			JOptionPane.showMessageDialog(this, "목디스크예정 병아리");
		else if (ob == btn3)
			JOptionPane.showMessageDialog(this, "스윙");
		else if (ob == btn4)
			JOptionPane.showMessageDialog(this, "말하는 새");

	}

	public static void main(String[] args) {

		new SwingImageIcon_06("버튼이벤트_6");

	}

}
