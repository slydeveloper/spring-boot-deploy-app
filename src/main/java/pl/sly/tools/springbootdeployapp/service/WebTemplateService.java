package pl.sly.tools.springbootdeployapp.service;

import org.springframework.ui.Model;

/**
 * Service for update UI {@link Model}
 *
 * @author Sylwester Sokolowski
 */
public interface WebTemplateService {

    /**
     * UI model to update.
     *
     * @param model that will be updated
     */
    void updateModel(Model model);
}
