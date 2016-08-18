package fcu.selab.training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
	
	FileOutputStream fos = null;
	static StringBuilder sb = new StringBuilder();
	static String word[] ;
	static String sortedWord;
	
    public static void main( String[] args )
    {
    	readFile();
    	sortWord();
    	writeFile();
    	System.out.println(sortedWord);
    }
    
    static void readFile()
    {
    	FileInputStream fis = null;
    	try
    	{
			fis = new FileInputStream("input.txt");
			int count;
			while((count = (fis.read())) != -1)
			{
				
				sb.append((char)count);
			}
			
			fis.close();
	    }catch(Exception e)
    	{
			e.printStackTrace();
		}
    	String AllWord = sb.toString();
    	word = AllWord.split(",");
    	
//    	System.out.println(word.length);
//    	System.out.println(word[3]);
   	
    }
    static void sortWord()
    {
    	Arrays.sort(word);
    	
//    	int i = 0;
//    	while(i != word.length)
//    	{
//    		System.out.println(word[i]);
//    		i++;
//    	}
    	
    	int i = 0;
    	while(i != word.length)
    	{
    		word[i] = Integer.toString(i+1) + "." +  word[i];
    		System.out.println(word[i]);
    		i++;
    	}
    	
    	sortedWord = Arrays.toString(word);
    	
//    	System.out.println(sortedWord);
    }
    static void writeFile()
    {
    	FileOutputStream fos = null;
    	try
    	{
    		
			fos = new FileOutputStream("output.txt");
			byte getWord[] = sortedWord.getBytes();
		
			fos.write(getWord);
			fos.flush();
			
//			System.out.println(getWord);
//			System.out.println(getWord.length);

//    		int i = 0;

//			while(i != getWord.length)
//			{
//				System.out.println(getWord[i]);
//				i++;
//			}
			
			fos.close();
		}catch(Exception e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
