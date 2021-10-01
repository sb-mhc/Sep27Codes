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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.util.Duration;

public class myFirstAnimation extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Circle ball = new Circle(0,0,20);
		root.getChildren().add(ball);
		
		Scene s = new Scene(root, 600, 600);
		primaryStage.setScene(s);
		primaryStage.show();
		
		TranslateTransition t = new TranslateTransition(Duration.millis(1000),ball);
		t.setFromX(0);
		t.setFromY(0);
		t.setToX(s.getWidth());
		t.setToY(s.getHeight());
		//t.setCycleCount(Transition.INDEFINITE);
		
		// 2nd animation
		Circle ball1 = new Circle(0,0,20);
		//ball1.fill(Color.AQUA);
		root.getChildren().add(ball1);
		
		TranslateTransition t2 = new TranslateTransition(Duration.millis(1000),ball);
		t2.setFromX(s.getWidth());
		t2.setFromY(0);
		t2.setToX(0);
		t2.setToY(s.getHeight());
		//t2.setCycleCount(Transition.INDEFINITE);
		
		
		ParallelTransition st = new ParallelTransition(t, t2);
		st.setCycleCount(Transition.INDEFINITE);
		st.play();
		
	}
	

}
