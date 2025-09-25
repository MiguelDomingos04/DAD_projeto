package didameetings;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: DidaMeetingsPaxos.proto")
public final class DidaMeetingsPaxosServiceGrpc {

  private DidaMeetingsPaxosServiceGrpc() {}

  public static final String SERVICE_NAME = "didameetings.DidaMeetingsPaxosService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.PhaseOneRequest,
      didameetings.DidaMeetingsPaxos.PhaseOneReply> getPhaseoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "phaseone",
      requestType = didameetings.DidaMeetingsPaxos.PhaseOneRequest.class,
      responseType = didameetings.DidaMeetingsPaxos.PhaseOneReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.PhaseOneRequest,
      didameetings.DidaMeetingsPaxos.PhaseOneReply> getPhaseoneMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.PhaseOneRequest, didameetings.DidaMeetingsPaxos.PhaseOneReply> getPhaseoneMethod;
    if ((getPhaseoneMethod = DidaMeetingsPaxosServiceGrpc.getPhaseoneMethod) == null) {
      synchronized (DidaMeetingsPaxosServiceGrpc.class) {
        if ((getPhaseoneMethod = DidaMeetingsPaxosServiceGrpc.getPhaseoneMethod) == null) {
          DidaMeetingsPaxosServiceGrpc.getPhaseoneMethod = getPhaseoneMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsPaxos.PhaseOneRequest, didameetings.DidaMeetingsPaxos.PhaseOneReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "phaseone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsPaxos.PhaseOneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsPaxos.PhaseOneReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsPaxosServiceMethodDescriptorSupplier("phaseone"))
              .build();
        }
      }
    }
    return getPhaseoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.PhaseTwoRequest,
      didameetings.DidaMeetingsPaxos.PhaseTwoReply> getPhasetwoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "phasetwo",
      requestType = didameetings.DidaMeetingsPaxos.PhaseTwoRequest.class,
      responseType = didameetings.DidaMeetingsPaxos.PhaseTwoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.PhaseTwoRequest,
      didameetings.DidaMeetingsPaxos.PhaseTwoReply> getPhasetwoMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.PhaseTwoRequest, didameetings.DidaMeetingsPaxos.PhaseTwoReply> getPhasetwoMethod;
    if ((getPhasetwoMethod = DidaMeetingsPaxosServiceGrpc.getPhasetwoMethod) == null) {
      synchronized (DidaMeetingsPaxosServiceGrpc.class) {
        if ((getPhasetwoMethod = DidaMeetingsPaxosServiceGrpc.getPhasetwoMethod) == null) {
          DidaMeetingsPaxosServiceGrpc.getPhasetwoMethod = getPhasetwoMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsPaxos.PhaseTwoRequest, didameetings.DidaMeetingsPaxos.PhaseTwoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "phasetwo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsPaxos.PhaseTwoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsPaxos.PhaseTwoReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsPaxosServiceMethodDescriptorSupplier("phasetwo"))
              .build();
        }
      }
    }
    return getPhasetwoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.LearnRequest,
      didameetings.DidaMeetingsPaxos.LearnReply> getLearnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "learn",
      requestType = didameetings.DidaMeetingsPaxos.LearnRequest.class,
      responseType = didameetings.DidaMeetingsPaxos.LearnReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.LearnRequest,
      didameetings.DidaMeetingsPaxos.LearnReply> getLearnMethod() {
    io.grpc.MethodDescriptor<didameetings.DidaMeetingsPaxos.LearnRequest, didameetings.DidaMeetingsPaxos.LearnReply> getLearnMethod;
    if ((getLearnMethod = DidaMeetingsPaxosServiceGrpc.getLearnMethod) == null) {
      synchronized (DidaMeetingsPaxosServiceGrpc.class) {
        if ((getLearnMethod = DidaMeetingsPaxosServiceGrpc.getLearnMethod) == null) {
          DidaMeetingsPaxosServiceGrpc.getLearnMethod = getLearnMethod =
              io.grpc.MethodDescriptor.<didameetings.DidaMeetingsPaxos.LearnRequest, didameetings.DidaMeetingsPaxos.LearnReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "learn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsPaxos.LearnRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  didameetings.DidaMeetingsPaxos.LearnReply.getDefaultInstance()))
              .setSchemaDescriptor(new DidaMeetingsPaxosServiceMethodDescriptorSupplier("learn"))
              .build();
        }
      }
    }
    return getLearnMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DidaMeetingsPaxosServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsPaxosServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsPaxosServiceStub>() {
        @java.lang.Override
        public DidaMeetingsPaxosServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsPaxosServiceStub(channel, callOptions);
        }
      };
    return DidaMeetingsPaxosServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DidaMeetingsPaxosServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsPaxosServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsPaxosServiceBlockingStub>() {
        @java.lang.Override
        public DidaMeetingsPaxosServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsPaxosServiceBlockingStub(channel, callOptions);
        }
      };
    return DidaMeetingsPaxosServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DidaMeetingsPaxosServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsPaxosServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DidaMeetingsPaxosServiceFutureStub>() {
        @java.lang.Override
        public DidaMeetingsPaxosServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DidaMeetingsPaxosServiceFutureStub(channel, callOptions);
        }
      };
    return DidaMeetingsPaxosServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DidaMeetingsPaxosServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void phaseone(didameetings.DidaMeetingsPaxos.PhaseOneRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.PhaseOneReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPhaseoneMethod(), responseObserver);
    }

    /**
     */
    public void phasetwo(didameetings.DidaMeetingsPaxos.PhaseTwoRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.PhaseTwoReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPhasetwoMethod(), responseObserver);
    }

    /**
     */
    public void learn(didameetings.DidaMeetingsPaxos.LearnRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.LearnReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLearnMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPhaseoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsPaxos.PhaseOneRequest,
                didameetings.DidaMeetingsPaxos.PhaseOneReply>(
                  this, METHODID_PHASEONE)))
          .addMethod(
            getPhasetwoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsPaxos.PhaseTwoRequest,
                didameetings.DidaMeetingsPaxos.PhaseTwoReply>(
                  this, METHODID_PHASETWO)))
          .addMethod(
            getLearnMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                didameetings.DidaMeetingsPaxos.LearnRequest,
                didameetings.DidaMeetingsPaxos.LearnReply>(
                  this, METHODID_LEARN)))
          .build();
    }
  }

  /**
   */
  public static final class DidaMeetingsPaxosServiceStub extends io.grpc.stub.AbstractAsyncStub<DidaMeetingsPaxosServiceStub> {
    private DidaMeetingsPaxosServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsPaxosServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsPaxosServiceStub(channel, callOptions);
    }

    /**
     */
    public void phaseone(didameetings.DidaMeetingsPaxos.PhaseOneRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.PhaseOneReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPhaseoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void phasetwo(didameetings.DidaMeetingsPaxos.PhaseTwoRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.PhaseTwoReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPhasetwoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void learn(didameetings.DidaMeetingsPaxos.LearnRequest request,
        io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.LearnReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLearnMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DidaMeetingsPaxosServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DidaMeetingsPaxosServiceBlockingStub> {
    private DidaMeetingsPaxosServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsPaxosServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsPaxosServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public didameetings.DidaMeetingsPaxos.PhaseOneReply phaseone(didameetings.DidaMeetingsPaxos.PhaseOneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPhaseoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsPaxos.PhaseTwoReply phasetwo(didameetings.DidaMeetingsPaxos.PhaseTwoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPhasetwoMethod(), getCallOptions(), request);
    }

    /**
     */
    public didameetings.DidaMeetingsPaxos.LearnReply learn(didameetings.DidaMeetingsPaxos.LearnRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLearnMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DidaMeetingsPaxosServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DidaMeetingsPaxosServiceFutureStub> {
    private DidaMeetingsPaxosServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DidaMeetingsPaxosServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DidaMeetingsPaxosServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsPaxos.PhaseOneReply> phaseone(
        didameetings.DidaMeetingsPaxos.PhaseOneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPhaseoneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsPaxos.PhaseTwoReply> phasetwo(
        didameetings.DidaMeetingsPaxos.PhaseTwoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPhasetwoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<didameetings.DidaMeetingsPaxos.LearnReply> learn(
        didameetings.DidaMeetingsPaxos.LearnRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLearnMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PHASEONE = 0;
  private static final int METHODID_PHASETWO = 1;
  private static final int METHODID_LEARN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DidaMeetingsPaxosServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DidaMeetingsPaxosServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PHASEONE:
          serviceImpl.phaseone((didameetings.DidaMeetingsPaxos.PhaseOneRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.PhaseOneReply>) responseObserver);
          break;
        case METHODID_PHASETWO:
          serviceImpl.phasetwo((didameetings.DidaMeetingsPaxos.PhaseTwoRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.PhaseTwoReply>) responseObserver);
          break;
        case METHODID_LEARN:
          serviceImpl.learn((didameetings.DidaMeetingsPaxos.LearnRequest) request,
              (io.grpc.stub.StreamObserver<didameetings.DidaMeetingsPaxos.LearnReply>) responseObserver);
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

  private static abstract class DidaMeetingsPaxosServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DidaMeetingsPaxosServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return didameetings.DidaMeetingsPaxos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DidaMeetingsPaxosService");
    }
  }

  private static final class DidaMeetingsPaxosServiceFileDescriptorSupplier
      extends DidaMeetingsPaxosServiceBaseDescriptorSupplier {
    DidaMeetingsPaxosServiceFileDescriptorSupplier() {}
  }

  private static final class DidaMeetingsPaxosServiceMethodDescriptorSupplier
      extends DidaMeetingsPaxosServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DidaMeetingsPaxosServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DidaMeetingsPaxosServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DidaMeetingsPaxosServiceFileDescriptorSupplier())
              .addMethod(getPhaseoneMethod())
              .addMethod(getPhasetwoMethod())
              .addMethod(getLearnMethod())
              .build();
        }
      }
    }
    return result;
  }
}
