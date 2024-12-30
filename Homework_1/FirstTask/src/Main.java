import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Manager {
    private String name;
    private LocalDate hiringDate;

    public Manager(String name) {
        this.name = name;
    }
    public Manager(String name, LocalDate hiringDate){
        this.name = name;
        this.hiringDate = hiringDate;
    }
    public String getName(){
        return name;
    }
    public LocalDate getHiringDate(){
        return hiringDate;
    }
    public void setHiringDate(LocalDate hiringDate)
    {
        this.hiringDate = hiringDate;
    }

    public long numberOfYearsInCompanyTill(LocalDate date){
        return ChronoUnit.YEARS.between(this.hiringDate,date);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String nameOfManager = bufferedReader.readLine();

        int yearOfHiring = Integer.parseInt(bufferedReader.readLine().trim());

        int monthOfHiring = Integer.parseInt(bufferedReader.readLine().trim());

        int dayOfHiring = Integer.parseInt(bufferedReader.readLine().trim());

        int currentYear = Integer.parseInt(bufferedReader.readLine().trim());

        int currentMonth = Integer.parseInt(bufferedReader.readLine().trim());

        int currentDay = Integer.parseInt(bufferedReader.readLine().trim());

        Manager manager = new Manager(nameOfManager, LocalDate.of(yearOfHiring, monthOfHiring, dayOfHiring));

        System.out.println(manager.getHiringDate());
        System.out.println(manager.numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay)));
    }
}