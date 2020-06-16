package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Quiz03 extends JFrame implements ActionListener{
	//필드
	JTextArea area;
	
	//생성자
	public Quiz03() {
		setTitle("나의 파일");
		setLayout(new BorderLayout());
		//메뉴 아이템 3개 만들기
		JMenuItem item_new=new JMenuItem("New");
		JMenuItem item_open=new JMenuItem("Open");
		JMenuItem item_save=new JMenuItem("Save");
		
		item_new.setActionCommand("new");
		item_new.addActionListener(this);
		item_open.setActionCommand("open");
		item_open.addActionListener(this);
		item_save.setActionCommand("save");
		item_save.addActionListener(this);
		
		//메뉴에 아이템 추가
		JMenu menu1=new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		//메뉴바에 메뉴 추가
		JMenuBar mb=new JMenuBar();
		mb.add(menu1);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		//텍스트 area 를 프레임의 가운데에 배치
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.YELLOW);
		area.setVisible(false);
	}
	public static void main(String[] args) {
		Quiz03 f=new Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("new")) {//새로운거 생성
			area.setVisible(true);
			
		}else if(command.equals("open")) {//열기 눌렀을때
			area.setVisible(true);
			open();
			
		}else if(command.equals("save")) {//저장 눌렀을때
			save();
		}
	}

	//open 눌렀을때 파일 문자 내용가져오기
	public void open() {
		JFileChooser chooser=new JFileChooser("c:/acorn2020/myFolder");
		int returnVal=chooser.showOpenDialog(null);
		//열기를 눌렀을때 
		if(returnVal== chooser.APPROVE_OPTION) {
			File f=chooser.getSelectedFile();
			try {
				FileReader txt=new FileReader(f);
				BufferedReader str=new BufferedReader(txt);
				while(true) {
					String line=str.readLine();
					if(line==null) {
						break;
					}
					area.append(line);;
					area.append("\r\n");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//열기눌렀을때 종료
		
	}
	//저장할때 동작
	public void save() {
		JFileChooser chooser=new JFileChooser("c:/acorn2020/myFolder");
		int inputSave=chooser.showSaveDialog(null);
		
		if(inputSave==chooser.APPROVE_OPTION) {
			//area 에 쓴것을 txt 로 저장하기
			File file=chooser.getSelectedFile();
			FileWriter fw=null;
			BufferedWriter bw=null;
			String str=area.getText();
			try {
				fw = new FileWriter(file);
				bw=new BufferedWriter(fw);
				bw.write(str);
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(fw!=null)fw.close();
					if(bw!=null)bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
}
