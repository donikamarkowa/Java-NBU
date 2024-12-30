package org.example.utils;

import org.example.items.Item;

import java.io.*;

public class ItemUtil {
    public static void serializeItem(String filePath, Item item)
        throws IOException{
        try(FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos)){
            outputStream.writeObject(item);
        }
    }

    public static Item deserializeItem(String filePath)
        throws  IOException, ClassNotFoundException{
        try(FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fis)){
            return(Item) inputStream.readObject();
        }
    }
}
