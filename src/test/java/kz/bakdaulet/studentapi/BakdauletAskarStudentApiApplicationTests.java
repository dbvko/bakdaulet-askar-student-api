package kz.bakdaulet.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class BakdauletAskarStudentApiApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(false, "Intentional failure for Jenkins CI demonstration");
    }
}
