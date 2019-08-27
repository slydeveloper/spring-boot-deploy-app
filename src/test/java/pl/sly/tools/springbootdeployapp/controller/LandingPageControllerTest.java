package pl.sly.tools.springbootdeployapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import pl.sly.tools.springbootdeployapp.enums.domain.WebTemplateAttributeType;
import pl.sly.tools.springbootdeployapp.enums.domain.WebViewType;
import pl.sly.tools.springbootdeployapp.service.WebTemplateService;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test of {@link LandingPageController}
 */
@RunWith(SpringRunner.class)
@WebMvcTest(LandingPageController.class)
public class LandingPageControllerTest {

    private static final String LANDING_PAGE_MAPPING = "/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WebTemplateService webTemplateServiceMock;

    /**
     * Test if {@link LandingPageController} properly render HTML view.
     *
     * @throws Exception
     */
    @Test
    public void testHandleLandingPageView() throws Exception {
        // given
        doAnswer(invocationOnMock -> {
            Model model = (Model) invocationOnMock.getArguments()[0];
            model.addAttribute(WebTemplateAttributeType.APP_TITLE.getKey(), "TEST_APP_TITLE");
            model.addAttribute(WebTemplateAttributeType.APP_NAME.getKey(), "TEST_APP_NAME");
            model.addAttribute(WebTemplateAttributeType.APP_VERSION.getKey(), "2.0");
            model.addAttribute(WebTemplateAttributeType.CONTAINER_ID.getKey(), "0123456789");
            model.addAttribute(WebTemplateAttributeType.PAGE_TITLE.getKey(), "PAGE_TITLE");
            model.addAttribute(WebTemplateAttributeType.PAGE_TEXT.getKey(), "PAGE_TEXT");
            model.addAttribute(WebTemplateAttributeType.PAGE_CARD_HEADER_COLOR.getKey(), "PAGE_CARD_HEADER_COLOR");
            return null;
        }).when(this.webTemplateServiceMock).updateModel(Mockito.any(Model.class));

        // then
        this.mockMvc
                .perform(get(LANDING_PAGE_MAPPING))
                .andExpect(status().isOk())
                .andExpect(view().name(is(WebViewType.INDEX.getKey())))
                .andExpect(content().string(containsString("<title>TEST_APP_TITLE</title>")))
                .andExpect(content().string(containsString("<h5 class=\"card-title\">TEST_APP_NAME</h5>")))
                .andExpect(content().string(containsString("<h5 class=\"card-title\">2.0</h5>")))
                .andExpect(content().string(containsString("<h5 class=\"card-title\">0123456789</h5>")))
                .andExpect(content().string(containsString("<h1 class=\"display-5 text-white\">PAGE_TITLE</h1>")))
                .andExpect(content().string(containsString("<p class=\"lead text-secondary\">PAGE_TEXT</p>")))
                .andExpect(content().string(containsString("<div class=\"card shadow-sm mb-4 PAGE_CARD_HEADER_COLOR\">")));
    }
}