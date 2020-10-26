package com.simplon.senForageSpringProject.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length=200)
    private String nom;

    @Column(length=200)
    private String prenom;

    @Column(length=100)
    private String email;

    @Column
    private String password;

    @Column
    private int etat;

    @OneToMany(mappedBy="user")
    private List<Client> clients=new ArrayList<>();

    @OneToMany(mappedBy="user")
    private List<Village> villages =new ArrayList<Village>();

    @ManyToMany
    private List<Roles> roles =new ArrayList<Roles>();

    public User() {
    }

    public User(int id, String nom, String prenom, String email, String password, int etat, List<Client> clients, List<Village> villages, List<Roles> roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.etat = etat;
        this.clients = clients;
        this.villages = villages;
        this.roles = roles;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Village> getVillages() {
        return villages;
    }

    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}