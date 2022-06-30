package org.example.Message.Calories;

import org.example.Message.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
public class ManageFoodItem extends FoodItem {
    static DayTrack dayTrack = new DayTrack();
    static Socket clientSoc;
    public static FoodItem updateMealCount(Dao dao, FoodItem foodItem) {
        if(dayTrack.dayChanged(foodItem)) {
            foodItem.setMealCount(1);
            dayTrack = new DayTrack();
        } else {
            Integer temp = dao.findByMealCount();
            if(temp != null) {
                foodItem.setMealCount(++temp);
            }
            else {
                foodItem.setMealCount(1);
            }
        }
        return foodItem;
    }

    public static void sendName(String message) throws IOException, InterruptedException {
        //
        // java client ---> js server
        //

        clientSoc = new Socket("localhost",2020);

        DataOutputStream d = new DataOutputStream(
                clientSoc.getOutputStream());

        // message to display
        d.writeUTF(message);

        d.flush();

        // closing DataOutputStream
        d.close();

        // closing socket
        clientSoc.close();


        // 2
//        PrintWriter pr = new PrintWriter(nodejs.getOutputStream());
//        pr.println(message);
//        pr.flush();
//
//        InputStreamReader in = new InputStreamReader(nodejs.getInputStream());
//        BufferedReader bf = new BufferedReader(in);
//
//        String result = bf.readLine();

        // 1
        //nodejs.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));
        //nodejs.getOutputStream().flush();
    }

    public static Integer getValue() throws IOException {

        //
        // java server <--- js client
        //

        ServerSocket ss = new ServerSocket(4040);


        ProcessBuilder pb = new ProcessBuilder("node",
                System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\Message\\Calories\\cal.cjs");
        Process p = pb.start(); // asking cal.cjs to provide calories
        System.out.println("is alive = " + p.isAlive());
        // establishes connection

        Socket soc = ss.accept();
        // invoking input stream
        DataInputStream dis
                = new DataInputStream(soc.getInputStream());
        System.out.println("dis: " + dis.readUTF());


        // System.out.println("is alive: " + p.isAlive());

        //soc.setSoTimeout(5000);
        //String test;
        //test = String.valueOf(dis.read());
        int result;
        result = dis.readInt();

        System.out.println("result= " + result);

        // closing socket
        ss.close();
        return result;
    }
}
