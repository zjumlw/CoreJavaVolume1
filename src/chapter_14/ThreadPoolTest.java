package chapter_14;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner in = new Scanner(System.in)){
			String bookPath1 = "E:\\Test\\Java\\CoreJavaVolume1\\src\\chapter_09\\Alice in Wonderland.txt";
			System.out.print("Enter base directory: ");
			String directory = in.nextLine();
			System.out.print("Enter keyword: ");
			String keyword = in.nextLine();
			
			ExecutorService pool = Executors.newCachedThreadPool();	//新建一个缓存型线程池
			
			MatchCounter2 counter = new MatchCounter2(new File(directory), keyword, pool);
			Future<Integer> result = pool.submit(counter);	//将Callable对象提交给ExecutorService
			
			try{
				System.out.println(result.get() + " matching files.");
			}catch(ExecutionException e){
				e.printStackTrace();
			}catch(InterruptedException e){
				
			}
			pool.shutdown();	//启动线程池关闭序列
			
			int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
			System.out.println("largest pool size = " + largestPoolSize);
		}
	}

}

class MatchCounter2 implements Callable<Integer>{

	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;
	
	public MatchCounter2(File directory, String keyword, ExecutorService pool){
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		count = 0;
		try{
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for(File file : files){
				if(file.isDirectory()){
					MatchCounter2 counter = new MatchCounter2(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);	//将Callable对象提交给ExecutorService
					results.add(result);
				}else{
					if(search(file))
							count++;
				}
			}
			
			for(Future<Integer> result : results){
				try{
					count += result.get();
				}catch(ExecutionException e){
					e.printStackTrace();
				}
			}
		}catch(InterruptedException e){
			
		}
		return count;
	}
	
	public boolean search(File file){
		try{
			try(Scanner in = new Scanner(file, "UTF-8")){
				boolean found = false;
				while(!found & in.hasNextLine()){
					String line = in.nextLine();
					if(line.contains(keyword))
						found = true;
				}
				return found;
			}
		}catch(IOException e){
			return false;
		}
	}
}
