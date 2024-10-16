import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBConfig {
    Connection conn;
    DBConfig()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_db", "root", "");
            createTable();
        }catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void createTable() throws SQLException {
        //                System.out.println("Connected with db");
        String query = "create table if not exists contacts(id int primary key unique auto_increment, name varchar(255), phone varchar(255));";
        Statement s = conn.createStatement();
        s.execute(query);
    }

    public int insertContact(String name, String phone) throws SQLException {
        String query = "insert into contacts(name, phone)values(?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, phone);

        return ps.executeUpdate();
    }

    public int update(int id, String name, String phone) throws SQLException {
        String query = "update contacts set name=?, phone=?  where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setInt(3, id);

        return ps.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String query = "delete from contacts where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        return ps.executeUpdate();
    }

    public ArrayList<String> getAllContacts() throws SQLException {
        ArrayList<String> records = new ArrayList<>();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from contacts");
        String line;
        while(rs.next())
        {

            line = rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
            records.add(line);
        }

        return records;
    }
}
