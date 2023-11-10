package com.pgse.grpc.client;

import com.google.protobuf.Timestamp;
import com.pgse.grpc.generated.TimeReaderGrpc;
import com.pgse.grpc.generated.TimeReaderRequest;
import com.pgse.grpc.generated.TimeReaderResponse;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientSpringBootApplication implements CommandLineRunner {

    @Value("${streaming-time-duration}")
    private int streamingTimeDuration;

    private static final Logger LOG = LoggerFactory.getLogger(GrpcClientSpringBootApplication.class);
    @GrpcClient("time-reader-0")
    private TimeReaderGrpc.TimeReaderStub timeReaderStub;

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientSpringBootApplication.class);
    }

    @Override
    public void run(String... args) {
        LOG.info("Streaming time duration has been set to: {}", streamingTimeDuration);
        TimeReaderRequest timeReaderRequest = TimeReaderRequest.newBuilder()
            .setStreamingTimeDuration(streamingTimeDuration).build();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        TimeReaderStreamObserver timeReaderStreamObserver = new TimeReaderStreamObserver(countDownLatch);
        timeReaderStub.withWaitForReady().readTime(timeReaderRequest, timeReaderStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            LOG.info("Streaming has been interrupted");
            throw new RuntimeException(e);
        }
    }

    private static class TimeReaderStreamObserver implements
        io.grpc.stub.StreamObserver<com.pgse.grpc.generated.TimeReaderResponse> {

        private final CountDownLatch countDownLatch;

        public TimeReaderStreamObserver(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void onNext(TimeReaderResponse timeReaderResponse) {
            LOG.info("Server time reading: {}", toInstant(timeReaderResponse.getTimestamp()));
        }

        @Override
        public void onError(Throwable throwable) {
            LOG.info(throwable.getMessage());
            LOG.info(throwable.getCause().getMessage());
        }

        @Override
        public void onCompleted() {
            LOG.info("Streaming has completed");
            countDownLatch.countDown();
        }

        private Instant toInstant(Timestamp timestamp) {
            long milliseconds = (timestamp.getSeconds() * 1000) + (timestamp.getNanos() / 1000000);
            return Instant.ofEpochMilli(milliseconds);
        }
    }
}