package dto;

import entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sithum
 */
public class ProgramDTO {
    private String pId;
    private String program;
    private int duration;
    private double fee;
    private List<Student> studentList = new ArrayList<>();

    public ProgramDTO(String pId, String program, int duration, double fee) {
        this.pId = pId;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public ProgramDTO(String pId, String program, int duration, double fee, List<Student> studentList) {
        this.pId = pId;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
        this.studentList = studentList;
    }

    public ProgramDTO() {
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
