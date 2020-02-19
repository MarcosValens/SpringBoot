package com.valensmarcos.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "publicacio")
public class Publication {

    @Id
    @Column(name = "idpublicacio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titol", nullable = false)
    private String title;

    @Column(name = "contingut", nullable = false)
    private String content;

    @Column(name = "observacions", nullable = false)
    private String observations;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuari_idusuari", foreignKey = @ForeignKey(name = "usuari_idusuari"), nullable = false)
    private User user;

    public Publication() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
