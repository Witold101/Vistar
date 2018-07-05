package com.witold.vistar.contract.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Contract {

    public static void getContractWord(String path,Contract contract) throws IOException {

        File file = new File(path);
        FileOutputStream fos;
        fos = new FileOutputStream(file);


        fos.close();
    }
}
