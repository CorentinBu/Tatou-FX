import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class View {
    private Stage stage;
    private BorderPane root;
    private VBox leftMenuPanel;
    private HBox menuPanel;
    private ScrollPane scrollPane;
    private VBox publiPanel;

    private Button associationsButton;
    private Button jobsButton;
    private Button sportsButton;
    private Button rechercheButton;
    private Button profilButton;
    private Button associationsSuiviesButton;
    private Button deconnexionButton;

    public View() {
        stage = new Stage();
        stage.setTitle("Tatou");

        root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Menu Panel
        menuPanel = new HBox(20);
        menuPanel.setAlignment(Pos.CENTER);
        menuPanel.setPadding(new Insets(50, 0, 0, 0));
        menuPanel.setBackground(new Background(new BackgroundFill(Color.web("#C8280E"), CornerRadii.EMPTY, Insets.EMPTY)));
        menuPanel.setPrefHeight(100);

        associationsButton = createStyledButton("Associations");
        jobsButton = createStyledButton("Jobs");
        sportsButton = createStyledButton("Sports");
        rechercheButton = createStyledButton("Recherche");

        menuPanel.getChildren().addAll(associationsButton, jobsButton, sportsButton, rechercheButton);
        root.setTop(menuPanel);

        // Left Menu Panel
        leftMenuPanel = new VBox(10);
        leftMenuPanel.setAlignment(Pos.TOP_CENTER);
        leftMenuPanel.setBackground(new Background(new BackgroundFill(Color.web("#C8280E"), CornerRadii.EMPTY, Insets.EMPTY)));
        leftMenuPanel.setPrefWidth(100);

        profilButton = createStyledButton("Profil");
        associationsSuiviesButton = createStyledButton("Associations suivies");
        deconnexionButton = createStyledButton("Déconnexion");

        leftMenuPanel.getChildren().addAll(profilButton, associationsSuiviesButton, deconnexionButton);
        root.setLeft(leftMenuPanel);

        // Publication Panel
        publiPanel = new VBox(25);
        publiPanel.setAlignment(Pos.TOP_CENTER);
        publiPanel.setBackground(new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY, Insets.EMPTY)));

        publiPanel.getChildren().addAll(
                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1"),
                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2"),
                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3"),
                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1"),
                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2"),
                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3"),
                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1"),
                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2"),
                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3"),
                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1"),
                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2"),
                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3")
        );

        scrollPane = new ScrollPane(publiPanel);
        scrollPane.setFitToWidth(true);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 1920/2, 1080/2);
        stage.setScene(scene);
        stage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        button.setBackground(new Background(new BackgroundFill(Color.web("#C8280E"), new CornerRadii(5), Insets.EMPTY)));
        button.setTextFill(Color.WHITE);
        button.setFocusTraversable(false);
        return button;
    }

    // Add getter methods for buttons
    public Button getAssociationsButton() {
        return associationsButton;
    }

    public Button getJobsButton() {
        return jobsButton;
    }

    public Button getSportsButton() {
        return sportsButton;
    }

    public Button getRechercheButton() {
        return rechercheButton;
    }

    public Button getProfilButton() {
        return profilButton;
    }

    public Button getAssociationsSuiviesButton() {
        return associationsSuiviesButton;
    }

    public Button getDeconnexionButton() {
        return deconnexionButton;
    }
}