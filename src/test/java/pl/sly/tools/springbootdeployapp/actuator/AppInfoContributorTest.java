package pl.sly.tools.springbootdeployapp.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sly.tools.springbootdeployapp.context.TestActuatorContext;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Test of {@link AppInfoContributor}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { TestActuatorContext.class })
public class AppInfoContributorTest {

    @Autowired
    private AppInfoContributor appInfoContributor;

    /**
     * Test if {@link AppInfoContributor#contribute(Info.Builder)} properly builds actuator response.
     */
    @Test
    public void testContribute() {
        // given
        var builder = new Info.Builder();
        var expected = Map.of("app",
                Map.of("ATTRIBUTE_NAME_1", "ATTRIBUTE_VALUE_1",
                        "ATTRIBUTE_NAME_2", "ATTRIBUTE_VALUE_2"));
        // when
        appInfoContributor.contribute(builder);

        // then
        assertThat(builder).isNotNull();
        assertThat(builder.build().getDetails()).isEqualTo(expected);
    }
}