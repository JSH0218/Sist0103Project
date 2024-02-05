package stum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StumUpdateForm extends JFrame implements ActionListener {

	JLabel lblName, lblKor, lblEng, lblMat;
	JTextField tfName, tfKor, tfEng, tfMat;
	JButton btnUpdate, btnList;
	StuDbModel model=new StuDbModel();
	String selectNum;
	ArrayList<String> list=new ArrayList<String>();

	public StumUpdateForm(String selectNum) {

		super("학생수정");
		this.setBounds(750, 100, 500, 750);
		this.selectNum=selectNum;
		list=model.selectUpdateStum(selectNum);
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

		tfName = new JTextField(list.get(0));
		tfName.setBounds(225, 125, 100, 50);
		this.add(tfName);

		tfKor = new JTextField(list.get(1));
		tfKor.setBounds(225, 225, 100, 50);
		this.add(tfKor);

		tfEng = new JTextField(list.get(2));
		tfEng.setBounds(225, 325, 100, 50);
		this.add(tfEng);

		tfMat = new JTextField(list.get(3));
		tfMat.setBounds(225, 425, 100, 50);
		this.add(tfMat);

		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(100, 550, 100, 50);
		this.add(btnUpdate);

		btnList = new JButton("조회화면");
		btnList.setBounds(250, 550, 100, 50);
		this.add(btnList);
		
		btnList.addActionListener(this);
		btnUpdate.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();

		if (ob == btnList) {
			
			this.setVisible(false);

			new StumListFrom().setVisible(true);
			
		}else if(ob==btnUpdate) {
			
			StumDto dto=new StumDto();
			
			dto.setName(tfName.getText());
			dto.setKor(Integer.parseInt(tfKor.getText()));
			dto.setEng(Integer.parseInt(tfEng.getText()));
			dto.setMat(Integer.parseInt(tfMat.getText()));
			
			model.updateStum(selectNum,dto);
			
			JOptionPane.showMessageDialog(null, "수정되었습니다");
			
		}

	}

//	public static void main(String[] args) {
//
//		new StumUpdateForm();
//
//	}

}
