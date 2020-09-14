import java.lang.String;
import java.lang.System;


public class Encrypter {

    public String encrypt(String i)
    {

        int[] x = StringtoIntArray(i);
        int [] temp = StringtoIntArray(i);
        char[] code = i.toCharArray();
        int [] FinalEncryption = CompleteEncryption(x , temp);
        String code1 = Restring(FinalEncryption);


       return code1;


    }

    public int[] StringtoIntArray(String i) {
        int[] x = new int[i.length()];
        char[] code = i.toCharArray();
        for (int y = 0; y < i.length(); y++) {
            x[y] = Character.getNumericValue(code[y]);
        }
        return x;
    }

    public int[] CompleteEncryption(int[] x, int[] y) {
        for (int z = 0; z < x.length; z++) {

            x[z] = y[(z + 2) % 4];
            x[z] += 7;
            x[z] %= 10;
        }
        return x;
    }

    public String Restring(int [] x){

        String delimiter = "";
        StringBuilder nb = new StringBuilder();
        for(int w : x){
            if(nb.length() > 0){
                nb.append(delimiter);
            }
            nb.append(w);
        }
        String code1 = nb.toString();

        return code1;

    }

    }




