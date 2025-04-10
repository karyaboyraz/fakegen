package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.WordGenerator;

public class WordProvider {
    private final RandomService random;
    private final WordGenerator wordGenerator;

    public WordProvider(RandomService random) {
        this.random = random;
        this.wordGenerator = new WordGenerator(random.getRandom());
    }

    public String word() {
        return wordGenerator.generateWord();
    }

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

    public String sentence(int wordCount) {
        String sentence = words(wordCount);
        return sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + ".";
    }

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

    public String paragraph(int sentenceCount) {
        return sentences(sentenceCount);
    }

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

    public String text(int characterCount) {
        String text = paragraphs(random.nextInt(3, 7));
        return text.substring(0, Math.min(characterCount, text.length()));
    }

    public static void main(String[] args) {
        WordProvider wordProvider = new WordProvider(new RandomService());
        System.out.println(wordProvider.word());
        System.out.println(wordProvider.words(5));
        System.out.println(wordProvider.sentence(5));
        System.out.println(wordProvider.sentences(5));
        System.out.println(wordProvider.paragraph(5));
        System.out.println(wordProvider.paragraphs(5));
    }
} 