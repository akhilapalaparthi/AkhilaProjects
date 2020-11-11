package dataStructures;

public class Employee1Comparable implements Comparable<Employee1Comparable> {
		
	    private int id;
	    private String name;
	    private int age;
	    private long salary;

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public long getSalary() {
	        return salary;
	    }

	    public Employee1Comparable(int id, String name, int age, int salary) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }

	    @Override
	    //this is overridden to print the user-friendly information about the Employee
	    public String toString() {
	        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
	                this.salary + "]";
	    }

		public int compareTo(Employee1Comparable emp) {
			 //let's sort the employee based on an id in ascending order
	        //returns a negative integer, zero, or a positive integer as this employee id
	        //is less than, equal to, or greater than the specified object.
	        return (this.id - emp.id);
	    	

		}	}

		
	




