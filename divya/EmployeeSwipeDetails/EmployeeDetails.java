class EmployeeDetails{

      	  int empId;
          boolean flag;
          Date date;
          EmployeeDetails(){
          }

          EmployeeDetails(int id, boolean flag,Date date){
              this.empId = id;
              this.flag = flag;
              this.date=date;
          }

          public int getEmpId() {
              return empId;
          }

          public void setEmpId(int empId) {
              this.empId = empId;
          }

          public boolean getFlag() {
              return flag;
          }     

          public void setFlag(boolean flag) {
              this.flag = flag;
          }

          public Date getEDate() {
              return date;
          } 

          public void setEDate(Date date) {
              this.date = date;
          }

         public String toString() {
              return ("EmpId:" + this.getEmpId()+" IN/OUT: "+ this.getFlag() +" Date : " + this.getEDate());
         }
}

