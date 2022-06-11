package it.unibs.pgmarnaldoesame;

import java.io.FileInputStream;
import java.util.HashMap;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;



public class LettoreMappeXML {
	
	private static final String FILE_PATH = "mappe\\";
	

	
	public static int [][] leggiMappa(HashMap<Integer, String> legendaSimboli) {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		
		int [][] mappa = null;
		int dimColonne = 0;
		int dimRighe = 0;
		
		
		int contaRiga = -1;
		int contaColonna = 0;
		
		try {
			 xmlif = XMLInputFactory.newInstance();
			 xmlr = xmlif.createXMLStreamReader(FILE_PATH + "livello1.xml", new FileInputStream(FILE_PATH + "livello1.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}

try {
	while(xmlr.hasNext()) {
				
				if(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT)
				{
					
					switch(xmlr.getLocalName()) {
					case "mappa":
						           dimRighe = Integer.parseInt(xmlr.getAttributeValue(1));
						           dimColonne = Integer.parseInt(xmlr.getAttributeValue(0)); 
						           mappa = new int [dimRighe][dimColonne];
								   break;
					case "row" : 	contaRiga++;
									contaColonna = 0;
									break;
					case "cell": 	xmlr.next();


										String simbolo = xmlr.getText();
										for(int i = 0; i < legendaSimboli.size(); i++) {
											String valore = legendaSimboli.get(i);
											if(simbolo.equals(valore))
											{
												mappa[contaRiga][contaColonna] = i;
												break;
											}	
										}
										
										contaColonna++;

								break;
					
					}
				}
				xmlr.next();
			}
} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (XMLStreamException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		return mappa;
	}

}
