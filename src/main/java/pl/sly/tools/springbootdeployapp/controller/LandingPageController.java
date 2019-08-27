package pl.sly.tools.springbootdeployapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sly.tools.springbootdeployapp.enums.domain.WebViewType;
import pl.sly.tools.springbootdeployapp.service.WebTemplateService;

/**
 * Landing page controller for the Thymeleaf UI.
 *
 * @author Sylwester Sokolowski
 */
@Controller
public class LandingPageController {

    public static final String LANDING_PAGE_MAPPING = "/";

    @Autowired
    private WebTemplateService webTemplateService;

    /**
     * Main landing page handler.
     *
     * @param model instance of
     * @return
     */
    @GetMapping(LANDING_PAGE_MAPPING)
    public String handleLandingPageView(Model model) {
        webTemplateService.updateModel(model);

        return WebViewType.INDEX.getKey();
    }
}
