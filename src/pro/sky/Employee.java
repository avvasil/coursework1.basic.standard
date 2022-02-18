package pro.sky;

public class Employee {
    private static int counter = 1;

    private int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private int department;
    private float salary;


    public Employee(String lastName, String firstName, String middleName,int department, float salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;


    }

    @Override
    public String toString() {
        return "Сотрудник: " + lastName + firstName + middleName +
                ". Отдел: " + department +
                ". Зарплата: " + salary +
                ". ID: " + id +
                "." ;
    }

    public String getFullName() {
        return getLastName() + " " + getFirstName()+ " " + getMiddleName();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
