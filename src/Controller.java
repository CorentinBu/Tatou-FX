import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Add event listeners to the buttons
        view.getAssociationsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Associations button clicked");
                model.sayHello(); // Example action
            }
        });

        view.getJobsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Jobs button clicked");
                model.sayHello(); // Example action
            }
        });

        view.getSportsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sports button clicked");
                model.sayHello(); // Example action
            }
        });

        view.getProfilButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Profil button clicked");
                model.sayHello(); // Example action
            }
        });

        view.getAssociationsSuiviesButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Associations suivies button clicked");
                model.sayHello(); // Example action
            }
        });

        view.getDeconnexionButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Déconnexion button clicked");
                model.sayHello(); // Example action
            }
        });
    }
}