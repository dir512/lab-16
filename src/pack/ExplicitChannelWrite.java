// Записать данные в файл средствами системы ввода-вывода NIO .
// Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelWrite {

    public static void main (String args[]) {
        // получить канал к файлу в блоке оператора try с ресурсами
        try ( FileChannel fChan = ( FileChannel)
                Files.newByteChannel (Paths.get( "test.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE ) )
        {
            // создать буфер
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            // записать некоторое количество байтов в буфер
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));

            // подготовить буфер к записи данных
            mBuf.rewind();

            // записать данные из буфера в выходной файл
            fChan.write(mBuf);

        } catch ( InvalidPathException е) {
            System.out.println("Oшибкa указания пути " + е);
        } catch ( IOException е) {
            System.out.println( "Oшибкa ввода-вывода: " + е) ;
            System.exit(1) ;
        }
    }
}