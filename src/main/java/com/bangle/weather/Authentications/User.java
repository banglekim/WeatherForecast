package com.bangle.weather.Authentications;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    public User ( ) {
    }

    public User ( String username, String password ) {
        this.username = username;
        this.password = password;
    }

    public Integer getUserid ( ) {
        return userid;
    }

    public void setUserid ( Integer userid ) {
        this.userid = userid;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }
}
