public class Manager extends Employee{
    private int salary;
    private int fixedSalary = 25000;
    private String position;

    public Manager(){
        this.salary = payroll();
        this.position = "Manager";
    }

    private int payroll(){
        return fixedSalary + (int)Math.round((115000 + Math.random() * 25000) * 0.05);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public String getPosition(){
        return this.position;
    }
}
