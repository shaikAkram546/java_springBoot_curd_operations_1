package com.Akram.Akram_Jdbc;

 

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
import java.util.*;

 

@RestController // Rest controller is used for controller all the rest operations
public class StudentController {


    @Autowired
    DataBaseRepo repo;



    /*
    We can also use the ResponseEntity object to share the data back to the client
    if we user the void data type we can't return the response object by using tha above we can do that.
    */
    

    @PostMapping("/api/students")  // The PostMapping is used to post the data into the DataBase.
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

        //System.out.println("Creating and updating the values in the sql");
        return new ResponseEntity<>(repo.save(student), HttpStatus.ACCEPTED); // In this We are saving the data and returnin the saved data back to the client

    }
    
    @GetMapping("/api/students")
    public ResponseEntity<ArrayList<Student>> getStudents() {

        ArrayList<Student> students = new ArrayList<>(repo.findAll()); //using arrayList dataType to get the data from the database.
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    
    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);
        if(student.isPresent()){
             return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



       
        // In this case the student is Optional so we are using student.get(), to get the value from the database.
    }
    

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);
        if (student.isPresent()) {
            repo.deleteById(id); //This will delete the data from the database.
            return new ResponseEntity<>(student.get(), HttpStatus.OK); // In this case oK is that the data is deleted from the database
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/api/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> stud = repo.findById(id);
        if (stud.isPresent()) {
            stud.get().setSid(student.getSid());
            stud.get().setSname(student.getSname());
            stud.get().setSnumber(student.getSnumber());
            stud.get().setSmarks(student.getSmarks());
            return new ResponseEntity<>(repo.save(stud.get()), HttpStatus.ACCEPTED);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
