package chapter_09;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> words = new TreeSet<>();
		long totalTime = 0;
		String bookPath1 = "E:\\Test\\Java\\CoreJavaVolume1\\src\\chapter_09\\Alice in Wonderland.txt";
		String bookPath2 = "E:\\Test\\Java\\CoreJavaVolume1\\src\\chapter_09\\The Count of Monte Cristo.txt";
		try(Scanner in = new Scanner(Paths.get(bookPath2), "UTF-8")){
			while(in.hasNext()){
				String word = in.next();
				long callTime = System.currentTimeMillis();
				words.add(word);
				callTime = System.currentTimeMillis() - callTime;
				totalTime += callTime;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		Iterator<String> iter = words.iterator();
		for(int i = 1; i <= 20 && iter.hasNext(); i++){
			System.out.println(iter.next());
		}
		System.out.println("...");
		System.out.println(words.size() + " distinct words. " + totalTime + " millseconds.");
	}

}
