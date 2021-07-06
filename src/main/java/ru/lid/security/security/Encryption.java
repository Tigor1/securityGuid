package ru.lid.security.security;


import lombok.Data;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

//@Data
//public final class Encryption {
//
//    public static PublicKey getPublicKey(Path pathPublicKey) {
//        try {
//            var keyBytes = Files.readAllBytes(pathPublicKey);
//            var spec = new X509EncodedKeySpec(keyBytes);
//            return ;
//        } catch (IOException ioEx) {
//            throw new RuntimeException("Error loading public key", ioEx);
//        }
//    }
//}
