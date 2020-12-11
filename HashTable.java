import java.util.Locale;

public class HashTable<T> {
    NGen<T>[] arr;
    int position = 0;
    public HashTable() {
        arr = new NGen[100];
    }

    public int Hash1(T key) {
        String token = key.toString();
        int hash = 0;
        for (int i=0; i<token.length(); i++) {
            hash += token.charAt(i);
        }
        //int hash = ((String)key).charAt(0) + ((((String)key).length()>1)?((String)key).charAt(1) : 0);
        return hash % 100;
    }
    public int Hash2(T key) {
        //Found this
        int h = 0;
        int off = 5;
        System.out.println(key);
        char val[] = key.toString().toCharArray();
        int len = key.toString().length();

        for (int i = 0; i < len; i++)
            h = 31*h + val[off++%len];

        return ((h<0)?-h:h) % 100;
        //return hash;
    }



    public int hash3(T key) {
        int hash = 0;
        return hash;
    }

    public void add(T data) {
        if (data == null) return;
        int hash = Hash2(data);
        NGen<T> linkedList = arr[hash];
        NGen<T> newNode = new NGen<T>();
        newNode.setData(data);
        if (linkedList==null) {
            arr[hash] = newNode;
        } else {
            while (linkedList.getNext() != null) linkedList = linkedList.getNext();
            linkedList.setNext(newNode);
        }
    }

    public void display() {
        int totalNonEmpty = 0;
        int totalTokens = 0;
        int longest = 0;
        int currentLongest;
        int nodeCount;
        NGen<T> ls;
        for (int i=0; i<100; i++) {
            ls = arr[i];
            currentLongest = 0;
            if (ls!=null) {
                totalNonEmpty++;
                nodeCount = 0;
                while (ls.getNext() != null) {
                    nodeCount++;
                    if (++currentLongest > longest) longest = currentLongest;
                    ls = ls.getNext();
                    totalTokens++;
                }
                System.out.printf(i+": " + nodeCount);
            } else {
                System.out.printf(i+": 0");
            }
            System.out.println();
        }
        System.out.println("Average Collisions: " + totalTokens/totalNonEmpty);
        System.out.println("Longest Collisions: " + longest);
        System.out.println("Total tokens: "+totalTokens );
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        TextScan textScan = new TextScan();
        textScan.openFile("keywords.txt");
        String token = textScan.getNextToken();
        while (token!=null) {
            hashTable.add(token);
            token = textScan.getNextToken();
        }
        hashTable.display();
        textScan.closeFile();
    }
}