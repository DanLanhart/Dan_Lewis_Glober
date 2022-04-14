package com.dan_lewis_glober.model;


import javax.persistence.*;

@Entity
@Table(name = "bug_reports")
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "bug_description")
    private String bug_description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBug_description() {
        return bug_description;
    }

    public void setBug_description(String bug_description) {
        this.bug_description = bug_description;
    }
}
