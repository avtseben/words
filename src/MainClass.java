//1) Создать переменную с небольшим текстом(в котором должны встречать повторяющиеся слова):
//а) Посчитать сколько раз встречается каждое слово;
//б) Найти все слова из которых состоит текст(дубликаты не считаем);

//2) Создать массив из элементов(например, String[] = { Hello, Hi, Hello, Abc, Bca, Hi }
//Найти дубликаты в этом массиве и вывести в консоль.

//2) Создать массив из элементов(например, String[] = { Hello, Hi, Hello, Abc, Bca, Hi }
//Найти дубликаты в этом массиве и вывести в консоль.

import java.util.*;


public class MainClass {
	public static void main(String[] args) {

	    String s = "this is a new text for my home home home work. A use repeat with this word, and try to find repeat words";

	    System.out.println(s);
	    System.out.println(separateWordsInText(s));
	    System.out.println(countOfWords(separateWordsInText(s)));
	    System.out.println(wordsSetInText(s));
	    findDuplicate(s);
	    

	}
	static void prt(String _s) {
	    System.out.println(_s);
	}
	static ArrayList<String> separateWordsInText(String _s) {
	    ArrayList<String> a = new ArrayList<String>();
	    String w = "";
	    for(int i = 0; i < _s.length(); i++) {
		if(isSeparateChar(_s.charAt(i)) && w != "") {
			a.add(w);
			w = "";
		}
		else { 
		    w = w + _s.charAt(i);
		}
	    }
	    return a;
	}
	static Map<String, Integer> countOfWords(ArrayList<String> _a) {
	    Map<String, Integer> a = new HashMap<String, Integer>();
	    Integer c = 1;

	    for(int i = 0; i < _a.size(); i++) {
		Integer wordCounter = a.put(_a.get(i), c);
		if(wordCounter != null) {
		    a.put(_a.get(i), ++wordCounter);
		}
	    }
	    return a;
	}
	static Set<String> wordsSetInText(String _s) {
	    Set<String> sw = new HashSet<>();
	    String w = "";
	    for(int i = 0; i < _s.length(); i++) {
		if(isSeparateChar(_s.charAt(i))) {
		    sw.add(w);
		    w = "";
		}
		else {
		    w = w + _s.charAt(i);
		}
	    }
	    return sw;
	}
	static boolean isSeparateChar(char _c) {//TODO This is not all separate chars
	    if(_c == ' ' || _c == ',' || _c == '.')
		return true;
	    return false;
	}
	static void findDuplicate(String _s) {
	    ArrayList<String> a = separateWordsInText(_s);
	    Set<String> sw = new HashSet<>();
	    for(int i = 0; i < a.size(); i++) {
		if(!sw.add(a.get(i)))
		    System.out.println("Duplicate: " + a.get(i));
	    }
	}

}
