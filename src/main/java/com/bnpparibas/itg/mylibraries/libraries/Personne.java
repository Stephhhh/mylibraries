package com.bnpparibas.itg.mylibraries.libraries;

public class Personne {

    private String nom;

    private String prenom;

    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Personne() {
    }

    public String getNom() {
        return nom;
    }

    public Personne setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Personne setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Personne setAge(int age) {
        this.age = age;
        return this;
    }
}
