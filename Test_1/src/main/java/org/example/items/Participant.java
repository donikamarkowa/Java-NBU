package org.example.items;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Participant implements Serializable {
    public String name;
    public LocalDate birthdate;

    public Participant(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public long age(){
        return ChronoUnit.YEARS.between(LocalDate.now(), this.birthdate);
    }

    public boolean isYounger(Participant participant1, Participant participant2){
        if(participant1.age() > participant2.age()){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
