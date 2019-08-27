package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle application title parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class AppTitleTemplateItem implements IWebTemplateItem {

    /**
     * Environment variable: SPRING_BOOT_DEPLOY_APP_TITLE
     * Default: Spring Boot Deploy App
     */
    @Value("${SPRING_BOOT_DEPLOY_APP_TITLE:Spring Boot Deploy App}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.APP_TITLE.getKey();
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
