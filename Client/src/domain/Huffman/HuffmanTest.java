package domain.Huffman;

public class HuffmanTest {
    public static void main(String[] args) {

        /*Encoding*/
        HuffmanEncoder encoder = new HuffmanEncoder("Hello World");
        encoder.print();
        //encoder.printEncodingMap();
        System.out.println(encoder.getEncodedString());



    }
}
