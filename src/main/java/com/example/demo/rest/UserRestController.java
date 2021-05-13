package com.example.demo.rest;

import com.example.demo.model.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class UserRestController {


//    @GetMapping()
//    @PreAuthorize("hasAuthority('users:write')")
//    public String getAll(){
//        return "HELLO users";
//    }
//
//    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('users:write')")
//    public String getById(@PathVariable Long id){
//        return "HELLO";
//    }
//
//    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('users:write')")
//    public String create( @RequestBody User user){
//        return "HELLO";
//    }
//    @DeleteMapping("/del/{id}")
//    @PreAuthorize("hasAuthority('users:write')")
//    public String deleteById(@PathVariable Long id){
//        this.users.removeIf(user -> user.getId().equals(id));
//        return "redicate:/";
//    }
}
