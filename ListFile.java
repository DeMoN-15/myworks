import java.io.*;
import java.nio.file.*;
public class ListFile{
    static File dirpath;
    static int count;
    public static void main(String a[]){
	String file=a[0];
	dirpath=new File(file);
	l(dirpath.listFiles(),0,0);
    }
    public static void l(File[] filearray ,int value,int index)
    {
	if(index==filearray.length)
	    {
		return;
	    }
	
	try{
	   
	    for(File afile:filearray)
		{
		    System.out.print("file no"+count+"\t");
		    for(int i=0;i<value;i++)
			{
			    System.out.print("\t");
			}
		    count++;
		    System.out.println(afile.getName());
		    if(afile.isDirectory()){
			l(afile.listFiles(),value+1,0);
		    }		   
		    
		}
	}
	catch(NullPointerException e){
	}
	
    }

}
