package com.example.demo_data.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo_data.dto.logincheckdto;
import com.example.demo_data.model.Authdata;
import com.example.demo_data.repositery.ddatarepo;

@Service
public class ddataservices {
  
    ddatarepo drepo; 

    PasswordEncoder pEncoder; 

    ddataservices( ddatarepo drepo , PasswordEncoder pEncoder){
         this.drepo = drepo; 
         this.pEncoder = pEncoder;
    }
    
    @PostMapping Authdata post1(Authdata data){
     String password = data.getPassword(); 
     String Ecodepass = pEncoder.encode(password);
         data.setPassword(Ecodepass);
        drepo.save(data);
        return (data);
    }
    public Authdata post( Authdata data){

        drepo.save(data);
        return data;
    }

      public List<Authdata>Getbyall(){
           return drepo.findAll();
      }

      public Optional<Authdata> Getbyid(Integer id){
           return drepo.findById(id);
      }

    //   public String logincheck1(Integer id , logincheckdto checkdto ){  // same code 
    //         Optional<Authdata> usercheck = drepo.findById(id);
    //         if (usercheck.isPresent()){
    //                if(usercheck.get().getEmail().equals(checkdto.getEmail())){
    //                 if(usercheck.get().getPassword().equals(checkdto.getPassword())){
    //                      return "logged in "; 
    //                 }
    //                }
    //         }return "invalid user"; 
    //   }
      
      public String logincheck(Integer id , logincheckdto dto){
          Optional<Authdata> usercheckdata = drepo.findById(id);
          if(usercheckdata.isPresent()){
               if(usercheckdata.get().getEmail().equals(dto.getEmail())){
                    if(usercheckdata.get().getPassword().equals(dto.getPassword())){
                         return "user login in account";
                    }
               }
          }return "invalid user";
      }

      public Optional<Authdata> Gettbyid( Integer id ){
               return drepo.findById(id);
      }

      public String Deletedata( Integer id ){
               drepo.deleteById(id);
              return "delete sucessfully";
      }

      // partialy update
      public String updatedata(Integer id, Authdata userdata) {
            Authdata present_updat_data = drepo.findById(id).orElseThrow();
            if(userdata.getName() != null){
              present_updat_data.setName(userdata.getName());
            }
            if(userdata.getEmail() != null){
               present_updat_data.setEmail(userdata.getEmail());
            }
            if(userdata.getPassword() != null){
               present_updat_data.setPassword(userdata.getPassword());
            }
            drepo.save(present_updat_data);
            return "update sucessfully";

      }
    

       public String postdata(Authdata data ){
            drepo.save(data);
            return "data post ";
       }

       public Authdata getdata(String email) {
          return drepo.findByEmail(email);

       }
      }

