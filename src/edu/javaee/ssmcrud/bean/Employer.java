package edu.javaee.ssmcrud.bean;

public class Employer {
    private Integer emp_id;

    private String emp_name;

    private String emp_gender;

    private String email;

    private Integer dept_id;

    private Department department;

    public Employer(Integer emp_id, String emp_name, String emp_gender, String email, Integer dept_id) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_gender = emp_gender;
        this.email = email;
        this.dept_id = dept_id;
    }

    public Employer() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name == null ? null : emp_name.trim();
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender == null ? null : emp_gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_gender='" + emp_gender + '\'' +
                ", email='" + email + '\'' +
                ", dept_id=" + dept_id +
                ", department=" + department +
                '}';
    }
}