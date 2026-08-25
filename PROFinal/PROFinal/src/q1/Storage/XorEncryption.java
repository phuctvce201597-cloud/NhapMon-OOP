package q1.Storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class XorEncryption {

    private static final byte KEY = 0x5A;

    /**
     *
     * @param filePath
     * @param data
     * @throws IOException
     */
    public static void writeEncrypted(String filePath, String data) throws IOException {
        byte[] rawBytes = data.getBytes("UTF-8");
        byte[] encrypted = new byte[rawBytes.length];
        for (int i = 0; i < rawBytes.length; i++) {
            encrypted[i] = (byte) (rawBytes[i] ^ KEY);
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(encrypted);
        }
    }

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readDecrypted(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
            byte[] chunk = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(chunk)) != -1) {
                buffer.write(chunk, 0, bytesRead);
            }
            byte[] encrypted = buffer.toByteArray();
            byte[] decrypted = new byte[encrypted.length];
            for (int i = 0; i < encrypted.length; i++) {
                decrypted[i] = (byte) (encrypted[i] ^ KEY);
            }
            return new String(decrypted, "UTF-8");
        }
    }
}
