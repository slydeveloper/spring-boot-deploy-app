package pl.sly.tools.springbootdeployapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.service.WebTemplateService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of {@link WebTemplateService} for updates UI model {@link Model}
 * with data items base on {@link IWebTemplateItem} components.
 *
 * @author Sylwester Sokolowski
 */
@Service
public class WebTemplateServiceImpl implements WebTemplateService {

    @Autowired
    private List<IWebTemplateItem> webTemplateItems;

    @Override
    public void updateModel(Model model) {
        if (Objects.isNull(model)) {
            return;
        }

        Optional.ofNullable(this.webTemplateItems)
                .orElseGet(Collections::emptyList)
                .stream()
                .forEach(item -> model.addAttribute(item.getAttributeName(), item.getAttributeValue()));
    }
}
