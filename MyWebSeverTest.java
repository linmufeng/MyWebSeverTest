import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebSeverTest{
    public static void main (String[] args){
        try{
            System.out.print("9999 waiting...");
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            //note
            
            OutputStream os = s.getOutputStream();
            BufferedReader br = new BufferedReader (
                new FileReader("D:\\MyWebSever\\hello.html"));
            String buf = "";
            while((buf = br.readLine()) != null){
                os.write(buf.getBytes());
            }
            //close stream
            br.close();
            os.close();
            s.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}