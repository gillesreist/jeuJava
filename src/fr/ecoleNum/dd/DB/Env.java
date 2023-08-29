package fr.ecoleNum.dd.DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Env {

    private static Properties env;

    private Env() {
        try {
            env = new Properties();
            env.load(new FileInputStream(".env"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Properties getEnv() {
        if (env == null) {
            new Env();
        }
        return env;
    }



}
