package pl.sly.tools.springbootdeployapp.controller.handler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sly.tools.springbootdeployapp.controller.LandingPageController;

/**
 * Error handler controller which redirects error to the landing page.
 *
 * @author Sylwester Sokolowski
 */
@Controller
public class ErrorHandlerController implements ErrorController {

    private static final String ERROR_PAGE_MAPPING = "/error";
    private static final String REDIRECT_URL = "redirect:" + LandingPageController.LANDING_PAGE_MAPPING;

    /**
     * Handle /error page and redirect to the main landing page.
     *
     * @return redirect URL
     */
    @RequestMapping(ERROR_PAGE_MAPPING)
    public String handleError() {
        return REDIRECT_URL;
    }

    /**
     * Error path.
     *
     * @return error PATH
     */
    @Override
    public String getErrorPath() {
        return ERROR_PAGE_MAPPING;
    }
}