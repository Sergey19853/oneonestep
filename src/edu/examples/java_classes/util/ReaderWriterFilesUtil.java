package edu.examples.java_classes.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderWriterFilesUtil {
	
    public static void export(List<String> medicine) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/medicines.txt"))){
            for(String med: medicine){
                writer.write(med);
            }       	
        }
 
    }

    public static List<String> importMedicines() throws IOException {
    	
        List<String> medicines = new ArrayList<>();
        Stream<String> medicinesStream = Files.lines(Paths.get("resources/medicines.txt"));
        medicines =  medicinesStream.collect(Collectors.toList());
        return medicines;
        
    }
}
