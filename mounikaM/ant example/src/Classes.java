import java.util.List;
public class Classes {
	List<Student> s;
	Teacher t;
	List<String> subject_list;
	String std;
	public List<Student> getS() {
		return s;
	}
	public void setS(List<Student> s) {	
		this.s = s;
	}
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
	public List<String> getSubject_list() {
		return subject_list;
	}
	public void setSubject_list(List<String> subject_list) {
		this.subject_list = subject_list;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	} 
	public String toString() {
		return "Classes s=" + s + ", t=" + t + ", subject_list="+ subject_list+ ", std=" + std;
	}
}

