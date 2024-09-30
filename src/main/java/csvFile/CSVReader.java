package csvFile;

import entity.Career;
import entity.City;
import entity.Courses;
import entity.Student;
import repository.implementsRepositories.*;
import repository.interfaceRepository.RepositoryFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

//Crea JPARepositoryFactory con repositorios de cada entidad para leer CSV y persistirlos

public class CSVReader {

    private RepositoryFactory repositoryFactoryJPA;
    private static final String PATH = "src/main/resources/";

    //creacion de JPARepository
    public CSVReader(){
        repositoryFactoryJPA = new JPARepositoryFactory();
    }

    //lee archivos y los agrega a la base
    public void readFileStudent() {
        CityRepositoryImp cityRepository = repositoryFactoryJPA.getCityRepository();
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        String csvFile = PATH+"student.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    String[] datos = line.split(cvsSplitBy);
                    City cityStudent = cityRepository.findById(Integer.parseInt(datos[6]));
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
                    String[] datos = line.split(cvsSplitBy);
                    Student student = studentRepository.findById(Integer.parseInt(datos[0]));
                    Career career = careerRepository.findById(Integer.parseInt(datos[1]));
                    LocalDate inscrip = LocalDate.of(Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]));
                    Courses newCourses = null;
                    if(Integer.parseInt(datos[5]) == 1){
                        LocalDate fechaGraduado = LocalDate.of(Integer.parseInt(datos[6]),Integer.parseInt(datos[7]),Integer.parseInt(datos[8]));
                        newCourses = new Courses(student,career,inscrip,fechaGraduado);
                    }else{
                        newCourses = new Courses(student,career,inscrip);
                    }
                    coursesRepository.persist(newCourses);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
