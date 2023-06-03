import TAD.Hash.HashTablaImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        HashTablaImpl<String, String> tabla = new HashTablaImpl<>(3);
        tabla.put("Pedro", "Pedro_0");
        tabla.put("Roberto", "roberto_1");
        tabla.put("Maria", "Maria_2");
//        tabla.put("Juan", "Juan_3");
//        tabla.put("Pancracio", "Pancracio_4");
//        tabla.put("Juan Pedro", "Juan Pedro_5");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inresar Key: ");
        String key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        String data = scanner.nextLine();
        tabla.put(key, data);

        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);
        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);
        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);
        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);
        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);
        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);
        System.out.print("Inresar Key: ");
        key = scanner.nextLine();
        System.out.print("Inresar Data: ");
        data = scanner.nextLine();
        tabla.put(key, data);








    }
}

