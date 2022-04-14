package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.BugReport;

import java.util.List;

public interface BugReportService {

    List<BugReport> getAllBugReports();

    void saveBugReport(BugReport bugReport);

    void deleteBugReportById(long id);
}
