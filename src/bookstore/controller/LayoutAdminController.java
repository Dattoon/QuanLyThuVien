package bookstore.controller;

import java.sql.SQLException;
import bookstore.repository.ReportRepository;

public class LayoutAdminController {

    private ReportRepository reportRepository;

    public LayoutAdminController() {
        this.reportRepository = new ReportRepository();
    }

    public int getCountBooksBorrowed() {
        try {
            return reportRepository.countBooksBorrowed();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getCountOverdueBooks() {
        try {
            return reportRepository.countOverdueBooks();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getCountRegisteredReaders() {
        try {
            return reportRepository.countRegisteredReaders();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
