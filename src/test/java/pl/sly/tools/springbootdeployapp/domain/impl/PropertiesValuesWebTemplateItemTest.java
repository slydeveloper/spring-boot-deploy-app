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
 * Test of {@link IWebTemplateItem} properties.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesValuesWebTemplateItemTest {

    @Autowired
    private List<IWebTemplateItem> webTemplateItems;

    /**
     * Test if properties provided by {@link IWebTemplateItem} are valid.
     */
    @Test
    public void testIWebTemplateItems() {
        webTemplateItems
                .stream()
                .forEach(iWebTemplateItemConsumer);
    }

    Consumer<IWebTemplateItem> iWebTemplateItemConsumer = item -> {
        if (item instanceof AppVersionTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.APP_VERSION.toString());
            assertThat(item.getAttributeValue()).isEqualTo("0.1");
        }
        if (item instanceof PageCardHeaderColorTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.PAGE_CARD_HEADER_COLOR.toString());
            assertThat(item.getAttributeValue()).isEqualTo("color");
        }
        if (item instanceof PageProjectUrlNameTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.PAGE_PROJECT_URL_NAME.toString());
            assertThat(item.getAttributeValue()).isEqualTo("project");
        }
        if (item instanceof PageProjectUrlTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.PAGE_PROJECT_URL.toString());
            assertThat(item.getAttributeValue()).isEqualTo("http://example.com");
        }
        if (item instanceof PageTextTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.PAGE_TEXT.toString());
            assertThat(item.getAttributeValue()).isEqualTo("text");
        }
        if (item instanceof PageTitleTemplateItem) {
            assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.PAGE_TITLE.toString());
            assertThat(item.getAttributeValue()).isEqualTo("title");
        }
    };
}
