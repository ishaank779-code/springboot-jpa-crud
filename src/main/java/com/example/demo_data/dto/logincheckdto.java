package com.example.demo_data.dto;

import com.example.demo_data.model.Enum.Roles;

public class logincheckdto {
   private String email;
   private String password; 
   private Roles role;
    public Roles getRole() {
    return role;
}
   public void setRole(Roles role) {
    this.role = role;
   }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    } 
}
