import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Controller;

import javax.swing.JOptionPane;

public class CollectionsDemo extends Application {

    private Controller controler = new Controller();
    private Text tElem = new Text("Unesite novi element kolekcije: ");
    private TextField tfElem = new TextField();
    private Button addBtn = new Button("Add");
    private Button removeBtn = new Button("Remove");
    private Button sortBtn = new Button("Sort");
    private Button shuffleBtn = new Button("Shuffle");
    private Button reverseBtn = new Button("Reverse");
    private Text display = new Text();

    @Override
    public void start(Stage primaryStage) {
        HBox top = new HBox(20);
        HBox bottom = new HBox(20);
        setDisplay();
        addListeners();
        top.getChildren().addAll(tElem, tfElem, addBtn, removeBtn);
        bottom.getChildren().addAll(sortBtn, shuffleBtn, reverseBtn);

        BorderPane root = new BorderPane();

        root.setTop(top);
        root.setBottom(bottom);
        root.setCenter(display);

        Scene scene = new Scene(root, 500, 200);

        primaryStage.setTitle("Collectioins");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setDisplay() {
        display.setFont(Font.font("Arial", FontWeight.BOLD, 32));
    }

    public void addListeners() {
        addBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String text = tfElem.getText();
                try {
                    if (text != null && !text.isEmpty()) {
                        Integer el = Integer.parseInt(text);
                        controler.addElement(el);
                        display.setText(controler.showAsString());
                        tfElem.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Element mora biti ceo broj. ");
                }
            }
        });

        removeBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (!controler.listEmty()) {
                    controler.removeLast();
                    display.setText(controler.showAsString());
                }
            }
        });

        sortBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                controler.sort();
                display.setText(controler.showAsString());
            }
        });

        shuffleBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                controler.shuffle();
                display.setText(controler.showAsString());
            }
        });

        reverseBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                controler.reverse();
                display.setText(controler.showAsString());
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}