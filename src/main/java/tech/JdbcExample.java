package tech;

import org.h2.tools.Server;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcExample {
    private static String urlString = "jdbc:h2:/Users/student/rkashaev/testdb";

    public static void main(String[] args) throws Exception {
        Server.main("-web", "-tcp");

        Class.forName("org.h2.Driver");
        try (Connection con = DriverManager.getConnection(urlString, "sa", "")) {

            List<Student> students = listStudents(con);

            students.forEach(System.out::println);
        }
    }

    private static List<Student> listStudents(Connection con) {
        List<Student> res = new ArrayList<>();

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM STUDENT")) {

            while(rs.next()) {
                Student stud = new Student();
                stud.id = rs.getInt("id");
                stud.name = rs.getString("name");
                stud.dbirth = rs.getDate("dbirth").toLocalDate();

                res.add(stud);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

}

class Student {
    int id;
    String name;
    LocalDate dbirth;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dbirth=").append(dbirth);
        sb.append('}');
        return sb.toString();
    }
}
