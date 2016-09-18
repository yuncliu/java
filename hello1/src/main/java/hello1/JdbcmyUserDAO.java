package hello1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import hello1.myUser;
import hello1.myUserDAO;

class JdbcmyUserDAO implements myUserDAO {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void insert(myUser user) {
    }
    public myUser findById(int id) {
        String sql = "select id, name, age from myuser where id = ?";
        Connection conn = null;
        try {
            conn = this.dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            myUser u = null;
            if (resultSet.next()) {
                u = new myUser(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
            }
            resultSet.close();
            preparedStatement.close();
            return u;
        }catch(SQLException e) {
        }finally {
        }
        return null;
    }
}
