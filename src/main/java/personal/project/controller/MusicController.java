package personal.project.controller;

import personal.project.model.ChordGenerator;
import personal.project.model.NoteGenerator;
import personal.project.view.Frame;

public class MusicController {
    private Frame frame;

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    public void handleGenerateNoteClick() {
        String randomNote = NoteGenerator.getRandomNote();
        frame.showGeneratedNoteResult(randomNote);
    }

    public void handleGenerateChordNoteClick(){
        String randomChord = ChordGenerator.getRandomChord();
        frame.showGeneratedChordResult(randomChord);
    }
}
