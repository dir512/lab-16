/* Эта программа выводит текстовый файл , используя код
 потокового ввода-вывода на основе системы NIO .
 Требуется установка комплекта JDK , начиная с версии 7
 Чтобы восполь зоваться этой программой , укажите имя файла ,
 который требуе тся просмотре ть . Например, чтобы просмотреть
 файл ТESТ . ТХТ, введите в режиме командной строки
 следующую команду :
 java ShowFile ТЕSТ.ТХТ
*/

import java.io.*;
import java.nio.file.*;
class ShowFile {
    public static void main(String args[])
    {
        int i;

        // сначала удостовериться, что указано имя файла
        if (args.length != 1) {
            System.out.println("Пpимeнeниe: ShowFile имя_файла");
            return;
        }

        //открыть файл и получить связанный с ним поток ввода-вывода
        try (InputStream fin = Files.newInputStream(Paths.get(args[0]))) {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

        } catch (InvalidPathException е) {
            System.out.println(" Oшибкa указания пути " + е);
        } catch (IOException е) {
            System.out.println("Oшибкa ввода-вывода " + е);
        }
    }
}
