import de.bsohef.programming.java.examples.hellostudent.HelloStudent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MainTest {

    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    //Read output
    @Spy
    final PrintStream out = new PrintStream(outputStream);


    @Test
    void mainTest() {

        System.setOut(out);
        HelloStudent.main(null);
        //Validate output
        String output = outputStream.toString();
        assertTrue(output.contains("Hello Teacher!"), "Die Ausgabe sollte 'Hello Teacher!' lauten.");
    }
}