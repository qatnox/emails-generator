package Main;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final File input = new File("src\\Files\\ukr-names.csv");
    private static final File output = new File("src\\Files\\corp-emails.csv");
    private static GenerateMail generateMail = new GenerateMail();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========[ E-MAIL GENERATOR ]=========");

        System.out.print("Enter domain: ");
        String domain = sc.nextLine();

        generateMail.init(input, domain, output);
    }
}
