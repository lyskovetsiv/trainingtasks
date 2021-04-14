package optionaliotasks.changepublictoprivate;

public class AppStarter {
    public static void main(String[] args) {
        ClassChanger classChanger = new ClassChanger();

        classChanger.createFileWithDifferentModificators();
        classChanger.reverseEveryLineInFile();
    }
}
