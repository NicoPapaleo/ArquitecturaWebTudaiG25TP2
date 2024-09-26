package setup;

import csvFile.CSVReader;

public class InitializeJPA {

    public static void loadDataBase(){
        CSVReader csvReader = new CSVReader();
        csvReader.readFileCity();
        csvReader.readFileCareer();
        csvReader.readFileStudent();
        csvReader.readFileCourses();
    }
}
