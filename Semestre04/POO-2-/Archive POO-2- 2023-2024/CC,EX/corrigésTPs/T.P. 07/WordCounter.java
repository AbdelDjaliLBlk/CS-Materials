import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public Map<String, Integer> countWords(String text) {
        // Création d'une Map pour stocker les mots et leurs occurrences
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Séparation du texte en mots en utilisant l'espace comme délimiteur
        String[] words = text.split("\\s+");

        // Parcours de tous les mots du texte
        for (String word : words) {
            // Convertir le mot en minuscules pour ignorer la casse
            word = word.toLowerCase();

            // Vérifier si le mot est déjà présent dans la Map
            if (wordCountMap.containsKey(word)) {
                // Si oui, mettre à jour le compteur d'occurrences
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // Sinon, ajouter le mot à la Map avec un compteur d'occurrences initialisé à 1
                wordCountMap.put(word, 1);
            }
        }

        // Renvoyer la Map contenant le comptage des mots
        return wordCountMap;
    }
}
