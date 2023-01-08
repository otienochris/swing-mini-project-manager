package main.model;

import java.time.LocalDateTime;

public class Project {
    
    private Integer id;
    private String title;
    private String description;
    private String content;
    private LocalDateTime dueDate;
    private Boolean isAssigned;
    private Student student;
    private Lecturer lecturer;
    private String category;
    private Boolean isActive;


    public Project() {
        isAssigned = false;
        dueDate = LocalDateTime.now().plusMonths(6);
        this.isActive = true;
    }
    
    public Project(Integer id, String title, String description, String content, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.content = content;
        
        // defaults
        isAssigned = false;
        dueDate = LocalDateTime.now().plusMonths(6);
        this.isActive = true;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(Boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate.toLocalDate() + ", isAssigned=" + isAssigned + ", student=" + student + ", lecturer=" + lecturer + '}';
    }
    
    
    
}
