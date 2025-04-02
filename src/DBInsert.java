import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


// JAVA ASSIGNEMENT 2
public class DBInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // Load and register the MySQL JDBC driver
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Bharat2004");  // Establish a connection to the MySQL database
			Statement statement = connection.createStatement();  // query execute
			
			// Create
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter yo name: ");
			String name = scanner.next();
			String query = "insert into user(`name`) values('"+name+"')";
			int i = 0;
			i = statement.executeUpdate(query);  // returns 1 if query is executed
			if(i!=0) {
				System.out.println("Data Inserted!");
			}
			
			
			//READ
			ResultSet set = statement.executeQuery("SELECT * FROM user");  // Execute SQL query to fetch all records from the 'user' table
			while(set.next()) {
				System.out.println(set.getInt(1) + "  "+set.getString(2));
			}
			
			
			// UPDATE
			System.out.print("Enter yo new name and id: ");
			String new_name = scanner.next();
			int target_id = scanner.nextInt();
			
			String queryupd = "UPDATE `user` SET `name` = '"+new_name+"' WHERE (`id` = '"+target_id+"')";
			
			int i1 = 0;
			i1 = statement.executeUpdate(queryupd);
			if(i1!=0) {
				System.out.println("Data Updated!");
			}
			
			
			// DELETE
			int del_id = scanner.nextInt();
			String querydel= "DELETE FROM `user` WHERE (`id` = '"+del_id+"');";
			
			int i2 = 0;
			i2 = statement.executeUpdate(querydel);
			if(i2!=0) {
				System.out.println("Data Deleted!");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
