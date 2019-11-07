/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityguideproject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*; 
/**
 *
 * @author felixfaker
 */
public class CheckCV extends PDFTextStripper{
    static List<String> words = new ArrayList<String>();
    public CheckCV() throws IOException { 
}

 public static int check( String fileName, String requirements ) throws IOException {
        int flag = 1;
        PDDocument document = null;
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new CheckCV();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
            Set<String> s = new LinkedHashSet<String>(words);
            String[] strArray1 = requirements.split(",", requirements.length());
            int[] arr = new int[strArray1.length];
            for(int i=0; i<strArray1.length; i++)
            {
                arr[i] = 0;
            }
            int k =0;
            for(String key:strArray1){
            for(String word:s){
                if(word.toLowerCase().contains(key.toLowerCase()))
                {arr[k]++; System.out.println(word);} 
            }
            k++;
            }
            for(int i=0; i<strArray1.length; i++)
            {
                if(arr[i]==0)
                {
                    flag =0;
                    break;
                }
            }
        }
        finally {
            if( document != null ) {
                document.close();
                
            }
        }
        System.out.println(flag);
        return flag;
    }
    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
    protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
        String[] wordsInStream = str.split(getWordSeparator());
        if(wordsInStream!=null){
            for(String word :wordsInStream){
                words.add(word);
            }
        }
    }
} 