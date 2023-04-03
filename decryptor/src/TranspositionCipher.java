import java.util.Random;
import java.util.ArrayList;
public class TranspositionCipher {
    //Random rand = new Random();
    ArrayList<String> column1;
    ArrayList<String> column2;
    ArrayList<String> column3;
    ArrayList<String> column4;

    public String decrypt(String ciphertext) {
        String plaintext = "";
        int numCols = 4;

        int numRows = ciphertext.length() / numCols;
        column1 = new ArrayList<String>();
        column2 = new ArrayList<String>();
        column3 = new ArrayList<String>();
        column4 = new ArrayList<String>();

        int count = 0;
        for (int k = 0; k < numRows; k++) {
            
            for (int g = 0; g < numCols; g++) {
                int count2=count + 1;
                int count3=count + 2;
                int count4=count + 3;
                if (g==1){
                    column1.add(count,ciphertext);
                }else if (g==2){
                    column2.add(count2,ciphertext);
                }else if (g==3){
                    column3.add(count3,ciphertext);
                }else if (g==4){
                    column4.add(count4,ciphertext);
                }    
         
            }
            count += 4;
        }
        System.out.println(column1);
        System.out.println(column2);
        System.out.println(column3);
        System.out.println(column4);
        return plaintext;
    }
}
// public class TranspositionCipher {

//     Random rand;
//     ArrayList<Integer> randNum = new ArrayList<Integer>();

//     public String decrypt(String ciphertext){
//         String plaintext = "";
    
//         int numRows = ciphertext.length() / 4;
//         int counter = 0;
        

//         for (int k = 0; k < 24; k++) {
//             for (int g = 0; g < 4; g++){
//                 int randomNum = rand.nextInt((4 - 1) + 1) + 1;
//                 if (randNum.contains(randomNum)){  
                    
//                 }else {
//                     randNum.add(randomNum);
//                 }
//             }
//             for (int i = 0; i < numRows; i++) {
//                 plaintext += ciphertext.charAt(randNum.get(0));
//                 plaintext += ciphertext.charAt(randNum.get(1));
//                 plaintext += ciphertext.charAt(randNum.get(2));
//                 plaintext += ciphertext.charAt(randNum.get(3));

            

//                 counter += 4;

//             }
//             // return plaintext;
//         }
//         //System.out.println(plaintext);
//         return plaintext;
//     }
// }

//     public String every4 (String text){
//         //String subset = "";
//         for (int i = 0; i < text.length(); i += 4) {
//             if (i + 4 <= text.length()) {
//                 return text.substring(i, i + 4);
//             } else {
//                 return text.substring(i);
//             }
//         }
//         return null;
//     }
//     public String decrypt(String cipher, int keylength){

//         String text = every4(cipher);

        


//         return "done";
//     }
// }
