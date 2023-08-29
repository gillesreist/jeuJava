package fr.ecoleNum.dd.DB;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import fr.ecoleNum.dd.character.Character;
import fr.ecoleNum.dd.character.Sorcerer;
import fr.ecoleNum.dd.character.Warrior;

public class Hero {
    private Connection connection;

    public ArrayList<Character> getHeroes() {
        ArrayList<Character> characters = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;

        loadDatabase();

        try {
            statement = connection.createStatement();

            // Exécution de la requête
            result = statement.executeQuery("SELECT CHARACTERCLASS, NAME, LIFELEVEL, ATTACKSTRENGTH FROM hero;");

            // Récupération des données
            while (result.next()) {
                String characterClass = result.getString("CHARACTERCLASS");
                String name = result.getString("NAME");
                int lifeLevel = result.getInt("LIFELEVEL");
                int attackStrength = result.getInt("ATTACKSTRENGTH");

                try
                {
                  Class characterType = Class.forName("fr.ecoleNum.dd.character."+characterClass);

                  Character character = (Character) characterType.getDeclaredConstructor().newInstance();


                    character.setName(name);
                    character.setLifeLevel(lifeLevel);
                    character.setAttackStrength(attackStrength);

                    characters.add(character);
                }
                catch (ClassNotFoundException e)
                {
                    // La classe n'existe pas
                }
                catch (NoSuchMethodException e)
                {
                    // Methode non trouvée
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

               /* if (characterClass.equals("warrior")) {
                    character = new Warrior();
                } else {
                    character = new Sorcerer();
                }*/
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }

        return characters;
    }

    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dungeongame", "adventurer", "adventurerpw");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
