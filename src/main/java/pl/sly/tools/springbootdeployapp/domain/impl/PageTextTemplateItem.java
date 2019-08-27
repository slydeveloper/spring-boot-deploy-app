package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle main text parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class PageTextTemplateItem implements IWebTemplateItem {

    /**
     * Main text parameter.
     * Default: N/A
     */
    @Value("${page.text:N/A}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.PAGE_TEXT.getKey();
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
