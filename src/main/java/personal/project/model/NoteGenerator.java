package personal.project.model;

import personal.project.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NoteGenerator {
    public static String getRandomNote() {
        ArrayList<String> notes = new ArrayList<>(Arrays.asList( "C", "C#", "Db", "D", "D#", "Eb", "E", "Fb", "E#", "F",
                "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "Cb", "B#" ));
        int randomIndex = ThreadLocalRandom.current().nextInt(notes.size());
        return notes.get(randomIndex);
    }
}
