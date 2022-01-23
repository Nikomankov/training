public class Main {
    public static void main(String[] args) {

        Company ccgroup = new Company("CCgroup", 1000000,80,10,180);

        System.out.println("Top 10 salaries:");
        for(Employee employee : ccgroup.getTopSalaryStaff(10)){
            System.out.println(employee.getSalary() + " руб.");
        }

        System.out.println("-----------------------------------\n" +
                "30 lowest salaries:");
        for(Employee employee : ccgroup.getLowestSalaryStaff(30)){
            System.out.println(employee.getSalary() + " руб.");
        }

        int employeesNumber = ccgroup.getEmployeeList().size();
        for(int i = 0; i < Math.round(employeesNumber/2); i++){
            ccgroup.fire((int)Math.random() * ccgroup.getEmployeeList().size());
        }

        System.out.println("-----------------------------------\n" +
                "Top 10 salaries:");
        for(Employee employee : ccgroup.getTopSalaryStaff(10)){
            System.out.println(employee.getSalary() + " руб.");
        }

        System.out.println("-----------------------------------\n" +
                "30 lowest salaries:");
        for(Employee employee : ccgroup.getLowestSalaryStaff(30)){
            System.out.println(employee.getSalary() + " руб.");
        }


//        Company newCompany = new Company("CCGroup", 10000001, 2,2,2);
//        newCompany.hire(new Manager());
//        for(Employee employee : newCompany.getEmployeeList()){
//            System.out.println(employee.getPosition() + " " + employee.getName() + " - " + employee.getSalary());
//        }
//        System.out.println("------------------------------");
//        System.out.println("Top salary: ");
//
//        for(Employee employee : newCompany.getTopSalaryStaff(3)){
//            System.out.println(employee.getPosition() + " " + employee.getName() + " - " + employee.getSalary());
//        }
//        System.out.println("------------------------------");
//        System.out.println("Lowest salary: ");
//        for(Employee employee : newCompany.getLowestSalaryStaff(3)){
//            System.out.println(employee.getPosition() + " " + employee.getName() + " - " + employee.getSalary());
//        }
    }

}

