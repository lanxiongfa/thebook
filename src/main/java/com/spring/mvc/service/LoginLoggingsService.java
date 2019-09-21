package com.spring.mvc.service;

import com.spring.mvc.dao.LoginAndUserDao;
import jdk.management.resource.internal.inst.FileInputStreamRMHooks;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginLoggingsService {
    FileOutputStream outputStream = null;
    String header = "loggings" + File.separator;
    public boolean exists(String username){
        File file =new File (header+username);
        if(file.exists()){
            return  true;
        }else {
            return  false;
        }
    }

    public void OutputStream(String username, String date) {


        File createfile = new File(header + username);


        if (!createfile.exists()) {
            try {


                createfile.createNewFile();
                outputStream = new FileOutputStream(createfile);
                byte[] usernames = username.getBytes();
                byte[] dates = date.getBytes();
                outputStream.write(usernames, 0, usernames.length);
                outputStream.write("==".getBytes());
                outputStream.write(dates, 0, dates.length);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (null != outputStream)
                        outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                if(createfile.length()>1024*1024*5){

                createfile.delete();
                createfile.createNewFile();
                }
                outputStream = new FileOutputStream(createfile, true);
                outputStream.write("\r\n".getBytes());
                byte[] usernames = username.getBytes();


                byte[] dates = date.getBytes();

                outputStream.write(usernames);
                outputStream.write("==".getBytes());
                outputStream.write(dates, 0, dates.length);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (null != outputStream)
                        outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }


    public List<String> InputStream(String username) {
        FileReader fileReader = null;
        List<String> logging = new ArrayList<String>();

        String header = "loggings" + File.separator;
        File file = new File(header + username);
        int count=0;
        if (file.exists()) {
            try {
                fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String n = null;

                while ((n = bufferedReader.readLine()) != null) {
                    if (!n.equals("0")) {
                        count=count+1;

                        if (!n.equals("")) {
                            logging.add(n);
                        }

                    }


                }
                bufferedReader.close();
                String c="登录次数:"+count;
                logging.add(c);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {


                    if (null != fileReader) {
                        fileReader.close();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return logging;
    }
}


