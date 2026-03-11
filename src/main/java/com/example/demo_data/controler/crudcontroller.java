package com.example.demo_data.controler;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo_data.dto.logincheckdto;
import com.example.demo_data.jwt.Jeneratetoken;
import com.example.demo_data.model.Authdata;
import com.example.demo_data.services.ddataservices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;









@RestController
@CrossOrigin("http://localhost:3000/")
public class crudcontroller {

    @Autowired
    private Jeneratetoken jtoken; 
    ddataservices dservices; 
    crudcontroller(ddataservices dservices){
           this.dservices = dservices; 
    }
    @PostMapping("/demodata")
    public Authdata postdata(@RequestBody Authdata data) {
        return dservices.post(data); 
        
    }
    @GetMapping("/user")
    public List<Authdata> getMethodName() {
        return dservices.Getbyall();
    }
    
    @GetMapping("/user/{id}")
    public Optional<Authdata> getMethodName(@PathVariable Integer id) {
        return dservices.Getbyid(id);
    }
    
    // @GetMapping("/users/{id}")
    // public String getMethodName(@PathVariable Integer id , @RequestBody logincheckdto checkdto) {
    //     return dservices.logincheck(id, checkdto);
    // }

    @GetMapping("/userlogin/{id}")
    public String getMethodName(@PathVariable Integer id , @RequestBody logincheckdto dto) {
        return dservices.logincheck(id, dto);
    }
    
      @GetMapping("/users/{id}")
      public Optional<Authdata> getMethod(@PathVariable Integer id) {
          return dservices.Gettbyid(id);
      }
      
    // delete mapping for do delete ; 
    @DeleteMapping("/deletedata/{id}")
    public String  Deletedata(@PathVariable Integer id ){
            return  dservices.Deletedata(id);
    }
    
    @PutMapping("partalyupdate/{id}")
    public String putMethodName(@PathVariable Integer id, @RequestBody Authdata userdata) {
        return dservices.updatedata(id,userdata);
    }
   


    @PostMapping("/postdata")
    public String senddata(@RequestBody Authdata data) {
        return dservices.postdata(data);
    }

    @GetMapping("/usergetdata/{email}")
    public Authdata getMethodName(@PathVariable String  email) {
         return dservices.getdata(email);
         
    }

    @GetMapping("/Admin")
    public String getuserdata() {
        return "data return sucessfully ";
    }
    
    // gererate token 
    // @PostMapping("/token")
    // public String tokengenerate(@RequestBody String email) {
    //      String webtoken = jtoken.gernateToken(email);
        
    //     return jtoken.extract(webtoken);

    // }
//    @PostMapping("/tokengenerate")
//    public String tokengenerates(@RequestBody String email) {
    
       
//        return jtoken.gernateToken(email);
//    }
//    @PreAuthorize("hasRole("ADMIN")");  // shortcut hasrole define; 
   @GetMapping("/admin")
   public String getdata() {
       return "admin dashboard";
   }
   
   // postmaping using email and add roles ; 
   @PostMapping("login-user")
   public String login (@RequestBody logincheckdto dto) {
       
       return jtoken.gernateToken(dto.getEmail() , dto.getRole());
   }
   
    
    
    
    
}
