package chapter11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution112 {
    public static void main(String[] args) {
        final Employee emp = new Employee("Joe");
        System.out.println(emp.getDateHired());
        System.out.println(emp.toString());
    }

    public static class Person {
        private final String name;
        private String address;
        private String phoneNumber;
        private String emailAddress;

        public Person(final String name, final String address, final String phoneNumber, final String emailAddress) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        public Person(final String name) {
            this(name, "Not specified", "Not specified", "Not specified");
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        @Override
        public String toString() {
            return "Person class: " +
                    "name = " + name;
        }
    }

    public static class Student extends Person {
        private final static int FRESHMAN = 1;
        private final static int SOPHOMORE = 2;
        private final static int JUNIOR = 3;
        private final static int SENIOR = 4;

        private int status;


        public Student(final String name, final int status) {
            super(name);
            setStatus(status);
        }

        public Student(final String name) {
            super(name);
            setStatus(Student.FRESHMAN);
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            if (status < FRESHMAN || status > SENIOR) {
                throw new IllegalArgumentException();
            }

            this.status = status;
        }

        @Override
        public String toString() {
            return "Student class: " +
                    "name = " + this.getName();
        }
    }

    public static class Employee extends Person {
        private String office;
        private int salary;
        private final Date dateHired;

        public Employee(final String name, final String office, final int salary) {
            super(name);
            this.office = office;
            this.salary = salary;
            dateHired = new Date();

        }

        public Employee(final String name) {
            this(name, "Not specified", 0);
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getDateHired() {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            return formatter.format(dateHired);
        }

        @Override
        public String toString() {
            return "Employee class: " +
                    "name = " + this.getName();
        }
    }

    public static class Faculty extends Employee {
        private String officeHours;
        private String rank;

        public Faculty(final String name, final String officeHours, final String rank) {
            super(name);
            this.officeHours = officeHours;
            this.rank = rank;
        }

        public Faculty(final String name) {
            this(name, "Not specified", "Not specified");
        }

        public String getOfficeHours() {
            return officeHours;
        }

        public void setOfficeHours(String officeHours) {
            this.officeHours = officeHours;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Faculty class: " +
                    "name = " + this.getName();
        }
    }

    public static class Staff extends Employee {
        private String title;

        public Staff(final String name, final String title) {
            super(name);
            this.title = title;
        }

        public Staff(final String name) {
            this(name, "Not specified");
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Staff class: " +
                    "name = " + this.getName();
        }
    }
}
