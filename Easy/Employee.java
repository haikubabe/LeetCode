package Easy;

public class Employee
{
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
               name.equals(employee.name);
    }

    @Override
    public int hashCode()
    {
        int hash = 13;
        hash = 17 * hash + id;
        hash = 17 * hash + ((name == null) ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
