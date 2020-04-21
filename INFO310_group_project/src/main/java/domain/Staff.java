package domain;

/**
 * Staff.java
 * 
 * @author cedricstephani
 */
public class Staff {
    private Integer staffID;
    private String firstname; 
    private String surname; 
    private String username; 
    private String password; 
    private String email; 
    private String category;
    private boolean searching; 

    public Staff(Integer staffID, String firstname, String surname, String username, String password, String email, String category, boolean searching) {
        this.staffID = staffID;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.category = category;
        this.searching = searching;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSearching() {
        return searching;
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }
}
