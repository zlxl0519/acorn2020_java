package test.dto;

public class MemoDto {
	private int num;
	private String content;
	private String regdate;
	
	public MemoDto() {
		
	}

	public MemoDto(int num, String regdate, String content) {
		super();
		this.num = num;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
