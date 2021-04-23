package z_first.DTO;

public class ResultDTO {
	private String no;
	private String code;
	private String sdate;
	private String status;
	private String ldate;
	private String result;
	
	public ResultDTO() {
		super();
	}
	public ResultDTO(String no, String code, String sdate, String status, String ldate, String result) {
		super();
		this.no = no;
		this.code = code;
		this.sdate = sdate;
		this.status = status;
		this.ldate = ldate;
		this.result = result;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
