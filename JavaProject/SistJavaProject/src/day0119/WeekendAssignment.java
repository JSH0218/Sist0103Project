package day0119;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class WeekendAssignment extends JFrame implements ActionListener, ItemListener {

	Container cp;
	JCheckBox cbMale;
	String[] colorsNames = { "빨강", "초록", "파랑" };
	Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
	JRadioButton[] rbColors = new JRadioButton[3];
	String[] country = { "한국", "미국", "일본", "중국", "영국" };
	JCheckBox[] cbCountry = new JCheckBox[5];
	JLabel lblResult;

	public WeekendAssignment(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(1200, 200, 500, 500);
		cp.setBackground(new Color(255, 255, 255));
		initDesign();

		this.setVisible(true);
	}

	public void initDesign() {
		this.setLayout(null);

		cbMale = new JCheckBox("남성");
		cbMale.setBounds(20, 20, 100, 30);
		cbMale.setOpaque(false);
		cbMale.addItemListener(this);
		this.add(cbMale);

		// 라디오버튼 하나만 선택되도록 하려면 그룹으로 지어줘야함
		ButtonGroup bg = new ButtonGroup();

		int xpos = 20;

		for (int i = 0; i < rbColors.length; i++) {
			rbColors[i] = new JRadioButton(colorsNames[i]); // 라디오버튼생성
			rbColors[i].setBounds(xpos, 60, 100, 30);
			rbColors[i].setOpaque(false);
			rbColors[i].addActionListener(this);
			this.add(rbColors[i]);
			bg.add(rbColors[i]); // 그룹에 추가
			xpos += 110;
		}

		xpos = 20;

		for (int i = 0; i < cbCountry.length; i++) {
			cbCountry[i] = new JCheckBox(country[i]);
			cbCountry[i].setBounds(xpos, 100, 80, 30);
			cbCountry[i].setOpaque(false);
			cbCountry[i].addActionListener(this);
			this.add(cbCountry[i]);
			xpos += 90;
		}

		lblResult = new JLabel("", JLabel.CENTER);
		lblResult.setBounds(20, 150, 440, 300);
		lblResult.setOpaque(true);
		lblResult.setBorder(new LineBorder(Color.BLACK, 1));
		this.add(lblResult);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		for (int i = 0; i < rbColors.length; i++) {
			if (ob == rbColors[i]) {
				lblResult.setBackground(colors[i]);
			}
		}

		String s = "";

		for (int i = 0; i < cbCountry.length; i++) {
			if (cbCountry[i].isSelected() == true) {
				s += "[" + cbCountry[i].getText() + "]";
			}

		}
		
		String m = "";
		
		if (cbMale.isSelected() == true) {
			m = "나는 남자입니다.\n";
			lblResult.setText(s);
		} else {
			m = "나는 여자입니다.\n";
			lblResult.setText(s);
		}
		

		lblResult.setText(m+s);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();

		if (ob == cbMale) {
			if (cbMale.isSelected() == true) {
				String s = "나는 남자입니다.";
				lblResult.setText(s);
			} else {
				String s = "나는 여자입니다.";
				lblResult.setText(s);
			}

		}

	}

	public static void main(String[] args) {

		new WeekendAssignment("주말과제");

	}

}
