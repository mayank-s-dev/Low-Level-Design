package ProxyDesignPattern;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        try {
            EmployeeDAO employeeDao = new EmployeeDAOProxy();
            employeeDao.create("ADMIN", new Employee());
            System.out.println("Operation Successful");
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
