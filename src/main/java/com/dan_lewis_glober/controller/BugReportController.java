package com.dan_lewis_glober.controller;

import com.dan_lewis_glober.model.BugReport;
import com.dan_lewis_glober.service.BugReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BugReportController {

    @Autowired
    private BugReportService bugReportService;

    // display list of reported bugs
    @RequestMapping("/view_bugs_page")
    public String viewBugReports(Model model) {
        model.addAttribute("listBugReports", bugReportService.getAllBugReports());
        return "view_bugs_page";
    }

    @GetMapping("/showBugReportForm")
    public String showBugReportForm(Model model)   {
        // create model attribute to bind from data
        BugReport bugReport = new BugReport();
        model.addAttribute("bugReport", bugReport);
        return "report_a_bug_page";
    }

    @PostMapping("/saveBugReport")
    public String saveBugReport(@ModelAttribute("bugReport") BugReport bugReport) {
        // save bug report to database
        bugReportService.saveBugReport(bugReport);
        return "redirect:/";
    }

    @GetMapping("/deleteBugReport/{id}")
    public String deletePlayer(@PathVariable(value="id") long id)  {
        // call delete player method
        this.bugReportService.deleteBugReportById(id);
        return "redirect:/";
    }
}
