package mx.com.consubanco.icbs.interfaces.spei;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;
import com.ibm.as400.access.DataQueue;
import com.ibm.as400.access.DataQueueEntry;

public class SpeiOutDataQueueInvoker {

	private static Log log = LogFactory.getLog( SpeiOutDataQueueInvoker.class );

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Uso: java -Xms64M -Xmx1024M -Dfile.encoding=ISO-8859-1 mx.com.shermfin.bd.creditline.CreditLineDecrementalInvoker <root_path>");
            System.out.println();
            System.exit(1);
        }

        try {
			AS400 as400Captacion = new AS400("172.16.40.241",
					"S620100009",
					"Santafe020");
			
			DataQueue speiDQ = new DataQueue(as400Captacion,"/QSYS.LIB/CAPTAP.LIB/SPEIOUTDQ.DTAQ");
			
			DataQueueEntry speiDataQueueEntry = speiDQ.peek( );
			
		    System.out.println( speiDataQueueEntry.toString() );
			
		} catch (AS400Exception e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }

}
