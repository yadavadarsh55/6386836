

public class FactoryPatternTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PDFFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        wordDoc.open();
        wordDoc.close();

        pdfDoc.open();
        pdfDoc.close();

        excelDoc.open();
        excelDoc.close();
    }
}