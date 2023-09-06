package sevice;


import model.Classroom;
import model.Student;
import sevice.ISevice.ISutdentSevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentSevice implements ISutdentSevice<Student> {
    List<Student> staffList = new ArrayList<>();
    Connection connection = ConnectionMySql.getConnection();
    @Override
    public void add(Student student) throws SQLException {
     String query = "insert into studen( name, email,birth, address, phone,classroom) values (?, ?, ?, ?, ?, ?);";
     PreparedStatement statement = connection.prepareStatement(query);
     statement.setString(1 ,student.getName());
     statement.setString(2,student.getEmail());
     statement.setString(3,student.getBirth());
     statement.setString(4 ,student.getAddress());
     statement.setString(5,student.getPhone());
     statement.setString(6,student.getClassroom().getId());

     statement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
     String query = "delete from staff where id = ?;";
     PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public void edit(int id, Student student) throws SQLException {
        String query = "UPDATE staff SET name = ?, email = ?, salary = ?, address = ?, phonenumber = ?, idDepartment = ? WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3,student.getBirth());
        statement.setString(4, student.getAddress());
        statement.setString(5, student.getPhone());
        statement.setString(6, student.getClassroom().getId());
        statement.setInt(7, id);
        statement.executeUpdate();
    }
    @Override
    public List<Student> findAll() throws SQLException {
        String query = "select student.id as id , staff.name as name , email as email , salary as salary, address as address , phonenumber as phone , idDepartment as idDepartment , department.name as departmentName from staff join department on department.id = staff.idDepartment;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        staffList.clear();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String birth = resultSet.getString("birth");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            String classroom = resultSet.getString("classroom");
            Classroom classRoom = new Classroom(id , classroom);
            Student student = new Student(id , name , birth , email , address , phone , classroom);
            staffList.add(student);
        }
        return Student;
    }

    public Student findById(int id) throws SQLException {
        String query = "select student.id as id , student.name as name , email as email , student as student, address as address , phonenumber as phone , classroom as classroom , classroom.name as classroom from studnet join classroom on classroom.id = student.class_id where studnet.id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int studentId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String birth = resultSet.getString("birth");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            String classroom = resultSet.getString("classroom");
            return new Student(studentId, name, birth, email, address, phone, classroom);
        }

        return null;
    }
    public List<Student> findByName(String name) throws SQLException {
        List<Student> staffList = findAll();
        List<Student> searchList = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(staffList.get(i).toString());
                searchList.add(staffList.get(i));
            }
        }
        return searchList;
    }

}
