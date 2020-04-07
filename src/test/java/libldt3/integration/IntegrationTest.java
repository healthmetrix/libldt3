package libldt3.integration;
import libldt3.LdtConstants;
import libldt3.LdtReader;
import org.junit.Test;

public class IntegrationTest {
    private final LdtReader reader = new LdtReader(LdtConstants.Mode.RELAXED);
    @Test
    public void reads306Doc() {
        String path = "3.0.6-normal.ldt";
    }
}
