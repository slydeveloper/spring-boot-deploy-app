package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

/**
 * Handle page card header color parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class PageCardHeaderColorTemplateItem implements IWebTemplateItem {

    /**
     * Card header color.
     * Default: bg-info
     */
    @Value("${page.card.header.color:bg-info}")
    private String attributeValue;

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.PAGE_CARD_HEADER_COLOR.getKey();
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
