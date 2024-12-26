package personal.project.model;

import personal.project.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class ChordGenerator {

    public static String getRandomChord(){

        String allChords = getMajorChords() + getMinorChords() + getPowerChords() + getSeventhChords();

        ArrayList<String> chordList = new ArrayList<>(Arrays.asList(allChords.split(", ")));

        return Random.sortElement(chordList);
    }


    public static String getMajorChords() {
        return String.join(", ", "C", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#",
                "Ab", "A", "A#", "Bb", "B" );
    }

    public static String getMinorChords() {
        return String.join(", ", "Cm", "C#m", "Dbm", "Dm", "D#m", "Ebm", "Em", "Fm", "F#m", "Gbm",
                "Gm", "G#m", "Abm", "Am", "A#m", "Bbm", "Bm" );
    }

    public static String getPowerChords() {
        return String.join(", ", "C5", "C#5", "Db5", "D5", "D#5", "Eb5", "E5", "F5", "F#5", "Gb5",
                "G5", "G#5", "Ab5", "A5", "A#5", "Bb5", "B5" );
    }

    public static String getSeventhChords() {
        return String.join(", ", "C7", "C#7", "Db7", "D7", "D#7", "Eb7", "E7", "F7", "F#7", "Gb7",
                "G7", "G#7", "Ab7", "A7", "A#7", "Bb7", "B7" );
    }
}
