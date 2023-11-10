package com.pgse.grpc.server.service;

import com.google.protobuf.Timestamp;
import com.pgse.grpc.generated.TimeReaderGrpc;
import com.pgse.grpc.generated.TimeReaderResponse;
import io.grpc.stub.ServerCallStreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TimeReaderGrpcService extends TimeReaderGrpc.TimeReaderImplBase {

    private final Timestamp.Builder timestampBuilder = Timestamp.newBuilder();
    private final TimeReaderResponse.Builder timeReaderResponseBuilder = TimeReaderResponse.newBuilder();

    @Override
    public void readTime(com.pgse.grpc.generated.TimeReaderRequest request,
        io.grpc.stub.StreamObserver<com.pgse.grpc.generated.TimeReaderResponse> responseObserver) {
        ServerCallStreamObserver<TimeReaderResponse> serverCallStreamObserver
            = (ServerCallStreamObserver<TimeReaderResponse>) responseObserver;
        int streamingTimeDuration = request.getStreamingTimeDuration() * 1000;
        long start = System.currentTimeMillis();
        long now = start;

        while(now - start <= streamingTimeDuration) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (serverCallStreamObserver.isReady()) {
                serverCallStreamObserver.onNext(timeReaderResponseBuilder.setTimestamp(readCurrentTime()).build());
            }
            now = System.currentTimeMillis();
        }
        serverCallStreamObserver.onCompleted();
        System.exit(0);
    }

    private Timestamp readCurrentTime() {
        // Timestamp computing recommended by https://protobuf.dev/reference/protobuf/google.protobuf/#timestamp
        long millis = System.currentTimeMillis();
        return timestampBuilder.setSeconds(millis / 1000)
            .setNanos((int) ((millis % 1000) * 1000000)).build();
    }
}
