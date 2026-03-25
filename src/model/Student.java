package model;

public class Student {
    private int sno;
    private String name;
    private String gender;
    private int regno;
    private String email;
    private String dob;

    public Student(String name, String gender, int regno, String email, String dob) {
        this.name = name;
        this.gender = gender;
        this.regno = regno;
        this.email = email;
        this.dob = dob;
    }

    public Student(int sno, String name, String gender, int regno, String email, String dob) {
        this.sno = sno;
        this.name = name;
        this.gender = gender;
        this.regno = regno;
        this.email = email;
        this.dob = dob;
    }

    public int getSno()       { return sno; }
    public String getName()   { return name; }
    public String getGender() { return gender; }
    public int getRegno()     { return regno; }
    public String getEmail()  { return email; }
    public String getDob()    { return dob; }

    @Override
    public String toString() {
        return "SNO: " + sno + " | Name: " + name + " | Gender: " + gender +
                " | RegNo: " + regno + " | Email: " + email + " | DOB: " + dob;
    }
}