package pl.sly.tools.springbootdeployapp.domain.impl;

import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Handle container ID parameter.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class ContainerIdTemplateItem implements IWebTemplateItem {

    private static final String UNKNOWN = "unknown";

    @Override
    public String getAttributeName() {
        return WebTemplateAttributeType.CONTAINER_ID.getKey();
    }

    @Override
    public String getAttributeValue() {
        return provideHostname();
    }

    @Override
    public ActuatorInfoType getInfoType() {
        return ActuatorInfoType.CONTAINER;
    }

    /**
     * Discover hostname based on network settings.
     *
     * @return hostname
     */
    protected String provideHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return UNKNOWN;
    }
}
