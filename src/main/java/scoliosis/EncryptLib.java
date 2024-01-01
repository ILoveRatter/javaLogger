package scoliosis;

public class EncryptLib {

    public static String DecryptWebhook(String encryptedString) {

        String decryptedString = "";

        String numbers = encryptedString.substring(70, 89);
        String numbersDecrypted = "";
        String discordString = "https://discord.com";

        for (int i = 0; i < 19; i++) {
            numbersDecrypted += Charecters().indexOf(numbers.charAt(i))-Charecters().indexOf(discordString.charAt(i));
        }


        String numbersDecryptedUnreversed = ReverseNumbers(numbersDecrypted);

        int b = 0;

        for (int i = 69; i < 100; i++) {

            while (b >= 19) {
                b -= 19;
            }

            b++;
        }

        for (int i = 101; i <= 191; i++) {

            while (b >= 19) {
                b -= 19;
            }

            int numtouse = Integer.parseInt(String.valueOf(numbersDecryptedUnreversed.charAt(b)));

            decryptedString += ShiftChar(encryptedString.charAt(i), -numtouse);

            b++;
        }
        decryptedString = "https://discord.com/api/webhooks" + decryptedString.substring(2);

        return decryptedString;
    }


    private static String Charecters() {
        // doesnt work with my alphabet so english alphabet it is! (i was very confused why it wasnt working on some letters and its because ñ counts as the same as ¡ and ¿ i think
        return "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789./_:-+|!?'`[]{}$%&()=;@<>";
    }

    private static String newCharAt(int pos) {
        while (pos < 0) {
            pos+=Charecters().length();
        }
        while (pos > Charecters().length()) {
            pos-=Charecters().length();
        }
        return String.valueOf(Charecters().charAt(pos));
    }

    public static String ReverseNumbers(String longnumber) {
        String numb = "";

        for (int i = 0; i < longnumber.length(); i++) {
            numb+=longnumber.charAt(longnumber.length()-i-1);
        }
        return numb;
    }

    public static String ShiftChar(char charecter, int howmuch) {
        return newCharAt(Charecters().indexOf(charecter)+howmuch);
    }
}
