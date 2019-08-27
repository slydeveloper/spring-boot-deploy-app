package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle page title parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class PageTitleTemplateItem implements IWebTemplateItem {

    /**
     * Page title parameter.
     * Default: Spring Boot Deploy App
     */
    @Value("${page.title:Spring Boot Deploy App}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.PAGE_TITLE.getKey();
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
