package com.simplon.senForageSpringProject.entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column
    private String prenom;
    @Column
    private String adresse;
    @Column
    private String tel;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village = new Village();

    //Chaque client sera ajouter par un utilisateur
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user= new User();

    public Client() {
    }

    public Client(int id, String nom, String prenom, String adresse, String tel, Village village, User user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.village = village;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

