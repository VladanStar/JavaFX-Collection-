package sample;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Controller {
    private LinkedList<Integer> list;

    public Controller() {
        list = new LinkedList<>();
    }

    private boolean isDuplicate(Integer val) {
        if (list.isEmpty()) {
            return false;
        }
        for (Integer temp : list) {
            if (temp.equals(val)) {
                return true;
            }
        }
        return false;
    }

    public void addElement(Integer val) {
        if (!isDuplicate(val)) {
            list.add(val);
        }
    }

    public void removeLast() {
        list.removeLast();
    }

    public void sort() {
        Collections.sort(list);
    }

    public void shuffle() {
        Collections.shuffle(list);
    }

    public void reverse() {
        Collections.reverse(list);
    }
    public String showAsString(){
        System.out.println("Usao AsString");
        Iterator<Integer> i = list.iterator();
        String result = "";
        while (i.hasNext()){
            result +=i.next() + " ";
        }
        return result;
    }
    public boolean listEmpty(){
        return list.isEmpty();
    }

    public boolean listEmty() {
        return true;
    }
}

