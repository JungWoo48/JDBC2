package edu.kh.jdbc.model.vo;


public class TestVO {
	
	private int testNo;
	private String testtitle;
	private String tsetContent;
	
	// 기본 생성자
	public TestVO() {}

	//매개변수 생성자
	public TestVO(int testNo, String testtitle, String tsetContent) {
		super();
		this.testNo = testNo;
		this.testtitle = testtitle;
		this.tsetContent = tsetContent;
	}

	//getter setter
	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTesttitle() {
		return testtitle;
	}

	public void setTesttitle(String testtitle) {
		this.testtitle = testtitle;
	}

	public String getTsetContent() {
		return tsetContent;
	}

	public void setTsetContent(String tsetContent) {
		this.tsetContent = tsetContent;
	}

	//toString 오버라이딩
	@Override
	public String toString() {
		return "TestVO [testNo=" + testNo + ", testtitle=" + testtitle + ", tsetContent=" + tsetContent + "]";
	}
	
	
	
}
