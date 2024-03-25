public class word_decompressed {
    public static String decompressWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder decompressedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder decompressedWord = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);

                if (Character.isLetter(currentChar)) {
                    decompressedWord.append(currentChar);
                } else if (Character.isDigit(currentChar)) {
                    int frequency = Character.getNumericValue(currentChar);
                    char previousChar;
                    if (!decompressedWord.isEmpty()) {
                        previousChar = decompressedWord.charAt(decompressedWord.length() - 1);
                    } else {
                        previousChar = ' ';
                    }

                    decompressedWord.append(String.valueOf(previousChar).repeat(Math.max(0, frequency - 1)));
                }
            }

            decompressedSentence.append(decompressedWord);
            if (i != words.length - 1) {
                decompressedSentence.append(" ");
            }
        }

        return decompressedSentence.toString();
    }

    public static void main(String[] args) {
        String sentence = "ba3 mis2is2p2i";
        String decompressedSentence = decompressWords(sentence);
        System.out.println(decompressedSentence);
    }
}