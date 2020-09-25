
/*
Задачи из презентации:
Исходные данные: текстовый файл со средней длиной строки равной 10 символам (файл или прошить текст в коде).
    В реализациях используйте наиболее подходящие имплементации коллекций!
    Задание 1: Подсчитайте количество различных слов в файле.
    Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    Задание 4: Выведите на экран все строки файла в обратном порядке.
    Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
    Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
 */

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BigTask {

    private static ArrayList<String> text = new ArrayList<>();
    private static ArrayList<String> uniqueWords = new ArrayList<>();
    private static HashMap<String, Integer> dict = new HashMap<>();

    static {
        try (Scanner scanner = new Scanner(new File("lesson_02\\src\\text.txt"))) {
            while (scanner.hasNextLine())
                text.add(scanner.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (String str : text)
            System.out.println(str);

        // Task 1
        System.out.println("Число слов в тексте: " + getWordCount());
        // Task 2
        //printDifferentWords();
        // Task 3
        createDictionary();
        // Task 4
        printReverse();

        // Task 6
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ind = new ArrayList<>();
        String[] temp = scanner.nextLine().split(" ");
        for (String s : temp)
            ind.add(Integer.parseInt(s));
        printStrings(ind);

    }

    // Task 1
    public static int getWordCount(){
        int wordCount = 0;
        for (String str : text)
            wordCount += str.split(" ").length;
        return  wordCount;
    }

    // Task 2
    public static void printDifferentWords(){
        HashSet<String> words = new HashSet<>();
        for (String str : text)
            words.addAll(Arrays.asList(str.split(" ")));
        uniqueWords.addAll(words);
        uniqueWords.sort(new ComparatorByLength<>());
        for (String str : uniqueWords)
            System.out.println(str);
    }

    // Task 3
    public static void createDictionary(){
        for(String line : text){
            for (String word : line.split("[^A-Za-zА-Яа-я]+")){
                if(dict.containsKey(word))
                    dict.replace(word, dict.get(word), dict.get(word) + 1);
                else
                    dict.put(word, 1);
            }
        }
        System.out.println(dict);
    }

    // Task 4
    public static void printReverse(){
        for(int i = text.size() - 1; i > -1; i--)
            System.out.println(text.get(i));
    }

    // Task 5
    public class ReverseIterator<T> implements Iterator<T>, Iterable<T> {

        private final List<T> list;
        private int position;

        public ReverseIterator(List<T> list) {
            this.list = list;
            this.position = list.size() - 1;
        }

        @Override
        public Iterator<T> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            return position >= 0;
        }

        @Override
        public T next() {
            return list.get(position--);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void printStrings(ArrayList<Integer> indexes){
        for (int i : indexes){
            if (i < text.size())
                System.out.println(text.get(i));
            else
                System.out.println("No such line with index " + i);
        }
    }


}

class ComparatorByLength<String> implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.toString().length(), o2.toString().length());
    }
}