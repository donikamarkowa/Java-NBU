package org.example.camp;

import org.example.exceptions.BelowMinAgeException;
import org.example.items.Event;
import org.example.items.Participant;
import org.example.items.TypeCamp;

import java.util.ArrayList;
import java.util.List;

public class KidsCamp extends Event {
    public int minAge;
    public List<Participant> participantList;
    public TypeCamp typeCamp;

    public int getMinAge() {
        return minAge;
    }

    public TypeCamp getTypeCamp() {
        return typeCamp;
    }

    public KidsCamp(String name, int days, double transportCosts, double rentCosts, int minAge, TypeCamp typeCamp) {
        super(name, days, transportCosts, rentCosts);
        this.minAge = minAge;
        this.participantList = new ArrayList<>();
        this.typeCamp = typeCamp;
    }

    public void addParticipant(Participant participant) throws BelowMinAgeException {
        if(participant.age() < minAge){
            throw new BelowMinAgeException("Participant is underage the minAge", minAge);
        }
        participantList.add(participant);
    }

    @Override
    public double costs() {
        return super.costs() + typeCamp.getCostForTypeCamp();
    }

    public double averageCost(){
        double average = 0;
        for(Participant participant : participantList){
            average += this.costs();
        }
        double averageCostsPerParticipant = average/participantList.size();
        return  averageCostsPerParticipant;
    }

    @Override
    public String toString() {
        return "KidsCamp{" +
                "minAge=" + minAge +
                ", participantList=" + participantList +
                ", typeCamp=" + typeCamp +
                '}';
    }
}
