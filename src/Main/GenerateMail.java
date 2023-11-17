package Main;

import com.ibm.icu.text.Transliterator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class GenerateMail {
    private static final String CYRILLIC_TO_LATIN = "Ukrainian-Latin/BGN";
    private static final Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String password;
    private static double start;
    private static final List<String> list = new ArrayList<>();
    private static final List<String> mail = new ArrayList<>();

    public static void readFile(File input){
        start = System.currentTimeMillis();
        try {
            System.out.println("> Opening & reading " + input.getName() + " file...");

            FileReader reader = new FileReader(input);
            BufferedReader buffReader = new BufferedReader(reader);

            String line;
            while((line = buffReader.readLine()) != null){
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println("The process cannot access the file because it is being used by another process");
            System.exit(0);
        }
    }

    public static void generate(String domain) {
        System.out.println(">> Creating emails & password...");
        for (String s : list) {
            String latin = toLatinTrans.transliterate(s);
            latin = latin.toLowerCase();

            String[] emailParts = latin.split(";");

            if (emailParts[0].contains("'") || emailParts[0].contains("ʹ")) {
                emailParts[0] = emailParts[0].replace("'", "").replace("ʹ", "");
            }
            String name = String.valueOf(emailParts[1].charAt(0));
            mail.add(emailParts[0] + "." + name + "@" + domain);
        }
    }

    public static void saveFile(File output){
        try {
            System.out.println(">>> Saving to " + output.getName() +"...");

            FileWriter writer = new FileWriter(output);
            writer.write("ID" + ";" + "Email" + ";" + "Password\n");
            for(int i = 0; i < mail.size(); i++) {

                char[] passSymbols = ALPHABET.toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                for (int p = 0; p < 10; p++) {
                    Random random = new Random();
                    stringBuilder.append(passSymbols[random.nextInt(passSymbols.length)]);
                    password = stringBuilder.toString();
                }

                writer.write(i + ";" + mail.get(i) + ";" + password + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.err.println("The process cannot access the file because it is being used by another process");
            System.exit(0);
        }

        double end = System.currentTimeMillis();
        double time = (end - start) / 1000;
        System.out.println
                ("====================================\n" +
                        "Saved in " + output.getName() + "\n" +
                        "Done in " + (time) + " sec");
    }
}