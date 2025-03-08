import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    private TextField searchField; // Remplace le bouton recherche
    private Button profilButton;
    private Button associationsSuiviesButton;
    private Button deconnexionButton;

    public View() {
        stage = new Stage();
        stage.setTitle("Tatou");

        // Initialize the root BorderPane
        root = new BorderPane();

        // Load the image
        Image image = new Image("img/bg.png");

        // Create a BackgroundImage with the image
        BackgroundImage myBI = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT, // No repeat
                BackgroundRepeat.NO_REPEAT, // No repeat
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true) // Cover the
                                                                                                       // entire area
        );

        // Set the background to the root pane
        root.setBackground(new Background(myBI));

        // Create the top menu panel
        menuPanel = new HBox(20);
        menuPanel.setAlignment(Pos.CENTER);
        menuPanel.setPadding(new Insets(50, 0, 0, 0));
        menuPanel.setBackground(
                new Background(new BackgroundFill(Color.web("#C8280E"), CornerRadii.EMPTY, Insets.EMPTY)));
        menuPanel.setPrefHeight(100);
        menuPanel.setPrefWidth(1400);

        // Create buttons for the top menu
        associationsButton = createStyledButton("Associations");
        jobsButton = createStyledButton("Jobs");
        sportsButton = createStyledButton("Sports");

        // Créer la barre de recherche
        searchField = new TextField();
        searchField.setPromptText("Rechercher..."); // Texte d'indication
        searchField.setPrefWidth(300); // Largeur de la barre de recherche
        searchField.setFont(Font.font("Arial", FontWeight.NORMAL, 16)); // Police
        searchField.setStyle(
                "-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-border-radius: 5; -fx-padding: 5;");

        // Gérer l'événement de la touche "Entrée"
        searchField.setOnAction(event -> {
            String searchText = searchField.getText();
            Search search = new Search(searchText, stage); // Passer le stage actuel
            search.show(); // Appeler la méthode show de Search
        });

        // Add buttons and search field to the top menu
        menuPanel.getChildren().addAll(associationsButton, jobsButton, sportsButton, searchField);
        root.setTop(menuPanel);

        // Create the left menu panel
        leftMenuPanel = new VBox(20);
        leftMenuPanel.setAlignment(Pos.TOP_CENTER);
        leftMenuPanel.setBackground(
                new Background(new BackgroundFill(Color.web("#C8280E"), CornerRadii.EMPTY, Insets.EMPTY)));
        leftMenuPanel.setPrefWidth(291); // 15% of the screen width

        // Create buttons for the left menu
        profilButton = createStyledButton("Profil");
        associationsSuiviesButton = createStyledButton("Associations suivies");
        deconnexionButton = createStyledButton("Déconnexion");

        // Add buttons to the left menu
        leftMenuPanel.getChildren().addAll(profilButton, associationsSuiviesButton, deconnexionButton);
        root.setLeft(leftMenuPanel);

        // Create the publication panel
        publiPanel = new VBox(50);
        publiPanel.setAlignment(Pos.TOP_CENTER);
        publiPanel.setBackground(
                new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Add publication items to the panel
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
                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3"));

        // Create a container for the publication panel
        VBox publiContainer = new VBox();
        publiContainer.setPadding(new Insets(30, 172, 0, 115));
        publiContainer.setBackground(
                new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY, Insets.EMPTY)));
        publiContainer.getChildren().add(publiPanel);

        // Create a ScrollPane for the publication container
        scrollPane = new ScrollPane(publiContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setBackground(
                new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setPadding(new Insets(0));

        // Set the ScrollPane as the center of the root
        root.setCenter(scrollPane);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, 1920, 1080);

        scene.setFill(Color.web("#FFA83C")); // Set the scene's background color
        stage.setScene(scene);
        stage.show();
    }

    // Méthode pour afficher la page View
    public void show(Stage primaryStage) {
        primaryStage.setScene(new Scene(root, 1920, 1080)); // Définir la scène sur le stage
        primaryStage.show(); // Afficher le stage
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        button.setBackground(
                new Background(new BackgroundFill(Color.web("#C8280E"), new CornerRadii(5), Insets.EMPTY)));
        button.setTextFill(Color.WHITE);
        button.setFocusTraversable(false);

        button.setOnMouseEntered(event -> {
            button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        });

        button.setOnMouseExited(event -> {
            button.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        });
        return button;
    }

    // Getter methods for buttons
    public Button getAssociationsButton() {
        return associationsButton;
    }

    public Button getJobsButton() {
        return jobsButton;
    }

    public Button getSportsButton() {
        return sportsButton;
    }

    public TextField getSearchField() { // Getter pour le champ de recherche
        return searchField;
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