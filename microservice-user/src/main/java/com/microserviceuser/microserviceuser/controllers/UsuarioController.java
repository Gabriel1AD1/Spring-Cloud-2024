package com.microserviceuser.microserviceuser.controllers;

import com.microserviceuser.microserviceuser.models.entitys.User;
import com.microserviceuser.microserviceuser.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//Handler Controller
/*
* Use Controller directorions Request
*
* */
@RestController
public class UsuarioController {
    private final UserService service;

    public UsuarioController(UserService service) {
        this.service = service;
    }

    //List of user
    @GetMapping
    public List<User> listar(){
        return service.listAll();
    }

    //PathVariable ID by handler
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable(name = "id") Long id){
        //Optional was created for store user o null
        Optional<User> userOptional = service.findById(id);
        //Valitation yes UserOptional isPresent o not present
        //Yes present returun Response Entity.ok(USerOPtional.get) g
        //get User by id
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        //Else retorun NoFound in application web
        return ResponseEntity.notFound().build();
    }

    //Create user for save in database
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody User user, BindingResult result){

        if (result.hasErrors()){
            return getMapResponseEntity(result);
        }
        if(!user.getEmail().isEmpty() && getEmailVerifier(user) && service.existByEmail(user.getEmail()))
            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "Already exist a user whit that email"));


        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }




    //Update User
    //Params ID , OBJECT USER

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody User user,BindingResult result ,@PathVariable Long id){
        if (result.hasErrors())
            return getMapResponseEntity(result);
        //VALITATION YES Service in contain user of the id
        Optional<User> userById = service.findById(id);
        //Yes user is present Update User
        if(userById.isPresent()){
            User userDB = userById.get();
            if(getEmailVerifier(user) && !user.getEmail().isEmpty() &&
                    !user.getEmail().equalsIgnoreCase(userDB.getEmail()) && service.findByEmail(user.getEmail()).isPresent())
                return ResponseEntity.badRequest().body(Collections.
                        singletonMap("mensaje", "Already exist a user whit that email"));
            userDB.setName(user.getName());
            userDB.setEmail(user.getEmail());
            userDB.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userDB));
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){

        Optional<User> userOptional = service.findById(id);
        if(userOptional.isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user-course")
    public ResponseEntity<?> getUserByCourse(@RequestParam List<Long> id){
        return ResponseEntity.ok(service.listById(id));

    }


    private static boolean getEmailVerifier(User user) {
        return !user.getEmail().isEmpty();
    }

    private static ResponseEntity<Map<String, String>> getMapResponseEntity(BindingResult result) {
        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
