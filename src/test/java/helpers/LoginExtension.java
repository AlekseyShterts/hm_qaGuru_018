package helpers;

import api.AuthSteps;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoginExtension implements BeforeEachCallback{
    @Override
    public void beforeEach(ExtensionContext context) {
        AuthSteps.setCookies(AuthSteps.getResponse());
    }
}
