package pl.sly.tools.springbootdeployapp.domain;

import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;

/**
 * Web template item data provider interface.
 *
 * @author Sylwester Sokolowski
 */
public interface IWebTemplateItem {

    /**
     * Name of attribute that will be match with ${TOKEN} in the frontend.
     *
     * @return name of attribute
     */
    String getAttributeName();

    /**
     * Value of attribute that will be replace with ${TOKEN} in the frontend.
     *
     * @return value of attribute
     */
    String getAttributeValue();

    /**
     * Type of item defines if item should be returned in the /actuator/info
     *
     * @return type of item.
     */
    ActuatorInfoType getInfoType();
}
