package ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDAO {
    @Override
    public void create(String client, Employee obj) throws Exception {
        System.out.println("Created new row in employee table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Deleted row in employee table");
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        System.out.println("Fetching data from db");
        return new Employee();
    }
}
