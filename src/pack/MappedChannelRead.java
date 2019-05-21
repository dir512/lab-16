// Исполь зовать сопоставление для чтения данных из файла .
// Требуется установка комплекта JDK , начиная с версии 7
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.* ;

public class MappedChannelRead {
    public static void main(String args[]) {
        // получить канал к файлу в блоке оператора try с ресурсами
        try (FileChannel fChan =
                     (FileChannel) Files.newByteChannel(Paths.get("test.txt "))) {
            // получить размер файла
            long fSize = fChan.size();

            // а теперь сопоставить файл с буфером
            MappedByteBuffer mВuf =
                    fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            // читать байты из буфера и выводить их на экран
            for (int i = 0; i < fSize; i++)
                System.out.print((char) mВuf.get());
            System.out.println();

        } catch (InvalidPathException е){
            System.out.println("Oшибкa указания пути " + е);
        } catch(IOException е){
            System.out.println("Oшибкa ввода-вывода " + е);
        }
    }

}
