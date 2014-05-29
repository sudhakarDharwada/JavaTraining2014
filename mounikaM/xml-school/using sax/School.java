import java.util.List;
public class School {
	List<Classes> classes;
	String s_name;
	public List<Classes> getClasses() 
	{
		return classes;
	}
	public void setClasses(List<Classes> classes) 
	{
		this.classes = classes;
	}
	public String getS_name() 
	{
		return s_name;
	}
	public void setS_name(String s_name) 
	{
		this.s_name = s_name;
	}
	public String toString() {
		return "classes=" + classes+" s_name"+ s_name;
	}	
}

