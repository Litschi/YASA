/**
 */
package shootingmachineemfmodel.tests;

import junit.textui.TestRunner;

import shootingmachineemfmodel.Sender;
import shootingmachineemfmodel.ShootingmachineemfmodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sender</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SenderTest extends SenderPortsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SenderTest.class);
	}

	/**
	 * Constructs a new Sender test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sender test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Sender getFixture() {
		return (Sender)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ShootingmachineemfmodelFactory.eINSTANCE.createSender());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SenderTest
