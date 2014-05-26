package SchoolXml;

import java.util.List;

public class SchoolDetails {
	private String teachername;
	private List<Students>stds;
	private List<Subjects>sub;
	private String classname;
	
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public List<Students> getStds() {
		return stds;
	}
	public void setStds(List<Students> stds) {
		this.stds = stds;
	}
	public List<Subjects> getSub() {
		return sub;
	}
	public void setSub(List<Subjects> sub) {
		this.sub = sub;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
}
