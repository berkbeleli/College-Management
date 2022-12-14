package main_components.batch;

import java.util.List;

import dao.BatchDao;
import dao.BatchDaoImpl;
import exception.BatchException;
import style.Style;
import model.Report;

public class GenerateReport {


    public static void viewAllBatch() {

        BatchDao dao = new BatchDaoImpl();

        try {
            List<Report> batches = dao.generateReport();

            System.out.println();
            System.out.println(Style.ORANGE+"-------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%13s %8s %6s %10s %10s %10s %10s %10s", " BATCH ID |", "COURSE ID |", "FACULTY NAME |", "No. Of Students |", "Starting Date |", "Duration |", "DAY PLANNED |", "DAY COMPLETED |");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------");

            batches.forEach( b -> {
                System.out.printf("%12s %8s %12s %15s %20s %11s %10s %12s", b.getBatchId(), b.getCourseId(), b.getFacultyFname(), b.getNoOfStudents(), b.getBatchstartDate(), b.getDuration(), b.getPlanned(), b.getCompleted());
                System.out.println();

            });
            System.out.println(Style.RESET);

        } catch (BatchException e) {

            System.out.println();
            System.out.println(Style.RED_BACKGROUND+e.getMessage()+Style.RESET);
            System.out.println();
        }

    }

}
