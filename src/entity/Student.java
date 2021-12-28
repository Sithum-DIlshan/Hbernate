package entity;

import entity.embedded.Name;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author sithum
 */
@Entity
@Table(name = "student")
public class Student {
    @Id /*@GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")*/
    private String studentId;
    private Name name;
    private String address;
    private String parentName;
    private String contactNo;
    private LocalDate dob;
    private int age;
    private String gender;
    private String email;
    private String province;
    private String course;

    public Student(String studentId,Name name, String address, String parentName, String contactNo, LocalDate dob, int age, String gender, String email, String province, String course) {
        this.studentId = studentId;
        this.name = name;
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

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
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
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name=" + name +
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
