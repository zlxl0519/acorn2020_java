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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dao.MemoDao;
import test.dto.MemoDto;

/*
 * 	create table memo
 * (num number primary key,
 * 	content varchar2(30),
 * 	regdate date);
 * 	
 * 	create sequence memo_seq;
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
public class MemoFrame extends JFrame implements ActionListener, KeyListener, PropertyChangeListener{
	JTextField inputMemo;
	DefaultTableModel model;
	JTable table;
	//생성자
	public MemoFrame() {
		setLayout(new BorderLayout());
		
		JLabel label=new JLabel("메모");
		inputMemo=new JTextField(10);
		inputMemo.addKeyListener(this);
		
		JButton saveBtn=new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		table=new JTable();
		String[] columnNames= {"번호", "메모", "날짜"};
		model= new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {//변경할수 있는지 여부
				if(column==0 || column==2) {// 0번째, 2번째 칼럼은 수정불가
					return false;
				}
				return true;
			}
		};
		
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(inputMemo);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		displayList();
		
		table.addPropertyChangeListener(this);
		
	}
	
	public void displayList() {
		model.setRowCount(0);
		MemoDao dao=MemoDao.getInstance();
		List<MemoDto> list=dao.getList();
		
		for(MemoDto dto:list) {
			Object[] memo= {dto.getNum(), dto.getContent(), dto.getRegdate()};
			model.addRow(memo);
		}
	}
	
	//main메소드
	public static void main(String[] args) {
		MemoFrame f=new MemoFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	public void save() {
		String memo=inputMemo.getText();
		MemoDto dto=new MemoDto();
		dto.setContent(memo);
		MemoDao dao=MemoDao.getInstance();
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, "메모가 추가되었습니다.");
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패");
		}
		displayList();
		inputMemo.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("save")) {
			save();
		}
		
		if(command.equals("delete")) {
			int selectedrow=table.getSelectedRow();
			if(selectedrow == -1) {
				return;
			}
			
			int num=(int)model.getValueAt(selectedrow, 0);
			MemoDao dao=MemoDao.getInstance();
			dao.delete(num);
			
			displayList();
		}
	}

	@Override
	public void keyPressed(KeyEvent e1) {
		int code=e1.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			save();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent e2) {
		System.out.println(e2.getPropertyName());// 어떨때 property가 어떤 문자열로 변하는지 관찰
		
		if(e2.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedrow=table.getSelectedRow();
				String updateContent=(String)model.getValueAt(selectedrow, 1);
				MemoDto dto=new MemoDto();
				dto.setContent(updateContent);
				MemoDao dao=MemoDao.getInstance();
				dao.update(dto);
				
				isEditing=false;
			}
			isEditing=true;//위쪽에 있으면 수정하지도 않았는데 update 메소드가 사용된다.
		}
	}
}
