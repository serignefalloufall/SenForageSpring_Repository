package com.simplon.senForageSpringProject.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="roles")
public class Roles implements Serializable
{
    @Id //pour la cle primaire
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //AUTO INCREMENT
    private int id;
    @Column
    private String nom;
    @ManyToMany(mappedBy="roles")
    private List<User> users =new ArrayList<User>();
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
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Roles(int id, String nom, List<User> users) {
        super();
        this.id = id;
        this.nom = nom;
        this.users = users;
    }
    public Roles() {
        super();
    }



}
