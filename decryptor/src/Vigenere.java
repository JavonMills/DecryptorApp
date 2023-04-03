import java.util.HashMap;

public class Vigenere {

    public static void everySixthChar(String str) {
        for (int i = 4; i < str.length(); i += 6) {
            System.out.print(str.charAt(i));
        }
    }
    
    
    
    public static double calculateIC(String text) {
        // Convert text to uppercase and remove spaces
        text = text.toUpperCase().replaceAll("\\s+", "");

        // Initialize variables
        int n = text.length();
        HashMap<Character, Integer> frequency = new HashMap<>();

        // Calculate frequency of each letter in text
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
    
        // Calculate Index of Coincidence
        double ic = 0.0;
        for (char c : frequency.keySet()) {
            int count = frequency.get(c);
            ic += (double) count * (count - 1) / (double) (n * (n - 1));
        }
    
        return ic;
    }
    //this function will decrypt a caser cypher through a run of different keys
    //and will only print but not return outputs
    public String Vdecrypt(String cypher){
        // p = c - k mod 26
        //String keyword = "TESSOFTHEDURBERVILLES";
        int[] keys = {4, 21, 16, 19, 20};
        //            T  E S  S  O  F T  H E D U  R  B E R  V  I L  L  E  S
        int length = keys.length;
       
        //int subtraction = key % 26;
        String answer = "";
        char[] chars = cypher.toCharArray();
        int index = 0;
        for (char b : chars){

            // this is to convert all characters to lower case to make the decrypting easier.
            if (Character.isUpperCase(b)) {
                b = Character.toLowerCase(b);
            }
            
            int subtraction = keys[index % length] % 26;
            b -= subtraction;
            // this is the main part of the cypher where we shift the alphabet by the key 
            //b -= subtraction;
            index++;
            if (b < 'a'){
                b += 26;
            }    
            // cause the orignal text is uppercase we bring it back to upper case
            b = Character.toUpperCase(b);
            String decryptChar = String.valueOf(b);
            answer = answer + decryptChar;
            
        }
        return answer;
    }

}
