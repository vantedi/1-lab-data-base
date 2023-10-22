package net.codejava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
 
public class data_base {

	public static void main(String[] args) throws SQLException {
	    Connection connection = DriverManager.getConnection("jdbc:h2:~/database", "sa", "");

	    Statement st = connection.createStatement();

	    st.execute("DROP TABLE GROUPS IF EXISTS");
	    st.execute("CREATE TABLE GROUPS(ID INT PRIMARY KEY, NAME VARCHAR(255), NUMBER_OF_MEMBERS TINYINT, DEBUT_YEAR SMALLINT) ;");

	    st.execute("INSERT INTO GROUPS VALUES(1, 'ATEEZ', 8, 2018);");
	    st.execute("INSERT INTO GROUPS VALUES(2, 'BTS', 7, 2013);");
	    st.execute("INSERT INTO GROUPS VALUES(3, 'TXT', 5, 2019);");
	    st.execute("INSERT INTO GROUPS VALUES(4, 'NCT', 23, 2016);");
	    st.execute("INSERT INTO GROUPS VALUES(5, 'THE BOYZ', 11, 2017);");
	    st.execute("INSERT INTO GROUPS VALUES(6, 'TREASURE', 10, 2020);");
	    st.execute("INSERT INTO GROUPS VALUES(7, 'SHINee', 4, 2008);");
	    st.execute("INSERT INTO GROUPS VALUES(8, 'Stray Kids ', 8, 2018);");
	    st.execute("INSERT INTO GROUPS VALUES(9, 'SEVENTEEN', 13, 2015);");
	    st.execute("INSERT INTO GROUPS VALUES(10, 'ONEUS', 6, 2019);");
	    st.execute("INSERT INTO GROUPS VALUES(11, 'A.C.E', 5, 2017);");
	    st.execute("INSERT INTO GROUPS VALUES(12, 'ENHYPEN', 7, 2020);");
	    st.execute("INSERT INTO GROUPS VALUES(13, 'CIX', 5, 2019);");
	    st.execute("INSERT INTO GROUPS VALUES(14, 'EPEX', 8, 2021);");
	    st.execute("INSERT INTO GROUPS VALUES(15, 'Xikers', 10, 2023);");
	    st.execute("INSERT INTO GROUPS VALUES(16, 'MCND', 5, 2020);");
	    st.execute("INSERT INTO GROUPS VALUES(17, 'MONSTA X', 7, 2015);");
	    st.execute("INSERT INTO GROUPS VALUES(18, 'VERIVERY', 7, 2019);");
	    st.execute("INSERT INTO GROUPS VALUES(19, 'VICTON', 6, 2016);");
	    st.execute("INSERT INTO GROUPS VALUES(20, 'ZEROBASEONE', 9, 2023);");
	    

	    ResultSet result = st.executeQuery("SELECT * FROM GROUPS");

	    System.out.println("Initial DataBase of K-Pop groups:");
	    printResultSet(result);

	    result = st.executeQuery("SELECT * FROM GROUPS WHERE NAME = 'MCND'");

	    System.out.println("\nName only 'MCND':");
	    printResultSet(result);
	    
	    result = st.executeQuery("SELECT * FROM GROUPS WHERE NUMBER_OF_MEMBERS = 7");
	    
	    System.out.println("\nNumber of members only 7:");
	    printResultSet(result);
	    
	    result = st.executeQuery("SELECT * FROM GROUPS WHERE DEBUT_YEAR = 2020");
	    
	    System.out.println("\nDebut year only 2020:");
	    printResultSet(result);
	}
	    
	public static void printResultSet(ResultSet result) throws SQLException {
	    String id, name, number_of_members, debut_year;
	    System.out.printf("%3s | %-15s | %-20s | %-10s \n", "ID", "NAME", "NUMBER_OF_MEMBERS", "DEBUT_YEAR");
	    while (result.next()) {
	        id = result.getString("ID");
	        name = result.getString("NAME");
	        number_of_members = result.getString("NUMBER_OF_MEMBERS");
	        debut_year = result.getString("DEBUT_YEAR");

	        System.out.printf("%3s | %-15s | %-20s | %-10s \n", id, name, number_of_members, debut_year);
	    }
	}
}