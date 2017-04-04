/**
 * Created by Roberto on 12/8/16.
 */
import java.lang.Math;

public class HashMap {
    public static int TABLE_SIZE ;
    public static int CountColisions =0;
    LinkedHashEntry[] table;

    HashMap(int size) {
        TABLE_SIZE = size;
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i <TABLE_SIZE; i++)
            table[i] = null;
        CountColisions = 0;
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null)
            return -1;
        else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry == null)
                return -1;
            else
                return entry.getValue();
        }
    }

    public void putDivision(int value) {
        int key = value;
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(key, value);
        else {
            CountColisions = CountColisions+1;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry.getKey() == key)
                entry.setValue(value);
            else
                entry.setNext(new LinkedHashEntry(key, value));
        }
    }

    public void putMultiplication(int value) {
        int key = value;
        double A = ((Math.sqrt(5)-1)/2);
        //A = 0.29832;
        double KA= key*A;
        long ipart = (long)KA;
        double fractionOfKA = KA - ipart;
        double KAM = fractionOfKA* TABLE_SIZE;
        int hash = (int) KAM;
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(key, value);
        else {
            CountColisions = CountColisions+1;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry.getKey() == key)
                entry.setValue(value);
            else
                entry.setNext(new LinkedHashEntry(key, value));
        }
    }


    public int getCountColisions(){
        return CountColisions;
    }
}