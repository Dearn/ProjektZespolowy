package database;
import java.sql.*;
public class DataBase {
    public static void main(String[] args) {
        int i=0;
        Connection con;
    	Statement st;
    	ResultSet rs;
        try{
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://192.168.1.2/mapawimii","Petrus","plomienprawdy");
    		st = con.createStatement();
    		String query="Select * from tblpok";
    		rs=st.executeQuery(query);
    		while(rs.next()){
    			System.out.println(rs.getString("mopis")+" "+rs.getString("mpracownicy")+" "+rs.getString("mnumer")+" "+rs.getString("mpath"));
                        i++;
    		}
    	}
    	catch(SQLException se){
    		se.printStackTrace();
    	}
    	catch(ClassNotFoundException cnfe){
    		cnfe.printStackTrace();
    	}
        System.out.println("Number of rows : "+i);
    }
}
