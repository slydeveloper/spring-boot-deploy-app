package pl.sly.tools.springbootdeployapp.enums.domain;

/**
 * A set of predefined constants of attributes for the Thymeleaf template.
 *
 * @author Sylwester Sokolowski
 */
public enum WebTemplateAttributeType {
    APP_NAME("appName"),
    APP_VERSION("appVersion"),
    APP_TITLE("appTitle"),
    CONTAINER_ID("containerId"),
    PAGE_TITLE("pageTitle"),
    PAGE_TEXT("pageText"),
    PAGE_PROJECT_URL("pageProjectUrl"),
    PAGE_PROJECT_URL_NAME("pageProjectUrlName"),
    PAGE_CARD_HEADER_COLOR("pageCardHeaderColor");

    WebTemplateAttributeType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return this.key;
    }

    private String key;
}
