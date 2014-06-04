import java.util.List;
public class Student {
	Name n;
	long dob;
	String address;
	public Name getN() {
		return n;
	}
	public void setN(Name n) {
		this.n = n;
	}
	public long getDob() {
		return dob;
	}
	public void setDob(long l) {
		this.dob = l;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student n=" + n + ", dob=" + dob + ", address=" + address;
	}
}
