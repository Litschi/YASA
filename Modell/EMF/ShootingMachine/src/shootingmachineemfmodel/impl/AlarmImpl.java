/**
 */
package shootingmachineemfmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import shootingmachineemfmodel.Alarm;
import shootingmachineemfmodel.ShootingmachineemfmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alarm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link shootingmachineemfmodel.impl.AlarmImpl#getMINCYCLE <em>MINCYCLE</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.AlarmImpl#getMAXALLOWEDVALUE <em>MAXALLOWEDVALUE</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.AlarmImpl#getTICKSPERBASE <em>TICKSPERBASE</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.AlarmImpl#isAUTOSTART <em>AUTOSTART</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.AlarmImpl#getALARMTIME <em>ALARMTIME</em>}</li>
 *   <li>{@link shootingmachineemfmodel.impl.AlarmImpl#getCYCLETIME <em>CYCLETIME</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlarmImpl extends StandardclassImpl implements Alarm {
	/**
	 * The default value of the '{@link #getMINCYCLE() <em>MINCYCLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMINCYCLE()
	 * @generated
	 * @ordered
	 */
	protected static final int MINCYCLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMINCYCLE() <em>MINCYCLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMINCYCLE()
	 * @generated
	 * @ordered
	 */
	protected int mincycle = MINCYCLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMAXALLOWEDVALUE() <em>MAXALLOWEDVALUE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMAXALLOWEDVALUE()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXALLOWEDVALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMAXALLOWEDVALUE() <em>MAXALLOWEDVALUE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMAXALLOWEDVALUE()
	 * @generated
	 * @ordered
	 */
	protected int maxallowedvalue = MAXALLOWEDVALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTICKSPERBASE() <em>TICKSPERBASE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTICKSPERBASE()
	 * @generated
	 * @ordered
	 */
	protected static final int TICKSPERBASE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTICKSPERBASE() <em>TICKSPERBASE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTICKSPERBASE()
	 * @generated
	 * @ordered
	 */
	protected int ticksperbase = TICKSPERBASE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAUTOSTART() <em>AUTOSTART</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAUTOSTART()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOSTART_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAUTOSTART() <em>AUTOSTART</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAUTOSTART()
	 * @generated
	 * @ordered
	 */
	protected boolean autostart = AUTOSTART_EDEFAULT;

	/**
	 * The default value of the '{@link #getALARMTIME() <em>ALARMTIME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getALARMTIME()
	 * @generated
	 * @ordered
	 */
	protected static final int ALARMTIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getALARMTIME() <em>ALARMTIME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getALARMTIME()
	 * @generated
	 * @ordered
	 */
	protected int alarmtime = ALARMTIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCYCLETIME() <em>CYCLETIME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCYCLETIME()
	 * @generated
	 * @ordered
	 */
	protected static final int CYCLETIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCYCLETIME() <em>CYCLETIME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCYCLETIME()
	 * @generated
	 * @ordered
	 */
	protected int cycletime = CYCLETIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlarmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShootingmachineemfmodelPackage.Literals.ALARM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMINCYCLE() {
		return mincycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMINCYCLE(int newMINCYCLE) {
		int oldMINCYCLE = mincycle;
		mincycle = newMINCYCLE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.ALARM__MINCYCLE, oldMINCYCLE, mincycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMAXALLOWEDVALUE() {
		return maxallowedvalue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMAXALLOWEDVALUE(int newMAXALLOWEDVALUE) {
		int oldMAXALLOWEDVALUE = maxallowedvalue;
		maxallowedvalue = newMAXALLOWEDVALUE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.ALARM__MAXALLOWEDVALUE, oldMAXALLOWEDVALUE, maxallowedvalue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTICKSPERBASE() {
		return ticksperbase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTICKSPERBASE(int newTICKSPERBASE) {
		int oldTICKSPERBASE = ticksperbase;
		ticksperbase = newTICKSPERBASE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.ALARM__TICKSPERBASE, oldTICKSPERBASE, ticksperbase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAUTOSTART() {
		return autostart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAUTOSTART(boolean newAUTOSTART) {
		boolean oldAUTOSTART = autostart;
		autostart = newAUTOSTART;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.ALARM__AUTOSTART, oldAUTOSTART, autostart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getALARMTIME() {
		return alarmtime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setALARMTIME(int newALARMTIME) {
		int oldALARMTIME = alarmtime;
		alarmtime = newALARMTIME;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.ALARM__ALARMTIME, oldALARMTIME, alarmtime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCYCLETIME() {
		return cycletime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCYCLETIME(int newCYCLETIME) {
		int oldCYCLETIME = cycletime;
		cycletime = newCYCLETIME;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShootingmachineemfmodelPackage.ALARM__CYCLETIME, oldCYCLETIME, cycletime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.ALARM__MINCYCLE:
				return getMINCYCLE();
			case ShootingmachineemfmodelPackage.ALARM__MAXALLOWEDVALUE:
				return getMAXALLOWEDVALUE();
			case ShootingmachineemfmodelPackage.ALARM__TICKSPERBASE:
				return getTICKSPERBASE();
			case ShootingmachineemfmodelPackage.ALARM__AUTOSTART:
				return isAUTOSTART();
			case ShootingmachineemfmodelPackage.ALARM__ALARMTIME:
				return getALARMTIME();
			case ShootingmachineemfmodelPackage.ALARM__CYCLETIME:
				return getCYCLETIME();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ShootingmachineemfmodelPackage.ALARM__MINCYCLE:
				setMINCYCLE((Integer)newValue);
				return;
			case ShootingmachineemfmodelPackage.ALARM__MAXALLOWEDVALUE:
				setMAXALLOWEDVALUE((Integer)newValue);
				return;
			case ShootingmachineemfmodelPackage.ALARM__TICKSPERBASE:
				setTICKSPERBASE((Integer)newValue);
				return;
			case ShootingmachineemfmodelPackage.ALARM__AUTOSTART:
				setAUTOSTART((Boolean)newValue);
				return;
			case ShootingmachineemfmodelPackage.ALARM__ALARMTIME:
				setALARMTIME((Integer)newValue);
				return;
			case ShootingmachineemfmodelPackage.ALARM__CYCLETIME:
				setCYCLETIME((Integer)newValue);
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
			case ShootingmachineemfmodelPackage.ALARM__MINCYCLE:
				setMINCYCLE(MINCYCLE_EDEFAULT);
				return;
			case ShootingmachineemfmodelPackage.ALARM__MAXALLOWEDVALUE:
				setMAXALLOWEDVALUE(MAXALLOWEDVALUE_EDEFAULT);
				return;
			case ShootingmachineemfmodelPackage.ALARM__TICKSPERBASE:
				setTICKSPERBASE(TICKSPERBASE_EDEFAULT);
				return;
			case ShootingmachineemfmodelPackage.ALARM__AUTOSTART:
				setAUTOSTART(AUTOSTART_EDEFAULT);
				return;
			case ShootingmachineemfmodelPackage.ALARM__ALARMTIME:
				setALARMTIME(ALARMTIME_EDEFAULT);
				return;
			case ShootingmachineemfmodelPackage.ALARM__CYCLETIME:
				setCYCLETIME(CYCLETIME_EDEFAULT);
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
			case ShootingmachineemfmodelPackage.ALARM__MINCYCLE:
				return mincycle != MINCYCLE_EDEFAULT;
			case ShootingmachineemfmodelPackage.ALARM__MAXALLOWEDVALUE:
				return maxallowedvalue != MAXALLOWEDVALUE_EDEFAULT;
			case ShootingmachineemfmodelPackage.ALARM__TICKSPERBASE:
				return ticksperbase != TICKSPERBASE_EDEFAULT;
			case ShootingmachineemfmodelPackage.ALARM__AUTOSTART:
				return autostart != AUTOSTART_EDEFAULT;
			case ShootingmachineemfmodelPackage.ALARM__ALARMTIME:
				return alarmtime != ALARMTIME_EDEFAULT;
			case ShootingmachineemfmodelPackage.ALARM__CYCLETIME:
				return cycletime != CYCLETIME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (MINCYCLE: ");
		result.append(mincycle);
		result.append(", MAXALLOWEDVALUE: ");
		result.append(maxallowedvalue);
		result.append(", TICKSPERBASE: ");
		result.append(ticksperbase);
		result.append(", AUTOSTART: ");
		result.append(autostart);
		result.append(", ALARMTIME: ");
		result.append(alarmtime);
		result.append(", CYCLETIME: ");
		result.append(cycletime);
		result.append(')');
		return result.toString();
	}

} //AlarmImpl
