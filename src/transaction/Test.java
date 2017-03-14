package transaction;

import java.sql.SQLException;

import javax.sql.XADataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

import oracle.jdbc.xa.client.OracleXADataSource;

public class Test {
	public static void main(String[] args) throws SQLException {
		XADataSource xa1 = new MysqlXADataSource();
		XADataSource xa2 = new OracleXADataSource();
		
		
	}

}
