package com.bangle.weather.Authentications;

import javax.persistence.*;

@Entity
@Table(name = "user_auth_group")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String usename;

    @Column(name = "auth_group")
    private String role;

    public Role ( ) {
    }

    public Role ( String usename, String role ) {
        this.usename = usename;
        this.role = role;
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getUsename ( ) {
        return usename;
    }

    public void setUsename ( String usename ) {
        this.usename = usename;
    }

    public String getRole ( ) {
        return role;
    }

    public void setRole ( String role ) {
        this.role = role;
    }
}
