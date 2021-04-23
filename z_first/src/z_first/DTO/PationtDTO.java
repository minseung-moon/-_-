package z_first.DTO;

public class PationtDTO {
	private String no;
	private String name;
	private String birth;
	private String gender;
	private String tel;
	private String city;
	
	public PationtDTO() {
		super();
	}
	public PationtDTO(String no, String name,String birth, String gender, String tel, String city) {
		super();
		this.no = no;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.tel = tel;
		this.city = city;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
