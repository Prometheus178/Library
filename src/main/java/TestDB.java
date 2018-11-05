import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;

public class TestDB {
    public void check(){
        try{
            InitialContext context = new InitialContext();
            DataSource source = (DataSource) context.lookup("java:/comp/env/jdbc/lib");
            Connection connection = source.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
