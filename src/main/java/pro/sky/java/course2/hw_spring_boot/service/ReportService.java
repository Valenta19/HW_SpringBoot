package pro.sky.java.course2.hw_spring_boot.service;

import pro.sky.java.course2.hw_spring_boot.pojo.Report;

import java.io.IOException;
import java.util.Optional;

public interface ReportService {

    Integer createReport() throws IOException;
    Optional<Report> getReportById(int id);
}
