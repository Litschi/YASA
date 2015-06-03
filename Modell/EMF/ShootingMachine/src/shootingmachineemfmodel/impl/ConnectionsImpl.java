/**
 */
package shootingmachineemfmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import shootingmachineemfmodel.Connections;
import shootingmachineemfmodel.ReceiverPorts;
import shootingmachineemfmodel.SenderPorts;
import shootingmachineemfmodel.ShootingmachineemfmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connections</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link shootingmachineemfmodel.impl.ConnectionsImpl#getHasReceiverPorts <em>Has Receiver Ports</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.ConnectionsImpl#getHasSenderPorts <em>Has Sender Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionsImpl extends MinimalEObjectImpl.Container implements Connections {
	/**
	 * The cached value of the '{@link #getHasReceiverPorts() <em>Has Receiver Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasReceiverPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<ReceiverPorts> hasReceiverPorts;

	/**
	 * The cached value of the '{@link #getHasSenderPorts() <em>Has Sender Ports</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasSenderPorts()
	 * @generated
	 * @ordered
	 */
	protected SenderPorts hasSenderPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShootingmachineemfmodelPackage.Literals.CONNECTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReceiverPorts> getHasReceiverPorts() {
		if (hasReceiverPorts == null) {
			hasReceiverPorts = new EObjectResolvingEList<ReceiverPorts>(ReceiverPorts.class, this, ShootingmachineemfmodelPackage.CONNECTIONS__HAS_RECEIVER_PORTS);
		}
		return hasReceiverPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderPorts getHasSenderPorts() {
		if (hasSenderPorts != null && hasSenderPorts.eIsProxy()) {
			InternalEObject oldHasSenderPorts = (InternalEObject)hasSenderPorts;
			hasSenderPorts = (SenderPorts)eResolveProxy(oldHasSenderPorts);
			if (hasSenderPorts != oldHasSenderPorts) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ShootingmachineemfmodelPackage.CONNECTIONS__HAS_SENDER_PORTS, oldHasSenderPorts, hasSenderPorts));
			}
		}
		return hasSenderPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderPorts basicGetHasSenderPorts() {
		return hasSenderPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasSenderPorts(SenderPorts newHasSenderPorts) {
		SenderPorts oldHasSenderPorts = hasSenderPorts;
		hasSenderPorts = newHasSenderPorts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.CONNECTIONS__HAS_SENDER_PORTS, oldHasSenderPorts, hasSenderPorts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_RECEIVER_PORTS:
				return getHasReceiverPorts();
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_SENDER_PORTS:
				if (resolve) return getHasSenderPorts();
				return basicGetHasSenderPorts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_RECEIVER_PORTS:
				getHasReceiverPorts().clear();
				getHasReceiverPorts().addAll((Collection<? extends ReceiverPorts>)newValue);
				return;
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_SENDER_PORTS:
				setHasSenderPorts((SenderPorts)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_RECEIVER_PORTS:
				getHasReceiverPorts().clear();
				return;
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_SENDER_PORTS:
				setHasSenderPorts((SenderPorts)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_RECEIVER_PORTS:
				return hasReceiverPorts != null && !hasReceiverPorts.isEmpty();
			case ShootingmachineemfmodelPackage.CONNECTIONS__HAS_SENDER_PORTS:
				return hasSenderPorts != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectionsImpl
