package domain;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * Student.java
 *
 * @author cedricstephani
 */

public class Student {
    @NotNull(message = "ID must be provided.")
    @NotBlank(message = "ID must be provided")
    private String id; //this is simply their student ID to keep it simple. 
    
    @NotNull(message = "name must be provided.")
    @NotBlank(message = "name must be provided")
    @Length(min=2, message="name must contain at least two characters.")
    private String firstName; 
    
    @NotNull(message = "surname must be provided.")
    @NotBlank(message = "surname must be provided")
    @Length(min=2, message="surname must contain at least two characters.")
    private String surname; 
    
    @NotNull(message = "username must be provided.")
    @NotBlank(message = "username must be provided")
    @Length(min=5, message="username must contain at least five characters.")
    private String username; 
    
    @NotNull(message = "password must be provided.")
    @NotBlank(message = "password must be provided")
    @Length(min=6, message="password must contain at least six characters.")
    private String password; 
    
    @NotNull(message = "email must be provided.")
    @NotBlank(message = "email must be provided")
    private String email; 
    private String category; 
    private boolean searching; 

    public Student(String id, String firstName, String surname, String username, String password, String email, String category, boolean searching) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
