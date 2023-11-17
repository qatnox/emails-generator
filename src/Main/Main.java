package Main;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final File input = new File("src/Files/ukr-names.csv");
    private static final File output = new File("src/Files/corp-emails.csv");
    private static GenerateMail generateMail = new GenerateMail();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========[ E-MAIL GENERATOR ]==========");
        System.out.print("Enter domain: ");
        String domain = sc.nextLine();
        generateMail.readFile(input);
        generateMail.generate(domain);
        generateMail.saveFile(output);
    }
}
