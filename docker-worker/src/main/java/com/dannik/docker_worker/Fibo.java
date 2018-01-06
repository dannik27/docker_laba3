package com.dannik.docker_worker;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fibo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private long previous;
    private long val;


    public Fibo(){}

    public Fibo(long previous, long val){
        this.previous = previous;
        this.val = val;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrevious() {
        return previous;
    }

    public void setPrevious(long previous) {
        this.previous = previous;
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }
}
