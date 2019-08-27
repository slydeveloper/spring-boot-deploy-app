package pl.sly.tools.springbootdeployapp.controller.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test of {@link ErrorHandlerController}
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ErrorHandlerController.class)
public class ErrorHandlerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Should handle HTTP 404 error for invalid URL parameters.
     * @throws Exception
     */
    @Test
    public void testHandleError() throws Exception {
        this.mockMvc
                .perform(get("/some/invalid/url"))
                .andExpect(status().isNotFound());
    }
}
