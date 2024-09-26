package csvFile;

import entity.Career;
import entity.City;
import entity.Student;
import repository.implementsRepositories.*;
import repository.interfaceRepository.RepositoryFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    private RepositoryFactory repositoryFactoryJPA;
    private static final String PATH="./src/main/java/csvFiles/";

    public CSVReader(){
        repositoryFactoryJPA = new JPARepositoryFactory();
    }

    public void readFileStudent() {
        CityRepositoryImp cityRepository = repositoryFactoryJPA.getCityRepository();
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        String csvFile = PATH+"student.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                //se usa la coma como separador
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    String[] datos = line.split(cvsSplitBy);
                    City cityStudent = cityRepository.findById(Integer.parseInt(datos[7]));
                    Student newStudent = new Student(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]),
                                                     datos[2], datos[3], Integer.parseInt(datos[4]),
                                                     datos[5].charAt(0), cityStudent);
                    studentRepository.persist(newStudent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileCity() {
        CityRepositoryImp cityRepository = repositoryFactoryJPA.getCityRepository();
        String csvFile = PATH+"city.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    //se usa la coma como separador
                    String[] datos = line.split(cvsSplitBy);
                    City newCity = new City(Integer.parseInt(datos[0]), datos[1]);
                    cityRepository.persist(newCity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileCareer() {
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        String csvFile = PATH+"career.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    //se usa la coma como separador
                    String[] datos = line.split(cvsSplitBy);
                    Career newCareer = new Career(Integer.parseInt(datos[0]), datos[1]);
                    careerRepository.persist(newCareer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileCourses() {
        CoursesRepositoryImp coursesRepository = repositoryFactoryJPA.getCoursesRepository();
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        String csvFile = PATH+"courses.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    //se usa la coma como separador
                    String[] datos = line.split(cvsSplitBy);
                    Student student = studentRepository.findById(Integer.parseInt(datos[0]));
                    Career career = careerRepository.findById(Integer.parseInt(datos[0]));
                    coursesRepository.enrollStudent(student,career);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
