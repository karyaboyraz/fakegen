package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class LoremProvider {
    private final RandomService random;

    public LoremProvider(RandomService random) {
        this.random = random;
    }

    public String word() {
        return random.randomElement(DataLoader.getListData("lorem", "words"));
    }

    public String sentence(int wordCount) {
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            if (i > 0) {
                sentence.append(" ");
            }
            sentence.append(word());
        }
        return sentence.toString() + ".";
    }

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

    public String text(int paragraphCount) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < paragraphCount; i++) {
            if (i > 0) {
                text.append("\n\n");
            }
            text.append(paragraph(random.nextInt(3, 7)));
        }
        return text.toString();
    }
} 