package jpmc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Problem1Tests {

    @Test
    public void checkEmptyInputs() {
        assertEquals("", Problem1.apply("", 'c'));
        assertEquals("", Problem1.apply("Sample text", ' '));
    }

    @Test
    public void checkInputsGivenInEmail() {
        String inputText = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        assertEquals("crazy", Problem1.apply(inputText, 'z'));
        assertEquals("I", Problem1.apply(inputText, 'I'));
        assertEquals("sentence", Problem1.apply(inputText, 'e'));
    }

    @Test
    public void checkCaseSensitivity() {
        String inputText = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        assertEquals("I", Problem1.apply(inputText, 'I'));
        assertEquals("This", Problem1.apply(inputText, 'i'));
    }

    @Test
    public void checkNoMatch() {
        String inputText = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        assertEquals("", Problem1.apply(inputText, 'k'));
    }

    @Test
    public void checkMoreMatchingCharsAtEnd() {
        String inputText = "This is a match_ii very long i and i are being match_iii tested";
        assertEquals("match_iii", Problem1.apply(inputText, 'i'));
    }

    @Test
    public void checkMoreMatchingCharsAtStart() {
        String inputText = "This match_iiii is a very long i and i are being match_iii tested";
        assertEquals("match_iiii", Problem1.apply(inputText, 'i'));
    }
}