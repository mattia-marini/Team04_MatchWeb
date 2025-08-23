package mmarini.unitn.team04_matchweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {

    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
