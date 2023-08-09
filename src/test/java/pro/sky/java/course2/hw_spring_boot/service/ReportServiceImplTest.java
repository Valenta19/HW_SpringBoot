package pro.sky.java.course2.hw_spring_boot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.hw_spring_boot.pojo.Report;
import pro.sky.java.course2.hw_spring_boot.repository.ReportRepository;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {

    @Mock
    private ReportRepository mockReportRepository;

    @InjectMocks
    private ReportServiceImpl mockReportServiceImpl;

    private final static List<Report> listReport = List.of(new Report(1, "report.json"),
            new Report(2, "report.json"),
            new Report(3, "report.json"),
            new Report(4, "report.json"));


    @Test
    public void shouldCreateReport() throws IOException {

        mockReportServiceImpl.createReport();
        verify(mockReportRepository,times(1)).createReport();
    }

    @Test
    public void shouldReturnReportById() {
        Integer id = 1;
        Optional<Report> report = listReport.stream()
                .filter(report1 -> Objects.equals(report1.getId(), id))
                .findFirst();
        Assertions.assertTrue(report.isPresent());
    }




}
