package org.jivesoftware.sparkimpl.plugin.transcripts;

import org.apache.commons.vfs2.FileObject;

/**
 * Created by TcheutchouaSteve on 10/13/2016.
 */
public interface ApacheVFSInterface {

    public  FileObject openVFSFile(String fileName) ;

    public StringBuffer readVFSFile (FileObject tfile);

    public boolean writeVFSFile (String content, FileObject tfile);

    public boolean appendVfSFile (StringBuffer sbf);

    public void closeVFSFile (FileObject tfile);
}
