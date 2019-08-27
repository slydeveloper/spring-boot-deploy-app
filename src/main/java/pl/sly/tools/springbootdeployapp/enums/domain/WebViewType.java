package pl.sly.tools.springbootdeployapp.enums.domain;

/**
 * A set of predefined constants of views for the Thymeleaf template.
 *
 * @author Sylwester Sokolowski
 */
public enum WebViewType {
    INDEX("index");

    WebViewType(String key) {
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
