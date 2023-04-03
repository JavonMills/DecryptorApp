public class CaesarCypher {
    
    //this function will decrypt a caser cypher through a run of different keys
    //and will only print but not return outputs
    public String decrypt(String cypher, int key){
        // p = c - k mod 26
  
        int subtraction = key % 26;
        String answer = "";
        char[] chars = cypher.toCharArray();
        for (char b : chars){
            // this is to convert all characters to lower case to make the decrypting easier.
            if (Character.isUpperCase(b)) {
                b = Character.toLowerCase(b);
            }
            // this is the main part of the cypher where we shift the alphabet by the key 
            b -= subtraction;
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
