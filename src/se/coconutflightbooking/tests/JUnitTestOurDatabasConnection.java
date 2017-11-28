package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.coconutflightbooking.database.NotSupportedDataTypeException;
import se.coconutflightbooking.database.OurDatabasConnection;

class JUnitTestOurDatabasConnection {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		OurDatabasConnection oDC = new OurDatabasConnection("localhost", "50000", "Coconut");
		ArrayList<HashMap<String, Object>> rs;
		
		String sql1 = "Select * from \"USER\".\"TESTNUMBER\"";
		String sql2 = "Select * from \"USER\".\"TESTDATES\"";
		String sql3 = "Select * from \"USER\".\"TESTSTRING\"";
		
		try {
			rs = oDC.retrieveResult (sql1);
			rs = oDC.retrieveResult (sql2);
			rs = oDC.retrieveResult (sql3);
			
		} catch (NotSupportedDataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void testAddData() {
		OurDatabasConnection oDC = new OurDatabasConnection("localhost", "50000", "Coconut");
		ArrayList<HashMap<String, Object>> rs;
		
		String tableName1 = "\"USER\".\"TESTNUMBER\""; 
		
		String sql1 = "Select * from \"USER\".\"TESTNUMBER\"";
		String sql2 = "Select * from \"USER\".\"TESTDATES\"";
		String sql3 = "Select * from \"USER\".\"TESTSTRING\"";
		
		try {
			rs = oDC.retrieveResult (sql1);
			rs = oDC.retrieveResult (sql2);
			rs = oDC.retrieveResult (sql3);
			
		} catch (NotSupportedDataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String, Object> addArray = new HashMap<String, Object>();
		addArray.put("TEST_NUMERIC", 12.54);
		addArray.put("TEST_DECIMAL", 24.54);
		addArray.put("TEST_SMALLINT", 1);
		addArray.put("TEST_INTEGER", 500);
		
		try {
			
			boolean result = oDC.addData(addArray, tableName1);
			System.out.println("OurDatabasConnection::addData() returned: " + result);

			rs = oDC.retrieveResult (sql1);
			
		} catch (NotSupportedDataTypeException e) {
			System.out.println("NotSupportedDataTypeException in addData");
			//e.printStackTrace();
		}
		
	}

}
