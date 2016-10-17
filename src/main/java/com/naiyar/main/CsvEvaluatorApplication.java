package com.naiyar.main;

import com.naiyar.processor.InputProcessor;
import com.naiyar.factory.InputArgProcessorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vikasnaiyar on 17/10/16.
 *
 * Main class to start the process
 */
@SpringBootApplication
@Slf4j
public class CsvEvaluatorApplication implements CommandLineRunner{

   public static void main(String[] args) {
       SpringApplication.run(CsvEvaluatorApplication.class,args);
    }

    /**
     * Read passed arguments
     * @param args
     */
    @Override
    public void run(String... args) {
        log.info("Executing program with args {}", args.length);
        if (args.length > 0) {
            for (String arg: args) {
                log.info("Printing args {} program with args", arg);
                // Using a combination of factory + strategy processor to get processor which will process this args
                InputProcessor processor = InputArgProcessorFactory.getInputProcessor(arg);
                if(processor != null) {
                    log.info("Get input processor {}" , processor);
                    // Give data to processor to process
                    processor.process(arg);
                } else {
                    log.error("Not input processor found for input arg = {}", arg);
                }
            }
        } else {
            log.info("No argument found for program");
        }
    }

}
