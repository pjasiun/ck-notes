package com.cksource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Files.FileColumns;
import android.util.Log;
import android.webkit.JavascriptInterface;


public class CameraInterface {
	private Editor activity;
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

	CameraInterface(Editor a) {
		activity = a;
	}

	@JavascriptInterface
	public String takePicture() {
		// create Intent to take a picture and return control to the calling application
	    File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
        imagesFolder.mkdirs();
        
        File image = new File(imagesFolder,  (Calendar.getInstance().getTimeInMillis()+".jpg"));
        Uri uriSavedImage = Uri.fromFile(image);
        
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        
        activity.setImageName(image.getAbsolutePath());

        activity.startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        
//        return image.getAbsolutePath(); 
        return getFileContent(image);
	}
	
	private String getFileContent(final File file){
        FileInputStream fileInputStream ;
        try {
                fileInputStream = new FileInputStream(file);
                
                StringBuilder sb = null;
                while(fileInputStream.available() > 0) {
                      sb = new StringBuilder();

                 sb.append((char)fileInputStream.read());
                }
        	    String fileContent = null;
        	    if(null!=sb){
        	         fileContent= sb.toString();
        	    }
        	    
        	    fileInputStream.close();
        	    

    	        return fileContent;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
