package com.example.demo_data.model;

import com.example.demo_data.model.Enum.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Authdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String Name; 
    private String email; 
    private String password; 

    @Enumerated(EnumType.STRING) // ye type convert krta hai enum ke 0, 1 to string ; 
    private Roles role; 

    public Roles getRole() {
      return role;
    }
    public void setRole(Roles role) {
      this.role = role;
    }
    public int getId(){
        return id; 
    }
    public void setId(int id){
         this.id = id; 
    }
      public String getName(){
        return Name; 
      } 
      public void setName(String Name){
           this.Name = Name; 
      }
      public String getEmail(){
        return email; 
      }
      public void setEmail(String email){
                this.email = email; 
      }
      public String getPassword(){
        return password; 
      }
      public void setPassword(String password){
         this.password = password; 
      }

}
