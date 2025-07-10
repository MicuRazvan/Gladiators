package front;



import database.Database;
import database.GladiatorDao;
import gladiatori.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerStart extends Application {
    public static Stage stage3;
    public static Stage stage4;
    public static Stage stage5;
    public static Gladiator gladiator_curent;
    @FXML
    private Pane pane;

    @FXML
    private ChoiceBox choiceBoxG;
    @FXML
    private ImageView img;

    @FXML
    private Label Name;

    @FXML
    private Label chest;

    @FXML
    private Label helmet;

    @FXML
    private Label weapon;

    @FXML
    private Label boots;

    @FXML
    private Label level;

    @FXML
    private Label HP;

    @FXML
    private Label SP;

    @FXML
    private Label power;

    @FXML
    private TextField textt;


   public static List<Gladiator> lista_curenta = new ArrayList<>();





    public void initialize(){
            textt.setVisible(false);
   }



    @FXML
    public void onDuelButtonClick(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("view3.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
        stage3 = stage;
        Controller.stage2.hide();
        this.RefreshImageAndInfo(ControllerStart.gladiator_curent);

    }

    public void onTournamentButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("view4.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 750, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
        stage3 = stage;
        Controller.stage2.hide();
        this.RefreshImageAndInfo(ControllerStart.gladiator_curent);
        choiceBoxG.getItems().clear();
        for (Gladiator a : lista_curenta) {
            choiceBoxG.getItems().add(a.getFullName());
        }
    }
    public void onAdaugaGladiatorButtonClick(ActionEvent actionEvent) {
            Name.setText("nu");
    }

    public void RefreshImageAndInfo(Gladiator a){
        this.Name.setText(a.getFullName());
        StringBuilder sb = new StringBuilder("");
        sb.append("Level: ");
        sb.append(a.getLevel());
        String s = sb.toString();
        this.level.setText(s);
        sb = new StringBuilder("");
        sb.append("HP: ");
        sb.append(a.getHp());
        s = sb.toString();
        this.HP.setText(s);
        sb = new StringBuilder("");
        sb.append("SP: ");
        sb.append(a.getSp());
        s = sb.toString();
        this.SP.setText(s);
        sb = new StringBuilder("");
        sb.append("Power: ");
        sb.append(a.getPower());
        s = sb.toString();
        this.power.setText(s);
        sb = new StringBuilder("");
        sb.append(a.getHelmet());
        s = sb.toString();
        this.helmet.setText(s);
        sb = new StringBuilder("");
        sb.append(a.getChest());
        s = sb.toString();
        this.chest.setText(s);
        sb = new StringBuilder("");
        sb.append(a.getWeapon());
        s = sb.toString();
        this.weapon.setText(s);
        sb = new StringBuilder("");
        sb.append(a.getBoots());
        s = sb.toString();
        this.boots.setText(s);


    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void onAddArcherButton(ActionEvent actionEvent) throws IOException {
        Gladiator a = new Archer("A");
        this.RefreshImageAndInfo(a);
        img.setImage(new Image("url:https://www.pngmart.com/files/6/Archer-Transparent-PNG.png"));
        this.choiceBoxG.getItems().add(a.getFullName());
        lista_curenta.add(a);
        gladiator_curent = a;
    }
    public void onAddAssasinButton(ActionEvent actionEvent) {
        Gladiator a = new Assasin("A");
        this.RefreshImageAndInfo(a);
        this.choiceBoxG.getItems().add(a.getFullName());
        img.setImage(new Image("url:https://www.pngmart.com/files/7/Assassin%E2%80%99s-Creed-Odyssey-PNG-Picture.png"));
        lista_curenta.add(a);
        gladiator_curent = a;
    }
    public void onAddFighterButton(ActionEvent actionEvent) {
        Gladiator a = new Fighter("A");
        this.RefreshImageAndInfo(a);
        this.choiceBoxG.getItems().add(a.getFullName());
        img.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-Image.png"));
        lista_curenta.add(a);
        gladiator_curent = a;
    }
    public void onAddBrutalButton(ActionEvent actionEvent) {
        Gladiator a = new Brutal("A");
        this.RefreshImageAndInfo(a);
        this.choiceBoxG.getItems().add(a.getFullName());
        img.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-File.png"));
        lista_curenta.add(a);
        gladiator_curent = a;
    }

    public void onLabelNameClick(MouseEvent mouseEvent) {
        Name.setVisible(false);
        textt.setVisible(true);
    }

    public void onSwitchMenu(ActionEvent inputMethodEvent) {
        Name.setText(String.valueOf(choiceBoxG.getValue()));
        for(Gladiator a : lista_curenta) {
           // System.out.println(a.getFullName());
            if (a.getFullName().equals(String.valueOf(choiceBoxG.getValue()))){
                this.RefreshImageAndInfo(a);
                if (a.getClasa().equals("Archer")) img.setImage(new Image("url:https://www.pngmart.com/files/6/Archer-Transparent-PNG.png"));
               else if (a.getClasa().equals("Assasin")) img.setImage(new Image("url:https://www.pngmart.com/files/7/Assassin%E2%80%99s-Creed-Odyssey-PNG-Picture.png"));
                else if (a.getClasa().equals("Fighter")) img.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-Image.png"));
                else if (a.getClasa().equals("Brutal")) img.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-File.png"));
                gladiator_curent = a;
            }
        }
    }

    public void onTextBox(ActionEvent actionEvent) {
      //  if (choiceBoxG.getValue() != null) {
            Name.setVisible(true);
            String s = textt.getText();
            Name.setText(textt.getText());
            for (Gladiator a : lista_curenta) {
                if (a.getFullName().equals(choiceBoxG.getValue())) {
                    choiceBoxG.getItems().remove(choiceBoxG.getValue());
                    StringBuilder sb = new StringBuilder("");
                    sb.append(a.getClasa());
                    sb.append(" ");
                    sb.append(s);
                    String s2 = sb.toString();
                    lista_curenta.get(lista_curenta.indexOf(a)).setNume(s);
                    choiceBoxG.setValue(s2);
                    choiceBoxG.getItems().add(s2);
                    gladiator_curent = a;

                }
                a.getClasa();
                System.out.println(a.getFullName());
            }

            textt.setVisible(false);
       // }

    }

    public void onSaveButtonClick(ActionEvent actionEvent) throws SQLException {
        Database database = Database.getInstance();
        GladiatorDao gladiatorDao = new GladiatorDao();

        gladiatorDao.deleteAll();

        for(Gladiator gladiator: lista_curenta){
            gladiatorDao.create(gladiator.getNume(), gladiator.getClasa(), gladiator.getHp(), gladiator.getSp(), gladiator.getDex(),
                    gladiator.getPower(), gladiator.getTurneeCastigate(), gladiator.getLupteCasualCastigate(), gladiator.getLupteCasualCastigateLaRand(),
                    gladiator.getExpeditii(), gladiator.getExpeditiiLaRand(), gladiator.getLevel(), gladiator.getHelmet().getLevel(),
                    gladiator.getChest().getLevel(), gladiator.getWeapon().getLevel(), gladiator.getBoots().getLevel(), gladiator.getBoots().getImmuneTo());
        }
    }

    public void onLoadButtonClick(ActionEvent actionEvent) throws SQLException {
        Database database = Database.getInstance();
        GladiatorDao gladiatorDao = new GladiatorDao();

        lista_curenta = gladiatorDao.findAll();
        for (Gladiator a : lista_curenta) {
            choiceBoxG.getItems().add(a.getFullName());
        }

    }

    public void onCampaignButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("view5.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
        stage3 = stage;
        Controller.stage2.hide();
        this.RefreshImageAndInfo(ControllerStart.gladiator_curent);
        choiceBoxG.getItems().clear();
        for (Gladiator a : lista_curenta) {
            choiceBoxG.getItems().add(a.getFullName());
        }

    }
}
