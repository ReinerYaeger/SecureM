/*
*
*  https://www.cs.miami.edu/home/odelia/teaching/csc317.sp15/syllabus/Algorithms8bClass_greedy.pdf
*
* */

package domain.Huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanEncoder {

    int frequency;
    char character;
    String encodedString ="";

    PriorityQueue <HuffmanNode> queue = new PriorityQueue<>(new HuffmanComparator());
    HashMap <Character, String> encodingMap = new HashMap<>();

    public HuffmanEncoder(String message){
        encode(message);
    }

    public void encode(String message){
        findFrequency(message);

        buildTree();

        for (HuffmanNode node : queue) {
            buildEncodingMap(node, "");
        }
        for (Character c : encodingMap.keySet()) {
            encodedString += encodingMap.get(c);
        }
        printEncodingMap();
    }

    /*   Encoding   */
    void findFrequency(String message){
        int[] frequency = new int[256];
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            if(!map.containsKey(message.charAt(i))){
               map.put(message.charAt(i),1);
            }else{
                int freq = map.get(message.charAt(i));
                map.put(message.charAt(i),freq+1);
            }
        }

        map.forEach((k,v)->{
            queue.add(new HuffmanNode(v,k));
        });

    }

    public void print(){

        PriorityQueue<HuffmanNode> q = queue;
        while (!q.isEmpty()){
            HuffmanNode node = (HuffmanNode) q.poll();
            System.out.print(node.getCharacter() + " " + node.getFrequency());
        }
    }

    void buildTree(){

        PriorityQueue<HuffmanNode> q = queue;

        while (q.size() > 1){
            HuffmanNode left = (HuffmanNode) queue.poll();
            HuffmanNode right = (HuffmanNode) queue.poll();
            assert right != null;
            HuffmanNode parent = new HuffmanNode(left.getFrequency()+right.getFrequency(), '\0');
            parent.setLeft(left);
            parent.setRight(right);
            q.add(parent);
        }
    }

    void buildEncodingMap(HuffmanNode node, String s){ //O Change to BFS traversal for better performance
        if(node == null){
            return;
        }
        if(node.getLeft() == null && node.getRight() == null){
            encodingMap.put(node.getCharacter(),s);
        }
        buildEncodingMap(node.getLeft(),s+"0");
        buildEncodingMap(node.getRight(),s+"1");
    }

    //print formatted hashmap
    public void printEncodingMap(){
        encodingMap.forEach((k,v)->{
            System.out.println(k + " " + v);
        });
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public HashMap<Character, String> getEncodingMap() {
        return encodingMap;
    }

    public void setEncodingMap(HashMap<Character, String> encodingMap) {
        this.encodingMap = encodingMap;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public void setEncodedString(String encodedString) {
        this.encodedString = encodedString;
    }

    @Override
    public String toString() {
        return "HuffmanEncoder{" +
                "frequency=" + frequency +
                ", character=" + character +
                ", queue=" + queue +
                ", encodingMap=" + encodingMap +
                '}';
    }
}
