/**
 */
package shootingmachineemfmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link shootingmachineemfmodel.System#getHasComponent <em>Has Component</em>}</li>
 *   <li>{@link shootingmachineemfmodel.System#getHasBrick <em>Has Brick</em>}</li>
 *   <li>{@link shootingmachineemfmodel.System#getHasConnections <em>Has Connections</em>}</li>
 *   <li>{@link shootingmachineemfmodel.System#getHasInterBrickCommunicationSystem <em>Has Inter Brick Communication System</em>}</li>
 * </ul>
 * </p>
 *
 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Has Component</b></em>' containment reference list.
	 * The list contents are of type {@link shootingmachineemfmodel.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Component</em>' containment reference list.
	 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getSystem_HasComponent()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Component> getHasComponent();

	/**
	 * Returns the value of the '<em><b>Has Brick</b></em>' containment reference list.
	 * The list contents are of type {@link shootingmachineemfmodel.Brick}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Brick</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Brick</em>' containment reference list.
	 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getSystem_HasBrick()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Brick> getHasBrick();

	/**
	 * Returns the value of the '<em><b>Has Connections</b></em>' containment reference list.
	 * The list contents are of type {@link shootingmachineemfmodel.Connections}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Connections</em>' containment reference list.
	 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getSystem_HasConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connections> getHasConnections();

	/**
	 * Returns the value of the '<em><b>Has Inter Brick Communication System</b></em>' containment reference list.
	 * The list contents are of type {@link shootingmachineemfmodel.InterBrickCommunication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Inter Brick Communication System</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Inter Brick Communication System</em>' containment reference list.
	 * @see shootingmachineemfmodel.ShootingmachineemfmodelPackage#getSystem_HasInterBrickCommunicationSystem()
	 * @model containment="true"
	 * @generated
	 */
	EList<InterBrickCommunication> getHasInterBrickCommunicationSystem();

} // System
