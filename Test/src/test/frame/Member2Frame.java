package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.Member2Dao;
import test.dto.Member2Dto;

public class Member2Frame extends JFrame implements ActionListener, KeyListener{
	JTextField inputName;
	JTextField inputaddr;
	DefaultTableModel model;
	JTable table;
	//생성자
	public Member2Frame() {
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("이름");
		inputName=new JTextField(10);
		JLabel label2=new JLabel("주소");
		inputaddr=new JTextField(10);
		
		JButton saveBtn=new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputaddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table=new JTable();
		String[] columnNames= {"번호", "이름", "주소"};
		model=new DefaultTableModel(columnNames, 0);
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		displayMember();
	}
	//리스트가 보이게 하는 메소드
	public void displayMember() {
		model.setRowCount(0);
		Member2Dao dao=Member2Dao.getInstance();
		List<Member2Dto> list=dao.getList();
		for(int i=0; i<list.size(); i++) {
			Member2Dto dto=list.get(i);
			Object[] member= {dto.getNum(), dto.getName(), dto.getAddr()};
			model.addRow(member);
		}
	}
	//main메소드
	public static void main(String[] args) {
		Member2Frame f=new Member2Frame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	public void save() {
		String name=inputName.getText();
		String addr=inputaddr.getText();
		Member2Dto dto=new Member2Dto();
		dto.setName(name);
		dto.setAddr(addr);
		Member2Dao dao=Member2Dao.getInstance();
		boolean isSucces=dao.insert(dto);
		if(isSucces) {
			JOptionPane.showMessageDialog(this, name+" 님의 내용이 추가되었습니다.");
		}else {
			JOptionPane.showMessageDialog(this, "추가실패");
		}
		displayMember();
		inputName.setText("");
		inputaddr.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("save")) {
			save();
		}//save 버튼 종료
		
		if(command.equals("delete")) {
			//1.선택된 로우 인덱스를 읽어온다.
			int selectedrow=table.getSelectedRow();
			// 로우 를 선택했을때 안했을때
			if(selectedrow==-1) {
				return;
			}
			//2. 선택된 로우의 첫번째 칼럼 숫자를 읽어온다.
			int num=(int)model.getValueAt(selectedrow, 0);
			//3. Member2Dao 객체이용해서 해당 회원의 정보를 삭제한다.
			Member2Dao dao=Member2Dao.getInstance();
			dao.delete(num);
			//4. table 회원목록 다시출력
			displayMember();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
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
	
}
