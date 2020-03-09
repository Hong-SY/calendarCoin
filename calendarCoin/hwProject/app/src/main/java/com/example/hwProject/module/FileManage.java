package com.example.hwProject.module;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/* 사용 예시
                String jsonstr = makeSchedule(schedule.getTitle(),"test","","","test","test", "test");

                boolean isFilePresent = fm.isFilePresent(getApplicationContext(), "storage.json");
                if(isFilePresent) {
                   String jsonString = fm.read(getApplicationContext(), "storage.json");
                   //do the json parsing here and do the rest of functionality of app
                } else {
                   boolean isFileCreated = fm.create(getApplicationContext(), "storage.json", jsonstr);
                   if(isFileCreated) {
                     //proceed with storing the first todo  or show ui
                   } else {
                     //show error or try again.
                   }
                }
                System.out.println(fm.read(getApplicationContext(), "storage.json"));
*/

public class FileManage {

    // file read 함수. file name 과 context를 인풋으로 받음.
    public String read(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    // json string 으로 file 생성.
    public boolean create(Context context, String fileName, String jsonString){

        try {
            FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_PRIVATE);
            if (jsonString != null) {
                fos.write(jsonString.getBytes());
            }
            fos.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }
    }

    // file 의 존재 유무 체크
    public boolean isFilePresent(Context context, String fileName) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }

}
