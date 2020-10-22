/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.helper;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Baler-Gamer
 */
public class FileURL {
    private static String folderName = getSetupFolder();
    public static String dbURL= "C:/"+folderName+"/My Training Guide/docs/portal.accdb";
    public static String uploadFolder = "C:/"+folderName+"/My Training Guide/docs/uploads";
    
    
    
    
    
    private static String getSetupFolder()
    {
        String folder = "Program Files (x86)";
        if(checkWindowsArch() == 64){
            folder = "Program Files (x86)";
        }
        else{
            folder = "Program Files";
        }
        return folder;
    }
    private static int checkWindowsArch()
    {
        int arch = 64;
        if(Files.isDirectory(Paths.get("C:/Windows/SysWOW64"))){
            arch = 64;
        }
        else{
            arch = 86;
        }
        
        return arch;
    }
}
