/**
 */
package shootingmachineemfmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import shootingmachineemfmodel.Alarm;
import shootingmachineemfmodel.Brick;
import shootingmachineemfmodel.Client;
import shootingmachineemfmodel.Connections;
import shootingmachineemfmodel.Display;
import shootingmachineemfmodel.Event;
import shootingmachineemfmodel.GetEvent;
import shootingmachineemfmodel.HWExtern;
import shootingmachineemfmodel.HWIntern;
import shootingmachineemfmodel.HWPort;
import shootingmachineemfmodel.HWType;
import shootingmachineemfmodel.InterBrickCommunication;
import shootingmachineemfmodel.Message;
import shootingmachineemfmodel.Motor;
import shootingmachineemfmodel.OSPortIN;
import shootingmachineemfmodel.OSPortOUT;
import shootingmachineemfmodel.Receiver;
import shootingmachineemfmodel.SA_Component;
import shootingmachineemfmodel.SW_Component;
import shootingmachineemfmodel.SendEvent;
import shootingmachineemfmodel.Sender;
import shootingmachineemfmodel.Server;
import shootingmachineemfmodel.ShootingmachineemfmodelFactory;
import shootingmachineemfmodel.ShootingmachineemfmodelPackage;
import shootingmachineemfmodel.Task;
import shootingmachineemfmodel.ToplevelSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ShootingmachineemfmodelFactoryImpl extends EFactoryImpl implements ShootingmachineemfmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ShootingmachineemfmodelFactory init() {
		try {
			ShootingmachineemfmodelFactory theShootingmachineemfmodelFactory = (ShootingmachineemfmodelFactory)EPackage.Registry.INSTANCE.getEFactory(ShootingmachineemfmodelPackage.eNS_URI);
			if (theShootingmachineemfmodelFactory != null) {
				return theShootingmachineemfmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ShootingmachineemfmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShootingmachineemfmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ShootingmachineemfmodelPackage.TOPLEVEL_SYSTEM: return createToplevelSystem();
			case ShootingmachineemfmodelPackage.BRICK: return createBrick();
			case ShootingmachineemfmodelPackage.SA_COMPONENT: return createSA_Component();
			case ShootingmachineemfmodelPackage.SW_COMPONENT: return createSW_Component();
			case ShootingmachineemfmodelPackage.SENDER: return createSender();
			case ShootingmachineemfmodelPackage.CLIENT: return createClient();
			case ShootingmachineemfmodelPackage.SEND_EVENT: return createSendEvent();
			case ShootingmachineemfmodelPackage.RECEIVER: return createReceiver();
			case ShootingmachineemfmodelPackage.SERVER: return createServer();
			case ShootingmachineemfmodelPackage.GET_EVENT: return createGetEvent();
			case ShootingmachineemfmodelPackage.TASK: return createTask();
			case ShootingmachineemfmodelPackage.EVENT: return createEvent();
			case ShootingmachineemfmodelPackage.ALARM: return createAlarm();
			case ShootingmachineemfmodelPackage.CONNECTIONS: return createConnections();
			case ShootingmachineemfmodelPackage.RUNNABLE: return createRunnable();
			case ShootingmachineemfmodelPackage.INTER_BRICK_COMMUNICATION: return createInterBrickCommunication();
			case ShootingmachineemfmodelPackage.HW_INTERN: return createHWIntern();
			case ShootingmachineemfmodelPackage.HW_EXTERN: return createHWExtern();
			case ShootingmachineemfmodelPackage.MOTOR: return createMotor();
			case ShootingmachineemfmodelPackage.DISPLAY: return createDisplay();
			case ShootingmachineemfmodelPackage.MESSAGE: return createMessage();
			case ShootingmachineemfmodelPackage.OS_PORT_IN: return createOSPortIN();
			case ShootingmachineemfmodelPackage.OS_PORT_OUT: return createOSPortOUT();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ShootingmachineemfmodelPackage.HW_TYPE:
				return createHWTypeFromString(eDataType, initialValue);
			case ShootingmachineemfmodelPackage.HW_PORT:
				return createHWPortFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ShootingmachineemfmodelPackage.HW_TYPE:
				return convertHWTypeToString(eDataType, instanceValue);
			case ShootingmachineemfmodelPackage.HW_PORT:
				return convertHWPortToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToplevelSystem createToplevelSystem() {
		ToplevelSystemImpl toplevelSystem = new ToplevelSystemImpl();
		return toplevelSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Brick createBrick() {
		BrickImpl brick = new BrickImpl();
		return brick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SA_Component createSA_Component() {
		SA_ComponentImpl sA_Component = new SA_ComponentImpl();
		return sA_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_Component createSW_Component() {
		SW_ComponentImpl sW_Component = new SW_ComponentImpl();
		return sW_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sender createSender() {
		SenderImpl sender = new SenderImpl();
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Client createClient() {
		ClientImpl client = new ClientImpl();
		return client;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendEvent createSendEvent() {
		SendEventImpl sendEvent = new SendEventImpl();
		return sendEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Receiver createReceiver() {
		ReceiverImpl receiver = new ReceiverImpl();
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server createServer() {
		ServerImpl server = new ServerImpl();
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetEvent createGetEvent() {
		GetEventImpl getEvent = new GetEventImpl();
		return getEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alarm createAlarm() {
		AlarmImpl alarm = new AlarmImpl();
		return alarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connections createConnections() {
		ConnectionsImpl connections = new ConnectionsImpl();
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public shootingmachineemfmodel.Runnable createRunnable() {
		RunnableImpl runnable = new RunnableImpl();
		return runnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterBrickCommunication createInterBrickCommunication() {
		InterBrickCommunicationImpl interBrickCommunication = new InterBrickCommunicationImpl();
		return interBrickCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWIntern createHWIntern() {
		HWInternImpl hwIntern = new HWInternImpl();
		return hwIntern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWExtern createHWExtern() {
		HWExternImpl hwExtern = new HWExternImpl();
		return hwExtern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Motor createMotor() {
		MotorImpl motor = new MotorImpl();
		return motor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Display createDisplay() {
		DisplayImpl display = new DisplayImpl();
		return display;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSPortIN createOSPortIN() {
		OSPortINImpl osPortIN = new OSPortINImpl();
		return osPortIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSPortOUT createOSPortOUT() {
		OSPortOUTImpl osPortOUT = new OSPortOUTImpl();
		return osPortOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWType createHWTypeFromString(EDataType eDataType, String initialValue) {
		HWType result = HWType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHWTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWPort createHWPortFromString(EDataType eDataType, String initialValue) {
		HWPort result = HWPort.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHWPortToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShootingmachineemfmodelPackage getShootingmachineemfmodelPackage() {
		return (ShootingmachineemfmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ShootingmachineemfmodelPackage getPackage() {
		return ShootingmachineemfmodelPackage.eINSTANCE;
	}

} //ShootingmachineemfmodelFactoryImpl
