package main.model;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
class Enrollment {
    private Integer id;
    private Project project;
    private Student student;
    private LocalDateTime assignedOn;

    public Enrollment(Integer id, Project project, Student student, LocalDateTime assignedOn) {
        this.id = id;
        this.project = project;
        this.student = student;
        this.assignedOn = assignedOn;
    }

    public Enrollment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getAssignedOn() {
        return assignedOn;
    }

    public void setAssignedOn(LocalDateTime assignedOn) {
        this.assignedOn = assignedOn;
    }
    
    
}
