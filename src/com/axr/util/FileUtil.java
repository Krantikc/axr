package com.axr.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	static Logger log = LoggerFactory.getLogger(FileUtil.class);
	public static boolean uploadFile(String folderName, MultipartFile file, String fileName) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                String finalPath = rootPath  + File.separator + "webapps" + File.separator + "ROOT" + File.separator;
                File dir = new File(finalPath + folderName);
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                
                System.out.println(serverFile+": "+serverFile.getAbsolutePath());
                stream.write(bytes);
                stream.close();
 
                log.info("Server File Location="
                        + serverFile.getAbsolutePath());
                
                return true;
               
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } 
        
        return false;

	}

	public static boolean deleteFile(String folderName, String fileName, String fileType, boolean isPartialFileName) {
		String rootPath = System.getProperty("catalina.home");
		String finalPath = rootPath  + File.separator + "webapps" + File.separator + "ROOT" + File.separator;
        System.out.println(finalPath + folderName);
		if (isPartialFileName) {
            try {
               
               File dir = new File(finalPath + folderName);
               FileFilter filter = new WildcardFileFilter("*" + fileName+ "*" + fileType);
               File[] files = dir.listFiles(filter);
               for (File file : files) {
            	   file.delete();
               }
               
                
                return true;
               
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
        	File file = new File(finalPath + folderName +  File.separator + fileName + fileType);
        	file.delete();
        }
         
        return false;

	} 

}
