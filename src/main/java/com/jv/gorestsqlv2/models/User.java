package com.jv.gorestsqlv2.models;

/*
   {
        "id": 4033,
        "name": "Minakshi Bharadwaj",
        "email": "minakshi_bharadwaj@kuhic.org",
        "gender": "female",
        "status": "inactive"
    }

     {
        "name": "",
        "email": "",
        "gender": "",
        "status": ""
    }
*/

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private String gender;

    @Column ()
    private String status;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
