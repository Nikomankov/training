public class TopManager extends Employee{
    private int salary;
    private int fixedSalary = 25000;
    private String position;

    public TopManager(int income){
        this.salary = payroll(income);
        this.position = "Top Manager";
    }

    private int payroll(int income){
        return fixedSalary + (int)(income > 10000000 ? fixedSalary * 1.5 : 0);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public String getPosition(){
        return this.position;
    }
}
