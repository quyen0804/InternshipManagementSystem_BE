package com.ims.internship_management_system.util.generator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdGenerator {

    public static String generateAuditResultId(String internId) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"))+internId;
    }

    public static String generateAuditInternId(String internId) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))+internId;
    }

    public static String generateAuditId(String mentorId) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))+mentorId;
    }

    public static String generateFeedbackId(String resultId) {
        return resultId+"F";
    }
}

