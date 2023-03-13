package co.develhope.springrepositories2.entities;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    private String firstAppearance;
    @Column(nullable = false)
    private String inventor;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(long id, String name, String firstAppearance, String inventor) {
        this.id = id;
        this.name = name;
        this.firstAppearance = firstAppearance;
        this.inventor = inventor;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getFirstAppearance() {
        return firstAppearance;
    }

    public String getInventor() {
        return inventor;
    }

}