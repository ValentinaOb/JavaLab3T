import java.util.Scanner;

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
                case 3:
                    main3(args);
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

        Linear one = new Linear();
        one.l();
        one.p();
        one.s();
        one.toStr();
        one.equal();

        Exponential two = new Exponential();
        two.l();
        two.p();
        two.s();
        two.toStr();
        two.equal();

    }

    public static void main3(String[] args) {

        S one = new L();
        one.l();
        one.p();
        one.s();
        one.toStr();
        one.equal();

        S two = new E();
        two.l();
        two.p();
        two.s();
        two.toStr();
        two.equal();

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
    int d;

    int b[] = new int[10];
    int q;

    int part, sum;

    public abstract void l();

    public abstract int p();

    public abstract int s();

    public abstract void equal();

    public abstract int pow(int a, int b);

    public abstract void toStr();

}

class Linear extends Series {

    int part = 0;
    int sum = 0;
    int[] a = new int[10];
    int d;
    int p = 1;
    int n = 0; // pos

    public int pow(int a, int b) {
        for (int i = 1; i <= b; i++) {
            p = p * a;
        }
        return p;
    }

    public void l() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("n: ");
            int l = in.nextInt();
            System.out.println("A[]: ");
            for (int i = 0; i < l; i++) {
                a[i] = in.nextInt();
            }
            System.out.println("Pos: ");
            n = in.nextInt();
        }
    }

    public int p() {
        d = a[1] - a[0];
        part = a[0] + d * (n);
        System.out.println("D: " + d);
        System.out.println("Part: " + part);
        return part;
    }

    public int s() {
        sum = ((a[0] + part) / 2) * n;
        System.out.println("An: " + part);
        System.out.println("Sum: " + sum);
        return sum;
    }

    public void equal() {
        if (part == 0) {
            System.out.println("P = 0\n");
        } else
            System.out.println("P != 0\n");

        if (sum == 0) {
            System.out.println("S = 0\n");
        } else
            System.out.println("S != 0\n");

        if (part > sum) {
            System.out.println("P > S\n");
        } else if (part < sum) {
            System.out.println("P < S\n");
        } else
            System.out.println("P = S\n");
    }

    public void toStr() {
        System.out.println("\nLp: " + part + "\nLs: " + sum);
    }
}

class Exponential extends Series {

    int part = 0;
    int sum = 0;
    int[] b = new int[10];
    int q = 0;
    int n = 0;

    public int pow(int a, int b) {
        int p = 1;
        for (int i = 0; i < b; i++) {
            p = p * a;
        }
        return p;
    }

    public void l() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\n\nn: ");
            int l = in.nextInt();
            System.out.println("B[]: ");
            for (int i = 0; i < l; i++) {
                b[i] = in.nextInt();
            }
            System.out.println("Pos: ");
            n = in.nextInt();
        }
    }

    public int p() {
        q = b[1] / b[0];
        part = pow(q, (n + 1));
        System.out.println("q: " + q);
        System.out.println("q^(n+1): " + pow(q, (n + 1)));
        System.out.println("Part: " + part);
        return part;
    }

    public int s() {
        sum = (b[0] * (pow(q, n + 1) - 1)) / (q - 1);
        System.out.println("Part: " + sum);
        return sum;
    }

    public void equal() {
        if (part == 0) {
            System.out.println("P = 0\n");
        } else
            System.out.println("P != 0\n");

        if (sum == 0) {
            System.out.println("S = 0\n");
        } else
            System.out.println("S != 0\n");

        if (part > sum) {
            System.out.println("P > S\n");
        } else if (part < sum) {
            System.out.println("P < S\n");
        } else
            System.out.println("P = S\n");
    }

    public void toStr() {
        System.out.println("\nEp: " + part + "\nEs: " + sum + "\n");
    }
}

interface S {

    void l();

    int p();

    int s();

    void equal();

    int pow(int a, int b);

    void toStr();

}

class L implements S {

    int part = 0;
    int sum = 0;
    int[] a = new int[10];
    int d;
    int p = 1;
    int n = 0;

    public int pow(int a, int b) {
        for (int i = 1; i <= b; i++) {
            p = p * a;
        }
        return p;
    }

    public void l() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("n: ");
            int l = in.nextInt();
            System.out.println("A[]: ");
            for (int i = 0; i < l; i++) {
                a[i] = in.nextInt();
            }
            System.out.println("Pos: ");
            n = in.nextInt();
        }
    }

    public int p() {
        d = a[1] - a[0];
        part = a[0] + d * (n);
        System.out.println("D: " + d);
        System.out.println("Part: " + part);
        return part;
    }

    public int s() {
        sum = ((a[0] + part) / 2) * n;
        System.out.println("An: " + part);
        System.out.println("Sum: " + sum);
        return sum;
    }

    public void equal() {
        if (part == 0) {
            System.out.println("P = 0\n");
        } else
            System.out.println("P != 0\n");

        if (sum == 0) {
            System.out.println("S = 0\n");
        } else
            System.out.println("S != 0\n");

        if (part > sum) {
            System.out.println("P > S\n");
        } else if (part < sum) {
            System.out.println("P < S\n");
        } else
            System.out.println("P = S\n");
    }

    public void toStr() {
        System.out.println("\nLp: " + part + "\nLs: " + sum);
    }
}

class E implements S {

    int part = 0;
    int sum = 0;
    int[] b = new int[10];
    int q = 0;
    int n = 0;

    public int pow(int a, int b) {
        int p = 1;
        for (int i = 0; i < b; i++) {
            p = p * a;
        }
        return p;
    }

    public void l() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\n\nn: ");
            int l = in.nextInt();
            System.out.println("B[]: ");
            for (int i = 0; i < l; i++) {
                b[i] = in.nextInt();
            }
            System.out.println("Pos: ");
            n = in.nextInt();
        }
    }

    public int p() {
        q = b[1] / b[0];
        part = pow(q, (n + 1));
        System.out.println("q: " + q);
        System.out.println("q^(n+1): " + pow(q, (n + 1)));
        System.out.println("Part: " + part);
        return part;
    }

    public int s() {
        sum = (b[0] * (pow(q, n + 1) - 1)) / (q - 1);
        System.out.println("Part: " + sum);
        return sum;
    }

    public void equal() {
        if (part == 0) {
            System.out.println("P = 0\n");
        } else
            System.out.println("P != 0\n");

        if (sum == 0) {
            System.out.println("S = 0\n");
        } else
            System.out.println("S != 0\n");

        if (part > sum) {
            System.out.println("P > S\n");
        } else if (part < sum) {
            System.out.println("P < S\n");
        } else
            System.out.println("P = S\n");
    }

    public void toStr() {
        System.out.println("\nEp: " + part + "\nEs: " + sum + "\n");
    }
}
