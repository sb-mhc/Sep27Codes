import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.util.Duration;

public class mySecondTimer extends Application {

	Label lbl;
	double opacity = 1;
	long lastUpdate = 0;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		lbl = new Label("I will fade");
		lbl.setFont(new Font(50));
		root.getChildren().add(lbl);
		
		AnimationTimer timer = new MyTimer();//create this class
		timer.start();
		
		Scene s = new Scene(root, 600,600);
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	private class MyTimer extends AnimationTimer{
		
		@Override
		public void handle(long now) {
			long elapsedNanoSeconds = now - lastUpdate;
			double elapsedSeconds = elapsedNanoSeconds / 1_000_000_000.0;
			if(elapsedSeconds >=1) {
				opacity -= 0.1;
				lbl.setOpacity(opacity);
				if (opacity <=0) {
					stop();
				}
				lastUpdate = now;
			}
			
		}
		
	}
}
