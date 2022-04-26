package add.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class AddServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50052;
        Server server = ServerBuilder
                .forPort(port)
                .addService(new AddServerImpl())
                .build();
        server.start();
        System.out.println("Server has started");
        System.out.println("Listening on port "+port);


        //Gracefully handle server shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Signal");
            server.shutdown();
            System.out.println("Server Shutdown Successful");
        }));

        server.awaitTermination();

    }
}
