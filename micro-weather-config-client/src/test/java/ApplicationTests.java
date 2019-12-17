import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Daydreamer
 * @date 2019/12/17 21:04
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Value("${author}")
    private String author;

    @Test
    public void contextLoads(){
        assertEquals("zzw.com", author);
    }
}
