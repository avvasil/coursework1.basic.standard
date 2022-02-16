package pro.sky;

import java.text.DecimalFormat;

public class Main {

    private static float totalMonthSalary;
    private static float totalMonthSalaryInDepartment;
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        addEmployee(new Employee("Сергеев", " Сергей ", "Сергеевич", 1, 155000));
        addEmployee(new Employee("Петров", " Пётр ", "Петрович", 2, 160560));
        addEmployee(new Employee("Сидоров", " Сидор ", "Сидорович", 3, 170800));
        addEmployee(new Employee("Иванов", " Иван ", "Иванович", 4, 183400));
        addEmployee(new Employee("Фёдоров", " Фёдор ", "Фёдорович", 5, 245000));
        addEmployee(new Employee("Семёнов", " Семён ", "Семёнович", 3, 253644));

//basic
//            System.out.println("=====================================================================================");
//            listOfAllEmployees(employees);//task1.1
//            System.out.println("=====================================================================================");
//            totalMonthlySalary(employees);//task1.2
//            System.out.println("=====================================================================================");
//            minSalaryPerson(employees);//task1.3
//            System.out.println("=====================================================================================");
//            maxSalaryPerson(employees);//task1.4
//            System.out.println("=====================================================================================");
//            averageMonthSalary(employees);//task1.5
//            System.out.println("=====================================================================================");
//            listOfFullNamesAllEmployees(employees);//task1.6
//            System.out.println("=====================================================================================");

//standard
//            System.out.println("===============================================================================================");
//            riseSalary(employees, 10);//task1
//            System.out.println("===============================================================================================");
//            minSalaryPersonInDepartment(employees, 3);//task2.1
//            System.out.println("===============================================================================================");
//            maxSalaryPersonInDepartment(employees, 3);//task2.2
//            System.out.println("===============================================================================================");
//            totalMonthlySalaryInDepartment(employees, 3);//task2.3
//            System.out.println("===============================================================================================");
//            averageMonthSalaryInDepartment(employees, 3);//task2.4
//            System.out.println("===============================================================================================");
//            riseSalaryInDepartment(employees, 15, 3);//task2.5
//            System.out.println("===============================================================================================");
//            listOfAllEmployeesInDepartment(employees, 3);//task2.6
//            System.out.println("===============================================================================================");
//            employeesWithSalaryLessThen(employees, 200000);//task3.1
//            System.out.println("===============================================================================================");
//            employeesWithSalaryMoreThen(employees, 100000);//task3.2
//            System.out.println("===============================================================================================");

    }
//basic

    private static boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public static void listOfAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static void totalMonthlySalary(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                totalMonthSalary += employees[i].getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц составила " + totalMonthSalary + " рублей.");
    }

    public static void minSalaryPerson(Employee[] employees) {
        float minSalary = Float.MAX_VALUE;
        String minSalaryPerson = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minSalaryPerson = employees[i].getLastName() + employees[i].getFirstName() + employees[i].getMiddleName();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minSalaryPerson + ". Зарплата " + minSalary + " рублей.");
    }

    public static void maxSalaryPerson(Employee[] employees) {
        float maxSalary = Float.MIN_VALUE;
        String maxSalaryPerson = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryPerson = employees[i].getLastName() + employees[i].getFirstName() + employees[i].getMiddleName();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxSalaryPerson + ". Зарплата " + maxSalary + " рублей.");
    }

    public static void averageMonthSalary(Employee[] employees) {
        int employeesNumbers = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employeesNumbers++;
            }
        }
        float averageMonthSalary = totalMonthSalary / employeesNumbers;
        String formattedAverageMonthSalary = new DecimalFormat("#0.00").format(averageMonthSalary);
        System.out.println("Среднее значение зарплат за месяц составила " + formattedAverageMonthSalary + " рублей.");
    }

    public static void listOfFullNamesAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("Ф.И.О. сотрудника: " + employees[i].getFullName());
            }
        }
    }

//standard

    public static void riseSalary(Employee[] employees, int salaryRaising) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * (100 + salaryRaising) / 100);
                System.out.println(employees[i].getFullName() + " теперь получает " + employees[i].getSalary() + ".");
            }
        }
    }

    public static void minSalaryPersonInDepartment(Employee[] employees, int department) {
        float minSalary = Float.MAX_VALUE;
        String minSalaryPerson = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary && employees[i].getDepartment() == department) {
                minSalary = employees[i].getSalary();
                minSalaryPerson = employees[i].getFullName();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой в отделе №" + department + " - " + minSalaryPerson + ". Зарплата: " + minSalary + ".");
    }

    public static void maxSalaryPersonInDepartment(Employee[] employees, int department) {
        float maxSalary = Float.MIN_VALUE;
        String maxSalaryPerson = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary && employees[i].getDepartment() == department) {
                maxSalary = employees[i].getSalary();
                maxSalaryPerson = employees[i].getFullName();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой в отделе №" + department + " - " + maxSalaryPerson + ". Зарплата: " + maxSalary + ".");
    }

    public static void totalMonthlySalaryInDepartment(Employee[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                totalMonthSalaryInDepartment += employees[i].getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц по отделу №" + department + " составила: " + totalMonthSalaryInDepartment + " рублей.");
    }

    public static void averageMonthSalaryInDepartment(Employee[] employees, int department) {
        int employeesNumbersInDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employeesNumbersInDepartment++;
            }
        }
        float averageMonthSalaryInDepartment = totalMonthSalaryInDepartment / employeesNumbersInDepartment;
        String formattedAverageMonthSalaryInDepartment = new DecimalFormat("#0.00").format(averageMonthSalaryInDepartment);
        System.out.println("Среднее значение зарплат за месяц по отделу №" + department + " составила: " + averageMonthSalaryInDepartment + " рублей.");
    }

    public static void riseSalaryInDepartment(Employee[] employees, int salaryRaising, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * (100 + salaryRaising) / 100);
                System.out.println(employees[i].getFullName() + " теперь получает " + employees[i].getSalary() + ".");
            }
        }
    }

    public static void listOfAllEmployeesInDepartment(Employee[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println("Сотрудник: " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + ", ID: " + employees[i].getId());
            }
        }
    }

    public static void employeesWithSalaryLessThen(Employee[] employees, float targetSalary) {
        System.out.println("Сотрудники с зарплатой, меньше " + targetSalary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < targetSalary) {
                System.out.println("ID: " + employees[i].getId() + ", Ф. И. О.: " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary());
            }
        }

    }

    public static void employeesWithSalaryMoreThen(Employee[] employees, float targetSalary) {
        System.out.println("Сотрудники с зарплатой, больше " + targetSalary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > targetSalary) {
                System.out.println("ID: " + employees[i].getId() + ", Ф. И. О.: " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary());
            }
        }

    }


}

