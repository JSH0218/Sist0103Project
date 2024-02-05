package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class CheckRadio_03 extends JFrame implements ActionListener, ItemListener {

	Container cp;
	JCheckBox[] cbHobby = new JCheckBox[4];
	JCheckBox cbDriver, cbBold;
	JButton btnHobby;
	JLabel lblResult;

	public CheckRadio_03(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(1200, 200, 500, 500);
		cp.setBackground(new Color(255, 255, 255));
		initDesign();

		this.setVisible(true);
	}

	public void initDesign() {
		this.setLayout(null);

		cbDriver = new JCheckBox("운전면허");
		cbDriver.setBounds(20, 20, 100, 30);
		cbDriver.setOpaque(false);
		cbDriver.addItemListener(this); // ItemListner이벤트 핸들러와 연결되는 객체임을 표시
		this.add(cbDriver);

		cbBold = new JCheckBox("글꼴굵게");
		cbBold.setBounds(120, 20, 100, 30);
		cbBold.setOpaque(false);
		cbBold.addItemListener(this); // ItemListner이벤트 핸들러와 연결되는 객체임을 표시
		this.add(cbBold);

		lblResult = new JLabel("Have a Nice Day!!!", JLabel.CENTER);
		lblResult.setBounds(20, 200, 300, 50);
		lblResult.setBorder(new LineBorder(Color.GREEN, 5));
		this.add(lblResult);

		// 취미체크박스
		String[] hobbys = { "여행", "게임", "넷플릭스감상", "코딩" };
		int xpos = 20;

		for (int i = 0; i < cbHobby.length; i++) {
			cbHobby[i] = new JCheckBox(hobbys[i]);
			cbHobby[i].setBounds(xpos, 80, 80, 30);
			cbHobby[i].setOpaque(false);
			this.add(cbHobby[i]);
			xpos += 80;
		}

		// 버튼
		btnHobby = new JButton("나의취미출력");
		btnHobby.setBounds(60, 140, 200, 30);
		this.add(btnHobby);

		btnHobby.addActionListener(this); // 버튼에 이벤트 추가
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == btnHobby) {
			String s = "나의 취미는 ";
			int select = 0;

			for (int i = 0; i < cbHobby.length; i++) {
				if (cbHobby[i].isSelected() == true) {
					select++;
					s += "[" + cbHobby[i].getText() + "]";
				}

			}

			if (select == 0) {
				s += "없습니다";
			} else {
				s += "입니다.";
			}

			lblResult.setText(s);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();

		if (ob == cbDriver) {
			String s = "체크상태: " + cbDriver.isSelected() + " ,텍스트: " + cbDriver.getText();
			lblResult.setText(s);
		} else if (ob == cbBold) {
			if (cbBold.isSelected()) {
				lblResult.setFont(new Font("", Font.BOLD, 12));
			} else {
				lblResult.setFont(new Font("", Font.PLAIN, 12));
			}
		}

	}

	public static void main(String[] args) {

		new CheckRadio_03("체크박스_03");

	}

}
