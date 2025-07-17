import java.util.Scanner;
class CieserCypher{
    String str;

    String convertToStandard(String s){
        s = s.trim().toLowerCase();
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)>=97 && s.charAt(i)<=122){
                newStr.append(s.charAt(i));
            }  
        }
        return newStr.toString();
    }

    public int[] getNumericValue(String str){
        int[] num = new int[str.length()];
        for(int i=0;i<str.length();i++){
            num[i] = str.charAt(i);
        }
        return num;
    }
    String enCrypt(String s,int n){
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            int base = 97;
            int ch = sb.charAt(i);
            char newCh = (char) ((ch-base+3)%n+base);
            sb.setCharAt(i,newCh);
        }
        return sb.toString().toUpperCase();
    }
    String deCrypt(String cypher,int n){
        StringBuilder plainText = new StringBuilder(cypher);
        for(int i=0;i<plainText.length();i++){
            int base = 65;
            char newChar = (char) ((plainText.charAt(i)-base-3)%n+base);
            plainText.setCharAt(i,newChar);
        }
        return plainText.toString().toLowerCase();
    }

    String encryptAddCypher(String plainText,int key,int n){
        StringBuilder sb = new StringBuilder();
        int base = 97;
        for(int i=0;i<plainText.length();i++){
            char newCh = (char) ((plainText.charAt(i)-base+key)%n+base);
           sb.append(newCh);
        }
        return sb.toString().toUpperCase();
    }
    String decryptAddCypher(String cypherText,int key,int n){
        StringBuilder sb = new StringBuilder();
        int base = 65;
        for(int i=0;i<cypherText.length();i++){
            char newCh = (char) ((cypherText.charAt(i)-base-key)%n+base);
            sb.append(newCh);
        }
        return sb.toString().toLowerCase();
    }
    String encryptMultiCypher(String plainText,int key,int n){
        boolean isEncryptable = false;
        for(int i=1;i<=key;i++){
            if((key*i)%n == 1){
                isEncryptable = true;
                break;
            }
        }
        if(!isEncryptable){
            return "Not Encryptable";
        }
        StringBuilder sb = new StringBuilder();
        int base = 97;
        for(int i=0;i<plainText.length();i++){
            
            char newChar = (char) (((plainText.charAt(i)-base)*key)%n+base);
            sb.append(newChar);
        }
        return sb.toString().toUpperCase();
    }
    String decryptMultiCypher(String cypher,int key,int n){
        int inverse = 0;
        for(int i=1;i<=key;i++){
            if((key*i)%n == 1){
                inverse = i;
                break;
            }
        }
        if(inverse != 0){
            int base = 65;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<cypher.length();i++){
                char newCh = (char) (((cypher.charAt(i)-base)*inverse)%n+base);
                sb.append(newCh);
            }
            return sb.toString().toLowerCase();
        }
        return "Non Decryptable";
    }

    public static void main(String s[]){
        CieserCypher obj = new CieserCypher();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plain text : ");
        String pText = sc.nextLine();
        pText = obj.convertToStandard(pText);
        System.out.println("Plain text is : "+pText);
        String cypher = obj.encryptMultiCypher(pText,5,26);
        System.out.println("cypher is : "+cypher);
        String plainText = obj.decryptMultiCypher(cypher,5,26);
        System.out.println("Plain text : "+plainText);
        
       

    }
}