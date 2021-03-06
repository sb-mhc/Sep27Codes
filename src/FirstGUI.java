import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;

public class FirstGUI extends Application {

	Label l;
	TextField tf;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
		//Contents of the application here!
		BorderPane bpane = new BorderPane();
		Button b = new Button("Click me");
		bpane.setCenter(b);
		
		l = new Label("my label");
		tf = new TextField();
		bpane.setRight(l);
		bpane.setLeft(tf);
		
		
		File absf = new File("/Users/sbiswal/COMSC225/FA2021/class-workspace/angryball.png");
		String rsrc1 = absf.toURI().toString();
		Image img = new Image(rsrc1);
		ImageView iv = new ImageView(img);
		
		bpane.setTop(iv);
		

		
		b.setOnMouseClicked(this::respondToClick); // this calls ehandeler on click
		
		//Scene
		Scene s1 = new Scene(bpane,800,500);// Will do it in 5 minutes
		
		//Add scene to stage
		primaryStage.setScene(s1);
		
		//Show stage
		
		primaryStage.setTitle("Click application");
		primaryStage.sizeToScene(); // size of the scene instead of explicitly specify H and W
		primaryStage.show();
		
	}
	
	
	public void respondToClick(MouseEvent e) {
		
		Button evtSrc = (Button)e.getSource(); // type-cast the source of event to button 
		
		if(evtSrc.getText() == "Click me")
			evtSrc.setText("Clicked");
		else
			evtSrc.setText("Click me");
		
		l.setText("new label");
		tf.setText("I am setting new text");
		
		
	}
	
	
}
