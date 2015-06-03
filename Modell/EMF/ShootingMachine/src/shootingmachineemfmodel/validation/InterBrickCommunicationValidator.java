/**
 *
 * $Id$
 */
package shootingmachineemfmodel.validation;

import shootingmachineemfmodel.Brick;
import shootingmachineemfmodel.Message;

/**
 * A sample validator interface for {@link shootingmachineemfmodel.InterBrickCommunication}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InterBrickCommunicationValidator {
	boolean validate();

	boolean validateHasBrickInterBrickCommunication(Brick value);
	boolean validateHasMessageInterBrickCommunication(Message value);
	boolean validateMessageID(int value);

	boolean validateName(String value);
}
