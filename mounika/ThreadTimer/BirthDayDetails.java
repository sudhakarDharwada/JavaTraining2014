package FirstTimer;

import java.sql.Timestamp;


public class BirthDayDetails {
	
public BirthDayDetails(String name,Timestamp birthTime) {
	this.name=name;
	this.birthTime=birthTime;
	
}
String name;
Timestamp birthTime;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Timestamp getBirthTime() {
	return birthTime;
}
public void setBirthTime(Timestamp birthTime) {
	this.birthTime = birthTime;
}


}
