package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        ReportRenderer reportRenderer = new ReportRenderer(1, true, false, "Random report", "report_1");
        reportRenderer.writeHeader(Arrays.asList("#", "Random number"));
        for (int i = 1; i <= 100; i++) {
            reportRenderer.writeRow(Arrays.asList(String.valueOf(i), String.valueOf(rnd.nextInt())));
        }
        reportRenderer.finish();
    }
}
