package main_components.faculty;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.FacultyDao;
import dao.FacultyDaoImpl;
import exception.FacultyException;
import style.Style;

public class UpdateFaculty {


    public static void UpdateById(int id) {

        try {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            boolean flag = true;
            boolean flag2 = true;

            while(flag) {

                String str = "";


                while(true) {

                    System.out.println(Style.CYAN+"What do you want to update?");
                    System.out.println("1. First Name");
                    System.out.println("2. Last Name");
                    System.out.println("3. Address");
                    System.out.println("4. State");
                    System.out.println("5. Pin");
                    System.out.println("6. Mobile");
                    System.out.println("7. Email");
                    System.out.println("8. Back");
                    System.out.println("9. Close" +Style.RESET);

                    int ch = sc.nextInt();

                    if(ch == 8) {
                        flag = false;
                        flag2 = false;
                        break;

                    }else if(ch== 9) {
                        System.out.println(Style.BANANA_YELLOW+"See You Soon..."+Style.RESET);
                        System.exit(0);
                    }

                    if(ch == 1) {
                        str = "facultyFname";
                        break;
                    }else if(ch == 2) {
                        str = "facultyLname";
                        break;
                    }else if(ch == 3) {
                        str = "facultyAddress";
                        break;
                    }else if(ch == 4) {
                        str = "facultyState";
                        break;
                    }else if(ch == 5) {
                        str = "facultyPin";
                        break;
                    }else if(ch == 6) {
                        str = "mobile";
                        break;
                    }else if(ch == 7) {
                        str = "email";
                        break;
                    }
                    else {
                        System.out.println(Style.RED+"Wrong Input Try Again"+Style.RESET);
                    }
                }

                if(flag2) {
                    sc.nextLine();
                    System.out.println("Enter New Entry :");
                    String set = sc.nextLine();

                    FacultyDao dao = new FacultyDaoImpl();

                    String result;
                    try {
                        result = dao.updateFacultyDetails(str, set, id);
                        System.out.println();
                        System.out.println(result);
                        System.out.println();

                    } catch (FacultyException e) {
                        System.out.println();
                        System.out.println(Style.RED_BACKGROUND+ e.getMessage()+Style.RESET);
                        System.out.println();
                    }

                }


                while(flag2) {
                    System.out.println(Style.CYAN+"Want to update anything else?(y/n)"+Style.RESET);
                    String choice = sc.next();

                    if(choice.equalsIgnoreCase("y")) {
                        break;
                    }else if(choice.equalsIgnoreCase("n")){
                        flag = false;
                        break;
                    }else {
                        System.out.println();
                        System.out.println(Style.RED+"Wrong Input...!"+Style.RESET);
                        System.out.println();
                    }
                }
            }

        }catch(InputMismatchException e) {
            System.out.println();
            System.out.println(Style.RED+"Wrong Input Try Again!"+Style.RESET);
            System.out.println();
            UpdateById(id);
        }

    }

}
