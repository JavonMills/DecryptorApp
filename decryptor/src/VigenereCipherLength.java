import java.util.Scanner;

public class VigenereCipherLength {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

        System.out.println("Enter the ciphertext: ");
        String ciphertext = "SERLTAREHHOEERATTOSLDOSSNAWDITLUTIHTFEARBONPLWDHDFOPGRDNANRHPSNAPHOOHLLSAARERTMONOPYNISDNOAAULDANAITLAOEEAAAIHMNHLDDGOMUOELATTTWAHIDSWIABOIMCDETHNODEERPTNIWSISSINELASAHVOONEPEETCDERFHRIOFEHEDOIEFGHTOEASGRUANLTYTHMSOTTHSPSOLLGNOFDNSSLHENIPSHCNIRGGNRNOOCERESTTOLNDYIMUONLWNYORDIOGTAOTAREHCFRRHRHILITSWSNGLIRIYAEHWLDAPDOAEDETAIKRRWISWUNAAWIOARISFDTNTEHRTEEHMOWEOSHDEOOCSIMLLHDENKNBTEAHNAAGDNGTFEWEAEHHRDEITLARHAWAJONOEDUOHIVHDUGAERFSOIENCTWEHPGTAKRTSDNEAIEGOSFRNTAHPNEDOOSBATAMLISTDDRPOAHDHWEEHBSEFSICNTEHSONETROEOETSLDAYIMRAENNIUETFPBAADEAIEBIAHCNNINHSUUTNHINOTLEEFTRDEOAPRNMGAHOLEEAHNEOADDIRNGQEIHTTTHSEPCAAMULLSISALTSHIETRRNEUEIOSAEPDAKTRDHSESKPAOMTSNCIUYOHTMATDDDDNNSHORUSDAITNCEMTEARESIIURWHGEADNHBRDUHOPDMTOSCOMRINEEELEEAWLIRNSDHUTNAHHEETUYESNTNIOSNTNIHIENSEAWDRPHTNUTCLFCIHIRETLLIRLOAISGOLDSWEHEIMJHBRGHSERITAYNNNGODMEMREDOMCNEAESSMTWEA";

        int maxKeyLength = 6;
        int minKeyLength = 4;
        int[] distances = new int[maxKeyLength - minKeyLength + 1];

        for (int keyLength = minKeyLength; keyLength <= maxKeyLength; keyLength++) {
            String key = "";
            for (int i = 0; i < keyLength; i++) {
                key += ciphertext.charAt(i);
            }

            int distanceSum = 0;
            for (int i = keyLength; i < ciphertext.length(); i++) {
                int ciphertextChar = ciphertext.charAt(i);
                int keyChar = key.charAt(i % keyLength);
                distanceSum += Math.abs(ciphertextChar - keyChar);
            }

            distances[keyLength - minKeyLength] = distanceSum;
        }

        int probableKeyLength = minKeyLength;
        int minDistance = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] < minDistance) {
                minDistance = distances[i];
                probableKeyLength = i + minKeyLength;
            }
        }

        System.out.println("Probable key length: " + probableKeyLength);
    }
} 