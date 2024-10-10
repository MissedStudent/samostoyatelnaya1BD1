import java.io.StringReader;
import java.util.Scanner;

//15. IT-компания
//- Разработайте базу для управления проектами, сотрудниками и задачами.
//- Запросы: задачи по проекту, загруженность сотрудника, отчет о завершенных проектах.
public class Main {
    public static void main(String[] args) {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        int swtch;
        while (bool) {
            System.out.println("");
            System.out.println("""
                    1.Задачи по проекту
                    2.Загруженность сотрудника
                    3.Отчет о завершенных проектах
                    4.Завершение работы программы
                    """);
            swtch= scanner.nextInt();
            switch (swtch){
                case 1:{//задачи по проекту
                    System.out.println("Введите название проекта");
                    String proj=scanner.next();
                    bd.tasksOfProject(proj);
                }break;
                case 2:{//загруженность сотрудника
                    System.out.println("Введите фамилию сотрудника");
                    String fam=scanner.next();
                    bd.employeeProjects(fam);
                }break;
                case 3:{//отчет о завершенных работах
                    System.out.println("Завершенные работы");
                    bd.finishedProjects();
                }break;
                case 4:{
                    bool=false;
                }break;
                default:{System.out.println("Значение выходит за предусмотренные пределы");}break;
            }
        }
    }
}