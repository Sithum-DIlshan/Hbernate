package entity;

import entity.embedded.Name;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sithum
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {
    @Id
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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Program> programList = new ArrayList();

    public Student(String studentId, Name name, String address, String parentName, String contactNo, LocalDate dob, int age, String gender, String email, String province, List<Program> programList) {
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
        this.programList = programList;
    }

   /* public Student(String studentId, Name name, String address, String parentName, String contactNo, LocalDate dob, int age, String gender, String email, String province, String course) {
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
    }*/

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

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId='" + studentId + '\'' + ", name=" + name + ", address='" + address + '\'' + ", parentName='" + parentName + '\'' + ", contactNo='" + contactNo + '\'' + ", dob=" + dob + ", age=" + age + ", gender='" + gender + '\'' + ", email='" + email + '\'' + ", province='" + province + '\'' + ", programList=" + programList + '}';
    }
}
