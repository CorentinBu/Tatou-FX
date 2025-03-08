import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Publi extends HBox { // Utilisation de HBox pour centrer verticalement
    private String nom;
    private String titre;
    private String description;
    private Stage stage; // Stage pour afficher PubliDetails
    private View view; // Référence à la vue principale pour revenir en arrière
    private Scene scene; // Référence à la scène principale pour revenir en arrière

    public Publi(String nom, String titre, String description, Stage stage, View view, Scene scene) {
        this.nom = nom;
        this.titre = titre;
        this.description = description;
        this.stage = stage;
        this.view = view;
        this.scene = scene;

        // Configuration du panel
        setPrefSize(1340, 130); // Taille par défaut
        setBackground(new Background(new BackgroundFill(Color.web("#620D2A"), new CornerRadii(200), Insets.EMPTY)));
        setPadding(new Insets(0, 0, 0, 161)); // Marge de 161 pixels à gauche
        setAlignment(Pos.CENTER_LEFT); // Centrer verticalement et aligner à gauche

        // Espacement horizontal entre les labels
        setSpacing(10);

        Label nomLabel = new Label(nom + " - ");
        Label titreLabel = new Label(titre + " - ");
        Label descriptionLabel = new Label(description);

        // Augmentation de la taille de la police
        nomLabel.setFont(Font.font("Arial", FontWeight.BOLD, 23)); // Taille de police augmentée
        titreLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); // Taille de police augmentée
        descriptionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); // Taille de police augmentée

        nomLabel.setTextFill(Color.WHITE);
        titreLabel.setTextFill(Color.WHITE);
        descriptionLabel.setTextFill(Color.WHITE);

        // Ajout des labels au HBox
        getChildren().addAll(nomLabel, titreLabel, descriptionLabel);

        // Effet de survol
        setOnMouseEntered(event -> {
            setPrefSize(1380, 140); // Agrandir légèrement la taille
            setBackground(new Background(new BackgroundFill(Color.web("#620D2A"), new CornerRadii(200), Insets.EMPTY)));
            setPadding(new Insets(0, 0, 0, 171)); // Ajuster la marge gauche pour correspondre à la nouvelle taille
        });

        setOnMouseExited(event -> {
            setPrefSize(1340, 130); // Revenir à la taille d'origine
            setBackground(new Background(new BackgroundFill(Color.web("#620D2A"), new CornerRadii(200), Insets.EMPTY)));
            setPadding(new Insets(0, 0, 0, 161)); // Rétablir la marge gauche d'origine
        });

        // Gestion du clic pour rediriger vers PubliDetails
        setOnMouseClicked(event -> {
            PubliDetails publiDetails = new PubliDetails(stage, view, nom, "Logo", titre, description, scene);
            publiDetails.show(); // Afficher la page des détails
        });
    }
}