package org.example.items;

public class Event implements CostsCalculation{
    public String name;
    public int days;
    public double transportCosts;
    public double rentCosts; // за целия период на провеждане на събитието.

    public Event(String name, int days, double transportCosts, double rentCosts) {
        this.name = name;
        this.days = days;
        this.transportCosts = transportCosts;
        this.rentCosts = rentCosts;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public double getTransportCosts() {
        return transportCosts;
    }

    public double getRentCosts() {
        return rentCosts;
    }

    //Метод costs() за изчисляване на разходите по организиране на събитието. Методът
    //трябва да връща сборът от разходите за транспорт и наем на помещения.
    @Override
    public double costs() {
        return this.rentCosts + this.transportCosts;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", days=" + days +
                ", transportCosts=" + transportCosts +
                ", rentCosts=" + rentCosts +
                '}';
    }
}
