import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Employee implements Comparable<Employee>{
    private List<String> firstNames = Arrays.asList(
            "Elena", "Vicktoria", "Liza", "Dmitriy",
            "Vasiliy", "Egor", "Anna", "Polina", "Yaroslav");
    private String name;
    private String position;
    private int salary;
    private int fixedSalary = 0;

    public Employee(){
        this.salary = payroll();
        this.position = "nothing";
        assignName();
    }

    private void assignName(){
        Random r = new Random();
        this.name = firstNames.get((int)Math.round(Math.random() * (firstNames.size()-1))) +
                " " + (char)(r.nextInt(26) + 'A') + ".";
    }

    private int payroll(){
        return fixedSalary;
    }

    public int getSalary(){
        return salary;
    }

    public String getName(){
        return this.name;
    }

    public String getPosition(){
        return this.position;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
