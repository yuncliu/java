package hello1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;

import hello1.myUser;
import hello1.myUserDAO;

class myUserDAOImpl extends JdbcDaoSupport implements myUserDAO {
    /*
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */
    public void insert(myUser user) {
    }
    public myUser findById(int id) {
        /*  use jdbc directly
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
        */

        // use JdbcTemplate
        myUser a = this.getJdbcTemplate().queryForObject(
                "select id, name, age from myuser where id = ?",
                new Object[]{id},
                new RowMapper<myUser>() {
                        public myUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                            myUser u = new myUser(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                            return u;
                        }
                    }
                );
        return a;
    }
}
