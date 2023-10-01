import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ex: ");

        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();

            switch (a) {
                case 1:
                    main1(args);
                    // case 2 : main2(args);
                    // case 3 : main3(args);
            }
        }
    }

    public static void main1(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Scanner s = new Scanner(System.in);

            System.out.println("Document: ");
            String name = s.nextLine();
            System.out.println("Recognition: ");
            String rec = s.nextLine();
            System.out.println("Product: ");
            String pr = s.nextLine();
            System.out.println("Sum: ");
            int a = in.nextInt();

            Document one = new Kvut(name, rec);
            one.Show();
            Document two = new Nakl(name, pr);
            two.Show();
            Document three = new Pax(name, a);
            three.Show();
        }
    }
}

class Document {

    String name;

    public String Name() {
        return name;
    }

    public Document(String name) {

        this.name = name;
    }

    public void Show() {

        System.out.printf("Document: %s \n", name);
    }
}

class Kvut extends Document {

    String recognition;

    public Kvut(String name, String recognition) {

        super(name);
        this.recognition = recognition;
    }

    public String getRec() {
        return recognition;
    }

    public void Show() {

        System.out.printf("Document %s Kvut %s \n", super.Name(), recognition);
    }
}

class Nakl extends Document {

    String product;

    public Nakl(String name, String product) {

        super(name);
        this.product = product;
    }

    public String getPr() {
        return product;
    }

    public void Show() {

        System.out.printf("Document %s Nakl %s \n", super.Name(), product);
    }
}

class Pax extends Document {

    int sum;

    public Pax(String name, int sum) {

        super(name);
        this.sum = sum;
    }

    public int getPax() {
        return sum;
    }

    public void Show() {

        System.out.printf("Document %s Pax %s \n", super.Name(), sum);
    }
}