package Collection_framework.Map;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(31,"Rakshit");
        map.put(11,"Akshit");
        map.put(2,"Neha");//this got overidden by mehul
        map.put(2,"Mehul");
        System.out.println(map);

        String student = map.get(31);
        System.out.println(student);
        String s = map.get(69);
        System.out.println(s);

        System.out.println(map.containsValue(2));
        System.out.println(map.containsValue("Shubham"));

        for(int i : map.keySet()){
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer,String>> entries = map.entrySet();

        for(Map.Entry<Integer,String> entry : entries){
            entry.setValue(entry.getValue().toUpperCase());
        }

        System.out.println(map);

        // map.remove(31)
        boolean res = map.remove(31,"Nitin");
        System.out.println("Removed ? : " + res);
        System.out.println(map);

        List<Integer> list = Arrays.asList(2,4,32,43,4,432);
        list.contains(32);
    }
}
