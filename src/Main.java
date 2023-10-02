import java.util.Scanner;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ex: ");

        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();

            switch (a) {
                case 1:
                    main1(args);
                case 2:
                    main2(args);
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

    public static void main2(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            Series one = new linear();
            one.toString();
            Series two = new exponential();
            two.toString();
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

abstract class Series {

    int a[] = new int[10];
    int d = a[2] - a[1];

    int b[] = new int[10];
    int q = a[2] / a[1];

    int parta, partg;
    int suma, sumg;

    public abstract int p();

    public abstract int s();

    public abstract int equal();

    static int pow(int a, int b) {
        int p = 1;
        for (int i = 1; i <= b; i++) {
            p = p * a;
        }
        return p;
    }

    /*
     * public int Arp(int n) {
     * this.parta = this.a[1] + this.d * (n - 1);
     * return this.parta;
     * }
     * 
     * public int Ars(int n) {
     * this.suma = ((this.a[1] + this.a[n]) / 2) * n;
     * return this.suma;
     * }
     * 
     * public int Gp(int n) {
     * this.partg = this.b[1] + pow(this.q, (n - 1));
     * return this.partg;
     * }
     * 
     * public int Gs(int n) {
     * this.sumg = (this.b[1] * (pow(this.q, (n)) - 1)) / (q - 1);
     * return this.sumg;
     * }
     */
    public String toString() {
        return "\nArp" + parta + "\nArs=" + suma + "\nGp" + partg + "\nGs=" + sumg;
    }

}

class linear extends Series {

    int p = 0;
    int s = 0;
    int[] a = new int[10];

    public linear() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("n: ");
            int n = in.nextInt();
            System.out.println("A[]: ");
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println("Pos: ");
            p = in.nextInt();
        }
    }

    public int p(int n) {
        p = this.a[1] + this.d * (n - 1);
        return this.p;
    }

    public int s(int n) {
        s = ((this.a[1] + this.a[n]) / 2) * n;
        return this.s;
    }

    public String toString() {
        return "Lp" + p + "\nLs=" + s;
    }
}

class exponential extends Series {

    int pa;
    int su;
    int[] b = new int[10];

    public exponential() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("n: ");
            int n = in.nextInt();
            System.out.println("A[]: ");
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            System.out.println("Pos: ");
            pa = in.nextInt();
        }
    }

    public int Ep(int n) {
        pa = b[1] + pow(q, (n - 1));
        return pa;
    }

    public int Es(int n) {
        su = (b[1] * (pow(q, (n)) - 1)) / (q - 1);
        return su;
    }

    public String toString() {
        return "\nEp" + pa + "\nEs=" + su;
    }
}
