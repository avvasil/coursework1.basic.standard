package pro.sky;

import java.text.DecimalFormat;

public class Main {

    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        addEmployee(new Employee("Сергеев", " Сергей ", "Сергеевич", 1, 155_000f));
        addEmployee(new Employee("Петров", " Пётр ", "Петрович", 2, 160_560f));
        addEmployee(new Employee("Сидоров", " Сидор ", "Сидорович", 3, 170_800f));
        addEmployee(new Employee("Иванов", " Иван ", "Иванович", 4, 183_400f));
        addEmployee(new Employee("Фёдоров", " Фёдор ", "Фёдорович", 5, 245_000f));
        addEmployee(new Employee("Семёнов", " Семён ", "Семёнович", 3, 253_644f));

//basic
            System.out.println("=====================================================================================");
            listOfAllEmployees();//task1.1
            System.out.println("=====================================================================================");
            findTotalMonthlySalary();//task1.2
            System.out.println("Сумма затрат на зарплаты в месяц составила " + findTotalMonthlySalary() + " рублей.");
            System.out.println("=====================================================================================");
            findMinSalaryPerson();//task1.3
            System.out.println("=====================================================================================");
            findMaxSalaryPerson();//task1.4
            System.out.println("=====================================================================================");
            findAverageMonthSalary();//task1.5
            System.out.println("Среднее значение зарплат за месяц составила " + findAverageMonthSalary()+ " рублей.");
            System.out.println("=====================================================================================");
            listOfFullNamesAllEmployees();//task1.6
            System.out.println("=====================================================================================");

//standard
            System.out.println("===============================================================================================");
            riseSalary(10);//task1
            System.out.println("===============================================================================================");
            findMinSalaryPersonInDepartment(3);//task2.1
            System.out.println("===============================================================================================");
            findMaxSalaryPersonInDepartment(3);//task2.2
            System.out.println("===============================================================================================");
            findTotalMonthlySalaryInDepartment(3);//task2.3
            System.out.println("Сумма затрат на зарплаты в месяц по отделу №" + findTotalMonthlySalaryInDepartment(3) + " составила: " + findTotalMonthlySalaryInDepartment(3) + " рублей.");
            System.out.println("===============================================================================================");
            findAverageMonthSalaryInDepartment(3);//task2.4
            System.out.println("Среднее значение зарплат за месяц по отделу №" + findAverageMonthSalaryInDepartment(3) + " составила: " + findAverageMonthSalaryInDepartment(3) + " рублей.");
            System.out.println("===============================================================================================");
            riseSalaryInDepartment(15, 3);//task2.5
            System.out.println("===============================================================================================");
            listOfAllEmployeesInDepartment(3);//task2.6
            System.out.println("===============================================================================================");
            findEmployeesWithSalaryLessThen(200000);//task3.1
            System.out.println("===============================================================================================");
            findEmployeesWithSalaryMoreThen(100000);//task3.2
            System.out.println("===============================================================================================");

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

    public static void listOfAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public static float findTotalMonthlySalary() {
        float totalMonthlySalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                totalMonthlySalary += employees[i].getSalary();
            }
        }
        return totalMonthlySalary;
    }

    public static void findMinSalaryPerson() {
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

    public static void findMaxSalaryPerson() {
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

    public static float findAverageMonthSalary() {
        int employeesNumbers = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employeesNumbers++;
            }
        }
        float averageMonthSalary = findTotalMonthlySalary() / employeesNumbers;
        return averageMonthSalary;
    }

    public static void listOfFullNamesAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("Ф.И.О. сотрудника: " + employees[i].getFullName());
            }
        }
    }

//standard

    public static void riseSalary(int salaryRaising) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * (100 + salaryRaising) / 100);
                System.out.println(employees[i].getFullName() + " теперь получает " + employees[i].getSalary() + ".");
            }
        }
    }

    public static void findMinSalaryPersonInDepartment(int department) {
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

    public static void findMaxSalaryPersonInDepartment(int department) {
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

    public static float findTotalMonthlySalaryInDepartment(int department) {
        float totalMonthSalaryInDepartment = 0f;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                totalMonthSalaryInDepartment += employees[i].getSalary();
            }
        } return totalMonthSalaryInDepartment;
    }

    public static float findAverageMonthSalaryInDepartment(int department) {
        int employeesNumbersInDepartment = 0;
        float averageMonthSalaryInDepartment = 0f;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employeesNumbersInDepartment++;
            }
        }
        averageMonthSalaryInDepartment = findTotalMonthlySalaryInDepartment(department) / employeesNumbersInDepartment;
        return averageMonthSalaryInDepartment;
    }

    public static void riseSalaryInDepartment(int salaryRaising, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * (100 + salaryRaising) / 100);
                System.out.println(employees[i].getFullName() + " теперь получает " + employees[i].getSalary() + ".");
            }
        }
    }

    public static void listOfAllEmployeesInDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println("Сотрудник: " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + ", ID: " + employees[i].getId());
            }
        }
    }

    public static void findEmployeesWithSalaryLessThen(float targetSalary) {
        System.out.println("Сотрудники с зарплатой, меньше " + targetSalary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < targetSalary) {
                System.out.println("ID: " + employees[i].getId() + ", Ф. И. О.: " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary());
            }
        }

    }

    public static void findEmployeesWithSalaryMoreThen(float targetSalary) {
        System.out.println("Сотрудники с зарплатой, больше " + targetSalary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > targetSalary) {
                System.out.println("ID: " + employees[i].getId() + ", Ф. И. О.: " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary());
            }
        }

    }


}

