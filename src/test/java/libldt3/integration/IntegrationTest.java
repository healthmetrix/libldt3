package libldt3.integration;
import libldt3.LdtConstants;
import libldt3.LdtReader;
import libldt3.model.saetze.Satz;
import org.junit.Rule;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class IntegrationTest {
    private final LdtReader reader = new LdtReader(LdtConstants.Mode.RELAXED);

    @Test
    public void reads306Doc() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("3.0.6-normal.ldt").getFile());


        System.out.println(reader.read(file.toString()));
    }
}
 