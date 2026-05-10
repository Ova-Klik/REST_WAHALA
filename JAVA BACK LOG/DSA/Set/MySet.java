import CustomException.IllegalArgumentException;

import java.util.ArrayList;

public class MySet {
    private ArrayList<String> set;

    public MySet(){
      this.set= new ArrayList<>();
    }
    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean add(String element) {
        validateNull(element);
        if(element.isEmpty()) throw new IllegalArgumentException("Element cannot be empty");
        if(contains(element)) return false;
        set.add(element);
        return true;
    }

    public boolean contains(String element) {
        for (String data:set) {
            if(data.equals(element)) return true;
        }
        return false;
    }

    public int getSize() {
        return set.size();
    }

    public boolean remove(String element) {
        if(!contains(element)) return false;
        set.remove(element);
        return true;
    }

    private void validateNull(String element){
        if(element==null) throw new NullPointerException("element is null");
    }

    private void validateNull(ArrayList<String> elements) {
        for (String element : elements) {
            if (element == null) throw new NullPointerException("element is null");

        }
    }
    public void clear() {
            if(isEmpty()) return;
            set.clear();
    }

    public boolean equals(ArrayList<String> secondSet) {
        if(set.size()!=secondSet.size()) return false;
        for(String data : secondSet){
            if(!set.contains(data)) return false;
        }
        return true;
    }


    public boolean containsAll(ArrayList<String> secondSet) {
        for(String data : secondSet){
            if(!set.contains(data)) return false;
        }
        return true;
    }

    public boolean retainAll(ArrayList<String> secondSet) {
        validateNull(secondSet);
        boolean changed = false;
        ArrayList<String> toRemove = new ArrayList<>();

        for (String data : set) {
            if (!secondSet.contains(data)) {
                toRemove.add(data);
                changed = true;
            }
        }

        set.removeAll(toRemove);
        return changed;
    }

    public boolean addAll(ArrayList<String> secondSet) {
        validateNull(secondSet);
        boolean changed = false;

        for (String data : secondSet) {
            if (add(data)) changed = true;
        }

        return changed;
    }

    public Object[] toArray() {
        return set.toArray();
    }
}
