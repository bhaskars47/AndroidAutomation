package com.android.utils;

import com.android.base.BaseTest;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class PageSourceExtractor extends BaseTest {

    @Test
    public void dumpPageSource() {
        try {
            System.out.println("Wait for app to settle...");
            Thread.sleep(8000); // 8 seconds to allow full render

            String source = driver.getPageSource();

            try (FileWriter file = new FileWriter("app_source.xml")) {
                file.write(source);
                System.out.println("Page source successfully dumped to app_source.xml");
            } catch (IOException e) {
                System.out.println("Failed to write to file: " + e.getMessage());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
