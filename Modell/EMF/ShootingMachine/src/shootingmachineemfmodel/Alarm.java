/**
 */
package shootingmachineemfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alarm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link shootingmachineemfmodel.Alarm#getHasCounter <em>Has Counter</em>}</li>
 * </ul>
 * </p>
 *
 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getAlarm()
 * @model
 * @generated
 */
public interface Alarm extends Standardclass {
	/**
	 * Returns the value of the '<em><b>Has Counter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Counter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Counter</em>' containment reference.
	 * @see #setHasCounter(Counter)
	 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getAlarm_HasCounter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Counter getHasCounter();

	/**
	 * Sets the value of the '{@link shootingmachineemfmodel.Alarm#getHasCounter <em>Has Counter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Counter</em>' containment reference.
	 * @see #getHasCounter()
	 * @generated
	 */
	void setHasCounter(Counter value);

} // Alarm
