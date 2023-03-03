package org.example;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.example.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Schema schema=ReflectData.get().getSchema(Student.class);
        System.out.println(schema.toString());
        File schemaFile=new File("src/main/resources/student-detail.avsc");
        if(!schemaFile.exists())
            schemaFile.createNewFile();
        FileWriter writer=new FileWriter(schemaFile);
        writer.append(schema.toString(true));
        writer.close();
    }
}