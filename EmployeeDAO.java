package payroll;

import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(String name,String dept,double basic) {

        double hra = basic * 0.20;
        double da = basic * 0.10;
        double deductions = basic * 0.05;
        double net = basic + hra + da - deductions;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO employees(name,department,basic_salary,hra,da,deductions,net_salary) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,dept);
            ps.setDouble(3,basic);
            ps.setDouble(4,hra);
            ps.setDouble(5,da);
            ps.setDouble(6,deductions);
            ps.setDouble(7,net);

            ps.executeUpdate();
            System.out.println("Employee Added!");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void viewEmployees() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while(rs.next()) {
                System.out.println(
                        rs.getInt("id")+" | "+
                        rs.getString("name")+" | "+
                        rs.getString("department")+" | Net Salary: "+
                        rs.getDouble("net_salary"));
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateSalary(int id,double basic){
        double hra = basic * 0.20;
        double da = basic * 0.10;
        double deductions = basic * 0.05;
        double net = basic + hra + da - deductions;

        try{
            Connection con = DBConnection.getConnection();

            String sql="UPDATE employees SET basic_salary=?,hra=?,da=?,deductions=?,net_salary=? WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setDouble(1,basic);
            ps.setDouble(2,hra);
            ps.setDouble(3,da);
            ps.setDouble(4,deductions);
            ps.setDouble(5,net);
            ps.setInt(6,id);

            ps.executeUpdate();
            System.out.println("Salary Updated!");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void deleteEmployee(int id){
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM employees WHERE id=?");

            ps.setInt(1,id);
            ps.executeUpdate();

            System.out.println("Deleted!");

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
