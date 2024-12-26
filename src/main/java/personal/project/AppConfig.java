package personal.project;

import personal.project.controller.MusicController;
import personal.project.view.Frame;

public class AppConfig {
    public Frame createFrame() {
        MusicController controller = createMusicController();
        return new Frame(controller);
    }

    private MusicController createMusicController() {
        return new MusicController();
    }
}
