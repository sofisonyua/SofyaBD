package by.bstu.project.ui;

import by.bstu.project.entity.*;
import by.bstu.project.file.PdfWrite;
import by.bstu.project.service.*;

import java.util.List;
import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private IRoomService roomService = new RoomServiceImpl();
    private IDoctorService doctorService = new DoctorServiceImpl();
    private IPatientService patientService = new PatientServiceImpl();
    private IRoomVOService roomVOService = new RoomVOServiceImpl();
    private PdfWrite pdfWrite = new PdfWrite();


    public void menu() throws Exception {
        printout();
        int item = inputInteger();

        while (item != 0) {

            switch (item) {

                case 1: {
                    scanner.nextLine();
                    System.out.println("Please, enter a firstname of doctor");
                    String firstname = inputString();
                    System.out.println("Please, enter a lastname of doctor");
                    String lastname = inputString();
                    System.out.println("Please, enter a specialization of doctor");
                    String specialization = inputString();
                    System.out.println("Please, enter age of doctor");
                    Integer age = inputInteger();

                    Doctor doctor = new Doctor();
                    doctor.setFirstName(firstname);
                    doctor.setLastName(lastname);
                    doctor.setSpecialization(specialization);
                    doctor.setAge(age);

                    if (doctorService.insert(doctor) == null)
                        System.out.println("Doctor is already in DataBase or Something goes wrong");
                    else System.out.println("Doctor was successfully added with id " + doctor.getId());
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 2: {
                    if (doctorService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Doctor> doctorsList = doctorService.getEntityList();
                        for (Doctor doctor : doctorsList)
                            System.out.println("Doctor:" + doctor.toString() + "\n");
                    }
                    scanner.nextLine();
                    System.out.println("Enter DoctorId of doctor to delete");
                    Integer Id = inputInteger();
                    Doctor doctorToDelete = new Doctor();
                    doctorToDelete.setId(Id);
                    if (doctorService.delete(doctorToDelete))
                        System.out.println("Doctor was successfully deleted");
                    else
                        System.out.println("There isn't bus in DataBase");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 3: {
                    if (doctorService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Doctor> docotrsList = doctorService.getEntityList();
                        for (Doctor doctor : docotrsList)
                            System.out.println("Doctor:" + doctor.toString() + "\n");
                    }
                    System.out.println("\nPlease, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 4: {
                    scanner.nextLine();
                    System.out.println("Please, enter a firstname of Employee");
                    String firstName = inputString();
                    System.out.println("Please, enter a lastName");
                    String surname = inputString();
                    System.out.println("Please, enter a position");
                    String position = inputString();
                    System.out.println("Please, enter age of employee");
                    Integer age = inputInteger();

                    Employee employee = new Employee();
                    employee.setFirstName(firstName);
                    employee.setLastName(surname);
                    employee.setPosition(position);
                    employee.setAge(age);

                    if (employeeService.insert(employee) == null)
                        System.out.println("Employee is already in DataBase");
                    else System.out.println("Employee was successfully added with id " + employee.getId());
                    System.out.println("Please, choose the next action");
                    item = inputInteger();

                    break;
                }

                case 5: {
                    if (employeeService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Employee> listOfEmployees = employeeService.getEntityList();
                        for (Employee employee : listOfEmployees)
                            System.out.println(employee.toString() + "\n");
                    }
                    scanner.nextLine();
                    System.out.println("Enter an employeeId to delete");
                    Integer Id = inputInteger();
                    Employee employee = new Employee();
                    employee.setId(Id);
                    if (employeeService.delete(employee))
                        System.out.println("Employee was successfully deleted");
                    else
                        System.out.println("There isn't bus in DataBase");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 6: {
                    if (employeeService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Employee> employeeList = employeeService.getEntityList();
                        for (Employee employee : employeeList)
                            System.out.println(employee.toString() + "\n");
                    }
                    System.out.println("\nPlease, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 7: {
                    scanner.nextLine();
                    System.out.println("Please, enter a firstname of Patient");
                    String firstName = inputString();
                    System.out.println("Please, enter a lastName of Patient");
                    String surname = inputString();
                    System.out.println("Please, enter a diagnosis");
                    String diagnosis = inputString();
                    System.out.println("Please, enter a therapy");
                    String therapy = inputString();

                    List<Doctor> doctorsList = doctorService.getEntityList();
                    for (Doctor doctor : doctorsList)
                        System.out.println("Doctor:" + doctor.toString() + "\n");

                    System.out.println("Enter doctor id of the patinet");
                    Integer doctorId = inputInteger();
                    if (doctorService.getEntity(doctorId) == null) {
                        System.out.println("There is no doctor with such Id");
                        System.out.println("Please, choose the next action");
                        item = inputInteger();
                        break;
                    }

                    Patient patient = new Patient();
                    patient.setFirstName(firstName);
                    patient.setLastName(surname);
                    patient.setDiagnosis(diagnosis);
                    patient.setTherapy(therapy);
                    patient.setDoctorId(doctorId);

                    if (patientService.insert(patient) == null)
                        System.out.println("Patient is already in DataBase");
                    else System.out.println("Patient was successfully added with id " + patient.getId());
                    System.out.println("Please, choose the next action");
                    item = inputInteger();

                    break;
                }

                case 8: {
                    if (patientService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Patient> patientList = patientService.getEntityList();
                        for (Patient patient : patientList)
                            System.out.println(patient.toString() + "\n");
                    }
                    scanner.nextLine();
                    System.out.println("Enter an patientId to delete");
                    Integer Id = inputInteger();
                    Patient patient = new Patient();
                    patient.setId(Id);
                    if (patientService.delete(patient))
                        System.out.println("Patient was successfully deleted");
                    else
                        System.out.println("There isn't bus in DataBase");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 9: {
                    if (patientService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Patient> patientList = patientService.getEntityList();
                        for (Patient patient : patientList)
                            System.out.println(patient.toString() + "\n");
                    }
                    System.out.println("\nPlease, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 10: {
                    scanner.nextLine();

                    List<Doctor> docotrsList = doctorService.getEntityList();
                    for (Doctor doctor : docotrsList)
                        System.out.println("Doctor:" + doctor.toString() + "\n");

                    System.out.println("Please, enter a DoctorId");
                    Integer doctorId = inputInteger();

                    if (doctorService.getEntity(doctorId) == null) {
                        System.out.println("There isn't doctor with this id\n");
                        System.out.println("Please, choose the next action");
                        item = inputInteger();
                        break;
                    }

                    List<Employee> employeeList = employeeService.getEntityList();
                    for (Employee employee : employeeList)
                        System.out.println(employee.toString() + "\n");

                    scanner.nextLine();
                    System.out.println("Please, enter a EmployeeId");
                    Integer employeeId = inputInteger();

                    if (employeeService.getEntity(employeeId) == null) {
                        System.out.println("There isn't bus with this id\n");
                        System.out.println("Please, choose the next action");
                        item = inputInteger();
                        break;
                    }

                    scanner.nextLine();
                    System.out.println("Enter a status of room: \n" +
                            "1 - free\n" +
                            "2 - not free\n");
                    Integer status = inputInteger();
                    boolean isFree;

                    isFree = status.equals(1);

                    Room room = new Room();
                    room.setDoctorId(doctorId);
                    room.setEmployeeId(employeeId);
                    room.setFree(isFree);

                    if (roomService.insert(room) == null)
                        System.out.println("Room is already in DataBase");
                    else System.out.println("Room was successfully added with id " + room.getId());
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 11: {
                    scanner.nextLine();
                    System.out.println("Enter a roomNumber to delete");

                    Integer Id = inputInteger();
                    Room room = new Room();
                    room.setId(Id);
                    if (roomService.delete(room))
                        System.out.println("Room was successfully deleted");
                    else
                        System.out.println("There isn't room in DataBase");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 12: {
                    if (roomService.getSize() == 0)
                        System.out.println("DataBase is empty");
                    else {
                        List<Room> roomList = roomService.getEntityList();
                        for (Room room : roomList)
                            System.out.println(room.toString() + "\n");
                    }
                    System.out.println("\nPlease, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 13: {
                    scanner.nextLine();
                    System.out.println("Enter a room number to show info");
                    Integer id = inputInteger();
                    RoomVO roomVO = roomVOService.getFullInfoById(id);
                    if (roomVO == null)
                        System.out.println("There is no room with such number");
                    else
                        System.out.println(roomVO.toString());
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 14: {
                    if (roomService.getSize() == 0) {
                        System.out.println("The list of rooms is empty");
                    } else {
                        List<RoomVO> roomVOList = roomVOService.getFullInfoList();
                        for (RoomVO roomVO : roomVOList) {
                            System.out.println(roomVO.toString());
                        }
                    }
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 15: {
                    List<RoomVO> roomVOList = roomVOService.getFreeRooms();
                    for (RoomVO roomVO : roomVOList) {
                        System.out.println(roomVO.toString());
                    }
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 16: {
                    scanner.nextLine();
                    System.out.println("Enter doctor id");
                    Integer id = inputInteger();
                    scanner.nextLine();
                    System.out.println("Please, enter a firstname of doctor");
                    String firstname = inputString();
                    System.out.println("Please, enter a lastname of doctor");
                    String lastname = inputString();
                    System.out.println("Please, enter a specialization of doctor");
                    String specialization = inputString();
                    System.out.println("Please, enter age of doctor");
                    Integer age = inputInteger();

                    Doctor doctor = new Doctor();
                    doctor.setId(id);
                    doctor.setFirstName(firstname);
                    doctor.setLastName(lastname);
                    doctor.setSpecialization(specialization);
                    doctor.setAge(age);
                    if (doctorService.update(doctor) == 1) {
                        System.out.println("Doctor was updated");
                    } else {
                        System.out.println("Something wrong");
                    }
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 17: {
                    scanner.nextLine();
                    System.out.println("Enter an employee id");
                    Integer id = inputInteger();
                    System.out.println("Please, enter a firstname of Employee");
                    String firstName = inputString();
                    System.out.println("Please, enter a lastName");
                    String surname = inputString();
                    System.out.println("Please, enter a position");
                    String position = inputString();
                    System.out.println("Please, enter age of employee");
                    Integer age = inputInteger();

                    Employee employee = new Employee();
                    employee.setId(id);
                    employee.setFirstName(firstName);
                    employee.setLastName(surname);
                    employee.setPosition(position);
                    employee.setAge(age);

                    if (employeeService.update(employee) == 1)
                        System.out.println("Employee updated");
                    else System.out.println("Something goes wrong or id is incorrect");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();

                    break;
                }

                case 18: {
                    scanner.nextLine();
                    System.out.println("Patient id: ");
                    Integer id = inputInteger();
                    System.out.println("Please, enter a firstname of Patient");
                    String firstName = inputString();
                    System.out.println("Please, enter a lastName of Patient");
                    String surname = inputString();
                    System.out.println("Please, enter a diagnosis");
                    String diagnosis = inputString();
                    System.out.println("Please, enter a therapy");
                    String therapy = inputString();

                    List<Doctor> doctorsList = doctorService.getEntityList();
                    for (Doctor doctor : doctorsList)
                        System.out.println("Doctor:" + doctor.toString() + "\n");

                    System.out.println("Enter doctor id of the patinet");
                    Integer doctorId = inputInteger();
                    if (doctorService.getEntity(doctorId) == null) {
                        System.out.println("There is no doctor with such Id");
                        System.out.println("Please, choose the next action");
                        item = inputInteger();
                        break;
                    }

                    Patient patient = new Patient();
                    patient.setId(id);
                    patient.setFirstName(firstName);
                    patient.setLastName(surname);
                    patient.setDiagnosis(diagnosis);
                    patient.setTherapy(therapy);
                    patient.setDoctorId(doctorId);

                    if (patientService.update(patient) == 1)
                        System.out.println("Updated successfully");
                    else System.out.println("Something goes wrong or id is incorrect");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();

                    break;
                }

                case 19: {
                    scanner.nextLine();
                    System.out.println("Enter id of room");
                    Integer id = inputInteger();

                    List<Doctor> docotrsList = doctorService.getEntityList();
                    for (Doctor doctor : docotrsList)
                        System.out.println("Doctor:" + doctor.toString() + "\n");

                    System.out.println("Please, enter a DoctorId");
                    Integer doctorId = inputInteger();

                    if (doctorService.getEntity(doctorId) == null) {
                        System.out.println("There isn't doctor with this id\n");
                        System.out.println("Please, choose the next action");
                        item = inputInteger();
                        break;
                    }

                    List<Employee> employeeList = employeeService.getEntityList();
                    for (Employee employee : employeeList)
                        System.out.println(employee.toString() + "\n");

                    scanner.nextLine();
                    System.out.println("Please, enter a EmployeeId");
                    Integer employeeId = inputInteger();

                    if (employeeService.getEntity(employeeId) == null) {
                        System.out.println("There isn't bus with this id\n");
                        System.out.println("Please, choose the next action");
                        item = inputInteger();
                        break;
                    }

                    scanner.nextLine();
                    System.out.println("Enter a status of room: \n" +
                            "1 - free\n" +
                            "2 - not free\n");
                    Integer status = inputInteger();
                    boolean isFree;

                    isFree = status.equals(1);

                    Room room = new Room();
                    room.setId(id);
                    room.setDoctorId(doctorId);
                    room.setEmployeeId(employeeId);
                    room.setFree(isFree);

                    if (roomService.update(room) == 1)
                        System.out.println("Room was updated");
                    else System.out.println("Something goes wrong or id is incorrect");
                    System.out.println("Please, choose the next action");
                    item = inputInteger();
                    break;
                }

                case 21:{
                    List<RoomVO> roomVOList = roomVOService.getFullInfoList();
                    System.out.println("Please, enter a filename");
                    scanner.nextLine();
                    String fileName = inputString();
                    pdfWrite.write(fileName, roomVOList);
                }

                default:
                    item = 0;
            }

        }
    }


    private static void printout() {
        System.out.println("Please choose an action. Press : \n"
                + "1 - Add new Doctor\n"
                + "2 - Delete Doctor\n"
                + "3 - Show all doctors\n"
                + "4 - Add new Employee\n"
                + "5 - Delete Employee\n"
                + "6 - Show all Employees\n"
                + "7 - Add new Patient\n"
                + "8 - Delete Patient\n"
                + "9 - Show all Patients\n"
                + "10 - Add new Room\n"
                + "11 - Delete Room\n"
                + "12 - Show list of rooms\n"
                + "13 - Get full info of room by number\n"
                + "14 - Show full list info\n"
                + "15 - Show free rooms\n"
                + "16 - Update doctor\n"
                + "17 - Update employee\n"
                + "19 - Update patient\n"
                + "20 - Update room\n"
                + "21 - Save in file\n"
                + "press 0 for exit\n\n"
                + "AFTER CHOOSING AN OPTION PLEASE PRESS ENTER");
    }

    private static String inputString() {
        String name = scanner.nextLine();
        while (name.length() == 0) {
            System.out.println("String can't be empty");
            name = scanner.nextLine();
        }
        name = name.replace(",", " ");
        return name;
    }

    private static Integer inputInteger() {
        Integer Id;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Input data must be a number");
                scanner.next();
            }
            Id = scanner.nextInt();
        } while (Id < 0);
        return Id;
    }
}
