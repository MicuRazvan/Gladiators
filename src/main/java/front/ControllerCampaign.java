package front;

import gladiatori.Campaign;
import gladiatori.Colosseum;
import gladiatori.Gladiator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerCampaign extends Application {
    @Override
    public void start(Stage stage) throws Exception {

    }

    @FXML
    private Label wl;
    @FXML
    private ImageView img;
    @FXML
    private Label Name;


    public void initialize(){
        Colosseum colosseum = new Colosseum();
        colosseum.setGladiatoriJucator(ControllerStart.lista_curenta);
        int index = 0;
        for (Gladiator a : colosseum.getGladiatoriJucator()) {
            if (a.equals(ControllerStart.gladiator_curent)) index = colosseum.getGladiatoriJucator().indexOf(a);
        }

        Campaign campaign = new Campaign(ControllerStart.gladiator_curent);
        colosseum.setCampaign(campaign);
        colosseum.startCampaign(index);
        Gladiator x = ControllerStart.gladiator_curent;
        if (x.getClasa().equals("Archer")) img.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/6/Archer-Transparent-PNG.png"));
        else if (x.getClasa().equals("Assasin")) img.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/7/Assassin%E2%80%99s-Creed-Odyssey-PNG-Picture.png"));
        else if (x.getClasa().equals("Fighter")) img.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-Image.png"));
        else if (x.getClasa().equals("Brutal")) img.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-File.png"));
        Name.setText(ControllerStart.gladiator_curent.getFullName());
        if (colosseum.getCampaign().getWin() == true)  {
            wl.setText("Win");

        }
        else {wl.setText("Lose: Your Gladiator died");
        ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);
        }

        
    }

    public void onBackButtonClick(ActionEvent actionEvent) {
        Controller.stage2.show();
        ControllerStart.stage3.hide();
    }
}
