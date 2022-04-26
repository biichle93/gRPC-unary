package add.client;
import com.proto.add.addGrpc;
import com.proto.add.request;
import com.proto.add.response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AddClient {

    public static void doAddition(ManagedChannel channel){
        addGrpc.addBlockingStub stub = addGrpc.newBlockingStub(channel);
        response response = stub.add(request.newBuilder().setFirstDigit(10).setSecondDigit(6).build());
        System.out.println(response);
    }


    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        doAddition(channel);
    }
}
