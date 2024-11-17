import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;



class Server{
    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;
    public Server(){
        try {
            server = new ServerSocket(8000);
            System.out.println("Server started. for accept connection.");
            System.out.println("waiting ....");
            socket=server.accept();
            br=new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            startreading();
            startwriting();
        
        
        } catch (Exception e) {
          
            e.printStackTrace();
        }

    }
    public void startreading(){
        //thread read and fetch;
        Runnable r1=()->{

            System.err.println("reader started....");
            while(true){
                try {
                    String msg=br.readLine();
                if(msg.equals("exit")){
                    System.err.println("clint termited the chat ");
                    break;
                }
                System.err.println("client : "+msg);
                    
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
                    
                }
            }



        };
        new Thread(r2).start();
    }

    public static void main(String[] args) {
       System.out.println(" this is is server which will going to start"); 
        new Server();
    
    
    
    
    
    
    
    }
}