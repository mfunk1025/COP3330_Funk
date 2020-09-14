import java.lang.String;
import java.lang.System;

public class Decrypter {

    public String decrypt(String c) {

        int[] a = StringtoIntArray(c);
        int[] temp = StringtoIntArray(c);
        char[] code = c.toCharArray();
        int[] FinalDecryption = CompleteDecryption(a, temp);
        String code2 = Restring(FinalDecryption);


        return code2;
    }

        public int[] StringtoIntArray(String c) {
        int[] a = new int[c.length()];
        char[] code = c.toCharArray();
        for (int y = 0; y < c.length(); y++) {
            a[y] = Character.getNumericValue(code[y]);
        }
        return a;
    }

    public int[] CompleteDecryption(int[] x, int[] y) {
        for (int z = 0; z < x.length; z++) {

            x[z] = y[(z + 2) % 4];

            if (x[z] < 7){
                x[z] += 3;
            }

            else{
                x[z] -= 7;
            }
        }
        return x;
    }

    public String Restring(int [] a){

        String delimiter = "";
        StringBuilder nb = new StringBuilder();
        for(int w : a){
            if(nb.length() > 0){
                nb.append(delimiter);
            }
            nb.append(w);
        }
        String code2 = nb.toString();

        return code2;

    }

}
