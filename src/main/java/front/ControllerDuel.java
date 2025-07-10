package front;


import gladiatori.Colosseum;
import gladiatori.Gladiator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerDuel extends Application{
    @FXML
    private ImageView imga;
    @FXML
    private ImageView imge;

    @FXML
    private Label namea;

    @FXML
    private Label namee;

    @FXML
    private Label wl;

    public void initialize(){
        Gladiator x = ControllerStart.gladiator_curent;
        if (x.getClasa().equals("Archer")) imga.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/6/Archer-Transparent-PNG.png"));
        else if (x.getClasa().equals("Assasin")) imga.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/7/Assassin%E2%80%99s-Creed-Odyssey-PNG-Picture.png"));
        else if (x.getClasa().equals("Fighter")) imga.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-Image.png"));
        else if (x.getClasa().equals("Brutal")) imga.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-File.png"));
        namea.setText(ControllerStart.gladiator_curent.getFullName());
        int index = 0;
        Colosseum colosseum = new Colosseum();
        colosseum.setGladiatoriJucator(ControllerStart.lista_curenta);
        for (Gladiator a : colosseum.getGladiatoriJucator()) {
            if (a.equals(x)) index = colosseum.getGladiatoriJucator().indexOf(a);
        }
        colosseum.startCasualFight(index);
        Gladiator y = colosseum.getGenerat();
        if (y.getClasa().equals("Archer")) imge.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/6/Archer-Transparent-PNG.png"));
        else if (y.getClasa().equals("Assasin")) imge.setImage(new javafx.scene.image.Image("https://www.pngmart.com/files/7/Assassin%E2%80%99s-Creed-Odyssey-PNG-Picture.png"));
        else if (y.getClasa().equals("Fighter")) imge.setImage(new javafx.scene.image.Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-Image.png"));
        else if (y.getClasa().equals("Brutal")) imge.setImage(new Image("url:https://www.pngmart.com/files/5/Gladiator-PNG-File.png"));
        namee.setText(y.getFullName());



        if (colosseum.getWin() == true){ wl.setText("WIN");
        ControllerStart.gladiator_curent = colosseum.getPlayer();
        for (Gladiator g : ControllerStart.lista_curenta) {
            if (g.getFullName().equals(ControllerStart.gladiator_curent)) {int indexx=0;
            indexx = ControllerStart.lista_curenta.indexOf(g);
            ControllerStart.lista_curenta.add(indexx,ControllerStart.gladiator_curent);
            }
        }

        }
        else wl.setText("LOSE");
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void onBackuttonClick(ActionEvent actionEvent) throws IOException {
        Controller.stage2.show();
        ControllerStart.stage3.hide();
    }
}