/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author cedricstephani
 */
public class Student {
    private String id; //this is simply their student ID to keep it simple. 
    private String firstName; 
    private String surname; 
    private String username; 
    private String password; 
    private String email; 
    private String categories; 
    private String subCategories;
    private boolean searching; 

    public Student(String id, String firstName, String surname, String username, String password, String email, String categories, String subCategories, boolean searching) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.categories = categories;
        this.subCategories = subCategories;
        this.searching = searching;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isSearching() {
        return searching;
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(String subCategories) {
        this.subCategories = subCategories;
    }

   
    
    
    
}
