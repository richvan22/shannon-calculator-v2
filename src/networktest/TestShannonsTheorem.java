package networktest;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import network.ShannonsTheorem;
/**
 * This class runs j-unit tests for constructors and methods within ShannonsTheorem.java
 * @author    Richard Nguyen Feb, 12, 2017
 * @version   1.0.1
 */
public class TestShannonsTheorem extends TestCase {
	ShannonsTheorem app = new ShannonsTheorem();

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public TestShannonsTheorem(String name) { super(name);	}

	public static TestSuite suite() { return new TestSuite(TestShannonsTheorem.class);		}

	protected void setUp() throws Exception { System.out.println("TestShannonsTheorem Begin");	}

	protected void tearDown() throws Exception { System.out.println("TestShannonsTheorem End");	}
	/**
	 * Tests default constructor
	 */
	@Test
	public void testDefaultConstructor() {

		assertNotNull(new ShannonsTheorem());
	}
	/**
	 * Tests parameterized constructor
	 */
	@Test
	public void testParamConstructor() {

		assertNotNull(new ShannonsTheorem(10, 10));

		assertNotNull(new ShannonsTheorem(9.5, 10));	

		thrown.expect(IllegalArgumentException.class);
		new ShannonsTheorem(-1, -1);
	}
	/**
	 * Tests the method setBandwidth()
	 */
	@Test
	public void testSetBandwidth() {

		app.setBandwidth(1000);
		assertEquals(1000, app.getBandwidth(), 0);

		app.setBandwidth(1499.49);
		assertEquals(1499.49, app.getBandwidth(), 0);

		thrown.expect(IllegalArgumentException.class);
		app.setBandwidth(-1);

	}
	/**
	 * Tests the method setSignalToNoise()
	 */
	@Test
	public void testSetSignalToNoise() {

		app.setSignalToNoise(40);
		assertEquals(40, app.getSignalToNoise(), 0);

		app.setSignalToNoise(100.5);
		assertEquals(100.5, app.getSignalToNoise(), 0);

	}
	/**
	 * Tests the method getBandwidth()
	 */
	@Test
	public void testGetBandwidth() {

		app.setBandwidth(2000);
		assertEquals(2000, app.getBandwidth(), 0);

		app.setBandwidth(1000);
		assertEquals(1000, app.getBandwidth(), 0);

	}
	/**
	 * Tests the method getSignalToNoise()
	 */
	@Test
	public void testGetSignalToNoise() {

		app.setSignalToNoise(30);
		assertEquals(30, app.getSignalToNoise(), 0);	

		app.setSignalToNoise(100);
		assertEquals(100, app.getSignalToNoise(), 0);

		thrown.expect(IllegalArgumentException.class);
		app.setSignalToNoise(-1.5);

	}
	/**
	 * Tests the method getMaxDataRate()
	 */
	@Test
	public void testGetMaxDataRate() {

		app.setBandwidth(1000);
		app.setSignalToNoise(100);
		assertEquals(33219.28, app.getMaxDataRate(), 0.01);

		app.setBandwidth(100.5);
		app.setSignalToNoise(50.5);
		assertEquals(1685.96, app.getMaxDataRate(), 0.01);

		thrown.expect(IllegalArgumentException.class);
		app.getMaxDataRate(-1, -1);

	}
	/**
	 * Tests the parameterized method getMaxDataRate()
	 */
	@Test
	public void testGetMaxDataRateParam() {

		assertEquals(33219.28, app.getMaxDataRate(1000, 100), 0.01);
		assertEquals(1685.96, app.getMaxDataRate(100.5,50.5), 0.01);
	}
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing TestShannonsTheorem suite");
		junit.textui.TestRunner.run(suite());
	}

}
