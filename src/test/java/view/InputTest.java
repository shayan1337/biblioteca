package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @DisplayName("expect user input to equal 3")
    @Test
    void testUserInput_3() {
        setSystem("3\n");
        Input input = new Input();
        assertEquals(3, input.getUserInput());
    }

    @DisplayName("expect user input to equal 5")
    @Test
    void testUserInput_5() {
        setSystem("5\n");
        Input input = new Input();
        assertEquals(5, input.getUserInput());
    }

    private void setSystem(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void rollback() {
        System.setIn(System.in);
    }
}
