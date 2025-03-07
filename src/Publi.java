import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Publi extends HBox { // Utilisation de HBox pour centrer verticalement
    private String nom;
    private String titre;
    private String description;

    public Publi(String nom, String titre, String description) {
        this.nom = nom;
        this.titre = titre;
        this.description = description;

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
    }
}