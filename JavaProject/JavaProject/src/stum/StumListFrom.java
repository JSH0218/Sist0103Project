package stum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import oracleDb.DbConnect;

public class StumListFrom extends JFrame implements ActionListener {

	DefaultTableModel model;
	JTable table;
	JButton btnMain, btnDel, btnUpdate;
	Vector<StumDto> list;
	StuDbModel dbModel = new StuDbModel();
	int selectRow;
	String selectNum;

	public StumListFrom() {

		super("전체학생조회");
		this.setBounds(500, 100, 1000, 750);
		initDesign();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void initDesign() {

		this.setLayout(null);

		list = dbModel.selectStum();

		String[] title = { "학번", "이름", "국어", "영어", "수학", "평균" };
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 10, 700, 695);
		this.add(js);

		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(750, 350, 200, 100);
		this.add(btnUpdate);

		btnDel = new JButton("삭제");
		btnDel.setBounds(750, 475, 200, 100);
		this.add(btnDel);

		btnMain = new JButton("메인화면");
		btnMain.setBounds(750, 600, 200, 100);
		this.add(btnMain);

		this.writeDate();

		btnMain.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDel.addActionListener(this);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					selectRow = table.getSelectedRow();

					if (selectRow != -1) {
						selectNum = (String) table.getValueAt(selectRow, 0);

					}
				}

			}
		});

	}

	public void writeDate() {

		model.setRowCount(0);

		for (StumDto dto : list) {
			Vector<String> data = new Vector<String>();

			data.add(dto.getNum());
			data.add(dto.getName());
			data.add(String.valueOf(dto.getKor()));
			data.add(String.valueOf(dto.getEng()));
			data.add(String.valueOf(dto.getMat()));
			data.add(String.valueOf(dto.getAvg()));

			// 테이블 모델에 주기
			model.addRow(data);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();

		if (ob == btnMain) {
			this.setVisible(false);

			new StumMain().setVisible(true);

		} else if (ob == btnUpdate) {

			if (selectNum == null) {

				JOptionPane.showMessageDialog(null, "수정할 데이터를 선택해 주세요");
				return;

			}

			this.setVisible(false);

			new StumUpdateForm(selectNum);

		} else if (ob == btnDel) {

			dbModel.deleteStum(selectNum);
			list = dbModel.selectStum();
			this.writeDate();
			selectNum = null;

		}

	}

//	public static void main(String[] args) {
//		
//		new StumListFrom();
//
//	}

}
