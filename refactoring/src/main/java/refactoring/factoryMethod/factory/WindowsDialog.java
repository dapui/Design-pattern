package refactoring.factoryMethod.factory;

import refactoring.factoryMethod.buttons.Button;
import refactoring.factoryMethod.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
