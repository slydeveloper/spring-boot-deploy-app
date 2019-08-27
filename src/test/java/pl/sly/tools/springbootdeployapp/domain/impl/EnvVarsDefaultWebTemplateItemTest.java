package pl.sly.tools.springbootdeployapp.domain.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Test of {@link IWebTemplateItem} default environment variables.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvVarsDefaultWebTemplateItemTest {

    @Autowired
    private List<IWebTemplateItem> webTemplateItems;

    /**
     * Test if default environment variables provided by {@link IWebTemplateItem} are valid.
     */
    @Test
    public void testIWebTemplateItems() {
        webTemplateItems
                .stream()
                .forEach(iWebTemplateItemConsumer);
    }

    Consumer<IWebTemplateItem> iWebTemplateItemConsumer = item -> {
        if (item instanceof AppNameTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.APP_NAME.toString());
            assertThat(item.getAttributeValue()).isEqualTo("Spring Boot Deploy App");
        }
        if (item instanceof AppTitleTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.APP_TITLE.toString());
            assertThat(item.getAttributeValue()).isEqualTo("Spring Boot Deploy App");
        }
    };
}
