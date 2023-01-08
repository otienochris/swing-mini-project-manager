package main;

import main.model.Project;
import main.model.Student;

/**
 *
 * @author
 */
public class ProjectAssignment {
    
    private Integer id;
    private AssignmentStatusEnum status;
    private Student student;
    private Project project;

    public ProjectAssignment() {
    }
    
    

    public ProjectAssignment(Integer id, AssignmentStatusEnum status, Student student, Project project) {
        this.id = id;
        this.status = status;
        this.student = student;
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AssignmentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatusEnum status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectAssignment{" + "id=" + id + ", status=" + status + ", student=" + student + ", project=" + project + '}';
    }
    
    
    
    
    
    
}
