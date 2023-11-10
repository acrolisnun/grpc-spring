package com.pgse.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: time_reading.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TimeReaderGrpc {

  private TimeReaderGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TimeReader";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pgse.grpc.generated.TimeReaderRequest,
      com.pgse.grpc.generated.TimeReaderResponse> getReadTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readTime",
      requestType = com.pgse.grpc.generated.TimeReaderRequest.class,
      responseType = com.pgse.grpc.generated.TimeReaderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.pgse.grpc.generated.TimeReaderRequest,
      com.pgse.grpc.generated.TimeReaderResponse> getReadTimeMethod() {
    io.grpc.MethodDescriptor<com.pgse.grpc.generated.TimeReaderRequest, com.pgse.grpc.generated.TimeReaderResponse> getReadTimeMethod;
    if ((getReadTimeMethod = TimeReaderGrpc.getReadTimeMethod) == null) {
      synchronized (TimeReaderGrpc.class) {
        if ((getReadTimeMethod = TimeReaderGrpc.getReadTimeMethod) == null) {
          TimeReaderGrpc.getReadTimeMethod = getReadTimeMethod =
              io.grpc.MethodDescriptor.<com.pgse.grpc.generated.TimeReaderRequest, com.pgse.grpc.generated.TimeReaderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pgse.grpc.generated.TimeReaderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pgse.grpc.generated.TimeReaderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TimeReaderMethodDescriptorSupplier("readTime"))
              .build();
        }
      }
    }
    return getReadTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TimeReaderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TimeReaderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TimeReaderStub>() {
        @java.lang.Override
        public TimeReaderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TimeReaderStub(channel, callOptions);
        }
      };
    return TimeReaderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TimeReaderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TimeReaderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TimeReaderBlockingStub>() {
        @java.lang.Override
        public TimeReaderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TimeReaderBlockingStub(channel, callOptions);
        }
      };
    return TimeReaderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TimeReaderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TimeReaderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TimeReaderFutureStub>() {
        @java.lang.Override
        public TimeReaderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TimeReaderFutureStub(channel, callOptions);
        }
      };
    return TimeReaderFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Server Streaming RPC
     * </pre>
     */
    default void readTime(com.pgse.grpc.generated.TimeReaderRequest request,
        io.grpc.stub.StreamObserver<com.pgse.grpc.generated.TimeReaderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadTimeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TimeReader.
   */
  public static abstract class TimeReaderImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TimeReaderGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TimeReader.
   */
  public static final class TimeReaderStub
      extends io.grpc.stub.AbstractAsyncStub<TimeReaderStub> {
    private TimeReaderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeReaderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TimeReaderStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC
     * </pre>
     */
    public void readTime(com.pgse.grpc.generated.TimeReaderRequest request,
        io.grpc.stub.StreamObserver<com.pgse.grpc.generated.TimeReaderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TimeReader.
   */
  public static final class TimeReaderBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TimeReaderBlockingStub> {
    private TimeReaderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeReaderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TimeReaderBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming RPC
     * </pre>
     */
    public java.util.Iterator<com.pgse.grpc.generated.TimeReaderResponse> readTime(
        com.pgse.grpc.generated.TimeReaderRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TimeReader.
   */
  public static final class TimeReaderFutureStub
      extends io.grpc.stub.AbstractFutureStub<TimeReaderFutureStub> {
    private TimeReaderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeReaderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TimeReaderFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_READ_TIME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READ_TIME:
          serviceImpl.readTime((com.pgse.grpc.generated.TimeReaderRequest) request,
              (io.grpc.stub.StreamObserver<com.pgse.grpc.generated.TimeReaderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getReadTimeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.pgse.grpc.generated.TimeReaderRequest,
              com.pgse.grpc.generated.TimeReaderResponse>(
                service, METHODID_READ_TIME)))
        .build();
  }

  private static abstract class TimeReaderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TimeReaderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pgse.grpc.generated.TimeReading.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TimeReader");
    }
  }

  private static final class TimeReaderFileDescriptorSupplier
      extends TimeReaderBaseDescriptorSupplier {
    TimeReaderFileDescriptorSupplier() {}
  }

  private static final class TimeReaderMethodDescriptorSupplier
      extends TimeReaderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TimeReaderMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TimeReaderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TimeReaderFileDescriptorSupplier())
              .addMethod(getReadTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
