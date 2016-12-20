package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class demo {
	
	public void test(Connection pLink) throws SQLException {
		Statement stmt = pLink.createStatement();
		
		PreparedStatement prestmt = pLink.prepareStatement("");
		prestmt.addBatch();
	}

	public static void main(String[] args) {
		
	}
}
