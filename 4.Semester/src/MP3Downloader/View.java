package MP3Downloader;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class View extends BorderPane{
    private ListView<String> listviewsong,listviewplaylist;
    private Button addsongs,deletesong, download;
    private GridPane upperframe,downframe,rightframe;
    private TextField title,interpret;
    private Text titleText;
    private Text intepretText;
    private TextField insertUrl;
    private Button paste,convert;
    private Text tutorial;
    private Button goToPath;
    public View(){
        setMaxSize(1024,1024);

        //instanziierungen
        listviewsong = new ListView<>();
        listviewsong.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listviewplaylist = new ListView<>();
        rightframe = new GridPane();

        upperframe = new GridPane();
        downframe = new GridPane();

        //downframe
        downframe.setVgap(30);
        downframe.setHgap(30);

        addsongs= new Button("Start Download");
        addsongs.setPadding(new Insets(10,10,10,10));
        downframe.add(addsongs,2,0);

        goToPath = new Button("Open Download Path");
        goToPath.setPadding(new Insets(10,10,10,10));
        downframe.add(goToPath,7,0);

        //upperframe
        insertUrl = new TextField();
        insertUrl.setPromptText("Copy/paste your Youtube link here...");
        insertUrl.setPadding(new Insets(10,10,10,10));
        insertUrl.setPrefWidth(500);
        upperframe.add(insertUrl,0,2);

        paste = new Button("Paste");
        paste.setPadding(new Insets(10,10,10,10));
        upperframe.add(paste,1,2);

        convert = new Button("Add to MP3 download list");
        convert.setPadding(new Insets(10,20,10,10));
        upperframe.add(convert,2,2);

        //rightframe
        rightframe.setMinSize(200,500);

        titleText = new Text("Title");
        rightframe.add(titleText,0,4);

        title = new TextField();
        title.setPadding(new Insets(5,20,5,5));
        rightframe.add(title,0,5);

        intepretText = new Text("Interpret");
        rightframe.add(intepretText,0,9);

        interpret = new TextField();
        interpret.setPadding(new Insets(5,20,5,5));
        rightframe.add(interpret,0,10);


        download = new Button("Set Download Path");
        download.setPadding(new Insets(10,10,10,10));
        rightframe.add(download,0,14);


        deletesong = new Button("Delete Song from list");
        deletesong.setPadding(new Insets(10,10,10,10));
        rightframe.add(deletesong,0,18);

        tutorial = new Text();
        tutorial.setFont(Font.font(20));
        tutorial.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_LIGHT,18));
        tutorial.setText(" Tutorial\n\n 1. Set Download Path\n\n 2. Paste Youtube link\n\n 3. Start Download");
        rightframe.add(tutorial,0,22);
        VBox vBox = new VBox(5);
        vBox.setMinWidth(200);

        rightframe.setHgap(10);
        rightframe.setVgap(10);

        rightframe.getColumnConstraints().add(new ColumnConstraints(125));

        //Alignments
        setRight(rightframe);
        setBottom(downframe);
        setTop(upperframe);
        setCenter(listviewplaylist);
        setLeft(listviewsong);

    }
}
