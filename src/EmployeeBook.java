public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int size) {
        this.employees = new Employee[size];
    }

    public void addEmployee(String fullName, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                break;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
                break;
            }
        }
    }


    // вот с этим моментом не понятно, если я хочу изменить ЗП, то я должен явно указать тип double
    // т.к., по умолчанию числовые литералы трактуются как int.
    // вполне возможно, что нужно было создать класс Department, и тогда не было бы такой неоднозначности
    // ну или просто я не понял задание
    public void updateEmployee(String fullName, int department) {
        updateEmployee(fullName, department, 0);
    }

    public void updateEmployee(String fullName, double salary) {
        updateEmployee(fullName, 0, salary);
    }

    private void updateEmployee(String fullName, int department, double salary) {
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getFullName().equals(fullName)) {
                if (department != 0) {
                    employee.setDepartment(department);
                }
                if (salary != 0) {
                    employee.setSalary(salary);
                }
            }
        }
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            if (employee == null) continue;
            System.out.println(employee);
        }
    }

    public void displaySortedEmployees() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Following people work in the " + i +"st department:");
            for (Employee employee : employees) {
                if (employee == null) continue;
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getFullName());
                }
            }
        }

    }

    public void displayEmployeesByDepartment(int department) {
        Employee[] group = getGroupEmployeeByDepartment(department);
        System.out.println("Employee(-s) of " + department + " department: ");
        for (Employee employee : group) {
            System.out.println("id: " + employee.getId() + " | Full name: " + employee.getFullName() + " | Salary: " + employee.getSalary());
        }
    }

    public void displayEmployeesWithSalaryLessThan(double value) {
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalary() < value) {
                System.out.println("id: " + employee.getId() + " | Full name: " + employee.getFullName() + " | Salary: " + employee.getSalary());
            }
        }
    }

    public void displayEmployeesWithSalaryGreaterThan(double value) {
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalary() >= value) {
                System.out.println("id: " + employee.getId() + " | Full name: " + employee.getFullName() + " | Salary: " + employee.getSalary());
            }
        }
    }

    public double getAllExpensesToSalary() {
        return getExpensesToSalary(employees);
    }

    public double getDepartmentExpensesToSalary(int department) {
        return getExpensesToSalary(getGroupEmployeeByDepartment(department));
    }


    public Employee getEmployeeWithMinSalaryFromAll() {
        return getEmployeeWithMinSalary(employees);
    }

    public Employee getEmployeeWithMaxSalaryFromAll() {
        return getEmployeeWithMaxSalary(employees);
    }

    public double getAllAverageSalary() {
        return getAverageSalary(employees);
    }

    public double getDepartmentAverageSalary(int department) {
        return getAverageSalary(getGroupEmployeeByDepartment(department));
    }

    public void getAllFullNames() {
        for (Employee employee : employees) {
            if (employee == null) continue;
            System.out.println(employee.getFullName());
        }
    }

    public void indexSalaryForAll(double value) {
        indexSalary(employees, value);
    }

    public void indexSalaryForDepartment(int department, double value) {
        indexSalary(getGroupEmployeeByDepartment(department), value);
    }

    public Employee getEmployeeWithMinSalaryFromDepartment(int department) {
        return getEmployeeWithMinSalary(getGroupEmployeeByDepartment(department));

    }

    public Employee getEmployeeWithMaxSalaryFromDepartment(int department) {
        return getEmployeeWithMaxSalary(getGroupEmployeeByDepartment(department));
    }

    private double getAverageSalary(Employee[] group) {
        double total = getExpensesToSalary(group);
        int count = getCountNotNullElements(group);
        return total / count;
    }

    private void indexSalary(Employee[] group, double value) {
        double percent = value / 100;
        for (Employee employee : group) {
            if (employee == null) continue;
            double currentSalary = employee.getSalary();
            employee.setSalary(currentSalary + currentSalary * percent);
        }
    }

    private double getExpensesToSalary(Employee[] group) {
        double total = 0;
        for (Employee employee : group) {
            if (employee == null) continue;
            total += employee.getSalary();
        }
        return total;
    }

    private Employee getFirstNotNull(Employee[] group) {
        for (Employee value : group) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    private Employee getEmployeeWithMinSalary(Employee[] group) {
        Employee minEmployee = getFirstNotNull(group);

        for (Employee employee : group) {
            if (employee == null) continue;
            if (employee.getSalary() < minEmployee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    private Employee getEmployeeWithMaxSalary(Employee[] group) {
        Employee maxEmployee = getFirstNotNull(group);

        for (Employee employee : group) {
            if (employee == null) continue;
            if (employee.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    private Employee[] getGroupEmployeeByDepartment(int department) {
        int arraySize = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartment() == department) {
                arraySize++;
            }
        }

        Employee[] group = new Employee[arraySize];
        for (int i = 0, j = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == department) {
                group[j] = employees[i];
                j++;
            }
        }
        return group;
    }

    private int getCountNotNullElements(Employee[] group) {
        int count = 0;
        for (Employee employee : group)
            if (employee != null) {
                count++;
            }
        return count;
    }
}
