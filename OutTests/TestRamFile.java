
import java.util.Date;
import java.text.DateFormat;

import org.apache.commons.vfs2.FileContent;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;

import org.apache.commons.vfs2.FileType;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

/*
Created by TcheutchouaSteve on Oct 3, 2016
*/

public class TestRamFile {

	private static final int SHOW_MAX = 5;
	
	/** Maximum number of children to show. */
	public static void main(String[] args) {
		
		StandardFileSystemManager manager = new StandardFileSystemManager();
		try {
			manager.init();
			manager.resolveFile("ram://root/file.txt").createFile(); // prepare test harness
			//manager.resolveFile("ram://C:/Users/TcheutchouaSteve\Desktop").createFile(); // prepare test harness
			final FileObject file = manager.resolveFile("ram://root/file.txt");
			
			
			System.out.println("URL: " + file.getURL());
            System.out.println("getName(): " + file.getName());
            System.out.println("BaseName: " + file.getName().getBaseName());
            System.out.println("Extension: " + file.getName().getExtension());
            System.out.println("Path: " + file.getName().getPath());
            System.out.println("Scheme: " + file.getName().getScheme());
            //System.out.println("creator: " + file.getName().);

         // get the file in a way so at to manipulate the content ( read and write )
            FileContent fileContent = file.getContent();
            
            // write some notes to a file 
            //fileContent.write("I like the notes in this file ");
            
		} catch (FileSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		// TODO Auto-generated method stub
		
		if (args.length == 0)
			          {
			              System.err.println("Please pass the name of a file as parameter.");
			              System.err.println("e.g. java org.apache.commons.vfs2.example.ShowProperties LICENSE.txt");
			              return;
			          }
		for (final String arg : args)
			         {
			              try
			              {
			                  final FileSystemManager mgr = VFS.getManager();
			                  System.out.println();
			                  System.out.println("Parsing: " + arg);
			                  final FileObject file = mgr.resolveFile(arg);
			                  System.out.println("URL: " + file.getURL());
			                  System.out.println("getName(): " + file.getName());
			                  System.out.println("BaseName: " + file.getName().getBaseName());
			                  System.out.println("Extension: " + file.getName().getExtension());
			                  System.out.println("Path: " + file.getName().getPath());
			                  System.out.println("Scheme: " + file.getName().getScheme());
			                  System.out.println("URI: " + file.getName().getURI());
			                  System.out.println("Root URI: " + file.getName().getRootURI());
			                  System.out.println("Parent: " + file.getName().getParent());
			                  System.out.println("Type: " + file.getType());
			                  System.out.println("Exists: " + file.exists());
			                  System.out.println("Readable: " + file.isReadable());
			                  System.out.println("Writeable: " + file.isWriteable());
			                  System.out.println("Root path: " + file.getFileSystem().getRoot().getName().getPath());
			                  if (file.exists())
			                  {
			                      if (file.getType().equals(FileType.FILE))
			                      {
			                          System.out.println("Size: " + file.getContent().getSize() + " bytes");
			                      }
			                      else if (file.getType().equals(FileType.FOLDER) && file.isReadable())
			                      {
			                          final FileObject[] children = file.getChildren();
			                          System.out.println("Directory with " + children.length + " files");
			                          for (int iterChildren = 0; iterChildren < children.length; iterChildren++)
			                          {
			                              System.out.println("#" + iterChildren + ": " + children[iterChildren].getName());
			                              if (iterChildren > SHOW_MAX)
			                              {
			                                  break;
			                              }
			                          }
			                      }
			                      System.out.println("Last modified: " + DateFormat.getInstance().format(
			                              new Date(file.getContent().getLastModifiedTime())));
			                  }
			                  else
			                  {
			                      System.out.println("The file does not exist");
			                  }
			                  file.close();
			              }
			              catch (final FileSystemException ex)
		             {
			                 ex.printStackTrace();
			             }
			         }
			         */
			     }
	

}
