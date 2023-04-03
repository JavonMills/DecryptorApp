import java.util.Scanner;
import java.util.Arrays;

public class VigenereCipherKey {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

        System.out.println("Enter the ciphertext: ");
        String ciphertext = "XCUGVMGBEYAZBEDSIQMBEIQGXXCUFUVMYXXHVYKSAJCXHFZSDERDRUMADJABIMMHIPTREUGFXTCVVDWLSGBBHKZOXMEITYFESUGZVVDVYWXEGMYHFMCZZVKIQOXXQMIJXLHVCIMSAJAYAVJXLQZQWMACEECZZTBHXCUBLVZIIYGOYOYGJJMUKZIPCXCURYWAYQYHPFHHXCUZLSPDWNLZOVLIKJLFSRBRUGMELMENJKCTJVMBIAYXFHMUMOVIYGAEGYMNPZVNLXCUKXSRDBHWPSAUQVDGYVOXTNACUGNLZOLBSPBWBEQUYCRDIAYHIEMUWDDZFIDDVBSAJAYTVIMOVZRNNAJKEXLVLXZEGBXHYITXLXCUXSIJVLIQZEGYSAJAYQDJPUWVCHMXOUWCSPIUOWDDXMWIEMGSMUMBEIXTFJVTHTIIIAISOIHZKVHECGWUBHKYYLWSQUKUFGUBHXCUPBSGUYCIGTRYXNKVBAVIMBICUKVWKKGAIISRNLVJILSWQUFCJDXVMOUHZMORRIRZSHQLVTUYIIINZJDSBYROJHMIVIHHXCUPBSGUWUMMOLJVJTNWIAEKNLZTTSHDVYYVDDZIRZVKIQVDHNLZHBHRVJNLINQGXQJEWMWJWKYEOBRUWOXXSHDTMBITOXNJJHFYHWUGXMIWTWYMYHOWGONHMAEKGVJMTOXJCTNMXDHCWZBXMWVDWURVBBYRJRLYVQUKJENIBHKYEPHXCUGYMBXUIYMYGAPVDXGMBXMQIGBAUZZRXYRZNVOWZTYIVHQLMMIWMBIHQLBSYWXUWOXXSGMUINEGEGAWOEHJMIWEIAOEWCWXUKHXCUIF";

        System.out.println("Enter the key length: ");
        int keyLength = 5;

        String[] substrings = new String[keyLength];
        for (int i = 0; i < keyLength; i++) {
            substrings[i] = "";
        }

        for (int i = 0; i < ciphertext.length(); i++) {
            substrings[i % keyLength] += ciphertext.charAt(i);
        }

        String key = "";
        for (String substring : substrings) {
            int[] letterFrequencies = new int[26];
            for (int i = 0; i < substring.length(); i++) {
                letterFrequencies[substring.charAt(i) - 'A']++;
            }

            int maxFrequencyIndex = 0;
            int maxFrequency = letterFrequencies[0];
            for (int i = 1; i < letterFrequencies.length; i++) {
                if (letterFrequencies[i] > maxFrequency) {
                    maxFrequency = letterFrequencies[i];
                    maxFrequencyIndex = i;
                }
            }

            int distance = (maxFrequencyIndex - 4 + 26) % 26;
            char keyLetter = (char) ('A' + distance);
            key += keyLetter;
        }

        System.out.println("The key is: " + key);

        int[] numericalKey = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            numericalKey[i] = (key.charAt(i) - 'A');
        }

        System.out.println("The key in numerical format is: " + Arrays.toString(numericalKey));
    }
}
