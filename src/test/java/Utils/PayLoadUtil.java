package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class PayLoadUtil {

    public static String getPetPayload(int id, String name, String status) {
        return "{\\n\" +\n" +
                "                \"  \\\"id\\\": 0,\\n\" +\n" +
                "                \"  \\\"category\\\": {\\n\" +\n" +
                "                \"    \\\"id\\\": " + id + ",\\n\" +\n" +
                "                \"    \\\"name\\\": \\\"string\\\"\\n\" +\n" +
                "                \"  },\\n\" +\n" +
                "                \"  \\\"name\\\": \\\"" + name + "\\\",\\n\" +\n" +
                "                \"  \\\"photoUrls\\\": [\\n\" +\n" +
                "                \"    \\\"string\\\"\\n\" +\n" +
                "                \"  ],\\n\" +\n" +
                "                \"  \\\"tags\\\": [\\n\" +\n" +
                "                \"    {\\n\" +\n" +
                "                \"      \\\"id\\\": 0,\\n\" +\n" +
                "                \"      \\\"name\\\": \\\"string\\\"\\n\" +\n" +
                "                \"    }\\n\" +\n" +
                "                \"  ],\\n\" +\n" +
                "                \"  \\\"status\\\": \\\"" + status + "\\\"\\n\" +\n" +
                "                \"}";
    }


    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(117 - 1) + 1;
    }


}
