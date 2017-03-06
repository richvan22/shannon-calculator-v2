package networktest;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import network.ShannonsModel;
/**
 * This class runs j-unit tests for constructors and methods within ShannonsModel.java
 * @author    Richard Nguyen Feb, 12, 2017
 * @version   1.0.1
 */
public class TestShannonsModel extends TestCase {
	ShannonsModel model = new ShannonsModel();

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public TestShannonsModel(String name) { super(name);	}

	public static TestSuite suite() { return new TestSuite(TestShannonsModel.class);		}

	protected void setUp() throws Exception { System.out.println("TestShannonsModel Begin");	}

	protected void tearDown() throws Exception { System.out.println("TestShannonsModel End");	}
	/**
	 * Tests default constructor
	 */
	@Test
	public void testDefaultConstructor() {
		assertNotNull(new ShannonsModel());
	}
	/**
	 * Tests parameterized constructor
	 */
	@Test
	public void testParamConstructor() {

		assertNotNull(new ShannonsModel(10, 10));

		assertNotNull(new ShannonsModel(9.5, 10));
		
		thrown.expect(IllegalArgumentException.class);
		new ShannonsModel(-1, -1);
		
	}
	/**
	 * Tests the method setBandwidth()
	 */
	@Test
	public void testSetBandwidth() {

		model.setBandwidth(1000);
		assertEquals(1000, model.getBandwidth(), 0);

		model.setBandwidth(1499.49);
		assertEquals(1499.49, model.getBandwidth(), 0);
		
		thrown.expect(IllegalArgumentException.class);
		model.setBandwidth(-1);

	}
	/**
	 * Tests the method setSignalToNoise()
	 */
	@Test
	public void testSetSignalToNoise() {

		model.setSignalToNoise(40);
		assertEquals(40, model.getSignalToNoise(), 0);

		model.setSignalToNoise(100.5);
		assertEquals(100.5, model.getSignalToNoise(), 0);
		
		thrown.expect(IllegalArgumentException.class);
		model.setSignalToNoise(-1);
	}
	/**
	 * Tests the method getBandwidth()
	 */
	@Test
	public void testGetBandwidth() {

		model.setBandwidth(2000);
		assertEquals(2000, model.getBandwidth(), 0);

		model.setBandwidth(1000);
		assertEquals(1000, model.getBandwidth(), 0);	
		
	}
	/**
	 * Tests the method getSignalToNoise()
	 */
	@Test
	public void testGetSignalToNoise() {

		model.setSignalToNoise(30);
		assertEquals(30, model.getSignalToNoise(), 0);	

		model.setSignalToNoise(100);
		assertEquals(100, model.getSignalToNoise(), 0);

	}
	/**
	 * Tests the method getMaxDataRate()
	 */
	@Test
	public void testGetMaxDataRate() {

		model.setBandwidth(1000);
		model.setSignalToNoise(100);
		assertEquals(33219.28, model.getMaxDataRate(), 0.01);

		model.setBandwidth(100.5);
		model.setSignalToNoise(50.5);
		assertEquals(1685.96, model.getMaxDataRate(), 0.01);
		
	}
	/**
	 * Tests the parameterized method getMaxDataRate()
	 */
	@Test
	public void testGetMaxDataRateParam() {

		assertEquals(33219.28, model.getMaxDataRate(1000, 100), 0.01);

		assertEquals(1685.96, model.getMaxDataRate(100.5,50.5), 0.01);
		
		thrown.expect(IllegalArgumentException.class);
		model.getMaxDataRate(-1, -1);
		
	}
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing TestShannonsModel suite");
		junit.textui.TestRunner.run(suite());
	}

}
