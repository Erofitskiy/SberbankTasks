import java.util.HashMap;
import java.util.Map;


public class CountMapImpl<K> implements CountMap<K>{

    private final HashMap<K, Integer> map = new HashMap<>();

    @Override
    public void add(Object key) {
        if (!map.containsKey(key)) {
            map.put((K) key, 0);
        }
        map.put((K) key, map.get(key) + 1);
    }

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(Object o) {
        int n = getCount(o);
        map.remove(o);
        return n;
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(java.lang.Object o) {
        return map.get(o);
    }

    //количество разных элементов
    @Override
    public int size() {
        int count = 0;
        for(Object i : map.keySet())
            count++;
        return count;
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    @Override
    public void addAll(CountMap<K> source) {
        Map<K, Integer> gap = source.toMap();
        for(Object i : source.toMap().keySet()) {
            int count = 0;
            for(Object j : map.keySet()) {
                if(j == i) {
                    map.put((K) j, gap.get(i) + map.get(j));
                    count++;
                    break;
                }
            }
            if(count == 0) {
                map.put((K) i, 1);
            }
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public Map<K, Integer> toMap() {
        return map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map<K, Integer> destination) {
        destination.putAll(map);
    }


    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<Integer>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
        System.out.println(map.getCount(10));

        // int count = map.getCount(5);  // 2
        // int count = map.getCount(6);  // 1
        // int count = map.getCount(10); // 3
    }
}
