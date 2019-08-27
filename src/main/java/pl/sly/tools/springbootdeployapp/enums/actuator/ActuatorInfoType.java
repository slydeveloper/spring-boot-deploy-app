package pl.sly.tools.springbootdeployapp.enums.actuator;

/**
 * A set of predefined constants of attributes for the Actuator Info endpoint.
 *
 * @author Sylwester Sokolowski
 */
public enum ActuatorInfoType {
    NONE("none"),
    APP("app"),
    CONTAINER("container");

    ActuatorInfoType(String key) {
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
