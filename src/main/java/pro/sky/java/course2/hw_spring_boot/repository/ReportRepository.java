package pro.sky.java.course2.hw_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.java.course2.hw_spring_boot.dto.ReportDTO;
import pro.sky.java.course2.hw_spring_boot.pojo.Report;

import java.util.List;


public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query(value = "SELECT new pro.sky.java.course2.hw_spring_boot.dto.ReportDTO(p.name, count(e.id), max(e.salary), min(e.salary), avg(e.salary)) " +
            "FROM Employee e left join Position p on p.id = e.position.id GROUP BY p.id")
     List<ReportDTO> createReport();
}
