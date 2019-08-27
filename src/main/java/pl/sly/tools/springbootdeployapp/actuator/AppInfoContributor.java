package pl.sly.tools.springbootdeployapp.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import pl.sly.tools.springbootdeployapp.domain.IWebTemplateItem;
import pl.sly.tools.springbootdeployapp.enums.actuator.ActuatorInfoType;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * Custom provider of actuator/info page.
 *
 * @author Sylwester Sokolowski
 */
@Component
public class AppInfoContributor implements InfoContributor {

    @Autowired
    private List<IWebTemplateItem> webTemplateItems;

    /**
     * Enrich {@link Info.Builder} with data based on {@link IWebTemplateItem} components.
     * Only other than {@ActuatorInfoType.NONE} are consider to put in the response.
     *
     * @param builder instance of {@link Info.Builder} that will be enriched with a map based
     *                on {@link IWebTemplateItem}
     */
    @Override
    public void contribute(Info.Builder builder) {
        Optional.ofNullable(this.webTemplateItems)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(item -> Objects.nonNull(item.getInfoType()))
                .filter(item -> !ActuatorInfoType.NONE.equals(item.getInfoType()))
                .sorted(Comparator.comparing(IWebTemplateItem::getInfoType))
                .collect(groupingBy(
                        IWebTemplateItem::getInfoType,
                        mapping(Function.identity(), toMap(
                                IWebTemplateItem::getAttributeName,
                                IWebTemplateItem::getAttributeValue))
                        )
                )
                .forEach((infoType, mapItems) -> builder.withDetail(infoType.toString(), mapItems));
    }
}
