package inlamningsuppgiftJava;

public class TextProcessor {

    // Attribut för att spara status (privata för säkerhet)
    // Vi sparar rader, tecken, ord, det längsta ordet och om vi ska stoppa
    private int rowCount, charCount, wordCount;
    private String longestWord = "";
    private boolean stop = false;

    // Getter för att hämta antal rader
    public int getRowCount() {
        return rowCount;
    }

    // Getter för att hämta antal tecken
    public int getCharCount() {
        return charCount;
    }

    // Getter för att hämta antal ord
    public int getWordCount() {
        return wordCount;
    }

    // Getter för att hämta det längsta ordet
    public String getLongestWord() {
        return longestWord;
    }

    // Getter för att se om användaren har skrivit "stop"
    public boolean shouldStop() {
        return stop;
    }

    // Huvudmetod: Tar emot en textrad och uppdaterar räknarna
    public void addText(String text) {

        // Kontrollera om ordet är "stop"
        if (text.equals("stop")) {
            stop = true;
            return;
        }

        // 1. Öka radräknaren med 1
        rowCount++;

        // 2. Lägg till längden på den nya texten till totalen (antal tecken)
        charCount += text.length();

        // 3. Dela upp texten vid mellanslag för att hitta orden
        String[] mintText = text.split(" ");

        // 4. Lägga till antalet ord till vår räknare
        wordCount += mintText.length;

        // 5. Loopa igenom de nya orden för att hitta det längsta
        for (int i = 0; i < mintText.length; i++) {

            // Om det nuvarande ordet är längre än det vi sparat tidigare...
            if (mintText[i].length() > longestWord.length()) {
                // ...så uppdaterar vi rekordet till det nya ordet!
                longestWord = mintText[i];
                //klar
            }
        }
    }
}
