package fil.iagl.opl.colombo;

import java.io.IOException;

public class Colombo {

    private static void usage() {
        System.err.println("java -jar colombo.jar challengeClassPath");
        System.err.println("\tArguments:");
        System.err.println("\t\tchallengeClassPath: the path to the Java class representing a challenge");
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            usage();
            return;
        }
        final String challengeClassPath = args[0];
    }

}
