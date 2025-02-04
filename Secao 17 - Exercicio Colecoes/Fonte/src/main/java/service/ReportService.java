package service;

import java.util.Map;

public class ReportService {
    public static void printReport(String title, Map<String, Double> data) {
        System.out.println("\n===== " + title + " =====");
        System.out.println(data.keySet());
        System.out.println(data.values());
    }
}