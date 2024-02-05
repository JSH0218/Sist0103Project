package stum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StumAddForm extends JFrame implements ActionListener {

	JLabel lblName, lblKor, lblEng, lblMat;
	JTextField tfName, tfKor, tfEng, tfMat;
	JButton btnAdd, btnMain;

	StuDbModel model = new StuDbModel();

	public StumAddForm() {

		super("학생추가");
		this.setBounds(750, 100, 500, 750);
		initDesign();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void initDesign() {

		this.setLayout(null);

		lblName = new JLabel("이름");
		lblName.setBounds(125, 100, 100, 100);
		this.add(lblName);

		lblKor = new JLabel("국어");
		lblKor.setBounds(125, 200, 100, 100);
		this.add(lblKor);

		lblEng = new JLabel("영어");
		lblEng.setBounds(125, 300, 100, 100);
		this.add(lblEng);

		lblMat = new JLabel("수학");
		lblMat.setBounds(125, 400, 100, 100);
		this.add(lblMat);

		tfName = new JTextField();
		tfName.setBounds(225, 125, 100, 50);
		this.add(tfName);

		tfKor = new JTextField();
		tfKor.setBounds(225, 225, 100, 50);
		this.add(tfKor);

		tfEng = new JTextField();
		tfEng.setBounds(225, 325, 100, 50);
		this.add(tfEng);

		tfMat = new JTextField();
		tfMat.setBounds(225, 425, 100, 50);
		this.add(tfMat);

		btnAdd = new JButton("추가");
		btnAdd.setBounds(100, 550, 100, 50);
		this.add(btnAdd);

		btnMain = new JButton("메인화면");
		btnMain.setBounds(250, 550, 100, 50);
		this.add(btnMain);

		btnMain.addActionListener(this);
		btnAdd.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();

		if (ob == btnMain) {

			this.setVisible(false);

			new StumMain().setVisible(true);

		} else if (ob == btnAdd) {

			StumDto dto = new StumDto();

			dto.setName(tfName.getText());
			dto.setKor(Integer.parseInt(tfKor.getText()));
			dto.setEng(Integer.parseInt(tfEng.getText()));
			dto.setMat(Integer.parseInt(tfMat.getText()));

			model.insertStum(dto);

			tfName.setText("");
			tfKor.setText("");
			tfEng.setText("");
			tfMat.setText("");

		}

	}

//	public static void main(String[] args) {
//		
//		new StumAddForm();
//
//	}

}
