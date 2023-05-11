package org.example.utils;

import org.example.items.Participant;

import java.io.*;

public class ParticipantUtil {
    public static void serializeParticipant(String filePath, Participant participant) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(participant);
        }
    }
    public static Participant deserializeItem(String filePath)
            throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {
            return (Participant) inputStream.readObject();
        }
    }

}
