package setup;

import csvFile.CSVReader;
import dto.CareerDTO;
import dto.ReportCareerDTO;
import dto.StudentDTO;
import entity.Career;
import entity.Student;
import repository.implementsRepositories.CareerRepositoryImp;
import repository.implementsRepositories.CoursesRepositoryImp;
import repository.implementsRepositories.JPARepositoryFactory;
import repository.implementsRepositories.StudentRepositoryImp;
import repository.interfaceRepository.RepositoryFactory;

import java.util.List;

//crea RepositoryFactory , carga datos a base, implementa metodos estaticos de consulta
public class InitializeJPA {

    private static RepositoryFactory repositoryFactoryJPA;

    public InitializeJPA(RepositoryFactory repositoryFactoryJPA) {
        this.repositoryFactoryJPA =  repositoryFactoryJPA;
    }

    //delega en clase CSVReader la lectura y carga a la base de datos
    public static void loadDataBase(){
        CSVReader csvReader = new CSVReader();
        csvReader.readFileCity();
        csvReader.readFileCareer();
        csvReader.readFileStudent();
        csvReader.readFileCourses();
    }

    //Metodos que responden a las consultas de los puntos del TP:

    //a) dar de alta un estudiante
    public static void addStudent(Student student){
        try{
            RepositoryFactory repositoryFactoryJPA = new JPARepositoryFactory();
            StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
            studentRepository.persist(student);
        } catch (Exception e) {
            System.out.print("No se puede dar de alta el estudiante");
        }
    }
    //b) matricular un estudiante en una carrera
    public static void enrollStudent(Student student, Career career){
        CoursesRepositoryImp coursesRepository = repositoryFactoryJPA.getCoursesRepository();
        coursesRepository.enrollStudent(student,career);
    }
    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    public static void studentsOrderedByLastName(){
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        List<StudentDTO> studentsOrderedByLastName = studentRepository.findAllStudentsOrderedByLastName();
        System.out.println("lista de estudiantes ordenada por Apellido");
        studentsOrderedByLastName.forEach(studentDTO -> System.out.println(studentDTO.toString()));
    }
    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    public static void studentByRecord(int idLibreta){
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        StudentDTO studentByRecord =studentRepository.studentByRecord(idLibreta);
        if(studentByRecord != null){
            System.out.println(" Estudiante con libreta N°: " + idLibreta  +"\\n"+ studentByRecord.toString());
        }else{
            System.out.println("No existe estudiante con libreta N°: " + idLibreta);
        }
    }
    //e) recuperar todos los estudiantes, en base a su género.
    public static void studentsFilterByGender(char gender) {
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        if(Character.toUpperCase(gender) == 'M' || Character.toUpperCase(gender) == 'F'){
            List<StudentDTO>studentsFilterByGender = studentRepository.findStudentsByGender(gender);
            System.out.println("lista de estudiantes filtrada por genero");
            studentsFilterByGender.forEach(studentDTO -> System.out.println(studentDTO.toString()));
        }else {
            System.out.println("Genero invalido");
        }
    }
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public static void careerFilterByEnrolledStudent(){
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        List<CareerDTO> careerFilterByEnrolledStudent = careerRepository.findByEnrolledStudentsOrderedByCant();
        System.out.println("lista de carreras con estudiantes inscriptos, ordenados por cantidad");
        careerFilterByEnrolledStudent.forEach(careerDTO -> System.out.println(careerDTO.toString()));
    }
    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    public static void studentsFilterByCity(String career, String city){
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        List<StudentDTO>studentsFilterByCity = studentRepository.getStudentsByCareerFilterByCity(career,city);
        System.out.println("lista de estudiantes de determinada carrera, filtrado por ciudad");
        studentsFilterByCity.forEach(studentDTO -> System.out.println(studentDTO.toString()));
    }
    //3) Generar un reporte de las carreras, que para cada carrera incluya información de los
    //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
    //los años de manera cronológica.
    public static void enunciado3(){
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        System.out.println("ejercicio numero 3"); //acomodar
        List<ReportCareerDTO> listReportCareerDTO = careerRepository.generateCareerReport();
        listReportCareerDTO.forEach( reportCareerDTO -> System.out.println(reportCareerDTO.toString()));
    }
}
