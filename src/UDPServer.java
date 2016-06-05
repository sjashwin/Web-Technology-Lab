/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel ;
import java.nio.channels.SocketChannel;
/**
 *
 * @author Ashwin
 */
public class UDPServer {
     ServerSocketChannel server ;
     static SocketChannel channel ;
     static ByteBuffer buffer ;
     UDPServer() throws IOException{
         server = ServerSocketChannel.open() ;
         server.socket().bind(new InetSocketAddress(8055)) ;
         channel = server.accept() ;
         buffer = ByteBuffer.allocate(1024) ;
     }
     public static void main(String args[]) throws IOException{
         while(true){
            channel.read(buffer) ;
            String data = "hello" ;
            buffer =  ;
            channel.write(buffer) ;
             
         }
     }
}
