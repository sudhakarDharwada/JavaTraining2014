class StudentDetails{
	int studentId;
    String studentName;
    String studentDepartment;
    StudentDetails()
    {
	}
    StudentDetails(int id, String name,String dept){
        this.studentId = id;
        this.studentName = name;
        this.studentDepartment=dept;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }     
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentDepartment() {
        return studentDepartment;
    } 
    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }
    public String toString() {
        return ("StudentID:"+this.getStudentId()+" Student Name: "+ this.getStudentName() +" Department : " + this.getStudentDepartment());
   }
}
