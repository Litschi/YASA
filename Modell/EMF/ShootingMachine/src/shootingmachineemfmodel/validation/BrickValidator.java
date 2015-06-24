/**
 *
 * $Id$
 */
package shootingmachineemfmodel.validation;

import org.eclipse.emf.common.util.EList;

import shootingmachineemfmodel.Alarm;
import shootingmachineemfmodel.Event;
import shootingmachineemfmodel.HWPorts;
import shootingmachineemfmodel.Task;

/**
 * A sample validator interface for {@link shootingmachineemfmodel.Brick}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface BrickValidator {
	boolean validate();

	boolean validateHasTaskBrick(EList<Task> value);
	boolean validateHasEventBrick(EList<Event> value);
	boolean validateHasAlarmBrick(EList<Alarm> value);
	boolean validateHasHWPortsBrick(EList<HWPorts> value);
}
