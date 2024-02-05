package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingBtnEvent_05 extends JFrame implements ActionListener {

	Container cp;
	JButton btn1, btn2;

	public SwingBtnEvent_05(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255, 255, 255));
		initDegign();

		this.setVisible(true);
	}

	public void initDegign() {
		this.setLayout(new FlowLayout());

		btn1 = new JButton("◀");
		btn2 = new JButton("▶");

		// 버튼색상
		btn1.setBackground(Color.PINK);
		btn2.setBackground(Color.ORANGE);

		// 글자색상
		btn1.setForeground(Color.GREEN);
		btn2.setForeground(Color.GREEN);

		// 프레임에 추가
		this.add(btn1);
		this.add(btn2);

		// 버튼에 이벤트 발생..이벤트 핸들러와 이벤트발생객체 연결
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); // 버튼의 어떤 메서드 호출인지 정확히 지정해주어야함

		// 버튼마다 다른 메세지 출력하려면?
		if (ob == btn1)
			JOptionPane.showMessageDialog(this, "왼쪽으로 이동");
		else if (ob == btn2)
			JOptionPane.showMessageDialog(this, "오른쪽으로 이동");

	}

	public static void main(String[] args) {

		new SwingBtnEvent_05("버튼이벤트_5");

	}

}
