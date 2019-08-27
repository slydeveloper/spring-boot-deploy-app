package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle page card URL parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class PageProjectUrlTemplateItem implements IWebTemplateItem {

    /**
     * Page card URL parameter.
     */
    @Value("${page.project.url}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.PAGE_PROJECT_URL.getKey();
    }

    @Override
    public String getAttributeValue() {
        return this.attributeValue;
    }

    @Override
    public ActuatorInfoType getInfoType() {
        return ActuatorInfoType.NONE;
    }
}
