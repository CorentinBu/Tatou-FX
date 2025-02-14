import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Publi extends VBox {
    private String nom;
    private String titre;
    private String description;

    public Publi(String nom, String titre, String description) {
        this.nom = nom;
        this.titre = titre;
        this.description = description;

        // Configuration du panel
        setPrefSize(800, 80);
        setBackground(new Background(new BackgroundFill(Color.web("#620D2A"), new CornerRadii(10), Insets.EMPTY)));
        setPadding(new Insets(10, 20, 10, 20));
        setSpacing(5);

        Label nomLabel = new Label(nom + " - ");
        Label titreLabel = new Label(titre + " - ");
        Label descriptionLabel = new Label(description);

        nomLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        titreLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        descriptionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

        nomLabel.setTextFill(Color.WHITE);
        titreLabel.setTextFill(Color.WHITE);
        descriptionLabel.setTextFill(Color.WHITE);

        getChildren().addAll(nomLabel, titreLabel, descriptionLabel);
    }
}