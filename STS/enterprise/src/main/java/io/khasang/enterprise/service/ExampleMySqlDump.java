package io.khasang.enterprise.service;


public class ExampleMySqlDump {
    static String result;

    public String newBaseResult() {
        ExampleMySqlDump db = new ExampleMySqlDump();
        db.newBase();
        return result;
    }

    public void newBase() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("C:\\Program Files (x86)\\MySQL\\MySQL Server 5.7\\bin\\mysqladmin -u root -proot create NEWDATABASE");
            result = "success";
        }
        catch (Exception e) {
            result = "Error:" + e;
        }
    }
    /*
    Делаем бекап
mysqldump -u USER -pPASSWORD DATABASE > /path/to/file/dump.sql

Создаём структуру базы без данных
mysqldump --no-data - u USER -pPASSWORD DATABASE > /path/to/file/schema.sql

Если нужно сделать дамп только одной или нескольких таблиц
mysqldump -u USER -pPASSWORD DATABASE TABLE1 TABLE2 TABLE3 > /path/to/file/dump_table.sql

Создаём бекап и сразу его архивируем
mysqldump -u USER -pPASSWORD DATABASE | gzip > /path/to/outputfile.sql.gz

Создание бекапа с указанием его даты
mysqldump -u USER -pPASSWORD DATABASE | gzip > `date +/path/to/outputfile.sql.%Y%m%d.%H%M%S.gz`

Заливаем бекап в базу данных
mysql -u USER -pPASSWORD DATABASE < /path/to/dump.sql

Заливаем архив бекапа в базу
gunzip < /path/to/outputfile.sql.gz | mysql -u USER -pPASSWORD DATABASE
или так
zcat /path/to/outputfile.sql.gz | mysql -u USER -pPASSWORD DATABASE

Создаём новую базу данных
mysqladmin -u USER -pPASSWORD create NEWDATABASE

Удобно использовать бекап с дополнительными опциями -Q -c -e, т.е.
mysqldump -Q -c -e -u USER -pPASSWORD DATABASE > /path/to/file/dump.sql, где:

    -Q оборачивает имена обратными кавычками
    -c делает полную вставку, включая имена колонок
    -e делает расширенную вставку. Итоговый файл получается меньше и делается он чуть быстрее



Для просмотра списка баз данных можно использовать команду:
mysqlshow -u USER -pPASSWORD

А так же можно посмотреть список таблиц базы:
mysqlshow -u USER -pPASSWORD DATABASE
     */
}
