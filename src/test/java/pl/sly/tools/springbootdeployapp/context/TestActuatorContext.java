package pl.sly.tools.springbootdeployapp.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sly.tools.springbootdeployapp.actuator.AppInfoContributor;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;

/**
 * Test application context for verify injection of {@link IWebTemplateItem}
 */
@Configuration
public class TestActuatorContext {

    /**
     * Bean of {@link AppInfoContributor} that implements {@link org.springframework.boot.actuate.info.InfoContributor}
     * for verify Actuator info endpoint.
     *
     * @return {@link AppInfoContributor} instance
     */
    @Bean
    public AppInfoContributor appInfoContributor() {
        return new AppInfoContributor();
    }

    /**
     * Test Bean 1
     *
     * @return {@link IWebTemplateItem}
     */
    @Bean
    public IWebTemplateItem webTemplateItemFirst() {
        return new IWebTemplateItem() {
            @Override
            public String getAttributeName() {
                return "ATTRIBUTE_NAME_1";
            }

            @Override
            public String getAttributeValue() {
                return "ATTRIBUTE_VALUE_1";
            }

            @Override
            public ActuatorInfoType getInfoType() {
                return ActuatorInfoType.APP;
            }
        };
    }

    /**
     * Test Bean 2
     *
     * @return {@link IWebTemplateItem}
     */
    @Bean
    public IWebTemplateItem webTemplateItemSecond() {
        return new IWebTemplateItem() {
            @Override
            public String getAttributeName() {
                return "ATTRIBUTE_NAME_2";
            }

            @Override
            public String getAttributeValue() {
                return "ATTRIBUTE_VALUE_2";
            }

            @Override
            public ActuatorInfoType getInfoType() {
                return ActuatorInfoType.APP;
            }
        };
    }

    /**
     * Test Bean 3
     *
     * @return {@link IWebTemplateItem}
     */
    @Bean
    public IWebTemplateItem webTemplateItemNone() {
        return new IWebTemplateItem() {
            @Override
            public String getAttributeName() {
                return "NONE_ATTRIBUTE_NAME";
            }

            @Override
            public String getAttributeValue() {
                return "NONE_ATTRIBUTE_VALUE";
            }

            @Override
            public ActuatorInfoType getInfoType() {
                return ActuatorInfoType.NONE;
            }
        };
    }

    /**
     * Test Bean 4
     *
     * @return {@link IWebTemplateItem}
     */
    @Bean
    public IWebTemplateItem webTemplateItemNull() {
        return new IWebTemplateItem() {
            @Override
            public String getAttributeName() {
                return "SOME_ATTRIBUTE_NAME";
            }

            @Override
            public String getAttributeValue() {
                return "SOME_ATTRIBUTE_VALUE";
            }

            @Override
            public ActuatorInfoType getInfoType() {
                return null;
            }
        };
    }
}