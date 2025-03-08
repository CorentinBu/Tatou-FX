import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Search {
        private Stage stage;
        private BorderPane root;

        public Search(String searchText, Stage primaryStage, View view, Scene scene) {
                this.stage = primaryStage; // Utiliser le stage passé en paramètre

                // Initialisation de la page Search
                root = new BorderPane();

                // Charger l'image de fond (optionnel)
                Image image = new Image("img/bg.png");
                BackgroundImage myBI = new BackgroundImage(
                                image,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
                root.setBackground(new Background(myBI));

                // Créer le panneau gauche (1/3 de l'écran)
                VBox leftPanel = new VBox(20);
                leftPanel.setAlignment(Pos.TOP_CENTER);
                leftPanel.setBackground(
                                new Background(new BackgroundFill(Color.web("#C8280E"), CornerRadii.EMPTY,
                                                Insets.EMPTY)));
                leftPanel.setPrefWidth(stage.getWidth() / 3); // 1/3 de la largeur de l'écran
                leftPanel.setPadding(new Insets(20));

                // Ajouter la barre de recherche avec le texte de recherche
                TextField searchField = new TextField(searchText);
                searchField.setPrefWidth(leftPanel.getPrefWidth() - 40); // Largeur ajustée
                searchField.setFont(Font.font("Arial", FontWeight.NORMAL, 20)); // Taille de police augmentée
                searchField.setStyle(
                                "-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-border-radius: 5; -fx-padding: 5;");

                // Ajouter les labels avec une taille de police plus grande
                Label logoLabel = new Label("Logo");
                logoLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Taille de police augmentée
                logoLabel.setTextFill(Color.WHITE);

                Label nomAssoLabel = new Label("Nom de l'assos");
                nomAssoLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20)); // Taille de police augmentée
                nomAssoLabel.setTextFill(Color.WHITE);

                Label titrePubliLabel = new Label("Titre de la publi");
                titrePubliLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20)); // Taille de police augmentée
                titrePubliLabel.setTextFill(Color.WHITE);

                Label descriptionLabel = new Label("Description de la publication");
                descriptionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20)); // Taille de police augmentée
                descriptionLabel.setTextFill(Color.WHITE);

                // Ajouter le bouton de retour
                Button backButton = new Button("← Retour");
                backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
                backButton.setOnAction(event -> {
                        // View view = new View();
                        view.show(scene); // Revenir à la page View sans créer une nouvelle fenêtre
                });

                // Ajouter tous les éléments au panneau gauche
                leftPanel.getChildren().addAll(searchField, logoLabel, nomAssoLabel, titrePubliLabel, descriptionLabel,
                                backButton);
                root.setLeft(leftPanel);

                // Créer le panneau des publications
                VBox publiPanel = new VBox(50);
                publiPanel.setAlignment(Pos.TOP_CENTER);
                publiPanel.setPadding(new Insets(120, 0, 0, 0)); // Décaler de 120 pixels vers le bas
                publiPanel.setBackground(
                                new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY,
                                                Insets.EMPTY)));

                // Ajouter des publications (exemple)
                publiPanel.getChildren().addAll(
                                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2",
                                                stage, view, scene),

                                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3",
                                                stage, view, scene),
                                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 1", "Titre Publication 1", "Description courte de la publication 1",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 2", "Titre Publication 2", "Description courte de la publication 2",
                                                stage, view,
                                                scene),
                                new Publi("Nom Asso 3", "Titre Publication 3", "Description courte de la publication 3",
                                                stage, view,
                                                scene));

                // Ajouter un ScrollPane pour les publications
                ScrollPane scrollPane = new ScrollPane(publiPanel);
                scrollPane.setFitToWidth(true);
                scrollPane.setBackground(
                                new Background(new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY,
                                                Insets.EMPTY)));
                scrollPane.setPadding(new Insets(0));

                // Définir le ScrollPane comme centre de la page
                root.setCenter(scrollPane);
        }

        // Méthode pour afficher la page Search
        public void show() {
                Scene scene = new Scene(root, 1920, 1080);
                scene.setFill(Color.web("#FFA83C"));
                stage.setScene(scene); // Définir la scène sur le stage
                stage.show(); // Afficher le stage
        }
}