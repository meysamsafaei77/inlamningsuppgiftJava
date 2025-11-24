package inlamningsuppgiftJava;

import java.util.Scanner;

public class TextMain {

    public static void main(String[] args) {

        // 1. Skapa motorn (logik-klassen)
        TextProcessor myTextProcessor = new TextProcessor();

        // 2. Skapa verktyget för att läsa in text
        Scanner scan = new Scanner(System.in);

        // Instruktion till användaren
        System.out.println("Skriv din text rad för rad. Avsluta genom att skriva 'stop'.");

        // 3. Loop: Körs så länge vi INTE har skrivit "stop"
        while (!myTextProcessor.shouldStop()) {

            // Läs in raden och skicka den till motorn
            String line = scan.nextLine();
            myTextProcessor.addText(line);
        }

        // 4. Utskrift: Visa resultaten när vi är klara
        System.out.println("Antal rader: " + myTextProcessor.getRowCount());
        System.out.println("Antal tecken: " + myTextProcessor.getCharCount());
        System.out.println("Antal ord: " + myTextProcessor.getWordCount());
        System.out.println("Längsta ordet: " + myTextProcessor.getLongestWord());
    }
}
