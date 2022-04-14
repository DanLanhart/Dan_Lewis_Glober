package com.dan_lewis_glober.repository;

import com.dan_lewis_glober.model.BugReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugReportRepository extends JpaRepository<BugReport, Long> {
}
