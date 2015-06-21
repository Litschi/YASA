/**
 */
package shootingmachineemfmodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import shootingmachineemfmodel.ShootingmachineemfmodelFactory;
import shootingmachineemfmodel.ShootingmachineemfmodelPackage;
import shootingmachineemfmodel.ToplevelSystem;

/**
 * This is the item provider adapter for a {@link shootingmachineemfmodel.ToplevelSystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ToplevelSystemItemProvider
	extends StandardclassItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToplevelSystemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_COMPONENT);
			childrenFeatures.add(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_BRICK);
			childrenFeatures.add(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_CONNECTIONS);
			childrenFeatures.add(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_INTER_BRICK_COMMUNICATION_SYSTEM);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ToplevelSystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ToplevelSystem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ToplevelSystem)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ToplevelSystem_type") :
			getString("_UI_ToplevelSystem_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ToplevelSystem.class)) {
			case ShootingmachineemfmodelPackage.TOPLEVEL_SYSTEM__HAS_COMPONENT:
			case ShootingmachineemfmodelPackage.TOPLEVEL_SYSTEM__HAS_BRICK:
			case ShootingmachineemfmodelPackage.TOPLEVEL_SYSTEM__HAS_CONNECTIONS:
			case ShootingmachineemfmodelPackage.TOPLEVEL_SYSTEM__HAS_INTER_BRICK_COMMUNICATION_SYSTEM:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_COMPONENT,
				 ShootingmachineemfmodelFactory.eINSTANCE.createSA_Component()));

		newChildDescriptors.add
			(createChildParameter
				(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_COMPONENT,
				 ShootingmachineemfmodelFactory.eINSTANCE.createSW_Component()));

		newChildDescriptors.add
			(createChildParameter
				(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_BRICK,
				 ShootingmachineemfmodelFactory.eINSTANCE.createBrick()));

		newChildDescriptors.add
			(createChildParameter
				(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_CONNECTIONS,
				 ShootingmachineemfmodelFactory.eINSTANCE.createConnections()));

		newChildDescriptors.add
			(createChildParameter
				(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_INTER_BRICK_COMMUNICATION_SYSTEM,
				 ShootingmachineemfmodelFactory.eINSTANCE.createInterBrickIn()));

		newChildDescriptors.add
			(createChildParameter
				(ShootingmachineemfmodelPackage.Literals.TOPLEVEL_SYSTEM__HAS_INTER_BRICK_COMMUNICATION_SYSTEM,
				 ShootingmachineemfmodelFactory.eINSTANCE.createInterBrickOut()));
	}

}