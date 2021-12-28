package dto;

import java.time.LocalDate;
import java.util.Date;

public class StudentDTO {
    private String studentId;
    private String fName;
    private String mName;
    private String lName;
    private String address;
    private String parentName;
    private String contactNo;
    private LocalDate dob;
    private int age;
    private String gender;
    private String email;
    private String province;
    private String course;

    public StudentDTO(String studentId, String fName, String mName, String lName, String address, String parentName, String contactNo, LocalDate dob, int age, String gender, String email, String province, String course) {
        this.studentId = studentId;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.address = address;
        this.parentName = parentName;
        this.contactNo = contactNo;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.province = province;
        this.course = course;
    }

    public StudentDTO() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", fName='" + fName + '\'' +
                ", mName='" + mName + '\'' +
                ", lName='" + lName + '\'' +
                ", address='" + address + '\'' +
                ", parentName='" + parentName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
