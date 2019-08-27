package pl.sly.tools.springbootdeployapp.domain.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Test of {@link ContainerIdTemplateItem}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContainerIdTemplateItemTest {

    @Spy
    @InjectMocks
    private ContainerIdTemplateItem item;

    /**
     * Test if {@link ContainerIdTemplateItem} properly provides hostname.
     */
    @Test
    public void testContainerIdTemplateItem() {
        // given
        given(item.provideHostname()).willReturn("hostname");

        // then
        assertThat(item.getAttributeName()).isEqualTo(WebTemplateAttributeType.CONTAINER_ID.toString());
        assertThat(item.getAttributeValue()).isEqualTo("hostname");
    }
}
