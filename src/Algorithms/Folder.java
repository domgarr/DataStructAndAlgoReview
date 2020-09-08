package Algorithms;

import java.io.File;

public class Folder {
    public static Long getDiskUsage(File root){
        /* Return immediate size of disk usage in bytes.
        Immediate means, just the files in the folder, not the nested folders.
        */
        long total = root.length();
        if(root.isDirectory()){
            for(String childName : root.list()){
                File child = new File(root, childName);
                total += getDiskUsage(child);
            }
        }
        return total;
    }
}
