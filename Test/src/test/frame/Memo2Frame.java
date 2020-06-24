package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.Memo2Dao;
import test.dto.Memo2Dto;

/*
 * 	create table memo2
 * (num number primary key,
 * 	content varchar2(30),
 * 	regdate date);
 * 	
 * 	create sequence memo2_seq;
 * 
 * 	위와 같이 테이블과 시퀀스를 만들고 해당 테이블에 데이터를 
 * 	select, insert, update, delete 기능을 수행할수 있는 MemoFrame 을 만들어 보세요.
 * 
 * 	조건
 * 	1. num 칼럼의 값은 시퀀스를 이용해서 넣으세요.
 * 	2. regdate 칼럼(등록일)의 값은 sysdate 를 이용해서 넣으세요.
 * 	3. 수정은 content 만 수정 가능하게 하세요.
 * 	4. MemoDto, MemoDao 를 만들어서 프로그래밍 하세요.
 */
public class Memo2Frame extends JFrame implements ActionListener, KeyListener, PropertyChangeListener{
	JTextField inputMemo;
	JTable table;
	DefaultTableModel model;
	//생성자
	public Memo2Frame() {
		setLayout(new BorderLayout());
		
		JLabel label=new JLabel("메모");
		inputMemo=new JTextField(10);
		inputMemo.addKeyListener(this);
		
		JButton saveBtn=new JButton("저장");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete");
		
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(inputMemo);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table=new JTable();
		String[] columnNames= {"번호", "메모", "날짜"};
		model=new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0 || column==2) {
					return false;
				}else {
					return true;
				}
			}
		};
		table.setModel(model);
		table.addPropertyChangeListener(this);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		displayMemo();
	}
	
	public void displayMemo() {
		model.setRowCount(0);
		Memo2Dao dao=Memo2Dao.getInstens();
		List<Memo2Dto> list=dao.getList();
		
		for(Memo2Dto dto:list) {
			Object[] memolist= {dto.getNum(), dto.getContent(), dto.getRegdate()};
			model.addRow(memolist);
		}
	}
	
	public static void main(String[] args) {
		Memo2Frame f=new Memo2Frame();
		f.setBounds(100, 100, 800,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedrow=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedrow, 0);
				String content=(String)model.getValueAt(selectedrow, 1);
				String regdate=(String)model.getValueAt(selectedrow, 2);
				Memo2Dto dto=new Memo2Dto();
				dto.setNum(num);
				dto.setContent(content);
				dto.setRegdate(regdate);
				Memo2Dao dao=Memo2Dao.getInstens();
				dao.update(dto);
			}
			isEditing=true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			save();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void save() {
		String memo=inputMemo.getText();
		Memo2Dto dto=new Memo2Dto();
		dto.setContent(memo);
		Memo2Dao dao=Memo2Dao.getInstens();
		dao.insert(dto);
		inputMemo.setText("");
		displayMemo();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("save")) {
			save();
		}
		
		if(command.equals("delete")) {
			int selectedrow=table.getSelectedRow();
			int num=(int)model.getValueAt(selectedrow, 0);
			Memo2Dao dao=Memo2Dao.getInstens();
			dao.delete(num);
			
			displayMemo();
		}
	}
}
