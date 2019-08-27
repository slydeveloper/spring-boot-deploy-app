package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle page card URL name parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class PageProjectUrlNameTemplateItem implements IWebTemplateItem {

    /**
     * Page URL name parameter.
     * Default: Github project
     */
    @Value("${page.project.url.name:Github project}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.PAGE_PROJECT_URL_NAME.getKey();
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
