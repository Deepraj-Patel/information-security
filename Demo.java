import java.util.Scanner;
class GenEnc{
    String p;
    String c;
    GenEnc(){
        read();
    }
    GenEnc(String p){
        this.p = p;
        stdForm();
    }
    GenEnc(GenEnc obj){
        p=obj.p;
        c=obj.c;
    }
    void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plain text : ");
        p = sc.nextLine();
        
        stdForm();
    }
    void stdForm(){
        StringBuilder sb = new StringBuilder();
        p = p.trim();
        for(char c:p.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(c);
            }
        }
        p = sb.toString().toLowerCase();
    }
}

class CieserCypher extends GenEnc{
   
    CieserCypher(GenEnc obj){
        super(obj);
    }

    void encryption(){
        StringBuilder sb = new StringBuilder();
        for(char c:p.toCharArray()){
            char newCh = (char)((c-97+3)%26+97);
            sb.append(newCh);
        }
        c = sb.toString().toUpperCase();
    }
    String decryption(){
        StringBuilder sb = new StringBuilder();
        if(c != null){
            
        for(char c:c.toCharArray()){
            int rem = (c-65-3);
            if(rem<0){
                char newCh = (char)((26-Math.abs(rem))+65);
                sb.append(newCh);
            }
            else{
                char newCh = (char)((rem%26+65));
                sb.append(newCh);
            }
            }
        }
        else{
            return "No encrypted text to decrypt";
        }
        return sb.toString().toLowerCase();
    }
}

class AddCypher extends GenEnc{
    int key;
    
    AddCypher(GenEnc obj){
        super(obj);
        readKey();
    }
    void readKey(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key : ");
        key = sc.nextInt();
    }
    void encryption(){
        StringBuilder sb = new StringBuilder();
        for(char c:p.toCharArray()){
            char newCh = (char)((c-97+key)%26+97);
            sb.append(newCh);
        }
        c = sb.toString().toUpperCase();
    }
    String decryption(){
        StringBuilder sb = new StringBuilder();
        for(char c:c.toCharArray()){
            int rem = (c-65-key);
            if(rem<0){
                rem = Math.abs(rem)%26;
                rem = 26-rem;
                char newCh = (char) (rem+65);
                sb.append(newCh);
            }
            else{
                char newCh = (char)(rem%26+65);
                sb.append(newCh);
            }
            
        }
        return sb.toString().toLowerCase();
    }
}

class MulCypher extends GenEnc{
    int key;
    int inverse = 0;
   
    MulCypher(GenEnc obj){
        super(obj);
        readKey();
    }
    void readKey(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key : ");
        key = sc.nextInt();
        
        for(int i=1;i<26;i+=2){
            if((key * i)%26 == 1){
                
                inverse = i;
                break;
            }
        }
        if(inverse == 0){
            System.out.println("enter valid key : ");
        }
    }
    void encryption(){
        StringBuilder sb = new StringBuilder();
        for(char c:p.toCharArray()){
            char newCh = (char)(((c-97)*key)%26+97);
            sb.append(newCh);
        }
        c = sb.toString().toUpperCase();
    }
    String decryption(){
        StringBuilder sb = new StringBuilder();
        for(char c : c.toCharArray()){
            char newCh = (char)((((c-65)*inverse))%26+65);
            sb.append(newCh);
    }
    return sb.toString().toLowerCase();
}



}




class Demo{
    public static void main(String s[]){
        GenEnc genEnc = new GenEnc();
         MulCypher obj = new MulCypher(genEnc);
         System.out.println(obj.p);
         obj.encryption();
         System.out.println(obj.c);
         System.out.println(obj.decryption());
         
         
    }
}