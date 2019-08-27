package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle application version parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class AppVersionTemplateItem implements IWebTemplateItem {

    /**
     * Application version
     */
    @Value("${app.version}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.APP_VERSION.getKey();
    }

    @Override
    public String getAttributeValue() {
        return this.attributeValue;
    }

    @Override
    public ActuatorInfoType getInfoType() {
        return ActuatorInfoType.APP;
    }
}
