package excel;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class Import {

	public static void main(String[] args) throws Exception {
		importData();
//		Connection con = Import.getConnection();
//		Statement stmt = null;
//		ResultSet rs = null;
//		try{
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from servant");
//			ResultSetMetaData metaSet = rs.getMetaData();
//			for (int i = 1;i <= metaSet.getColumnCount(); i++) {
//				System.out.println(metaSet.getColumnName(i));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
	public static Connection  getConnection() throws Exception {
	     Class.forName("com.mysql.jdbc.Driver");
	     String url = "jdbc:mysql://localhost:3306/hbmdb?user=root&password=root";
	     return DriverManager.getConnection(url);
	}
	
	
	public static void importData() throws Exception{
		File file = new File("G:\\2017gkzwxx\\2017ÕÐ¿¼¼òÕÂ.xls");
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file)); 
		HSSFWorkbook hssfWorkbook =  new HSSFWorkbook(poifsFileSystem);
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {

			conn = Import.getConnection();
			pstmt = conn.prepareStatement("insert into servant (a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x1,y1,z1,z2,sheet) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			int sheet_count  = hssfWorkbook.getNumberOfSheets();
			for (int s = 0; s < sheet_count; s ++) {
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(s);
				
				int rowstart = hssfSheet.getFirstRowNum();
			    int rowEnd = hssfSheet.getLastRowNum();
			    for(int i=rowstart + 1;i<=rowEnd;i++)
			    {
			        HSSFRow row = hssfSheet.getRow(i);
			        if (row == null) {
			        	continue;
			        }
			        
			        int cellStart = row.getFirstCellNum();
			        int cellEnd = row.getLastCellNum();
			        int index = 1 ;
			        for(int k=cellStart;k<=26;k++)
			        {
			        	HSSFCell cell = row.getCell(k);
			            if(null==cell) {
			            	continue;
			            }
			            switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							pstmt.setInt(index ++, new Double(cell.getNumericCellValue()).intValue() );
							break;
						case HSSFCell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							pstmt.setString(index ++, cell.getStringCellValue());
							break;
						default:
							break;
						}
			           
			        }
			        pstmt.setInt(index ++, s);
			        pstmt.addBatch();
			        System.out.print("\n");
			    }
			}
			
			pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null){
				conn.close();
			}
			hssfWorkbook.close();
		}

	}
}
