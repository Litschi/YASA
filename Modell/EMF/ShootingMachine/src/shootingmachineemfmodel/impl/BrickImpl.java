/**
 */
package shootingmachineemfmodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import shootingmachineemfmodel.Alarm;
import shootingmachineemfmodel.Brick;
import shootingmachineemfmodel.Event;
import shootingmachineemfmodel.HWPorts;
import shootingmachineemfmodel.InterBrickCommunication;
import shootingmachineemfmodel.ShootingmachineemfmodelPackage;
import shootingmachineemfmodel.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link shootingmachineemfmodel.impl.BrickImpl#getHasTaskBrick <em>Has Task Brick</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.BrickImpl#getHasEventBrick <em>Has Event Brick</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.BrickImpl#getHasAlarmBrick <em>Has Alarm Brick</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.BrickImpl#getHasHWPortsBrick <em>Has HW Ports Brick</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.BrickImpl#getHasInterBrickCommunicationBrick <em>Has Inter Brick Communication Brick</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BrickImpl extends MinimalEObjectImpl.Container implements Brick {
	/**
	 * The cached value of the '{@link #getHasTaskBrick() <em>Has Task Brick</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasTaskBrick()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> hasTaskBrick;

	/**
	 * The cached value of the '{@link #getHasEventBrick() <em>Has Event Brick</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasEventBrick()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> hasEventBrick;

	/**
	 * The cached value of the '{@link #getHasAlarmBrick() <em>Has Alarm Brick</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasAlarmBrick()
	 * @generated
	 * @ordered
	 */
	protected EList<Alarm> hasAlarmBrick;

	/**
	 * The cached value of the '{@link #getHasHWPortsBrick() <em>Has HW Ports Brick</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasHWPortsBrick()
	 * @generated
	 * @ordered
	 */
	protected EList<HWPorts> hasHWPortsBrick;

	/**
	 * The cached value of the '{@link #getHasInterBrickCommunicationBrick() <em>Has Inter Brick Communication Brick</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasInterBrickCommunicationBrick()
	 * @generated
	 * @ordered
	 */
	protected InterBrickCommunication hasInterBrickCommunicationBrick;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShootingmachineemfmodelPackage.Literals.BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getHasTaskBrick() {
		if (hasTaskBrick == null) {
			hasTaskBrick = new EObjectContainmentEList<Task>(Task.class, this, ShootingmachineemfmodelPackage.BRICK__HAS_TASK_BRICK);
		}
		return hasTaskBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getHasEventBrick() {
		if (hasEventBrick == null) {
			hasEventBrick = new EObjectContainmentEList<Event>(Event.class, this, ShootingmachineemfmodelPackage.BRICK__HAS_EVENT_BRICK);
		}
		return hasEventBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Alarm> getHasAlarmBrick() {
		if (hasAlarmBrick == null) {
			hasAlarmBrick = new EObjectContainmentEList<Alarm>(Alarm.class, this, ShootingmachineemfmodelPackage.BRICK__HAS_ALARM_BRICK);
		}
		return hasAlarmBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HWPorts> getHasHWPortsBrick() {
		if (hasHWPortsBrick == null) {
			hasHWPortsBrick = new EObjectContainmentEList<HWPorts>(HWPorts.class, this, ShootingmachineemfmodelPackage.BRICK__HAS_HW_PORTS_BRICK);
		}
		return hasHWPortsBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterBrickCommunication getHasInterBrickCommunicationBrick() {
		if (hasInterBrickCommunicationBrick != null && hasInterBrickCommunicationBrick.eIsProxy()) {
			InternalEObject oldHasInterBrickCommunicationBrick = (InternalEObject)hasInterBrickCommunicationBrick;
			hasInterBrickCommunicationBrick = (InterBrickCommunication)eResolveProxy(oldHasInterBrickCommunicationBrick);
			if (hasInterBrickCommunicationBrick != oldHasInterBrickCommunicationBrick) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ShootingmachineemfmodelPackage.BRICK__HAS_INTER_BRICK_COMMUNICATION_BRICK, oldHasInterBrickCommunicationBrick, hasInterBrickCommunicationBrick));
			}
		}
		return hasInterBrickCommunicationBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterBrickCommunication basicGetHasInterBrickCommunicationBrick() {
		return hasInterBrickCommunicationBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasInterBrickCommunicationBrick(InterBrickCommunication newHasInterBrickCommunicationBrick) {
		InterBrickCommunication oldHasInterBrickCommunicationBrick = hasInterBrickCommunicationBrick;
		hasInterBrickCommunicationBrick = newHasInterBrickCommunicationBrick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.BRICK__HAS_INTER_BRICK_COMMUNICATION_BRICK, oldHasInterBrickCommunicationBrick, hasInterBrickCommunicationBrick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.BRICK__HAS_TASK_BRICK:
				return ((InternalEList<?>)getHasTaskBrick()).basicRemove(otherEnd, msgs);
			case ShootingmachineemfmodelPackage.BRICK__HAS_EVENT_BRICK:
				return ((InternalEList<?>)getHasEventBrick()).basicRemove(otherEnd, msgs);
			case ShootingmachineemfmodelPackage.BRICK__HAS_ALARM_BRICK:
				return ((InternalEList<?>)getHasAlarmBrick()).basicRemove(otherEnd, msgs);
			case ShootingmachineemfmodelPackage.BRICK__HAS_HW_PORTS_BRICK:
				return ((InternalEList<?>)getHasHWPortsBrick()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.BRICK__HAS_TASK_BRICK:
				return getHasTaskBrick();
			case ShootingmachineemfmodelPackage.BRICK__HAS_EVENT_BRICK:
				return getHasEventBrick();
			case ShootingmachineemfmodelPackage.BRICK__HAS_ALARM_BRICK:
				return getHasAlarmBrick();
			case ShootingmachineemfmodelPackage.BRICK__HAS_HW_PORTS_BRICK:
				return getHasHWPortsBrick();
			case ShootingmachineemfmodelPackage.BRICK__HAS_INTER_BRICK_COMMUNICATION_BRICK:
				if (resolve) return getHasInterBrickCommunicationBrick();
				return basicGetHasInterBrickCommunicationBrick();
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
			case ShootingmachineemfmodelPackage.BRICK__HAS_TASK_BRICK:
				getHasTaskBrick().clear();
				getHasTaskBrick().addAll((Collection<? extends Task>)newValue);
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_EVENT_BRICK:
				getHasEventBrick().clear();
				getHasEventBrick().addAll((Collection<? extends Event>)newValue);
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_ALARM_BRICK:
				getHasAlarmBrick().clear();
				getHasAlarmBrick().addAll((Collection<? extends Alarm>)newValue);
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_HW_PORTS_BRICK:
				getHasHWPortsBrick().clear();
				getHasHWPortsBrick().addAll((Collection<? extends HWPorts>)newValue);
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_INTER_BRICK_COMMUNICATION_BRICK:
				setHasInterBrickCommunicationBrick((InterBrickCommunication)newValue);
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
			case ShootingmachineemfmodelPackage.BRICK__HAS_TASK_BRICK:
				getHasTaskBrick().clear();
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_EVENT_BRICK:
				getHasEventBrick().clear();
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_ALARM_BRICK:
				getHasAlarmBrick().clear();
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_HW_PORTS_BRICK:
				getHasHWPortsBrick().clear();
				return;
			case ShootingmachineemfmodelPackage.BRICK__HAS_INTER_BRICK_COMMUNICATION_BRICK:
				setHasInterBrickCommunicationBrick((InterBrickCommunication)null);
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
			case ShootingmachineemfmodelPackage.BRICK__HAS_TASK_BRICK:
				return hasTaskBrick != null && !hasTaskBrick.isEmpty();
			case ShootingmachineemfmodelPackage.BRICK__HAS_EVENT_BRICK:
				return hasEventBrick != null && !hasEventBrick.isEmpty();
			case ShootingmachineemfmodelPackage.BRICK__HAS_ALARM_BRICK:
				return hasAlarmBrick != null && !hasAlarmBrick.isEmpty();
			case ShootingmachineemfmodelPackage.BRICK__HAS_HW_PORTS_BRICK:
				return hasHWPortsBrick != null && !hasHWPortsBrick.isEmpty();
			case ShootingmachineemfmodelPackage.BRICK__HAS_INTER_BRICK_COMMUNICATION_BRICK:
				return hasInterBrickCommunicationBrick != null;
		}
		return super.eIsSet(featureID);
	}

} //BrickImpl
