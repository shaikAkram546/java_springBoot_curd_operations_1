package com.Akram.Akram_Jdbc;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository; ..// In this case we can use this repository also but the CurdRepository is the main repository used mostly.
//import org.springframework.data.repository.CrudRepository;

public interface DataBaseRepo extends JpaRepository<Student, Integer>{




}
