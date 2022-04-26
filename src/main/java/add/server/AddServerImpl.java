package add.server;

import com.proto.add.addGrpc;
import com.proto.add.request;
import com.proto.add.response;
import io.grpc.stub.StreamObserver;

public class AddServerImpl extends addGrpc.addImplBase {
    @Override
    public void add(request request, StreamObserver<response> responseObserver){
        responseObserver.onNext(response.newBuilder().setResult(request.getFirstDigit()+ request.getSecondDigit()).build());
        responseObserver.onCompleted();
    }

}
