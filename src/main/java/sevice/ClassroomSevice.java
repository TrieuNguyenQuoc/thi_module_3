package sevice;




import model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomSevice {
    List<Classroom> classroom = new ArrayList<>();
    Connection connection = ConnectionMySql.getConnection();
    public List<Classroom> findAll() throws SQLException {
        String query = "select class.id as id , name as name from class;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        classroom.clear();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Classroom classroom = new Classroom(id,name);
            classroom.add(classroom);
        }
        return classroom;
    }
}
