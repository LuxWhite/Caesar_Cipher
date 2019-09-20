import java.util.Scanner;
public class caesar_Cipher {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("!----Welcome to Caesar Cipher example---!");
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("Enter the single text you wish to encrypt: ");
        String text = input.nextLine();

        System.out.println("Enter the Shift value: ");
        Scanner value = new Scanner(System.in);
        int shift = value.nextInt();

        System.out.println("__________________Caesar Cipher__________________");
        System.out.println("Shift value: " + shift);
        System.out.println("Encryption: " +encryption(text,shift));
        System.out.println("_________________________________________________");

        System.out.print("do you wish to Decrypt? y/n ");
        Scanner ans = new Scanner(System.in);
        String reply = ans.nextLine();

        switch (reply.toUpperCase()){
            case "Y":
                StringBuffer encryption_Result = encryption(text,shift);
                System.out.println("Decryption: "+encryption(encryption_Result.toString(),26-shift));
                break;
            case "N":
                System.out.println("goodbye");
                break;
        }
        System.out.println("______________________Fin_________________________");
    }

    //_______________________________________________________________________________________________________________________________
    //Encryption Method (encoding the text)
    public static StringBuffer encryption(String text, int n) {
        StringBuffer encryption = new StringBuffer();

        //Traverse each character in the string
        for (int i = 0; i < text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                /*add shift to character of string
                simultaneously adjusting ascii value
                whether Uppercase or Lowercase letters.
                */
                char ch = (char) ((((int) text.charAt(i)) + n - 65) % 26 + 65);
                encryption.append(ch);
            } else
                {
                char ch = (char) ((((int) text.charAt(i)) + n - 97) % 26 + 97);
                encryption.append((ch));
            }
        }
        return encryption;
    }
} //End.