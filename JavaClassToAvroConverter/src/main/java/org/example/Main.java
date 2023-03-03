package org.example;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.example.model.LoanDetailPojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Schema schema=ReflectData.get().getSchema(LoanDetailPojo.class);
        File fileSchema=new File("src/main/resources/loan-detail.avsc");
        if(!fileSchema.exists())
        {
            fileSchema.createNewFile();
        }
        FileWriter writer=new FileWriter(fileSchema);
        writer.append(schema.toString(true));
        writer.close();
        System.out.println("Hello world!");
    }
}