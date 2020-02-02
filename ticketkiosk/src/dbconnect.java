import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconnect {

    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs,rs1;

    public dbconnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/oopkiosk", "NEWuser", "smr@2016G");
            st = conn.createStatement();
            pst=conn.prepareStatement("select * from printcred where book_id=? and ver_code=?");
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }

    }
    public Boolean printLogin(String bookid,String vericod){
        
        
        try { 
            pst.setString(1,bookid); //this replaces the 1st  "?" in the query for username
            pst.setString(2,vericod);

            rs1=pst.executeQuery();
            System.out.println(rs1);
            if(rs1.next())
            {
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbconnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }

    public void getdata() {
        try {
            String query = "select *from login";
            rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("username");
                String age = rs.getString("password");
                System.out.println(name + " " + age);
            }
        } catch(Exception e){
            System.out.println("**");
        }
    }
}
