package com.fakegen.providers;

import com.fakegen.util.RandomService;

/**
 * A provider class for generating text-related data.
 * This class provides methods to generate various text components such as
 * words, sentences, paragraphs, and full text content.
 */
public class WordProvider {
    private final RandomService random;

    /**
     * Constructs a new WordProvider with the specified RandomService.
     *
     * @param random The RandomService instance to use for generating random values
     */
    public WordProvider(RandomService random) {
        this.random = random;
    }

    /**
     * Generates a random word.
     *
     * @return A randomly generated word
     */
    public String word() {
        int length = random.nextInt(2, 8);
        return random.randomString(length, true, true, false, false).toLowerCase();
    }

    /**
     * Generates a specified number of random words.
     *
     * @param count The number of words to generate
     * @return A string containing the specified number of random words
     */
    public String words(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(word());
        }
        return result.toString();
    }

    /**
     * Generates a random sentence with the specified number of words.
     *
     * @param wordCount The number of words in the sentence
     * @return A randomly generated sentence
     */
    public String sentence(int wordCount) {
        StringBuilder sentence = new StringBuilder();
        
        for (int i = 0; i < wordCount; i++) {
            if (i > 0) {
                sentence.append(" ");
            }
            sentence.append(word());
        }
        
        // Capitalize first letter and add period
        if (sentence.length() > 0) {
            sentence.setCharAt(0, Character.toUpperCase(sentence.charAt(0)));
            sentence.append(".");
        }
        
        return sentence.toString();
    }

    /**
     * Generates a specified number of random sentences.
     * Each sentence contains between 3 and 10 words.
     *
     * @param count The number of sentences to generate
     * @return A string containing the specified number of random sentences
     */
    public String sentences(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(sentence(random.nextInt(3, 10)));
        }
        return result.toString();
    }

    /**
     * Generates a random paragraph with the specified number of sentences.
     *
     * @param sentenceCount The number of sentences in the paragraph
     * @return A randomly generated paragraph
     */
    public String paragraph(int sentenceCount) {
        StringBuilder paragraph = new StringBuilder();
        
        for (int i = 0; i < sentenceCount; i++) {
            if (i > 0) {
                paragraph.append(" ");
            }
            paragraph.append(sentence(random.nextInt(5, 15)));
        }
        
        return paragraph.toString();
    }

    /**
     * Generates a specified number of random paragraphs.
     * Each paragraph contains between 3 and 7 sentences.
     *
     * @param count The number of paragraphs to generate
     * @return A string containing the specified number of random paragraphs
     */
    public String paragraphs(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                result.append("\n\n");
            }
            result.append(paragraph(random.nextInt(3, 7)));
        }
        return result.toString();
    }

    /**
     * Generates a random text with the specified maximum character count.
     *
     * @param maxCharacterCount The maximum number of characters in the text
     * @return A randomly generated text
     */
    public String text(int maxCharacterCount) {
        StringBuilder text = new StringBuilder();
        
        while (text.length() < maxCharacterCount) {
            if (text.length() > 0) {
                text.append(" ");
            }
            
            String sentence = sentence(random.nextInt(3, 10));
            if (text.length() + sentence.length() <= maxCharacterCount) {
                text.append(sentence);
            } else {
                break;
            }
        }
        
        return text.toString();
    }

    /**
     * Generates a random word that starts with the specified letter.
     *
     * @param letter The starting letter of the word
     * @return A randomly generated word starting with the specified letter
     */
    public String wordStartingWith(char letter) {
        String word;
        do {
            word = word();
        } while (word.isEmpty() || Character.toLowerCase(word.charAt(0)) != Character.toLowerCase(letter));
        return word;
    }

    /**
     * Generates a random word that ends with the specified letter.
     *
     * @param letter The ending letter of the word
     * @return A randomly generated word ending with the specified letter
     */
    public String wordEndingWith(char letter) {
        String word;
        do {
            word = word();
        } while (word.isEmpty() || Character.toLowerCase(word.charAt(word.length() - 1)) != Character.toLowerCase(letter));
        return word;
    }

    /**
     * Main method for testing the functionality of WordProvider.
     * This method demonstrates the usage of various word generation methods.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        WordProvider wordProvider = new WordProvider(new RandomService());
        System.out.println("Random Word: " + wordProvider.word());
        System.out.println("Random Sentence: " + wordProvider.sentence(5));
        System.out.println("Random Paragraph: " + wordProvider.paragraph(3));
        System.out.println("Random Text: " + wordProvider.text(100));
        System.out.println("Word Starting with 'A': " + wordProvider.wordStartingWith('A'));
        System.out.println("Word Ending with 'E': " + wordProvider.wordEndingWith('E'));
    }
} 