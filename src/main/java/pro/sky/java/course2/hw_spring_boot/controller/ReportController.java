package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.hw_spring_boot.service.ReportService;

import java.io.IOException;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping(value = "/")
    public Integer createReport() throws IOException {

        return reportService.createReport();
    }


    @GetMapping(value = "/report/{id}")
    public ResponseEntity<Resource> getReportById(@PathVariable int id) {

        String jsonFile = "Report.json";
        String json = String.valueOf(reportService.getReportById(id));
        Resource resource = new ByteArrayResource(json.getBytes());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + jsonFile + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}