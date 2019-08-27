package pl.sly.tools.springbootdeployapp.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import pl.sly.tools.springbootdeployapp.context.TestServiceContext;

import static org.mockito.Mockito.verify;

/**
 * Test of {@link WebTemplateService}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { TestServiceContext.class })
public class WebTemplateServiceTest {

    @Autowired
    private WebTemplateService webTemplateService;

    /**
     * Test if {@link WebTemplateService#updateModel(Model)} properly updates {@link Model}
     * with {@link pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem}
     */
    @Test
    public void testUpdateModelWhenModelExists() {
        // given
        var model = Mockito.spy(Model.class);

        // when
        webTemplateService.updateModel(model);

        // then
        verify(model).addAttribute("ATTRIBUTE_NAME_1", "ATTRIBUTE_VALUE_1");
        verify(model).addAttribute("ATTRIBUTE_NAME_2", "ATTRIBUTE_VALUE_2");
    }

    /**
     * Test if no exception occurs whrn {@link Model} is null.
     */
    @Test
    public void testUpdateModelWhenModelIsNull() {
        // when
        Assertions.assertThatCode(() -> webTemplateService.updateModel(null)).doesNotThrowAnyException();
    }
}