package didameetings;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: DidaMeetingsMain.proto")
public final class DidaMeetingsMainServiceGrpc {

  private DidaMeetingsMainServiceGrpc() {}

  public static final String SERVICE_NAME = "didameetings.DidaMeetingsMainService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.OpenRequest,
      didameetings.DidaMeetingsMain.OpenReply> getOpenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "open",
      requestType = didameetings.DidaMeetingsMain.OpenRequest.class,
      responseType = didameetings.DidaMeetingsMain.OpenReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.OpenRequest,
      didameetings.DidaMeetingsMain.OpenReply> getOpenMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.OpenRequest, didameetings.DidaMeetingsMain.OpenReply> getOpenMethod;
    if ((getOpenMethod = DidaMeetingsMainServiceGrpc.getOpenMethod) == null) {
      synchronized (DidaMeetingsMainServiceGrpc.class) {
        if ((getOpenMethod = DidaMeetingsMainServiceGrpc.getOpenMethod) == null) {
          DidaMeetingsMainServiceGrpc.getOpenMethod = getOpenMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMain.OpenRequest, didameetings.DidaMeetingsMain.OpenReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "open"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.OpenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.OpenReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMainServiceMethodDescriptorSupplier("open"))
              .build();
        }
      }
    }
    return getOpenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.AddRequest,
      didameetings.DidaMeetingsMain.AddReply> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = didameetings.DidaMeetingsMain.AddRequest.class,
      responseType = didameetings.DidaMeetingsMain.AddReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.AddRequest,
      didameetings.DidaMeetingsMain.AddReply> getAddMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.AddRequest, didameetings.DidaMeetingsMain.AddReply> getAddMethod;
    if ((getAddMethod = DidaMeetingsMainServiceGrpc.getAddMethod) == null) {
      synchronized (DidaMeetingsMainServiceGrpc.class) {
        if ((getAddMethod = DidaMeetingsMainServiceGrpc.getAddMethod) == null) {
          DidaMeetingsMainServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMain.AddRequest, didameetings.DidaMeetingsMain.AddReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.AddReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMainServiceMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.TopicRequest,
      didameetings.DidaMeetingsMain.TopicReply> getTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "topic",
      requestType = didameetings.DidaMeetingsMain.TopicRequest.class,
      responseType = didameetings.DidaMeetingsMain.TopicReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.TopicRequest,
      didameetings.DidaMeetingsMain.TopicReply> getTopicMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.TopicRequest, didameetings.DidaMeetingsMain.TopicReply> getTopicMethod;
    if ((getTopicMethod = DidaMeetingsMainServiceGrpc.getTopicMethod) == null) {
      synchronized (DidaMeetingsMainServiceGrpc.class) {
        if ((getTopicMethod = DidaMeetingsMainServiceGrpc.getTopicMethod) == null) {
          DidaMeetingsMainServiceGrpc.getTopicMethod = getTopicMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMain.TopicRequest, didameetings.DidaMeetingsMain.TopicReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "topic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.TopicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.TopicReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMainServiceMethodDescriptorSupplier("topic"))
              .build();
        }
      }
    }
    return getTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.CloseRequest,
      didameetings.DidaMeetingsMain.CloseReply> getCloseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "close",
      requestType = didameetings.DidaMeetingsMain.CloseRequest.class,
      responseType = didameetings.DidaMeetingsMain.CloseReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.CloseRequest,
      didameetings.DidaMeetingsMain.CloseReply> getCloseMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.CloseRequest, didameetings.DidaMeetingsMain.CloseReply> getCloseMethod;
    if ((getCloseMethod = DidaMeetingsMainServiceGrpc.getCloseMethod) == null) {
      synchronized (DidaMeetingsMainServiceGrpc.class) {
        if ((getCloseMethod = DidaMeetingsMainServiceGrpc.getCloseMethod) == null) {
          DidaMeetingsMainServiceGrpc.getCloseMethod = getCloseMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMain.CloseRequest, didameetings.DidaMeetingsMain.CloseReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "close"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.CloseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.CloseReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMainServiceMethodDescriptorSupplier("close"))
              .build();
        }
      }
    }
    return getCloseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.DumpRequest,
      didameetings.DidaMeetingsMain.DumpReply> getDumpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dump",
      requestType = didameetings.DidaMeetingsMain.DumpRequest.class,
      responseType = didameetings.DidaMeetingsMain.DumpReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.DumpRequest,
      didameetings.DidaMeetingsMain.DumpReply> getDumpMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsMain.DumpRequest, didameetings.DidaMeetingsMain.DumpReply> getDumpMethod;
    if ((getDumpMethod = DidaMeetingsMainServiceGrpc.getDumpMethod) == null) {
      synchronized (DidaMeetingsMainServiceGrpc.class) {
        if ((getDumpMethod = DidaMeetingsMainServiceGrpc.getDumpMethod) == null) {
          DidaMeetingsMainServiceGrpc.getDumpMethod = getDumpMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsMain.DumpRequest, didameetings.DidaMeetingsMain.DumpReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.DumpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsMain.DumpReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsMainServiceMethodDescriptorSupplier("dump"))
              .build();
        }
      }
    }
    return getDumpMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DidaMeetingsMainServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMainServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMainServiceStub>() {
        @java.lang.Override
        public DidaMeetingsMainServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsMainServiceStub(channel, callOptions);
        }
      };
    return DidaMeetingsMainServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DidaMeetingsMainServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMainServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMainServiceBlockingStub>() {
        @java.lang.Override
        public DidaMeetingsMainServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsMainServiceBlockingStub(channel, callOptions);
        }
      };
    return DidaMeetingsMainServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DidaMeetingsMainServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMainServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsMainServiceFutureStub>() {
        @java.lang.Override
        public DidaMeetingsMainServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsMainServiceFutureStub(channel, callOptions);
        }
      };
    return DidaMeetingsMainServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DidaMeetingsMainServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void open(didameetings.DidaMeetingsMain.OpenRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.OpenReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenMethod(), responseObserver);
    }

    /**
     */
    public void add(didameetings.DidaMeetingsMain.AddRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.AddReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public void topic(didameetings.DidaMeetingsMain.TopicRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.TopicReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTopicMethod(), responseObserver);
    }

    /**
     */
    public void close(didameetings.DidaMeetingsMain.CloseRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.CloseReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseMethod(), responseObserver);
    }

    /**
     */
    public void dump(didameetings.DidaMeetingsMain.DumpRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.DumpReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDumpMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOpenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMain.OpenRequest,
                didameetings.DidaMeetingsMain.OpenReply>(
                  this, METHODID_OPEN)))
          .addMethod(
            getAddMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMain.AddRequest,
                didameetings.DidaMeetingsMain.AddReply>(
                  this, METHODID_ADD)))
          .addMethod(
            getTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMain.TopicRequest,
                didameetings.DidaMeetingsMain.TopicReply>(
                  this, METHODID_TOPIC)))
          .addMethod(
            getCloseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMain.CloseRequest,
                didameetings.DidaMeetingsMain.CloseReply>(
                  this, METHODID_CLOSE)))
          .addMethod(
            getDumpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsMain.DumpRequest,
                didameetings.DidaMeetingsMain.DumpReply>(
                  this, METHODID_DUMP)))
          .build();
    }
  }

  /**
   */
  public static final class DidaMeetingsMainServiceStub extends io.grpc.stub.AbstractAsyncStub<DidaMeetingsMainServiceStub> {
    private DidaMeetingsMainServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsMainServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsMainServiceStub(channel, callOptions);
    }

    /**
     */
    public void open(didameetings.DidaMeetingsMain.OpenRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.OpenReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void add(didameetings.DidaMeetingsMain.AddRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.AddReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void topic(didameetings.DidaMeetingsMain.TopicRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.TopicReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTopicMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void close(didameetings.DidaMeetingsMain.CloseRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.CloseReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dump(didameetings.DidaMeetingsMain.DumpRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.DumpReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDumpMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DidaMeetingsMainServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DidaMeetingsMainServiceBlockingStub> {
    private DidaMeetingsMainServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsMainServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsMainServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public didameetings.DidaMeetingsMain.OpenReply open(didameetings.DidaMeetingsMain.OpenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsMain.AddReply add(didameetings.DidaMeetingsMain.AddRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsMain.TopicReply topic(didameetings.DidaMeetingsMain.TopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTopicMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsMain.CloseReply close(didameetings.DidaMeetingsMain.CloseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsMain.DumpReply dump(didameetings.DidaMeetingsMain.DumpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDumpMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DidaMeetingsMainServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DidaMeetingsMainServiceFutureStub> {
    private DidaMeetingsMainServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsMainServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsMainServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMain.OpenReply> open(
        didameetings.DidaMeetingsMain.OpenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMain.AddReply> add(
        didameetings.DidaMeetingsMain.AddRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMain.TopicReply> topic(
        didameetings.DidaMeetingsMain.TopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTopicMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMain.CloseReply> close(
        didameetings.DidaMeetingsMain.CloseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsMain.DumpReply> dump(
        didameetings.DidaMeetingsMain.DumpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDumpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPEN = 0;
  private static final int METHODID_ADD = 1;
  private static final int METHODID_TOPIC = 2;
  private static final int METHODID_CLOSE = 3;
  private static final int METHODID_DUMP = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DidaMeetingsMainServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DidaMeetingsMainServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPEN:
          serviceImpl.open((didameetings.DidaMeetingsMain.OpenRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.OpenReply>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((didameetings.DidaMeetingsMain.AddRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.AddReply>) responseObserver);
          break;
        case METHODID_TOPIC:
          serviceImpl.topic((didameetings.DidaMeetingsMain.TopicRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.TopicReply>) responseObserver);
          break;
        case METHODID_CLOSE:
          serviceImpl.close((didameetings.DidaMeetingsMain.CloseRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.CloseReply>) responseObserver);
          break;
        case METHODID_DUMP:
          serviceImpl.dump((didameetings.DidaMeetingsMain.DumpRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsMain.DumpReply>) responseObserver);
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

  private static abstract class DidaMeetingsMainServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DidaMeetingsMainServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return didameetings.DidaMeetingsMain.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DidaMeetingsMainService");
    }
  }

  private static final class DidaMeetingsMainServiceFileDescriptorSupplier
      extends DidaMeetingsMainServiceBaseDescriptorSupplier {
    DidaMeetingsMainServiceFileDescriptorSupplier() {}
  }

  private static final class DidaMeetingsMainServiceMethodDescriptorSupplier
      extends DidaMeetingsMainServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DidaMeetingsMainServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DidaMeetingsMainServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DidaMeetingsMainServiceFileDescriptorSupplier())
              .addMethod(getOpenMethod())
              .addMethod(getAddMethod())
              .addMethod(getTopicMethod())
              .addMethod(getCloseMethod())
              .addMethod(getDumpMethod())
              .build();
        }
      }
    }
    return result;
  }
}
