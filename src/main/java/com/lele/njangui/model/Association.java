package com.lele.njangui.model;

import javax.persistence.*;

@Entity
@Table(name = "association")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String associationName;

    @OneToOne
    @JoinColumn(name = "president_user_id")
    private User president;

    @OneToOne
    @JoinColumn(name = "secretary_user_id")
    private User secretary;

    @OneToOne
    @JoinColumn(name = "accountant_user_id")
    private User accountant;

    public Association() {
    }

    public Association(Long id, String associationName, User president, User secretary, User accountant) {
        this.id = id;
        this.associationName = associationName;
        this.president = president;
        this.secretary = secretary;
        this.accountant = accountant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public User getPresident() {
        return president;
    }

    public void setPresident(User president) {
        this.president = president;
    }

    public User getSecretary() {
        return secretary;
    }

    public void setSecretary(User secretary) {
        this.secretary = secretary;
    }

    public User getAccountant() {
        return accountant;
    }

    public void setAccountant(User accountant) {
        this.accountant = accountant;
    }
}
