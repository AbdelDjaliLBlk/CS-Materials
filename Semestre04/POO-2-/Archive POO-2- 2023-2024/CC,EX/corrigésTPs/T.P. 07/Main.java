import java.util.Map;

class Main {
    public static void main(String[] args) {
        String text = "Java est un langage de programmation orienté objet.";
        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> wordCountMap = wordCounter.countWords(text);
        System.out.println("Comptage des mots : " + wordCountMap);
    }
}
