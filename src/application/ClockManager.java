package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ClockManager {
	@FXML
	Label timeLabel;
	@FXML
    private static ClockManager instance;
	@FXML
    private Timeline timeline;
	
    private int seconds;

    private ClockManager() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1.0), event -> {
            seconds++;
            timeLabel.setText("Time: " + seconds + " seconds");
        });

        timeline.getKeyFrames().add(keyFrame);
    }

    public static ClockManager getInstance() {
        if (instance == null) {
            instance = new ClockManager();
        }
        return instance;
    }

    public void startClock() {
        if (!timeline.getStatus().equals(Animation.Status.RUNNING)) {
            seconds = 0;
            timeline.play();
        }
    }

    public void stopClock() {
        if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
            timeline.stop();
        }
    }

    public int getSeconds() {
        return seconds;
    }
}

