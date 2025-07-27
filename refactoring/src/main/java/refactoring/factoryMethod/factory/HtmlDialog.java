package refactoring.factoryMethod.factory;

import refactoring.factoryMethod.buttons.Button;
import refactoring.factoryMethod.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
