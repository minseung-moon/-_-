package z_first.DTO;

public class ResultShowDTO {
	private String pationtNo;
	private String pationtName;
	private String labName;
	private String sdate;
	private String status;
	private String ldate;
	private String result;
	
	public ResultShowDTO() {
		super();
	}

	public String getPationtNo() {
		return pationtNo;
	}

	public void setPationtNo(String pationtNo) {
		this.pationtNo = pationtNo;
	}

	public String getPationtName() {
		return pationtName;
	}

	public void setPationtName(String pationtName) {
		this.pationtName = pationtName;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
