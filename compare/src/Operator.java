public class Operator extends Employee{
    private int salary;
    private int fixedSalary = 25000;
    private String position;

    public Operator(){
        this.salary = payroll();
        this.position = "Operator";
    }

    private int payroll(){
        return fixedSalary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public String getPosition(){
        return this.position;
    }
}
