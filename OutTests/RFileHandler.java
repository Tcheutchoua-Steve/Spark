package dev;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.vfs2.FileContent;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileUtil;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

/*
Created by TcheutchouaSteve on Oct 4, 2016
*/

public class RFileHandler {

	static FileObject file ;
	
	public static  FileObject open(String fileName) {
		
		try {
			// needs the try/catch
			/*FileSystemManager fsManager = VFS.getManager();
			String fileString = "ram://" + fileName;
			
			file = fsManager.resolveFile(fileString);*/
			StandardFileSystemManager manager = new StandardFileSystemManager();
			manager.init();
			//creates file if it does not exist
			manager.resolveFile("ram://"+  fileName).createFile(); // prepare test harness
			file = manager.resolveFile("ram://"+  fileName);
		} catch (FileSystemException e) {
				System.out.println("ERROR: " + e.toString());
		}
		
		return file ; 
	}

	public static StringBuffer read(FileObject tfile) {
		
		StringBuffer fileContents = new StringBuffer();
		
		
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			// needs the try/catch
			FileUtil.writeContent(tfile, outputStream);
			
			fileContents.append(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContents;
	}

	
	public static boolean write(StringBuffer sbf , FileObject tfile) {
		
		try {
			// needs the try/catch
			if (!tfile.exists())
				tfile.createFile();
			FileContent fc = tfile.getContent();
			// true added in getOutputStream to enable append to file
			OutputStream outputStream = fc.getOutputStream(true);
			PrintWriter pw = new PrintWriter(outputStream);
			pw.write(sbf.toString());
			pw.flush();
			outputStream.flush();
			
		} catch (FileSystemException e) {
			System.out.println("ERROR: " + e.toString());
		} catch (IOException e) {
			System.out.println("ERROR: " + e.toString());
		}
		return true;
	}

	
	public boolean append(StringBuffer sbf) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public static void close(String fileName) {
		try {
			file.close();
		} catch (FileSystemException e) {
			System.out.println("ERROR: " + e.toString());
		}
	}
	
	public static void main(String[] args) {
		String filename = "root/test.txt" ; 
		
		write2(filename, "I like this class");
		//write2(filename, "school is interesting");
		StringBuffer rbf = read (file);
		System.out.println("File contained : " + rbf.toString());
		write2(filename, read (file) + " school is interesting");
		//read (file);
		System.out.println("File contained : " + read (file).toString());
	}
	
	public static boolean write2 (String fileName, String contents){
		//System.out.println("went well");
		FileObject file = open(fileName);
		System.out.println("went well 2");

		StringBuffer line = new StringBuffer(contents);
		write(line, file);
		close(fileName);
		return true; 
	}
}
