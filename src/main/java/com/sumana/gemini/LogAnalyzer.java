package com.sumana.gemini;

import java.util.*;
import java.util.stream.Collectors;

class LogEntry {
    String serviceId;
    long timestamp; // Unix epoch seconds

    public LogEntry(String serviceId, long timestamp) {
        this.serviceId = serviceId;
        this.timestamp = timestamp;
    }

    // Getters
    public String getServiceId() { return serviceId; }
    public long getTimestamp() { return timestamp; }
}

public class LogAnalyzer {
    public static Set<String> findErrorSpikes(List<LogEntry> logs) {
        Set<String> serviceIds = new HashSet<>();

        Map<String, List<LogEntry>> logsMap = logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getServiceId));

        logsMap.forEach((s, logEntries) -> {
            var orderedEntries = logEntries.stream()
                    .sorted(Comparator.comparingLong(LogEntry::getTimestamp))
                    .toList();

            var windowSize = 3;
            var logPeriod = 60;

            var currentSum = orderedEntries.get(windowSize - 1).getTimestamp() - orderedEntries.get(0).getTimestamp();

            if (currentSum < logPeriod) {
                serviceIds.add(logEntries.get(0).getServiceId());
            }

            for (var i = windowSize; i < orderedEntries.size(); i++) {
                if (currentSum < logPeriod) {
                    serviceIds.add(logEntries.get(i).getServiceId());
                } else {
                    currentSum -= orderedEntries.get(i).getTimestamp() + orderedEntries.get(i - windowSize).getTimestamp();
                }
            }
        });

        return serviceIds;
    }

    public static void main(String[] args) {
        List<LogEntry> logs = List.of(
                new LogEntry("service-B", 2000),
                new LogEntry("service-B", 2015),
                new LogEntry("service-B", 2059) // 3 logs within 59 seconds
        );

        System.out.println(findErrorSpikes(logs));
    }
}
