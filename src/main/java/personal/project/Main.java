package personal.project;

import personal.project.controller.MusicController;
import personal.project.view.Frame;

public class Main {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        Frame frame = config.createFrame();

        MusicController controller = frame.getController();

        controller.setFrame(frame);
    }
}