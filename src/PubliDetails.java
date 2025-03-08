import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PubliDetails {
        private Stage stage;
        private BorderPane root;
        private View view; // Pour revenir à la vue précédente

        public PubliDetails(Stage primaryStage, View view, String nomAsso, String logo, String titrePubli,
                        String description, Scene scene) {
                this.stage = primaryStage;
                this.view = view;

                // Initialisation de la page PubliDetails
                root = new BorderPane();
                root.setBackground(new Background(
                                new BackgroundFill(Color.web("#FFA83C"), CornerRadii.EMPTY, Insets.EMPTY)));

                // Créer le carré rouge au centre
                VBox centerBox = new VBox(20);
                centerBox.setAlignment(Pos.CENTER);
                centerBox.setBackground(new Background(
                                new BackgroundFill(Color.web("#C8280E"), CornerRadii.EMPTY, Insets.EMPTY)));
                centerBox.setPrefSize(1420, 820); // Taille du carré rouge
                centerBox.setPadding(new Insets(20));

                // Ajouter les informations de la publication
                Label nomAssoLabel = new Label("Nom de l'association : " + nomAsso);
                nomAssoLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                nomAssoLabel.setTextFill(Color.WHITE);

                Label logoLabel = new Label("Logo : " + logo);
                logoLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
                logoLabel.setTextFill(Color.WHITE);

                Label titrePubliLabel = new Label("Titre de la publication : " + titrePubli);
                titrePubliLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                titrePubliLabel.setTextFill(Color.WHITE);

                Label descriptionLabel = new Label("Description : " + description);
                descriptionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
                descriptionLabel.setTextFill(Color.WHITE);
                descriptionLabel.setWrapText(true); // Pour permettre le retour à la ligne

                // Ajouter les éléments au carré rouge
                centerBox.getChildren().addAll(nomAssoLabel, logoLabel, titrePubliLabel, descriptionLabel);
                root.setCenter(centerBox);

                // Ajouter le bouton de retour en dehors du carré rouge
                Button backButton = new Button("← Retour");
                backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 20;");
                backButton.setOnAction(event -> {
                        view.show(scene); // Revenir à la page précédente
                });

                // Positionner le bouton en haut à gauche
                BorderPane.setAlignment(backButton, Pos.TOP_LEFT);
                BorderPane.setMargin(backButton, new Insets(20));
                root.setTop(backButton);
        }

        // Méthode pour afficher la page PubliDetails
        public void show() {
                Scene scene = new Scene(root, 1920, 1080);
                scene.setFill(Color.web("#FFA83C")); // Couleur de fond de la scène
                stage.setScene(scene);
                stage.show();
        }
}