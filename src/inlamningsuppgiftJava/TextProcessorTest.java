package inlamningsuppgiftJava;

import org.junit.jupiter.api.Test; // Importerar verktyget för att testa
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTest {

    // Testar utgångsläget: En ny processor ska inte ha några sparade rader eller tecken.
    @Test
    public void testInitialState() {
        // Arrange: Skapa objektet vi ska testa
        TextProcessor myTextProcessor = new TextProcessor();

        // Assert: Kontrollera att räknarna startar på noll
        assertEquals(0, myTextProcessor.getRowCount(), "Antal rader borde vara 0 från start");
        assertEquals(0, myTextProcessor.getCharCount(), "Antal tecken borde vara 0 från start");
    }

    // Testar grundfunktionen: Att lägga till en rad ska öka både radräknaren och teckenräknaren korrekt.
    @Test
    public void testAddOneLine() {
        // Arrange
        TextProcessor myTextProcessor = new TextProcessor();

        // Act: Vi simulerar att användaren skriver "Hej"
        myTextProcessor.addText("Hej");

        // Assert: Vi förväntar oss 1 rad och 3 tecken ('H', 'e', 'j')
        assertEquals(1, myTextProcessor.getRowCount());
        assertEquals(3, myTextProcessor.getCharCount());
    }

    // Testar ackumulering: Att lägga till flera rader ska summera totalen korrekt.
    @Test
    public void testAddTwoLines() {
        // Arrange
        TextProcessor myTextProcessor = new TextProcessor();

        // Act: Vi lägger till två olika rader
        myTextProcessor.addText("Hej"); // 3 tecken
        myTextProcessor.addText("Då");  // 2 tecken

        // Assert: Totalt 2 rader och 5 tecken (3 + 2)
        assertEquals(2, myTextProcessor.getRowCount());
        assertEquals(5, myTextProcessor.getCharCount());
    }

    // Testar att programmet korrekt räknar antalet ord
    @Test
    public void testWordCount() {
        // Arrange
        TextProcessor myTextProcessor = new TextProcessor();

        // Act: Vi lägger till en rad med 4 ord
        myTextProcessor.addText("Hur mår du idag?");

        // Assert: Vi förväntar oss 4 ord
        assertEquals(4, myTextProcessor.getWordCount());
    }

    // Testar att programmet korrekt räknar antalet ord
    @Test
    public void testLongestWord() {
        // Arrange
        TextProcessor myTextProcessor = new TextProcessor();

        // Act: Vi lägger till en rad med 4 ord
        myTextProcessor.addText("Var ligger den här adressen?");

        // Assert: Vi förväntar oss att få tillbaka ORDET "adressen?"
        assertEquals("adressen?", myTextProcessor.getLongestWord());
    }

    // Testar logiken för att avsluta programmet när användaren skriver "stop"
    @Test
    public void testStopCommand() {
        // Arrange: Skapa objektet
        TextProcessor myTextProcessor = new TextProcessor();

        // Assert: Kontrollera att vi inte ska stoppa från början
        assertEquals(false, myTextProcessor.shouldStop());

        // Act: Skicka in vanlig text
        myTextProcessor.addText("Du är bäst");

        // Assert: Vi ska fortfarande inte stoppa
        assertEquals(false, myTextProcessor.shouldStop());

        // Act: Skicka in stopp-kommandot
        myTextProcessor.addText("stop");

        // Assert: Nu ska flaggan ha ändrats till true
        assertEquals(true, myTextProcessor.shouldStop());
    }

}
