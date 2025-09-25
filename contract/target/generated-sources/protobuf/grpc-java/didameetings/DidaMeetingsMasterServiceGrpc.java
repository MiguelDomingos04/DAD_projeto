package didameetings;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: DidaMeetingsMaster.proto")
public final class DidaMeetingsMasterServiceGrpc {

  private DidaMeetingsMasterServiceGrpc() {}

  public static final String SERVICE_NAME = "didameetings.DidaMeetingsMasterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMaster.NewBallotRequest,
      didameetings.DidaMeetingsMaster.NewBallotReply> getNewballotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newballot",
      requestType = didameetings.DidaMeetingsMaster.NewBallotRequest.class,
      responseType = didameetings.DidaMeetingsMaster.NewBallotReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMaster.NewBallotRequest,
      didameetings.DidaMeetingsMaster.NewBallotReply> getNewballotMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMaster.NewBallotRequest, didameetings.DidaMeetingsMaster.NewBallotReply> getNewballotMethod;
    if ((getNewballotMethod = DidaMeetingsMasterServiceGrpc.getNewballotMethod) == null) {
      synchronized (DidaMeetingsMasterServiceGrpc.class) {
        if ((getNewballotMethod = DidaMeetingsMasterServiceGrpc.getNewballotMethod) == null) {
          DidaMeetingsMasterServiceGrpc.getNewballotMethod = getNewballotMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMaster.NewBallotRequest, didameetings.DidaMeetingsMaster.NewBallotReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "newballot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMaster.NewBallotRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMaster.NewBallotReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMasterServiceMethodDescriptorSupplier("newballot"))
              .build();
        }
      }
    }
    return getNewballotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMaster.SetDebugRequest,
      didameetings.DidaMeetingsMaster.SetDebugReply> getSetdebugMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setdebug",
      requestType = didameetings.DidaMeetingsMaster.SetDebugRequest.class,
      responseType = didameetings.DidaMeetingsMaster.SetDebugReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMaster.SetDebugRequest,
      didameetings.DidaMeetingsMaster.SetDebugReply> getSetdebugMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMaster.SetDebugRequest, didameetings.DidaMeetingsMaster.SetDebugReply> getSetdebugMethod;
    if ((getSetdebugMethod = DidaMeetingsMasterServiceGrpc.getSetdebugMethod) == null) {
      synchronized (DidaMeetingsMasterServiceGrpc.class) {
        if ((getSetdebugMethod = DidaMeetingsMasterServiceGrpc.getSetdebugMethod) == null) {
          DidaMeetingsMasterServiceGrpc.getSetdebugMethod = getSetdebugMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMaster.SetDebugRequest, didameetings.DidaMeetingsMaster.SetDebugReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setdebug"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMaster.SetDebugRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMaster.SetDebugReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMasterServiceMethodDescriptorSupplier("setdebug"))
              .build();
        }
      }
    }
    return getSetdebugMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DidaMeetingsMasterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMasterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMasterServiceStub>() {
        @java.lang.Override
        public DidaMeetingsMasterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsMasterServiceStub(channel, callOptions);
        }
      };
    return DidaMeetingsMasterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DidaMeetingsMasterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMasterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMasterServiceBlockingStub>() {
        @java.lang.Override
        public DidaMeetingsMasterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsMasterServiceBlockingStub(channel, callOptions);
        }
      };
    return DidaMeetingsMasterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DidaMeetingsMasterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMasterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMasterServiceFutureStub>() {
        @java.lang.Override
        public DidaMeetingsMasterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsMasterServiceFutureStub(channel, callOptions);
        }
      };
    return DidaMeetingsMasterServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DidaMeetingsMasterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void newballot(didameetings.DidaMeetingsMaster.NewBallotRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMaster.NewBallotReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewballotMethod(), responseObserver);
    }

    /**
     */
    public void setdebug(didameetings.DidaMeetingsMaster.SetDebugRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMaster.SetDebugReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetdebugMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewballotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMaster.NewBallotRequest,
                didameetings.DidaMeetingsMaster.NewBallotReply>(
                  this, METHODID_NEWBALLOT)))
          .addMethod(
            getSetdebugMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMaster.SetDebugRequest,
                didameetings.DidaMeetingsMaster.SetDebugReply>(
                  this, METHODID_SETDEBUG)))
          .build();
    }
  }

  /**
   */
  public static final class DidaMeetingsMasterServiceStub extends io.grpc.stub.AbstractAsyncStub<DidaMeetingsMasterServiceStub> {
    private DidaMeetingsMasterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsMasterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsMasterServiceStub(channel, callOptions);
    }

    /**
     */
    public void newballot(didameetings.DidaMeetingsMaster.NewBallotRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMaster.NewBallotReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewballotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setdebug(didameetings.DidaMeetingsMaster.SetDebugRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMaster.SetDebugReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetdebugMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DidaMeetingsMasterServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DidaMeetingsMasterServiceBlockingStub> {
    private DidaMeetingsMasterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsMasterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsMasterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public didameetings.DidaMeetingsMaster.NewBallotReply newballot(didameetings.DidaMeetingsMaster.NewBallotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewballotMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsMaster.SetDebugReply setdebug(didameetings.DidaMeetingsMaster.SetDebugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetdebugMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DidaMeetingsMasterServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DidaMeetingsMasterServiceFutureStub> {
    private DidaMeetingsMasterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsMasterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsMasterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMaster.NewBallotReply> newballot(
        didameetings.DidaMeetingsMaster.NewBallotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewballotMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMaster.SetDebugReply> setdebug(
        didameetings.DidaMeetingsMaster.SetDebugRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetdebugMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEWBALLOT = 0;
  private static final int METHODID_SETDEBUG = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DidaMeetingsMasterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DidaMeetingsMasterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEWBALLOT:
          serviceImpl.newballot((didameetings.DidaMeetingsMaster.NewBallotRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMaster.NewBallotReply>) responseObserver);
          break;
        case METHODID_SETDEBUG:
          serviceImpl.setdebug((didameetings.DidaMeetingsMaster.SetDebugRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMaster.SetDebugReply>) responseObserver);
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

  private static abstract class DidaMeetingsMasterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DidaMeetingsMasterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return didameetings.DidaMeetingsMaster.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DidaMeetingsMasterService");
    }
  }

  private static final class DidaMeetingsMasterServiceFileDescriptorSupplier
      extends DidaMeetingsMasterServiceBaseDescriptorSupplier {
    DidaMeetingsMasterServiceFileDescriptorSupplier() {}
  }

  private static final class DidaMeetingsMasterServiceMethodDescriptorSupplier
      extends DidaMeetingsMasterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DidaMeetingsMasterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DidaMeetingsMasterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DidaMeetingsMasterServiceFileDescriptorSupplier())
              .addMethod(getNewballotMethod())
              .addMethod(getSetdebugMethod())
              .build();
        }
      }
    }
    return result;
  }
}
