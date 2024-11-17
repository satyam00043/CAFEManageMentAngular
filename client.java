import java.net.Socket;
import java.io.*;
import java.net.*;

public class client {
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public client(){
        try {
            System.out.println("sending request to server");
            socket = new Socket("127.0.0.1", 8000);
            System.err.println("connection establish");


            br=new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            startreading();
            startwriting();



        } catch (Exception e) {
           
        }

    }
    public void startreading(){
        //thread read and fetch;
        Runnable r1=()->{

            System.err.println("writer started....");
            while(true){
                try {
                    String msg=br.readLine();
                if(msg.equals("exit")){
                    System.err.println("server  termited the chat ");
                    break;
                }
                System.err.println("server : "+msg);
                    
                } catch (Exception e) {
                   e.printStackTrace();
                }
                
            }
        };
        new Thread(r1).start();


    }




    public void startwriting(){
        System.err.println(" Writer has started");
        Runnable r2=()->{
            while(true){
                try {
                    BufferedReader br1=new BufferedReader
                    (new InputStreamReader(System.in));
                    String content=br1.readLine();
                    out.println(content);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
            }



        };
        new Thread(r2).start();
    }



    public static void main(String[] args) {
        System.err.println("client has started");
        new client();
        
    }
}
