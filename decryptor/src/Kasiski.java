import java.util.ArrayList;
import java.util.HashMap;

public class Kasiski {

    public static ArrayList<Integer> findRepeatedSubstrings(String text, int minLength) {
        ArrayList<Integer> distances = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> substrings = new HashMap<>();

        // Find all repeated substrings of length minLength or longer
        for (int i = 0; i < text.length() - minLength + 1; i++) {
            String substring = text.substring(i, i + minLength);
            if (substrings.containsKey(substring)) {
                ArrayList<Integer> indices = substrings.get(substring);
                indices.add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                substrings.put(substring, indices);
            }
        }

        // Calculate distances between repeated substrings
        for (ArrayList<Integer> indices : substrings.values()) {
            if (indices.size() > 1) {
                for (int i = 0; i < indices.size() - 1; i++) {
                    int distance = indices.get(i + 1) - indices.get(i);
                    if (!distances.contains(distance)) {
                        distances.add(distance);
                    }
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        String text = "XCUGVMGBEYAZBEDSIQMBEIQGXXCUFUVMYXXHVYKSAJCXHFZSDERDRUMADJABIMMHIPTREUGFXTCVVDWLSGBBHKZOXMEITYFESUGZVVDVYWXEGMYHFMCZZVKIQOXXQMIJXLHVCIMSAJAYAVJXLQZQWMACEECZZTBHXCUBLVZIIYGOYOYGJJMUKZIPCXCURYWAYQYHPFHHXCUZLSPDWNLZOVLIKJLFSRBRUGMELMENJKCTJVMBIAYXFHMUMOVIYGAEGYMNPZVNLXCUKXSRDBHWPSAUQVDGYVOXTNACUGNLZOLBSPBWBEQUYCRDIAYHIEMUWDDZFIDDVBSAJAYTVIMOVZRNNAJKEXLVLXZEGBXHYITXLXCUXSIJVLIQZEGYSAJAYQDJPUWVCHMXOUWCSPIUOWDDXMWIEMGSMUMBEIXTFJVTHTIIIAISOIHZKVHECGWUBHKYYLWSQUKUFGUBHXCUPBSGUYCIGTRYXNKVBAVIMBICUKVWKKGAIISRNLVJILSWQUFCJDXVMOUHZMORRIRZSHQLVTUYIIINZJDSBYROJHMIVIHHXCUPBSGUWUMMOLJVJTNWIAEKNLZTTSHDVYYVDDZIRZVKIQVDHNLZHBHRVJNLINQGXQJEWMWJWKYEOBRUWOXXSHDTMBITOXNJJHFYHWUGXMIWTWYMYHOWGONHMAEKGVJMTOXJCTNMXDHCWZBXMWVDWURVBBYRJRLYVQUKJENIBHKYEPHXCUGYMBXUIYMYGAPVDXGMBXMQIGBAUZZRXYRZNVOWZTYIVHQLMMIWMBIHQLBSYWXUWOXXSGMUINEGEGAWOEHJMIWEIAOEWCWXUKHXCUIF";
        int minLength = 4;
        ArrayList<Integer> distances = findRepeatedSubstrings(text, minLength);
        System.out.println("Repeated substring distances: " + distances);
    }
} 