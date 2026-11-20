import java.util.*;

public class VowelCount {
    public static void main(String[] args) {
        String inputString = "Bonjour tout le monde";
        Map<Character, Integer> vowelCountMap = countVowels(inputString);
        System.out.println("Vowel count in the string: "+ inputString);
        for (Map.Entry<Character, Integer> entry : vowelCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    
    public static Map<Character, Integer> countVowels(String str) {
        // Map to store vowel count
        Map<Character, Integer> vowelCountMap = new HashMap<>();
        // Vowels to check
        String vowels = "aeiouAEIOU";
        // Iterate through the characters of the string
        for (char ch : str.toCharArray()) {
            // Check if the character is a vowel
            if (vowels.indexOf(ch) != -1) {
                // Increment the count of the vowel in the map
                vowelCountMap.put(ch, vowelCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        
        return vowelCountMap;
    }
}
