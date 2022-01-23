import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Company {
    private String name;
    private int income;
    private int employeesNumber;
    private int topManagersNumber;
    private int managersNumber;
    private int operatorNumber;
    private List<Employee> employeeList = new ArrayList<>();

    public Company(String name, int income) {
        this.name = name;
        this.income = income;
        this.employeesNumber = 0;
    }

    public Company(String name, int income, int employeesNumber) {
        this.name = name;
        this.income = income;
        this.employeesNumber = employeesNumber;
        this.topManagersNumber = (int) Math.round(employeesNumber * 0.1);
        this.managersNumber = (int) Math.round((employeesNumber - this.topManagersNumber) * 0.4);
        this.operatorNumber = employeesNumber - (this.managersNumber + this.topManagersNumber);
        hireNumber("topmanager", topManagersNumber);
        hireNumber("manager", managersNumber);
        hireNumber("operator", operatorNumber);
    }

    public Company(String name, int income, int managersNumber, int topManagersNumber, int operatorNumber) {
        this.name = name;
        this.income = income;
        this.topManagersNumber = topManagersNumber;
        this.managersNumber = managersNumber;
        this.operatorNumber = operatorNumber;
        hireNumber("topmanager", topManagersNumber);
        hireNumber("manager", managersNumber);
        hireNumber("operator", operatorNumber);
    }

    public String getName() {
        return name;
    }

    public int getIncome() {
        return income;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void hire(Employee employee){
        this.employeeList.add(employee);
    }

    public void hireNumber(String position, int employeesNumber){
        switch (position.replaceAll("\\s+","").toLowerCase(Locale.ROOT)){
            case "topmanager":
                for(int i = 0; i < employeesNumber; i++){
                    this.employeeList.add(new TopManager(this.income));
                }
                break;
            case "manager":
                for(int i = 0; i < employeesNumber; i++){
                    this.employeeList.add(new Manager());
                }
                break;
            case "operator":
                for(int i = 0; i < employeesNumber; i++){
                    this.employeeList.add(new Operator());
                }
                break;
        }
    }

    public void allHire(List<Employee> employeeList){
        this.employeeList.addAll(employeeList);
    }

    public void fire(int index){
        this.employeeList.remove(index);
    }

    public List<Employee> getTopSalaryStaff(int count){
        return this.employeeList.stream().
                sorted(new EmployeeComparatorNatural()).
                limit(count).
                collect(Collectors.toList());
    }

    public List<Employee> getLowestSalaryStaff(int count){
        return this.employeeList.stream().
                sorted(new EmployeeComparatorReverse()).
                limit(count).
                collect(Collectors.toList());
    }
}

//Comparators
class EmployeeComparatorNatural implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int result = emp2.getSalary() - emp1.getSalary();
        if(result == 0){
            result = emp1.getName().compareTo(emp2.getName());
        }
        return result;
    }
}
class EmployeeComparatorReverse implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int result = emp1.getSalary() - emp2.getSalary();
        if(result == 0){
            result = emp1.getName().compareTo(emp2.getName());
        }
        return result;
    }
}

