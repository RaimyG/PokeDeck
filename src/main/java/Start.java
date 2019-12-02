import models.Card;
import views.Frame;

public class Start {

    public static void main(String[] args) {
        Card.initializeDeck();
        Frame frame = new Frame();
        frame.setVisible(true);
    }

}
