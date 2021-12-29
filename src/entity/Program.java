package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sithum
 */
@Entity
public class Program {

    @Id
    private String pId;
    private String program;
    private int duration;
    private double fee;
    @ManyToMany(mappedBy = "programList")
    private List<Student> studentList = new ArrayList<>();

    public Program(double fee, String pId, String program, int duration, List<Student> studentList) {
        this.fee = fee;
        this.pId = pId;
        this.program = program;
        this.duration = duration;
        this.studentList = studentList;
    }

    public Program(String pId, String program, int duration, double fee) {
        this.pId = pId;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public Program() {
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Program{" +
                "fee=" + fee +
                ", pId='" + pId + '\'' +
                ", program='" + program + '\'' +
                ", duration=" + duration +
                ", studentList=" + studentList +
                '}';
    }
}
