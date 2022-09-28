public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.addEmployee("Ivanov I.I.", 1, 1350);
        employeeBook.addEmployee("Petrov P.P.", 3, 1500);
        employeeBook.addEmployee("Sidorov S.S.", 2, 1600);
        employeeBook.addEmployee("Stolyarov V.J.", 5, 1700);
        employeeBook.addEmployee("Kim D.G.", 5, 1250);
        employeeBook.addEmployee("Tarasov A.E.", 4, 1200);
        employeeBook.addEmployee("Savin B.S.", 5, 1500);
        employeeBook.addEmployee("Suvorov A.V.", 1, 2100);
        employeeBook.addEmployee("Vinogradov S.V.", 2, 1100);
        employeeBook.addEmployee("Davydov A.A.", 3, 1600);
        employeeBook.removeEmployee("Ivanov I.I.");
        employeeBook.displayEmployees();
        System.out.println("------------------------");
        System.out.println(employeeBook.getAllExpensesToSalary());
        System.out.println("------------------------");
        System.out.println(employeeBook.getEmployeeWithMinSalaryFromAll());
        System.out.println("------------------------");
        System.out.println(employeeBook.getEmployeeWithMaxSalaryFromAll());
        System.out.println("------------------------");
        System.out.println(employeeBook.getAllAverageSalary());
        System.out.println("------------------------");
        employeeBook.getAllFullNames();
        System.out.println("------------------------");
        employeeBook.indexSalaryForAll(10);
        employeeBook.displayEmployees();
        System.out.println("------------------------");
        System.out.println(employeeBook.getEmployeeWithMinSalaryFromDepartment(5));
        System.out.println("------------------------");
        System.out.println(employeeBook.getEmployeeWithMaxSalaryFromDepartment(5));
        System.out.println("------------------------");
        System.out.println(employeeBook.getDepartmentExpensesToSalary(5));
        System.out.println("------------------------");
        employeeBook.indexSalaryForDepartment(5, 100);
        employeeBook.displayEmployeesByDepartment(5);
        System.out.println("------------------------");
        employeeBook.displayEmployeesWithSalaryLessThan(1800);
        System.out.println("------------------------");
        employeeBook.displayEmployeesWithSalaryGreaterThan(2000);
        System.out.println("------------------------");
        System.out.println(employeeBook.getDepartmentAverageSalary(5));
        System.out.println("------------------------");
        employeeBook.removeEmployee("Tarasov A.E.");
        employeeBook.displayEmployees();
        System.out.println("------------------------");
        employeeBook.removeEmployee(8);
        employeeBook.displayEmployees();
        System.out.println("------------------------");
        employeeBook.addEmployee("Vinogradov S.V.", 2, 1100);
        employeeBook.displayEmployees();
        System.out.println("------------------------");
        employeeBook.updateEmployee("Davydov A.A.", 5);
        employeeBook.updateEmployee("Ivanov I.I.", 1950.0);
        employeeBook.displayEmployees();
        System.out.println("------------------------");
        employeeBook.displaySortedEmployees();


    }
}