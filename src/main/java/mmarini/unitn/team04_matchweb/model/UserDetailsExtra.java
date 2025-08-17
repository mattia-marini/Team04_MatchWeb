package mmarini.unitn.team04_matchweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "USER_DETAILS_EXTRA")
public class UserDetailsExtra {

    @Id
    private String username;

    private String firstName;
    private String lastName;
    private String mail;
    private LocalDate birthDate;


    public UserDetailsExtra() {
    }

    public UserDetailsExtra(String username, String firstName, String lastName, String mail, LocalDate birthDate) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
