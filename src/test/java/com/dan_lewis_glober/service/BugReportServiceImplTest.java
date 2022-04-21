package com.dan_lewis_glober.service;


import com.dan_lewis_glober.model.BugReport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BugReportServiceImplTest {

    @Autowired
    private BugReportService bugReportService;

    @Test
    @Transactional
    void getAllBugReports() {

        List<BugReport> allBugReports = bugReportService.getAllBugReports();
        int beforeSubmittingNewBugReport = allBugReports.size();

        Assertions.assertThat(beforeSubmittingNewBugReport).isEqualTo(0);

        BugReport report = new BugReport();
        report.setEmail("test@test.com");
        report.setBug_description("This is a test bug within the BugReportServiceImplTest class.");

        bugReportService.saveBugReport(report);
        int afterSubmittingNewBugReport = bugReportService.getAllBugReports().size();

        Assertions.assertThat(afterSubmittingNewBugReport).isEqualTo(beforeSubmittingNewBugReport + 1);
        Assertions.assertThat(allBugReports.contains(report));
    }
}
