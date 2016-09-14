package hello;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //load org.postgresql.Driver
            Class.forName("org.postgresql.Driver");

            //create a connection
            connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/liu", "liu", "liu");
            //定义sql语句 ?表示占位符
            String sql = "select * from myuser where id < ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 10);
            //send to database for query and waitting for result set
            resultSet =  preparedStatement.executeQuery();
            //work throw result set
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
