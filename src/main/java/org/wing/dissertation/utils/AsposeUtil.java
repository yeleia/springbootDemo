package org.wing.dissertation.utils;

import com.aspose.cells.License;
import com.aspose.words.Document;

import java.io.InputStream;

/**
 * Created by liao on 16-11-21.
 */
public class AsposeUtil {
    public static boolean getLicense(){
        boolean result = false;
        try {
            InputStream is = AsposeUtil.class.getClassLoader().getResourceAsStream("aspose.word.license.xml"); //  license.xml应放在..\WebRoot\WEB-INF\classes路径下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void docToPdf(String filePath,String pdfPath) throws Exception{

        Document document=new Document(filePath);
        document.save(pdfPath);
    }


}
