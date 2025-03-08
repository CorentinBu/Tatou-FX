import java.sql.*;

public class ConnectDataBase {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ProjetTutore";
        String user = "postgres";
        String password = "JqcuPLp1T!jfts5";

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url, user, password);

            if (c!=null){
                System.out.println("Connected");
            } else {
                System.out.println("Not Connected");
            }
            /*
            EXEMPLE D'INSERT FONCTIONNEL

            Statement stmt = c.createStatement();
            String requete = "INSERT INTO public.\"Utilisateur\"(\"nomUtilisateur\", \"prenomUtilisateur\", \"ageUtilisateur\", \"photoProfil\", formation, universite, \"adresseMail\", \"motDePasse\", \"villeLogement\", \"ListeFavorisPub\", \"ListeStrucSuivie\")\n" +
                    "\tVALUES ('user', 'user2', 20, NULL, NULL, NULL, NULL, 'mdp', NULL, NULL, NULL);";
            stmt.executeUpdate(requete);
            */

            //EXEMPLE DE SELECT DE LA BASE
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from public.\"Utilisateur\"");
            while (rs.next()) {
                System.out.println("Id: "+rs.getInt(1));
                System.out.println("Nom: "+rs.getString(2));
                System.out.println("Prenom: "+rs.getString(3));
                System.out.println("Age: "+rs.getInt(4));
                System.out.println("PhotoURL: "+rs.getString(5));
                System.out.println("Formation: "+rs.getString(6));
                System.out.println("universite: "+rs.getString(7));
                System.out.println("Email: "+rs.getString(8));
                System.out.println("Mot de passe: "+rs.getString(9));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
