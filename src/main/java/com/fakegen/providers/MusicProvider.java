package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class MusicProvider {
    private final RandomService random;

    public MusicProvider(RandomService random) {
        this.random = random;
    }

    private String get(String category) {
        return random.randomElement(DataLoader.getListData("music", category));
    }

    public String genre() {
        return get("genres");
    }

    public String artist() {
        return get("artists");
    }

    public String album() {
        return get("albums");
    }

    public String song() {
        return get("songs");
    }

    public String instrument() {
        return get("instruments");
    }

    public String key() {
        return get("notes") + " " + get("scales");
    }

    public String chord() {
        String base = note();
        String chordType = get("chordTypes");
        return base + " " + chordType;
    }

    public String note() {
        return get("notes");
    }

    public String scale() {
        String base = note();
        String scaleType = get("scales");
        return base + " " + scaleType;
    }

    public String tempo() {
        return get("tempos");
    }

    public String dynamic() {
        return get("dynamics");
    }

    public String timeSignature() {
        return get("timeSignatures");
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