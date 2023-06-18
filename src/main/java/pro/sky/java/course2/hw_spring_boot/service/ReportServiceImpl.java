package pro.sky.java.course2.hw_spring_boot.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw_spring_boot.pojo.Report;
import pro.sky.java.course2.hw_spring_boot.repository.EmployeeRepository;
import pro.sky.java.course2.hw_spring_boot.repository.ReportRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final EmployeeService employeeService;


    public ReportServiceImpl(ReportRepository reportRepository, EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.reportRepository = reportRepository;
        this.employeeService = employeeService;

    }

    @Override
    public Integer createReport() throws IOException {
        File file = new File("Report.json");
        String s = reportRepository.createReport().toString();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getName());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(s);
        }
        Report report = new Report();
        report.setFile(file.getPath());
        reportRepository.save(report);
        return report.getId();
    }
    @Override
    public Optional<Report> getReportById(int id) {
        return reportRepository.findById(id);
    }


}