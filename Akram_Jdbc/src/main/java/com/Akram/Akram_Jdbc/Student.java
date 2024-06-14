package com.Akram.Akram_Jdbc;

 

//import org.hibernate.type.descriptor.jdbc.JsonAsStringJdbcType;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO) // this is used to generate the id values in the automatic order
    private int sid;
    private String sname;
    private int snumber;
    private int smarks;


    public Student(int sid, String sname, int smarks, int snumber) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.smarks = smarks;
        this.snumber = snumber;
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
        // When there is no Student present then this class is responsible to return the
        // object.
    }


    public int getSnumber() {
        return snumber;
    }

    public void setSnumber(int snumber) {
        this.snumber = snumber;
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSmarks() {
        return smarks;
    }

    public void setSmarks(int smarks) {
        this.smarks = smarks;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sname=" + sname + ", snumber=" + snumber + ", smarks=" + smarks + "]";
    }

 

}
