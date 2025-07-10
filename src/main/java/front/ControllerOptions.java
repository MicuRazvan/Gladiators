package front;

import javafx.event.ActionEvent;

public class ControllerOptions {
    public void onBackButtonClick(ActionEvent actionEvent) {
        Interface.show();
        Controller.stage2.hide();
    }
}
