package setup;

import csvFile.CSVReader;
import dto.CareerDTO;
import dto.ReportCareerDTO;
import dto.StudentDTO;
import entity.Student;
import repository.implementsRepositories.CareerRepositoryImp;
import repository.implementsRepositories.JPARepositoryFactory;
import repository.implementsRepositories.StudentRepositoryImp;
import repository.interfaceRepository.RepositoryFactory;

import java.util.List;

public class InitializeJPA {

    private static RepositoryFactory repositoryFactoryJPA;

    public InitializeJPA(RepositoryFactory repositoryFactoryJPA) {
        this.repositoryFactoryJPA =  repositoryFactoryJPA;
    }

    public static void loadDataBase(){
        CSVReader csvReader = new CSVReader();
       // csvReader.readFileCity();
      // csvReader.readFileCareer();
      // csvReader.readFileStudent();//csvReader.readFileCourses();
    }

    public static void addStudent(Student student){
        RepositoryFactory repositoryFactoryJPA = new JPARepositoryFactory();
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        studentRepository.persist(student);
    }

    public static void studentsOrderedByLastName(){
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        List<StudentDTO> studentsOrderedByLastName = studentRepository.findAllStudentsOrderedByLastName();
        System.out.println("lista ordenada por alfabeto");
        studentsOrderedByLastName.forEach(studentDTO -> System.out.println(studentDTO.toString()));
    }

    public static void studentByRecord(int idLibreta){
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        StudentDTO studentByRecord =studentRepository.studentByRecord(idLibreta);
        if(studentByRecord != null){
            System.out.println(" Estudiante con libreta N°: " + idLibreta  +"\\n"+ studentByRecord.toString());
        }else{
            System.out.println("No existe estudiante con libreta N°: " + idLibreta);
        }
    }

    public static void studentsFilterByGender(char gender) {
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        if(Character.toUpperCase(gender) == 'M' || Character.toUpperCase(gender) == 'F'){
            List<StudentDTO>studentsFilterByGender = studentRepository.findStudentsByGender(gender);
            System.out.println("lista filtrada por genero");
            studentsFilterByGender.forEach(studentDTO -> System.out.println(studentDTO.toString()));
        }else {
            System.out.println("Genero invalido");
        }


    }

    public static void studentsFilterByCity(String career, String city){
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        List<StudentDTO>studentsFilterByCity = studentRepository.getStudentsByCareerFilterByCity(career,city);
        System.out.println("lista filtrada por ciudad y carrera");
        studentsFilterByCity.forEach(studentDTO -> System.out.println(studentDTO.toString()));
    }

    public static void enunciado3(){
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        System.out.println("ejercicio numero 3"); //acomodar
        List<ReportCareerDTO> listReportCareerDTO = careerRepository.generateCareerReport();
        listReportCareerDTO.forEach( reportCareerDTO -> System.out.println(reportCareerDTO.toString()));
    }

    public static void careerFilterByEnrolledStudent(){
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        List<CareerDTO> careerFilterByEnrolledStudent = careerRepository.findByEnrolledStudentsOrderedByCant();
        System.out.println("lista de carrera por estudiantes ingresados");
        careerFilterByEnrolledStudent.forEach(careerDTO -> System.out.println(careerDTO.toString()));
    }
}
