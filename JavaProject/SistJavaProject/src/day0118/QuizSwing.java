package day0118;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class QuizSwing extends JFrame implements ActionListener {

	Container cp;
	JButton[] btn = new JButton[5];
	String[] btnLabel = { "Red", "Green", "Blue", "Magenta", "Gray" };
	Color[] btnColors = { Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.GRAY };
	JLabel lbl;

	public QuizSwing() {
		super();

		cp = this.getContentPane();

		this.setBounds(1200, 200, 500, 300);
		cp.setBackground(new Color(255, 255, 255));
		initDesign();

		this.setVisible(true);
	}

	public void initDesign() {
		// Panel은 기본이 FlowLayout
		JPanel panel = new JPanel();
		panel.setBackground(Color.orange);

		this.add(panel, BorderLayout.NORTH); // 프레임의 상단에 패널배치
		
		lbl = new JLabel("안녕하세요",JLabel.CENTER);
		lbl.setFont(new FontUIResource("", Font.BOLD, 50));
		this.add(lbl);

		// 버튼생성
		for (int i = 0; i < btn.length; i++) {
			// 버튼 5개생성
			btn[i] = new JButton(btnLabel[i]);

			// 버튼5개에 각각의 버튼색상변경
			btn[i].setForeground(btnColors[i]);

			// 버튼5개에 이벤트 추가
			btn[i].addActionListener(this);

			// panel에 버튼5개 추가
			panel.add(btn[i]);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		for (int i = 0; i < btn.length; i++) {
			if (ob == btn[i]) {
				// 각각의 버튼을 누르면 라벨의 글자색 변경
				lbl.setForeground(btnColors[i]);
			}
		}

	}

	public static void main(String[] args) {

		new QuizSwing();

	}

}
