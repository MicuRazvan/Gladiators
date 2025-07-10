package front;

import gladiatori.Colosseum;
import gladiatori.Gladiator;
import gladiatori.Tournament;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControllerTournament extends Application {

    @FXML
    private Label p1;
    @FXML
    private Label p2;
    @FXML
    private Label p3;
    @FXML
    private Label p4;
    @FXML
    private Label p5;
    @FXML
    private Label p6;
    @FXML
    private Label p7;
    @FXML
    private Label p8;
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;
    @FXML
    private Line line6;
    @FXML
    private Line line7;
    @FXML
    private Line line8;


    @FXML
    private Label wl;

    public void initialize() throws InterruptedException {
      Colosseum colosseum = new Colosseum();
      colosseum.setGladiatoriJucator(ControllerStart.lista_curenta);
      int index = 0;
      for (Gladiator a : colosseum.getGladiatoriJucator()) {
            if (a.equals(ControllerStart.gladiator_curent)) index = colosseum.getGladiatoriJucator().indexOf(a);
      }

        Tournament tournament = new Tournament(colosseum, ControllerStart.gladiator_curent);
        colosseum.setTournament(tournament);
        List<Gladiator> lista = new ArrayList<>();
        for (Gladiator a : tournament.getConcurenti()) {
            lista.add(a);
        }
        p1.setText(colosseum.getTournament().getConcurenti().get(0).getFullName());
        p2.setText(colosseum.getTournament().getConcurenti().get(1).getFullName());
        p3.setText(colosseum.getTournament().getConcurenti().get(2).getFullName());
        p4.setText(colosseum.getTournament().getConcurenti().get(3).getFullName());
        p5.setText(colosseum.getTournament().getConcurenti().get(4).getFullName());
        p6.setText(colosseum.getTournament().getConcurenti().get(5).getFullName());
        p7.setText(colosseum.getTournament().getConcurenti().get(6).getFullName());
        p8.setText(colosseum.getTournament().getConcurenti().get(7).getFullName());
        colosseum.startTurneu(index);
        for (Gladiator a : lista){
            if (a.getFullName().equals(colosseum.getTournament().getCastigator().getFullName()))
            {
                if (lista.indexOf(a) == 0) {
                    p1.setTextFill(Color.YELLOW);wl.setText("WINNER"); line1.setStroke(Color.YELLOW);
                    ControllerStart.gladiator_curent = colosseum.getTournament().getCastigator();
                    for (Gladiator g : ControllerStart.lista_curenta) {
                        if (g.getFullName().equals(ControllerStart.gladiator_curent)) {
                            int indexx=0;
                            indexx = ControllerStart.lista_curenta.indexOf(g);
                            ControllerStart.lista_curenta.add(indexx,ControllerStart.gladiator_curent);
                        }
                    }
                }
                if (lista.indexOf(a) == 1) {p2.setTextFill(Color.YELLOW);wl.setText("LOST");   line2.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
                if (lista.indexOf(a) == 2) {p3.setTextFill(Color.YELLOW);wl.setText("LOST");   line3.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
                if (lista.indexOf(a) == 3) {p4.setTextFill(Color.YELLOW);wl.setText("LOST");   line4.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
                if (lista.indexOf(a) == 4) {p5.setTextFill(Color.YELLOW);wl.setText("LOST");   line5.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
                if (lista.indexOf(a) == 5) {p6.setTextFill(Color.YELLOW);wl.setText("LOST");   line6.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
                if (lista.indexOf(a) == 6) {p7.setTextFill(Color.YELLOW);wl.setText("LOST");   line7.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
                if (lista.indexOf(a) == 7) {p8.setTextFill(Color.YELLOW);wl.setText("LOST");   line8.setStroke(Color.YELLOW); ControllerStart.lista_curenta.remove(ControllerStart.gladiator_curent);}
            }

        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void onBackButtonClick(ActionEvent actionEvent) {
        Controller.stage2.show();
        ControllerStart.stage3.hide();
    }
}
