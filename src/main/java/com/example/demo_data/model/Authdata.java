package com.example.demo_data.model;

import jakarta.persistence.Entity;
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
