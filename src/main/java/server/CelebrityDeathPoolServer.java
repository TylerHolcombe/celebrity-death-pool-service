package server;

import cdp.CelebrityDeathPoolGrpc.CelebrityDeathPoolImplBase;
import cdp.GetPlayersRequest;
import cdp.GetPlayersResponse;
import cdp.Player;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CelebrityDeathPoolServer {
    private static final Logger logger = Logger.getLogger(CelebrityDeathPoolServer.class.getName());
    private static final int port = 8080;

    private Server server;

    // TODO: move to separate file
    public static void main(String[] args) throws IOException, InterruptedException {
        final CelebrityDeathPoolServer server = new CelebrityDeathPoolServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        logger.info("Starting server...");
        server = ServerBuilder
                .forPort(port)
                .addService(new CelebrityDeathPoolImpl())
                .build()
                .start();
        logger.info("Server started, listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Using System.err since the logger may have been reset.
                System.err.println("*** JVM is shutting down. Shutting down gRPC server.");
                try {
                    CelebrityDeathPoolServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shutdown complete");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    static class CelebrityDeathPoolImpl extends CelebrityDeathPoolImplBase {
        @Override
        public void getPlayers(GetPlayersRequest request, StreamObserver<GetPlayersResponse> responseObserver) {
            // TODO: make db call here
            GetPlayersResponse response = GetPlayersResponse.newBuilder()
                    .addPlayers(
                            Player.newBuilder()
                                    .setFirstName("Tyler")
                                    .setLastName("Holcombe")
                                    .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
