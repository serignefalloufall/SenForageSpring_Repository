package com.simplon.senForageSpringProject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="village")
public class Village implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    @OneToMany(mappedBy = "village", fetch = FetchType.LAZY)
    private List<Client> clients = new ArrayList<>();

    //Chaque village sera ajouter par un utilisateur
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user= new User();


    public Village() {
    }

    public Village(String nom, List<Client> clients, User user) {
        this.nom = nom;
        this.clients = clients;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

