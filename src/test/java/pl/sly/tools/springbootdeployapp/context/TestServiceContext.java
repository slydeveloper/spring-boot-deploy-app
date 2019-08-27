package pl.sly.tools.springbootdeployapp.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;
import pl.sly.tools.springbootdeployapp.service.WebTemplateService;
import pl.sly.tools.springbootdeployapp.service.impl.WebTemplateServiceImpl;

/**
 * Test application context for verify injection of {@link IWebTemplateItem}
 */
@Configuration
public class TestServiceContext {

    /**
     * Bean of {@link WebTemplateServiceImpl} that implements {@link WebTemplateService}
     * for verify injection of {@link IWebTemplateItem}
     *
     * @return {@link WebTemplateServiceImpl} instance
     */
    @Bean
    public WebTemplateService webTemplateService() {
        return new WebTemplateServiceImpl();
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
}