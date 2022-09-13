package br.com.fergulha.util;

public class JWTGenerator {

    public static void main(String[] args) {
        String header = "{ \"alg\": \"HS256\" }";

        String payload = "{ \"fergulha:name\": \"your name\", \"fergulha:admin\": true }";

        // jwt = "header.payload.assinatura";
        String encodedData = Base64Url.encode(header) + "." + Base64Url.encode(payload);
        String secret = "anything";

        String signature = HmacSha256.sign(secret, encodedData);

        String jwt = encodedData + "." + signature;

        System.out.println(jwt);
    }
}
