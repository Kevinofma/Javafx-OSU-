package edu.guilford;

import java.nio.file.Paths;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class LevelSelect extends Pane {

    private Button song1;
    private Button song2;
    private Button song3;
    private Button song4;
    private Button song5;
    private Button song6;
    private Button hardcore;
    private Label hardcoreStatus;
    private Button chaos;
    private Label chaosStatus;
    private Button noFail;
    private Label noFailStatus;
    private Button menuButton;
    MediaPlayer mediaPlayer;

    static String songVideo;
    static String songFileName;
    static int songBPM;
    static int songDelay;
    static double beatsToDelayOffset = 0; // weird glitch where if if you return to menu, the SRT! button is not on beat

    private static boolean hardcoreDiff = false;
    private static boolean chaosDiff = false;
    private static boolean infiniteHealth = false;
    private static boolean songWithVideo = false;

    String song1Name = "Flower Dance";
    String song2Name = "The Stains of Time";
    String song3Name = "Dynamite";
    String song4Name = "Placeholder";
    String song5Name = "Placeholder";
    String song6Name = "Placeholder";

    String easyStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: rgba(55, 235, 52, 1); " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: black; ";
    String easyStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: rgba(55, 235, 52, 1); " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: black; ";
    String mediumStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: rgba(219, 116, 26, 1); " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: black; ";
    String mediumStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: rgba(219, 116, 26, 1); " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: black; ";
    String hardStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: rgba(235, 52, 52, 1); " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: black; ";
    String hardStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: rgba(235, 52, 52, 1); " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: black; ";
    String hardcoreStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";  
    String hardcoreStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";
    String chaosStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";
    String chaosStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";
    String noFailStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";
    String noFailStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";       
    String menuButtonStyleNormal = "-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";
    String menuButtonStyleBig = "-fx-font-size: 16px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; " +
    "-fx-focus-color: transparent; -fx-border-color: black; -fx-border-width: 1px; " +
    "-fx-background-radius: 2 2 2 2; -fx-background-color: black; " +
    "-fx-border-style: solid; -fx-border-radius: 2 2 2 2; -fx-padding: 5px; " +
    "-fx-border-insets: 2px; -fx-border-width: 1px; -fx-border-color: white; " +
    "-fx-text-fill: white;";
    
    //constructor
    public LevelSelect() {

        song1 = new Button(song1Name);
        song2 = new Button(song2Name);
        song3 = new Button(song3Name);
        song4 = new Button(song4Name);
        song5 = new Button(song5Name); 
        song6 = new Button(song6Name);
        hardcore = new Button("Hardcore");
        hardcoreStatus = new Label("Hardcore: " + "OFF");
        chaos = new Button("Chaos");
        chaosStatus = new Label("Chaos: " + "OFF");
        noFail = new Button("No Fail");
        noFailStatus = new Label("No Fail: " + "OFF");
        menuButton = new Button("Back");

        // place the song1 button at x = 20, y = 20 with a width of 300 and a height of 40
        this.getChildren().add(song1);
        song1.setLayoutX(20);
        song1.setLayoutY(20);
        song1.setMinSize(300, 40);
        song1.setMaxSize(300, 40);
        song1.setStyle(easyStyleNormal);
        // make the song1 button make a sound when it is hovered over and change font
        song1.setOnMouseEntered(event -> {
            hoversound();
            song1.setStyle(easyStyleBig);
        });

        // make the song1 button change back to normal when the mouse is no longer hovering over it
        song1.setOnMouseExited(event -> {
            song1.setStyle(easyStyleNormal);
        });

        // make the song1 button create a new scene when it is clicked
        song1.setOnAction(event -> {
            hoversound();
            StartMenuPane.stopThreads();
            songVideo = "FlowerDanceVideo.mp4";
            songFileName = "FlowerDance.wav";
            songBPM = 100;
            songDelay = 44;
            songWithVideo = false;
            Scene gameScene = new Scene(new GamePane(songVideo, songFileName), 1250, 650);
            Stage Stage = (Stage) this.getScene().getWindow();
            Stage.setScene(gameScene);
        });

        // in the top left corner of the button, display the text "Easy"
        song1.setGraphic(new Label("Easy"));
        song1.getGraphic().setStyle(easyStyleNormal);

        // REPEAT THIS FOR ALL SONG BUTTONS
        
        // place the song2 button at x = 20, y = 70 with a width of 300 and a height of 40
        this.getChildren().add(song2);
        song2.setLayoutX(20);
        song2.setLayoutY(70);
        song2.setMinSize(300, 40);
        song2.setMaxSize(300, 40);
        song2.setStyle(easyStyleNormal);
        // make the song2 button make a sound when it is hovered over and change font
        song2.setOnMouseEntered(event -> {
            hoversound();
            song2.setStyle(easyStyleBig);
        });

        // make the song2 button change back to normal when the mouse is no longer hovering over it
        song2.setOnMouseExited(event -> {
            song2.setStyle(easyStyleNormal);
        });

        song2.setOnAction(event -> {
            hoversound();
            StartMenuPane.stopThreads();
            songVideo = "StainsOfTimeVideo.mp4";
            songFileName = "The_Stains_of_Time.wav";
            songBPM = 100;
            songDelay = 5;
            songWithVideo = false;
            Scene gameScene = new Scene(new GamePane(songVideo, songFileName), 1250, 650);
            Stage Stage = (Stage) this.getScene().getWindow();
            Stage.setScene(gameScene);
        });

        // in the top left corner of the button, display the text "Easy"
        song2.setGraphic(new Label("Easy"));
        song2.getGraphic().setStyle(easyStyleNormal);

        // place the song3 button at x = 20, y = 120 with a width of 300 and a height of 40
        this.getChildren().add(song3);
        song3.setLayoutX(20);
        song3.setLayoutY(120);
        song3.setMinSize(300, 40);
        song3.setMaxSize(300, 40);
        song3.setStyle(mediumStyleNormal);
        // make the song3 button make a sound when it is hovered over and change font
        song3.setOnMouseEntered(event -> {
            hoversound();
            song3.setStyle(mediumStyleBig);
        });

        // make the song3 button change back to normal when the mouse is no longer hovering over it
        song3.setOnMouseExited(event -> {
            song3.setStyle(mediumStyleNormal);
        });

        song3.setOnAction(event -> {
            hoversound();
            StartMenuPane.stopThreads();
            songVideo = "DynamiteVideo.mp4";
            songFileName = "DynamiteVideo.mp4";
            songBPM = 120;
            songDelay = 14;
            songWithVideo = true;
            Scene gameScene = new Scene(new GamePane(songVideo, songFileName), 1250, 650);
            Stage Stage = (Stage) this.getScene().getWindow();
            Stage.setScene(gameScene);
        });

        // in the top left corner of the button, display the text "Medium"
        song3.setGraphic(new Label("Medium"));
        song3.getGraphic().setStyle(mediumStyleNormal);        
        
        // place the song4 button at x = 20, y = 170 with a width of 300 and a height of 40
        this.getChildren().add(song4);
        song4.setLayoutX(20);
        song4.setLayoutY(170);
        song4.setMinSize(300, 40);
        song4.setMaxSize(300, 40);
        song4.setStyle(mediumStyleNormal);
        // make the song4 button make a sound when it is hovered over and change font
        song4.setOnMouseEntered(event -> {
            hoversound();
            song4.setStyle(mediumStyleBig);
        });

        // make the song4 button change back to normal when the mouse is no longer hovering over it
        song4.setOnMouseExited(event -> {
            song4.setStyle(mediumStyleNormal);
        });

        // in the top left corner of the button, display the text "Medium"
        song4.setGraphic(new Label("Medium"));
        song4.getGraphic().setStyle(mediumStyleNormal);

        // place the song5 button at x = 20, y = 220 with a width of 300 and a height of 40
        this.getChildren().add(song5);
        song5.setLayoutX(20);
        song5.setLayoutY(220);
        song5.setMinSize(300, 40);
        song5.setMaxSize(300, 40);
        song5.setStyle(hardStyleNormal);
        // make the song5 button make a sound when it is hovered over and change font
        song5.setOnMouseEntered(event -> {
            hoversound();
            song5.setStyle(hardStyleBig);
        });

        // make the song5 button change back to normal when the mouse is no longer hovering over it
        song5.setOnMouseExited(event -> {
            song5.setStyle(hardStyleNormal);
        });

        // in the top left corner of the button, display the text "Hard"
        song5.setGraphic(new Label("Hard"));
        song5.getGraphic().setStyle(hardStyleNormal);
        
        // place the song6 button at x = 20, y = 270 with a width of 300 and a height of 40
        this.getChildren().add(song6);
        song6.setLayoutX(20);
        song6.setLayoutY(270);
        song6.setMinSize(300, 40);
        song6.setMaxSize(300, 40);
        song6.setStyle(hardStyleNormal);
        // make the song6 button make a sound when it is hovered over and change font
        song6.setOnMouseEntered(event -> {
            hoversound();
            song6.setStyle(hardStyleBig);
        });

        // make the song6 button change back to normal when the mouse is no longer hovering over it
        song6.setOnMouseExited(event -> {
            song6.setStyle(hardStyleNormal);
        });

        // in the top left corner of the button, display the text "Hard"
        song6.setGraphic(new Label("Hard"));
        song6.getGraphic().setStyle(hardStyleNormal);

        // place the hardcore button in the bottom right of the screen with a width of 100 and a height of 40
        this.getChildren().add(hardcore);
        hardcore.setLayoutX(475);
        hardcore.setLayoutY(310);
        hardcore.setMinSize(100, 40);
        hardcore.setMaxSize(100, 40);
        hardcore.setStyle(hardcoreStyleNormal);
        // make the hardcore button make a sound when it is hovered over and change font
        hardcore.setOnMouseEntered(event -> {
            hoversound();
            hardcore.setStyle(hardcoreStyleBig);
        });

        // make the hardcore button change back to normal when the mouse is no longer hovering over it
        hardcore.setOnMouseExited(event -> {
            hardcore.setStyle(hardcoreStyleNormal);
        });
    
        // make the hardcore button change hardcoreDiff to true/false when it is clicked and change the text of hardcoreStatus to "Hardcore: ON/OFF"
        hardcore.setOnAction(event -> {
            hoversound();
            if (hardcoreDiff == false) {
                hardcoreDiff = true;
                hardcoreStatus.setText("Hardcore: " + "ON");
            } else {
                hardcoreDiff = false;
                hardcoreStatus.setText("Hardcore: " + "OFF");
            }
        });

        // put a label above the hardcore button that says "Hardcore"
        this.getChildren().add(hardcoreStatus);
        hardcoreStatus.setLayoutX(485);
        hardcoreStatus.setLayoutY(290);
        hardcoreStatus.setStyle("-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; -fx-text-fill: white;");

        // place the chaos button in the bottom right of the screen with a width of 100 and a height of 40
        this.getChildren().add(chaos);
        chaos.setLayoutX(475);
        chaos.setLayoutY(350);
        chaos.setMinSize(100, 40);
        chaos.setMaxSize(100, 40);
        chaos.setStyle(chaosStyleNormal);
        // make the chaos button make a sound when it is hovered over and change font
        chaos.setOnMouseEntered(event -> {
            hoversound();
            chaos.setStyle(chaosStyleBig);
        });

        // make the chaos button change back to normal when the mouse is no longer hovering over it
        chaos.setOnMouseExited(event -> {
            chaos.setStyle(chaosStyleNormal);
        });

        // make the chaos button change chaosDiff to true/false when it is clicked and change the text of chaosStatus to "Chaos: ON/OFF"
        chaos.setOnAction(event -> {
            hoversound();
            if (chaosDiff == false) {
                chaosDiff = true;
                chaosStatus.setText("Chaos: " + "ON");
            } else {
                chaosDiff = false;
                chaosStatus.setText("Chaos: " + "OFF");
            }
        });

        // put a label above the chaos button that says "Chaos"
        this.getChildren().add(chaosStatus);
        chaosStatus.setLayoutX(485);
        chaosStatus.setLayoutY(330);
        chaosStatus.setStyle("-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; -fx-text-fill: white;");

        // place the noFail button in the bottom right of the screen with a width of 100 and a height of 40
        this.getChildren().add(noFail);
        noFail.setLayoutX(475);
        noFail.setLayoutY(390);
        noFail.setMinSize(100, 40);
        noFail.setMaxSize(100, 40);
        noFail.setStyle(noFailStyleNormal);
        // make the noFail button make a sound when it is hovered over and change font
        noFail.setOnMouseEntered(event -> {
            hoversound();
            noFail.setStyle(noFailStyleBig);
        });

        // make the noFail button change back to normal when the mouse is no longer hovering over it
        noFail.setOnMouseExited(event -> {
            noFail.setStyle(noFailStyleNormal);
        });

        // make the noFail button change infiniteHealth to true/false when it is clicked and change the text of noFailStatus to "No Fail: ON/OFF"
        noFail.setOnAction(event -> {
            hoversound();
            if (infiniteHealth == false) {
                infiniteHealth = true;
                noFailStatus.setText("No Fail: " + "ON");
            } else {
                infiniteHealth = false;
                noFailStatus.setText("No Fail: " + "OFF");
            }
        });

        // put a label above the noFail button that says "No Fail"
        this.getChildren().add(noFailStatus);
        noFailStatus.setLayoutX(485);
        noFailStatus.setLayoutY(370);
        noFailStatus.setStyle("-fx-font-size: 12px; -fx-font-family: 'Dialog'; -fx-font-weight: bold; -fx-text-fill: white;");

        // place the menuButton above the hardcore button with a width of 100 and a height of 40
        this.getChildren().add(menuButton);
        menuButton.setLayoutX(475);
        menuButton.setLayoutY(430);
        menuButton.setMinSize(100, 40);
        menuButton.setMaxSize(100, 40);
        menuButton.setStyle(menuButtonStyleNormal);
        // make the menuButton make a sound when it is hovered over and change font
        menuButton.setOnMouseEntered(event -> {
            hoversound();
            menuButton.setStyle(menuButtonStyleBig);
        });

        // make the menuButton change back to normal when the mouse is no longer hovering over it
        menuButton.setOnMouseExited(event -> {
            menuButton.setStyle(menuButtonStyleNormal);
        });

        // make the menuButton change the scene to the main menu when it is clicked
        menuButton.setOnAction(event -> {
            hoversound();
            StartMenuPane.mainMenuPlayer.stop();
            beatsToDelayOffset = -1.5;
            Scene mainMenuScene = new Scene(new StartMenuPane(), 1250, 650);
            Stage Stage = (Stage) this.getScene().getWindow();
            Stage.setScene(mainMenuScene);
        });
           
        //set the background to levelSelectBackground.jpg
        this.setStyle("-fx-background-image: url('levelSelectBackground.jpg'); -fx-background-size: 585, 360; -fx-background-position: 0, 0;");
       

    }

    //getter for hardcoreDiff
    public static boolean getHardcoreDiff() {
        return hardcoreDiff;
    }

    //getter for chaosDiff
    public static boolean getChaosDiff() {
        return chaosDiff;
    }

    //getter for infiniteHealth
    public static boolean getInfiniteHealth() {
        return infiniteHealth;
    }

    //getter for songVideo
    public static String getSongVideo() {
        return songVideo;
    }
    
    public void hoversound() {
        String s = "src/main/resources/hitsound.wav";
        //String s = "src/main/resources/100BPMMetronome.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }

    public static int getBPM() {
        return songBPM;
    }

    public static int getSongDelay() {
        return songDelay;
    }

    public static String getSongFileName() {
        return songFileName;
    }

    public static boolean getSongWithVideo() {
        return songWithVideo;
    }

    public static double getBeatsToDelayOffset() {
        return beatsToDelayOffset;
    }

    public static void setBeatsToDelayOffset(double beatsToDelayOffset) {
        LevelSelect.beatsToDelayOffset = beatsToDelayOffset;
    }
    
}
