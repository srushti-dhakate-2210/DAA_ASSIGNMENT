import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Node node;
        int x;
        String word, line;
        RedBlackTree rb = new RedBlackTree();
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("dictionary.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            rb.insert(line);
        }
        br.close();
        fr.close();
        while (true) {
            System.out.println("\n");
            System.out.println("Select operation you want to perform\n");            
            System.out.println("1]Insert ");
            System.out.println("2]Delete ");
            System.out.println("3]Search ");
            System.out.println("4]Print Size");
            System.out.println("5]print height");
            System.out.println("6]EXIT");
            System.out.println("\n");
            x = sc.nextInt();
            switch (x) {
                case 1: {
                    System.out.println("Insert word to add:  ");
                    word = sc.next();
                    rb.insert(word);
                    System.out.println("Word has been inserted.");
                    // rb.printTree();
                }
                    break;
                case 2: {
                    System.out.println("Insert word to delete> ");
                    word = sc.next();
                    rb.delete(word);
                    // rb.printTree();
                }
                    break;
                case 3: {
                    System.out.println("Insert word to search for> ");
                    word = sc.next();
                    node = rb.search(word.trim());
                    if (node == rb.nil)
                        System.out.println("word is not found!");
                }
                    break;
                case 4: {
                    rb.printSize();
                }
                    break;
                case 5: {
                    rb.printHeight();
                }
                    break;
                default: {
                    // rb.printTree();
                    System.exit(0);
                }

            }

        }

    }

}