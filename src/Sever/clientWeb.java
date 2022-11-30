package Sever;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import Logic.ConvertNum;

public class clientWeb {
    private void connectToWeb() {
        // String host = "104.194.240.16";
        String host = "127.0.0.1";
        int port = 8881;
        try {
            Socket socket = new Socket(host, port);
            String gameIp = "localhost";
            int gamePort = 1234;
            String namegame = "Bingo123";
            String author = "copv";
            String info = "4284729874982ishdfkjshdkjfsh";
            System.out.println(socket.toString());
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream d = new DataOutputStream(b);

            d.write(ConvertNum.intToByteArray(1));

            d.write(ConvertNum.intToByteArray(gameIp.length()));
            d.write(gameIp.getBytes());

            d.write(ConvertNum.intToByteArray(gamePort));

            // d.write(ConvertNum.intToByteArray(0));

            d.write(ConvertNum.intToByteArray(namegame.length()));
            d.write(namegame.getBytes());

            d.write(ConvertNum.intToByteArray(info.length()));
            d.write(info.getBytes());

            d.write(ConvertNum.intToByteArray(author.length()));
            d.write(author.getBytes());

            d.flush();
            System.out.println(Arrays.toString(b.toByteArray()));
            socket.getOutputStream().write(b.toByteArray());
            socket.getOutputStream().flush();
            // socket.
            byte[] payload = new byte[100];

            socket.getInputStream().read(payload);
            System.out.println(Arrays.toString(payload));
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new clientWeb().connectToWeb();
    }
}