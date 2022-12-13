package domain.Huffman;

import java.util.HashMap;

public class HuffmanDecoder {

    HashMap<String, Character> encodedMap = new HashMap<>();
    String encodedMessage;
    String decodedMessage;

    public HuffmanDecoder(HashMap<String, Character> encodedMap) {

    }

    public HashMap<String, Character> getEncodedMap() {
        return encodedMap;
    }

    public void setEncodedMap(HashMap<String, Character> encodedMap) {
        this.encodedMap = encodedMap;
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }

    public String getDecodedMessage() {
        return decodedMessage;
    }

    public void setDecodedMessage(String decodedMessage) {
        this.decodedMessage = decodedMessage;
    }

    @Override
    public String toString() {
        return "HuffmanDecoder{" +
                "encodedMap=" + encodedMap +
                ", encodedMessage='" + encodedMessage + '\'' +
                ", decodedMessage='" + decodedMessage + '\'' +
                '}';
    }
}
