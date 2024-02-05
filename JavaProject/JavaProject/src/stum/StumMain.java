package stum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StumMain extends JFrame implements ActionListener {

	JButton btnList, btnAdd, btnExit;

	public StumMain() {

		super("학생관리프로그램");
		this.setBounds(500, 100, 1000, 750);
		initDesign();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void initDesign() {

		this.setLayout(null);

		btnList = new JButton("조회");
		btnAdd = new JButton("추가");
		btnExit = new JButton("종료");

		btnList.setBounds(100, 300, 150, 100);
		btnAdd.setBounds(425, 300, 150, 100);
		btnExit.setBounds(750, 300, 150, 100);

		this.add(btnList);
		this.add(btnAdd);
		this.add(btnExit);

		btnList.addActionListener(this);
		btnAdd.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();

		if (ob == btnList) {

			new StumListFrom();
			this.setVisible(false);

		} else if (ob == btnAdd) {

			new StumAddForm();
			this.setVisible(false);

		} else if (ob == btnExit) {

			System.exit(0);

		}

	}

	public static void main(String[] args) {

		new StumMain();

	}

}
