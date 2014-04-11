package fileobjectread;

import java.sql.Time;

public class Studentdatedtls 
{
		int id;
		Time time;
		boolean flag;
		public Studentdatedtls(int id,String time,String flag)
		{
		   	this.id=id;
		   	this.time=Time.valueOf(time);
		    this.flag=Boolean.parseBoolean(flag);
		}
		public Time getTime() {
			return time;
		}
		public void setTime(Time t) {
			this.time = t;
		}
		public void setId(int id) {
		    this.id= id;
		}
		public int getId() {
			return this.id;
		}
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
}


