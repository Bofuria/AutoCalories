package org.example.Message.Calories;

import org.example.Message.dao.Dao;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class ManageFoodItem extends FoodItem {

    static DayTrack dayTrack = new DayTrack();
    static Socket clientSoc;
    static ServerSocket ss;

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

    public static void runJSServer() {
        ProcessBuilder pb = new ProcessBuilder("node", System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\Message\\Calories\\receive.cjs");
        try {
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clientSend(String message) throws IOException, InterruptedException {
        //
        // java client ---> js server
        //
        clientSoc = new Socket("localhost",2020);

        DataOutputStream d = new DataOutputStream(
                clientSoc.getOutputStream());

        d.writeUTF(message);

        d.flush();

        d.close();

        clientSoc.close();

    }

    public static Integer serverReceive(FoodItem foodItem) throws IOException, InterruptedException {
        //
        // java server <--- js client
        //
        ss = new ServerSocket(4040);

        runJSServer();
        Thread.sleep(1000);
        clientSend(foodItem.getName());
        Thread.sleep(3000);
        Socket socket = ss.accept();

        InputStream in = socket.getInputStream();
        // System.out.println("stream: " + in.available());

        char digit;
        StringBuilder result = new StringBuilder("");

        while(in.available() != 0) {
            digit = (char) in.read();
            result.append(digit);
        }

        // System.out.println("result: " + result);

        in.close();
        socket.close();
        ss.close();

        if(result.isEmpty() && !String.valueOf(result).equals("error")) {
            serverReceive(foodItem);
        }

        // add wrong input handling

        return Integer.valueOf(String.valueOf(result));
    }
}
