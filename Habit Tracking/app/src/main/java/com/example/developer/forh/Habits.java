package com.example.developer.forh;

/**
 * Created by Developer on 9/3/2016.
 */
public class Habits {
    public String habit;
    public String details ;
    public int id ;

    public Habits(String habit, String details, int id) {
        this.habit = habit;
        this.details = details;
        this.id = id;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabit() {
        return habit;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }
}
