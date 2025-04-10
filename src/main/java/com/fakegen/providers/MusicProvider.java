package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class MusicProvider {
    private final RandomService random;

    public MusicProvider(RandomService random) {
        this.random = random;
    }

    public String genre() {
        return random.randomElement(DataLoader.getListData("music", "genres"));
    }

    public String artist() {
        return random.randomElement(DataLoader.getListData("music", "artists"));
    }

    public String album() {
        return random.randomElement(DataLoader.getListData("music", "albums"));
    }

    public String song() {
        return random.randomElement(DataLoader.getListData("music", "songs"));
    }

    public String instrument() {
        return random.randomElement(DataLoader.getListData("music", "instruments"));
    }

    public String key() {
        String note = random.randomElement(DataLoader.getListData("music", "notes"));
        String scale = random.randomElement(DataLoader.getListData("music", "scales"));
        return note + " " + scale;
    }

    public String chord() {
        String note = random.randomElement(DataLoader.getListData("music", "notes"));
        String chordType = random.randomElement(DataLoader.getListData("music", "chordTypes"));
        return note + " " + chordType;
    }

    public String note() {
        return random.randomElement(DataLoader.getListData("music", "notes"));
    }

    public String scale() {
        String note = note();
        String scaleType = random.randomElement(DataLoader.getListData("music", "scales"));
        return note + " " + scaleType;
    }

    public String tempo() {
        return random.randomElement(DataLoader.getListData("music", "tempos"));
    }

    public String dynamic() {
        return random.randomElement(DataLoader.getListData("music", "dynamics"));
    }

    public String timeSignature() {
        return random.randomElement(DataLoader.getListData("music", "timeSignatures"));
    }

    public String chordProgression() {
        StringBuilder progression = new StringBuilder();
        int progressionLength = random.nextInt(3, 6);
        
        for (int i = 0; i < progressionLength; i++) {
            if (i > 0) {
                progression.append(" - ");
            }
            progression.append(chord());
        }
        
        return progression.toString();
    }

    public String musicalPhrase() {
        StringBuilder phrase = new StringBuilder();
        int phraseLength = random.nextInt(4, 8);
        
        for (int i = 0; i < phraseLength; i++) {
            if (i > 0) {
                phrase.append(" ");
            }
            phrase.append(note());
        }
        
        return phrase.toString();
    }

    public static void main(String[] args) {
        MusicProvider musicProvider = new MusicProvider(new RandomService());
        System.out.println("Müzik Türü: " + musicProvider.genre());
        System.out.println("Sanatçı: " + musicProvider.artist());
        System.out.println("Albüm: " + musicProvider.album());
        System.out.println("Şarkı: " + musicProvider.song());
        System.out.println("Enstrüman: " + musicProvider.instrument());
        System.out.println("Anahtar: " + musicProvider.key());
        System.out.println("Akor: " + musicProvider.chord());
        System.out.println("Nota: " + musicProvider.note());
        System.out.println("Gam: " + musicProvider.scale());
        System.out.println("Tempo: " + musicProvider.tempo());
        System.out.println("Dinamik: " + musicProvider.dynamic());
        System.out.println("Ölçü İşareti: " + musicProvider.timeSignature());
        System.out.println("Akor Progresyonu: " + musicProvider.chordProgression());
        System.out.println("Müzikal Cümle: " + musicProvider.musicalPhrase());
    }
} 