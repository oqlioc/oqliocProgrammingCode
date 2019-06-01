using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// 일형성 예제

abstract class Employee
{
    private String name;
    
    public Employee(String name)
    {
        this.name = name;
    }

    public String GetName()
    {
        return this.name;
    }

    public abstract int GetPay();
}

class Permanent : Employee
{
    private int salary;

    public Permanent(String name, int salary) : base(name)
    {
        this.salary = salary;
    }

    public override int GetPay()
    {
        return this.salary;
    }
}

class PartTime : Employee
{
    private int time;
    private int pay;

    public PartTime(String name, int time, int pay)  : base(name)
    {
        this.time = time;
        this.pay = pay;
    }

    public override int GetPay()
    {
        return this.time * this.pay;
    }
}

class Temporal : Employee
{
    private int salary;
    private double retio;

    public Temporal(String name, int salary, double retio) : base(name)
    {
        this.salary = salary;
        this.retio = retio;
    }

    public override int GetPay()
    {
        return (int)(this.salary * this.retio);
    }
}

class Department
{
    private ArrayList arList = new ArrayList();

    public void AddEmployee(Employee p)
    {
        this.arList.Add(p);
    }

    public void ShowEmployee()
    {
        foreach (Employee p in arList)
        {
            Console.WriteLine(p.GetName() + ":" + p.GetPay());
        }
    }
}

class PolymorphismMain
{
    public static void Main()
    {
        Department depart = new Department();
        depart.AddEmployee(new Permanent("KIM", 1000));
        depart.AddEmployee(new Permanent("LEE", 1500));
        depart.AddEmployee(new Permanent("JUN", 2000));
        depart.AddEmployee(new PartTime("PARK", 10, 200));
        depart.AddEmployee(new PartTime("HONG", 20, 170));
        depart.AddEmployee(new Temporal("YANG", 100, 0.3));
        depart.ShowEmployee();
    }
}