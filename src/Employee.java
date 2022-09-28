public class Employee {
    private static long counter = 0;

    private long id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        if ((department > 5 || department <= 0)) {
           showError("department");
        } else {
            this.department = department;
        }
        if (salary < 0) {
            showError("salary");
        } else {
            this.salary = salary;
        }
        this.id = counter++;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void showError(String dataField) {
        System.out.printf("The data field [%s] for %s doesn't initialize\n", dataField, fullName);
    }

    @Override
    public String toString() {
        return "id: " + id + " | Full name: " + fullName + " | Department: " + department + " | Salary: " + salary;
    }
}
