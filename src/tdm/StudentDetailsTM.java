package tdm;

/**
 * @author sithum
 */
public class StudentDetailsTM {
    private String studentName;
    private String contactNo;
    private int age;
    private String gender;
    private String e_mail;
    private String course;

    public StudentDetailsTM(String studentName, String contactNo, int age, String gender, String e_mail, String course) {
        this.studentName = studentName;
        this.contactNo = contactNo;
        this.age = age;
        this.gender = gender;
        this.e_mail = e_mail;
        this.course = course;
    }

    public StudentDetailsTM() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "studentName='" + studentName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
