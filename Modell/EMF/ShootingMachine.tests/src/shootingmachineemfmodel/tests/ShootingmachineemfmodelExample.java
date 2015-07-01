/**
 */
package shootingmachineemfmodel.tests;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import shootingmachineemfmodel.Client;
import shootingmachineemfmodel.Display;
import shootingmachineemfmodel.GetEvent;
import shootingmachineemfmodel.HWExtern;
import shootingmachineemfmodel.HWIntern;
import shootingmachineemfmodel.Motor;
import shootingmachineemfmodel.Receiver;
import shootingmachineemfmodel.SendEvent;
import shootingmachineemfmodel.Sender;
import shootingmachineemfmodel.Server;
import shootingmachineemfmodel.ShootingmachineemfmodelPackage;
import shootingmachineemfmodel.ToplevelSystem;
//import shootingmachineemfmodel.util.ShootingmachineemfmodelResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * A sample utility for the '<em><b>shootingmachineemfmodel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ShootingmachineemfmodelExample {
	/*
	 * HASHES VORBEREITEN:
	 */
	static Map<String, String> RunnablesToTask = new HashMap<String, String>();
    static Map<String, String> EventPort = new HashMap<String, String>();
    static Map<String, String> PortRunnable = new HashMap<String, String>();
    static Map<String, Integer> PortToID = new HashMap<String, Integer>();
    static Map<String, Integer> TaskBrick = new HashMap<String, Integer>();
    static Map<Integer, String> IDToPort = new HashMap<Integer, String>();

    //Liste von Listen von Listen von String um bei Erzeugung des oil-Files die richtigen Sender und Receiver Events im richtigen Brick hinzuzufuegen
    static List<ArrayList<ArrayList<String>>> Brick_SR_Events = new ArrayList<ArrayList<ArrayList<String>>>();


    //Funktion um Runnablecode aus angegebenem Pfad einlesen und als String zurueckgeben
    public static String copyFiletoString(String input)
    {
        String runnablecode = "";
        File file = new File(input);

        if (!file.canRead() || !file.isFile())
        {
        	System.out.print("Error: Datei " + input + " konnte nicht gefunden werden!!\n");
        	System.exit(0);
        }

            BufferedReader in = null;
        try
        {
            in = new BufferedReader(new FileReader(input));
            String zeile = null;
            while ((zeile = in.readLine()) != null)
            {
                runnablecode = runnablecode + zeile + "\n";
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (in != null)
                try
                {
                    in.close();
                }
                catch (IOException e)
                {

                }
        }
        System.out.print("\t\tDatei " + input + " eingelesen\n");

        return runnablecode;
    }

    //Funktion um Ordner rekursiv mit evtl. Unterordnern und Dateien zu loeschen
    public static void deleteDir(File path)
    {
    	for (File files : path.listFiles())
        {
        	if (files.isDirectory())
        		deleteDir(files);
        	files.delete();
        }
            path.delete();
    }

    public static List<String> generateOilFile(ToplevelSystem mySystem, int Brickindex, String Brickname) throws IOException
    {
    	//List<List<> Zeug fuer Events
    	List<ArrayList<String>> SenderReceiverEvents = new ArrayList<ArrayList<String>>();
    	List<String> SenderEvents = new ArrayList<String>();
    	List<String> ReceiverEvents = new ArrayList<String>();
    	SenderReceiverEvents = Brick_SR_Events.get(Brickindex);
    	SenderEvents = SenderReceiverEvents.get(0);
    	ReceiverEvents = SenderReceiverEvents.get(1);

    	System.out.print("\tDatei " + Brickname + ".oil erstellt.\n");
    	List<String> retlist = new ArrayList<String>();
    	String oilFileBeginn = "";
    	String oilFileTask = "";
    	String oilFileInitHook = "";
    	String oilFileBTInterface = "";
    	String oilFileBTImplizit = "";
    	String oilFileAlarm = "";
    	String oilFileCounter = "";
    	String oilFileEvent = "";
    	String oilFileBTEvents = "";

        //Anfang hardcoded
        oilFileBeginn = "#include \"implementation.oil\"\n\n"
                + "CPU ATMEL_AT91SAM7S256\n"
                + "{\n"
                + "\tOS LEJOS_OSEK\n"
                + "\t{\n"
                + "\t\tSTATUS = EXTENDED;\n"
                + "\t\tSTARTUPHOOK = FALSE;\n"
                + "\t\tERRORHOOK = FALSE;\n"
                + "\t\tSHUTDOWNHOOK = FALSE;\n"
                + "\t\tPRETASKHOOK = FALSE;\n"
                + "\t\tPOSTTASKHOOK = FALSE;\n"
                + "\t\tUSEGETSERVICEID = FALSE;\n"
                + "\t\tUSEPARAMETERACCESS = FALSE;\n"
                + "\t\tUSERESSCHEDULER = FALSE;\n"
                + "\t};\n\n"
                + "\tAPPMODE LEGOSAR{};\n\n";

        //for schleife fuer Task sektion
        for(int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().size(); j++)
        {
        	shootingmachineemfmodel.Task actualTask = mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j);
            oilFileTask += "\tTASK " + actualTask.getName() + "\n"
                    + "\t{\n";
            //Wenn AUTOSTART true ist:
            if (actualTask.isAUTOSTART() == true)
            {
                oilFileTask += oilFileTask + "\t\tAUTOSTART = TRUE\n"
                        + "\t\t{\n"
                        + "\t\t\tAPPMODE = LEGOSAR;\n"
                        + "\t\t};\n";
            }
            //AUTOSTART false
            else
            {
                oilFileTask += "\t\tAUTOSTART = FALSE;\n";
            }
            oilFileTask += "\t\tPRIORITY = " + actualTask.getPRIORITY() + ";\n"
                    + "\t\tACIVATION = " + actualTask.getACTIVATION() + ";\n"
                    + "\t\tSCHEDULE = FULL;\n"
                    + "\t\tSTACKSIZE = 512;\n";

            System.out.print("\t\tTASK " + actualTask.getName() + " in Datei " + Brickname +".oil hinzugefuegt\n");

            oilFileInitHook = "\tTASK InitHook\n" //Hier kein +=, weil es nur einmal pro Datei und nicht einmal pro Task eingefuegt werden soll
            		+"\t{\n"
            		+"\t\tAUTOSTART = TRUE\n"
            		+"\t\t{\n"
            		+"\t\t\tAPPMODE = LEGOSAR;\n"
            		+"\t\t};\n"
            		+"\t\tPRIORITY = 10;\n"
            		+"\t\tACTIVATION = 1\n"
            		+"\t\tSCHEDULE = FULL\n"
            		+"\t\tSTACKSIZE = 512\n"
            		+"\t};\n\n";

            System.out.print("\t\tImpliziten Task InitHook hinzugefuegt.\n");

            oilFileBTInterface = "\tTASK TASK_BT_INTERFACE_READER\n"  //Hier kein +=, weil es nur einmal pro Datei und nicht einmal pro Task eingefuegt werden soll
            		+ "\t{\n"
            		+"\t\tAUTOSTART = TRUE\n"
            		+"\t\t{\n"
            		+"\t\t\tAPPMODE = LEGOSAR;\n"
            		+"\t\t};\n"
            		+"\t\tPRIORITY = 7;\n"
            		+"\t\tACTIVATION = 1\n"
            		+"\t\tSCHEDULE = FULL\n"
            		+"\t\tSTACKSIZE = 512\n"
            		+"\t\tEVENT = BT_HAS_RECEIVED_PACKAGE;\n";
            for(int k = 0; k < ReceiverEvents.size(); k++) //Hier werden alle Events die zum InterfaceReader gehoeren aus der Liste geholt
            {
            	oilFileBTInterface += "\t\tEVENT = " + ReceiverEvents.get(k) + ";\n";
            }
    		oilFileBTInterface += "\t};\n\n"
    				+ "\tTASK TASK_BT_INTERFACE_WRITER\n"
    				+ "\t{\n"
    				+"\t\tAUTOSTART = TRUE\n"
    				+"\t\t{\n"
    				+"\t\t\tAPPMODE = LEGOSAR;\n"
    				+"\t\t};\n"
    				+"\t\tPRIORITY = 7;\n"
    				+"\t\tACTIVATION = 1\n"
    				+"\t\tSCHEDULE = FULL\n"
    				+"\t\tSTACKSIZE = 512\n";
    		for(int k = 0; k < SenderEvents.size(); k++) //Hier werden alle Events die zum InterfaceWriter gehoeren aus der Liste geholt
    		{
    			oilFileBTInterface += "\t\tEVENT = " + SenderEvents.get(k) + ";\n";
    		}
    		oilFileBTInterface += "\t};\n\n";

            System.out.print("\t\tTasks fuer Com-Service hinzugefuegt\n");

            if (mySystem.getHasBrick().get(Brickindex).isIsMaster())
            {
            	oilFileBTImplizit = "\tTASK BT_IMPLIZIT_MASTER\n";  //Hier kein +=, weil es nur einmal pro Datei und nicht einmal pro Task eingefuegt werden soll
            	System.out.print("\t\tBT_MASTER hinzugefuegt.\n");
            }
            else
            {
            	oilFileBTImplizit = "\tTASK BT_IMPLIZIT_SLAVE\n";  //Hier kein +=, weil es nur einmal pro Datei und nicht einmal pro Task eingefuegt werden soll
            	System.out.print("\t\tBT_SLAVE hinzugefuegt\n");
            }
            oilFileBTImplizit += "\t{\n"
            		+"\t\tAUTOSTART = TRUE\n"
            		+"\t\t{\n"
            		+"\t\t\tAPPMODE = LEGOSAR;\n"
            		+"\t\t};\n"
            		+"\t\tPRIORITY = 9;\n"
            		+"\t\tACTIVATION = 1\n"
            		+"\t\tSCHEDULE = FULL\n"
            		+"\t\tSTACKSIZE = 512\n"
            		+"\t\tEVENT = BT_SEND_MY_MESSAGE;\n"
            		+"\t};\n\n";


            //EVENTS die zu den TASKS gehoeren
            for(int k = 0; k < actualTask.getHasEvent().size(); k++)
            {
                oilFileTask += "\t\tEVENT = " + actualTask.getHasEvent().get(k).getName() + ";\n";
            }
            oilFileTask += "\t};\n\n";


            //for Schleife f�r ALARME
            for(int k = 0; k < actualTask.getHasAlarm().size(); k++)
            {
                oilFileAlarm += "\tALARM " + actualTask.getHasAlarm().get(k).getName() + "\n"
                        + "\t{\n"
                        + "\t\tCOUNTER = " + actualTask.getHasAlarm().get(k).getName() + ";\n"
                        + "\t\tACTION = ACTIVATETASK\n"
                        + "\t\t{\n"
                        + "\t\t\tTASK = " + actualTask.getName() + ";\n"
                        + "\t\t};\n";
                //AUTOSTART ist true
                if(actualTask.getHasAlarm().get(k).isAUTOSTART() == true)
                {
                    oilFileAlarm += oilFileAlarm + "\t\tAUTOSTART = TRUE\n"
                            + "\t\t{\n"
                            + "\t\t\tALARMTIME = " + actualTask.getHasAlarm().get(k).getALARMTIME() + ";\n"
                            + "\t\t\tCYCLETIME = " + actualTask.getHasAlarm().get(k).getCYCLETIME() + ";\n"
                            + "\t\t\tAPPMODE = LEGOSAR;\n"
                            + "\t\t};\n";
                }
                //AUTOSTART ist false
                else
                {
                    oilFileAlarm += "\t\tAUTOSTART = FALSE;\n";
                }
                oilFileAlarm += "\t};\n\n";

                //pro ALARM 1 Counter erstellen
                oilFileCounter += "\tCOUNTER C_" + actualTask.getHasAlarm().get(k).getName() + "\n"
                        + "\t{\n"
                        + "\t\tMINCYCLE = " + actualTask.getHasAlarm().get(k).getMINCYCLE() + ";\n"
                        + "\t\tMAXALLOWEDVALUE = " + actualTask.getHasAlarm().get(k).getMAXALLOWEDVALUE() + ";\n"
                        + "\t\tTICKSPERBASE = " + actualTask.getHasAlarm().get(k).getTICKSPERBASE() + ";\n"
                        + "\t};\n\n";


                System.out.print("\t\tALARM " + actualTask.getHasAlarm().get(k).getName() + " und COUNTER C_"
                		+ actualTask.getHasAlarm().get(k).getName() + " in Datei " + Brickname +".oil hinzugefuegt\n");

            }


        }
        //for Schleife fuer EVENTS
        for (int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasEventBrick().size(); j++)
        {
        	shootingmachineemfmodel.Event actualEvent = mySystem.getHasBrick().get(Brickindex).getHasEventBrick().get(j);
            oilFileEvent += "\tEVENT " + actualEvent.getName() + "\n"
                    + "\t{\n"
                    + "\t\tMASK = AUTO;\n"
                    + "\t};\n\n";

            System.out.print("\t\tEVENT " + actualEvent.getName() + " in Datei " + Brickname +".oil hinzugefuegt\n");
        }

        //Events zu Com-Service und BT_IMPLIZIT_MASTER/SLAVE hinzufuegen
        oilFileBTEvents += "\tEVENT BT_HAS_RECEIVED_PACKAGE\n"
        		+"\t{\n"
        		+"\t\tMASK = AUTO;\n"
        		+"\t};\n\n"
        		+"\tEVENT BT_SEND_MY_MESSAGE\n"
        		+"\t{\n"
        		+"\t\tMASK = AUTO;\n"
        		+"\t};\n\n";
        System.out.print("\t\tEvents BT_HAS_RECEIVED_PACKAGE & BT_SEND_MY_MESSAGE hinzugefuegt.\n");


        //Irgendwie ueberfluessig, bin aber schon bloed im Schaedel, laeuft jetzt auf jeden Fall ueber die List<List<List<String>>>

        //for Schleife fuer implizite Events
//        for (int j = 0; j < mySystem.getHasConnections().size(); j++)
//        {
//        	for(int k = 0; k < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();k++)
//        	{
//                oilFileEvent += "\tEVENT " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT\n"
//                        + "\t{\n"
//                        + "\t\tMASK = AUTO;\n"
//                        + "\t};\n\n";
//                System.out.print("\t\tImplizites Event " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT erzeugt\n");
//        	}
//        }

        //RTE_Funktionen Events werden hier hinzugefuegt
        for (int j = 0; j<ReceiverEvents.size(); j++)
        {
        	oilFileEvent += "\tEVENT " + ReceiverEvents.get(j) + "\n"
                    + "\t{\n"
                    + "\t\tMASK = AUTO;\n"
                    + "\t};\n\n";
        }
        for (int j = 0; j<SenderEvents.size(); j++)
        {
        	oilFileEvent += "\tEVENT " + SenderEvents.get(j) + "\n"
                    + "\t{\n"
                    + "\t\tMASK = AUTO;\n"
                    + "\t};\n\n";
        }


        retlist.add(oilFileBeginn);
        retlist.add(oilFileTask);
        retlist.add(oilFileInitHook);
        retlist.add(oilFileBTInterface);
        retlist.add(oilFileBTImplizit);
    	retlist.add(oilFileAlarm);
    	retlist.add(oilFileCounter);
    	retlist.add(oilFileBTEvents);
    	retlist.add(oilFileEvent);
        retlist.add("};");

        return retlist;
    }

    public static List<String> generatecFile(ToplevelSystem mySystem, int Brickindex, String Brickname) throws IOException
    {
    	System.out.print("\tDatei " + Brickname + ".c erstellt.\n");
    	List<String> retlist = new ArrayList<String>();
    	String cFileBeginn = "";
    	String cFileDeclareInitHook = "";
    	String cFileDeclareBTInterface = "";
    	String cFileDeclareBTImplizit = "";
    	String cFiledeclareBTEvents = "";
    	String cFileDeclareTask = "";
    	String cFileDeclareAlarm = "";
    	String newline = "\n";
    	String cFileDeclareEvent = "";
    	String newline1 = "\n";
    	String cFileRunnable = "";
    	String cFileInitHook = "";
    	String cFileBTInterface = "";
    	String cFileBTImplizit = "";
    	String cFileTask = "";



        cFileBeginn += "#include \"kernel.h\"\n"
                + "#include \"kernel_id.h\"\n"
                + "#include \"ecrobot_interface.h\"\n"
                + "#include \"ecrobot_bluetooth.h\"\n"
                + "#include \"YASA_generated_variables.h\"\n"
                + "#include \"YASA_global_variables.h\"\n\n";


        cFileDeclareInitHook += "DeclareTask(InitHook);\n";
        cFileDeclareBTInterface += "DeclareTask(TASK_BT_INTERFACE_READER);\n"
        		+ "DeclareTask(TASK_BT_INTERFACE_WRITER);\n";

        if(mySystem.getHasBrick().get(Brickindex).isIsMaster())
        {
        	cFileDeclareBTImplizit += "DeclareTask(BT_IMPLIZIT_MASTER);\n";
        }
        else
        {
        	cFileDeclareBTImplizit += "DeclareTask(BT_IMPLIZIT_SLAVE);\n";
        }

        cFiledeclareBTEvents += "DeclareEvent(BT_HAS_RECEIVED_PACKAGE);\n"
        		+"DeclareEvent(BT_SEND_MY_MESSAGE)\n";

        //For Schleife in welcher alle Tasks deklariert werden
        for(int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().size(); j++)
        {
            cFileDeclareTask += "DeclareTask(" + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getName() + ");\n\n";


            //For Schleife in welcher alle Alarme mit den zugehoerigen Countern deklariert werden
            for(int k = 0; k < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasAlarm().size(); k++)
            {
                cFileDeclareAlarm += "DeclareAlarm(" + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasAlarm().get(k).getName() + ");\n"
                        + "DeclareCounter(" + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasAlarm().get(k).getName() + ");\n";
            }
        }

        //For Schleife in welcher alle Events deklariert werden
        for (int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasEventBrick().size(); j++)
        {
            cFileDeclareEvent += "DeclareEvent(" + mySystem.getHasBrick().get(Brickindex).getHasEventBrick().get(j).getName() + ");\n";
        }


        //For Schleife in welcher die Runnables deklariert werden
        for(int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().size(); j++)
        {

            for(int k = 0; k < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().size(); k++)
            {
            	System.out.print("\t\thier " + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getName() + "\n");
                cFileRunnable += "//" + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getName() + "\n"
                		+ "void " + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getName() + "()\n"
                        + "{\n"
                        + copyFiletoString(mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getApplicationcode())
                        + "\n}\n\n";
                System.out.print("\t\tRunnable " + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getName() + " hinzugefuegt\n");
            }
        }

        cFileInitHook += "TASK(InitHook)\n"
        		+ "{\n";
        for(int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().size(); j++)
        {
        	try{
        		shootingmachineemfmodel.HWIntern myinput =  (HWIntern) mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j);
        		if(myinput.getType() == shootingmachineemfmodel.HWType.SONIC)
        		{
        			cFileInitHook += "\tecrobot_init_sonar_sensor("+mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname()+");\n";
        			System.out.print("\t\tPort " + mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname() + " als Ultraschall initialisiert\n");
        		}
        	}catch (java.lang.ClassCastException e){

        	}

        	try{
        		shootingmachineemfmodel.HWExtern myoutput = (HWExtern) mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j);
        		cFileInitHook += "\ti2c_enable(NXT_PORT_S"+myoutput.getPinnumber()+");\n";
        		System.out.print("\t\tI2C Expander an Port " + mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname() + " initialisiert.\n");
        	}
        	catch (java.lang.ClassCastException e)
        	{
        	}
        }
        cFileInitHook += "}\n\n";

        //BT Tasks hinzufuegen
        cFileBTInterface += copyFiletoString("..\\..\\..\\Code\\src\\BT_INTERFACE.c") + "\n";

        System.out.print("\t\tBT_INTERFACE hinzugefuegt\n");


        if(mySystem.getHasBrick().get(Brickindex).isIsMaster())
        {
        	cFileBTImplizit += copyFiletoString("..\\..\\..\\Code\\src\\BT_IMPLIZIT_MASTER.c") + "\n";
        	System.out.print("\t\tBT_IMPLIZIT_MASTER hinzuegfuegt\n");
        }
        else
        {
        	cFileBTImplizit += copyFiletoString("..\\..\\..\\Code\\src\\BT_IMPLIZIT_SLAVE.c") + "\n";
        	System.out.print("\t\tBT_IMPLIZIT_SLAVE hinzuegfuegt\n");
        }


        for(int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().size(); j++)
        {
        	cFileTask += "TASK(" +  mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getName() + ")\n"
        			+ "{\n"
        			+ "\twhile(1)\n"
        			+ "\t{\n";

        	for(int k = 0; k < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().size(); k++)
            {
        		cFileTask +="\t\t" + mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getName() + "();\n";
            }
        	cFileTask +=  "\t}\n"
        			+ "\tTerminateTask();\n"
        			+ "}\n";
        }

        retlist.add(cFileBeginn);
        retlist.add(cFileDeclareInitHook);
        retlist.add(cFileDeclareBTInterface);
        retlist.add(cFileDeclareBTImplizit);
        retlist.add(cFiledeclareBTEvents);
    	retlist.add(cFileDeclareTask);
    	retlist.add(cFileDeclareAlarm);
    	retlist.add(newline);
    	retlist.add(cFileDeclareEvent);
    	retlist.add(newline1);
    	retlist.add(cFileRunnable);
    	retlist.add(cFileInitHook);
    	retlist.add(cFileBTInterface);
    	retlist.add(cFileBTImplizit);
    	retlist.add(cFileTask);


        return retlist;
    }

    public static List<String> generatedynamiccFile(ToplevelSystem mySystem, int Brickindex, String Brickname) throws IOException
    {
    	System.out.print("\tDatei YASA_generated.c erstellt.\n");
    	List <String> retlist = new ArrayList<String>();

    	ArrayList<ArrayList<String>> Bricklist = new ArrayList<ArrayList<String>>();
    	ArrayList<String> SenderList = new ArrayList<String>();
    	ArrayList<String> ReceiverList = new ArrayList();

    	String genc = "";
    	String mySenderrtefunc = "";
    	String mySenderEinZweirtefunc = "";
    	String myReceiverrtefunc = "";

        //Nochmal von vorne den Spass:
        for(int j = 0; j < mySystem.getHasConnections().size(); j++)
        {
        		//Aktueller Sender sendet zu anderem Brick und ist auf aktuellem Brick(zweiter Teil der Bedingung)
        		if(mySystem.getHasConnections().get(j).getHasInterBrickCommunicationSystem() != null && Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasSenderPorts().getName()))))
        		{
        			try
                	{
                		//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Brick ist Sender
                		shootingmachineemfmodel.SendEvent myEventSender =  (SendEvent) mySystem.getHasConnections().get(j).getHasSenderPorts();
                		mySenderrtefunc = mySenderrtefunc + "\ninline std_return " + myEventSender.getName() + "()\n{\n";
                		for(int k=0; k < mySystem.getHasConnections().get(j).getHasReceiverPorts().size(); k++)
                		{
                			genc = genc + "DeclareEvent(" +  mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                			SenderList.add(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT");
                			mySenderrtefunc = mySenderrtefunc + "\tSetEvent(TASK_BT_INTERFACE_WRITER, " +  mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                		}
            			mySenderrtefunc = mySenderrtefunc + "}\n";
                		System.out.print("\t\tSender einer Eventbasierten Kommunikation ueber 2 Bricks\n");
                	}
        			catch(java.lang.ClassCastException e)
                	{

                	}
        			try
        			{
        				shootingmachineemfmodel.Sender mySender =  (Sender) mySystem.getHasConnections().get(j).getHasSenderPorts();
        				if (mySenderEinZweirtefunc == "")
        					mySenderEinZweirtefunc = mySenderEinZweirtefunc + "\ninline std_return " + mySender.getName() + "(char *a)\n{\n";
        				for(int k=0; k < mySystem.getHasConnections().get(j).getHasReceiverPorts().size(); k++)
                		{
                    		genc = genc + "DeclareEvent(" + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                    		SenderList.add(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT");
            				genc = genc + "U8 " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_SPEICHER;\n";
            				mySenderEinZweirtefunc = mySenderEinZweirtefunc + "\tstrcpy(COMSERVICE_transmit_package[" + PortToID.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName()) +"] ,*a);\n";
            				mySenderEinZweirtefunc = mySenderEinZweirtefunc + "\tSetEvent(TASK_BT_INTERFACE_WRITER, " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                		}
        				System.out.print("\t\tSender einer Sender-Receiver Kommunikation ueber 2 Bricks\n");
        			}
        			catch(java.lang.ClassCastException e)
                	{

                	}
        			try
        			{
        				shootingmachineemfmodel.Client myClient = (Client) mySystem.getHasConnections().get(j).getHasSenderPorts();
        				/*
	       				 *
	       				 * Vorbereitung fuer Client/Server Kommunikation ueber 2 Bricks (hier Client)
	       				 *
	       				 *
	       				 */
	       				System.out.print("\t\tClient einer Client/Server Kommunikation ueber 2 Bricks\n");
        			}
        			catch(java.lang.ClassCastException e)
        			{

        			}
        		}
        		//Aktueller Port ist kein Sender, aber nicht zwingend Receiver der zu diesem Brick gehoert
        		if(mySystem.getHasConnections().get(j).getHasInterBrickCommunicationSystem() != null)
        		{
        			//Ueber alle Receiver Ports des aktuellen Eintrags der Klasse iterieren
        			for(int l = 0; l < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();l++)
        			{
        				//Aktueller Eintrag gehoert zu aktuellem Brick
        				if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName()))))
        				{
        					try
        					{
	        					//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Brick ist Sender
	                    		shootingmachineemfmodel.GetEvent myEventgetter =  (GetEvent) mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l);
	                    		genc = genc + "DeclareEvent(" + myEventgetter.getName() + "_EVENT);\n";
	                    		ReceiverList.add(myEventgetter.getName() + "_EVENT");
	                    		//blockierend
	                    		if(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).isBlockierend() == true)
	                    		{
	                    			myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myEventgetter.getName() + "(char *a)\n{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tWaitEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    		}
	                    		//nicht blockierend
	                    		else
	                    		{
	                    			myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myEventgetter.getName() + "(uint8_t *a)\n{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tEventMaskType event = 0;\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tGetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName())) + ",&event);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tif(event & " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT)\n\t{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\t*a = 1;\n\t}\n\telse\n\t\t*a = 0;\n\t}\n";
	                    		}
	                    		myReceiverrtefunc += "}\n";
	                    		System.out.print("\t\tReceiver einer Eventbasierten Kommunikation ueber 2 Bricks\n");
        					}
        					catch(java.lang.ClassCastException e)
        					{

        					}
                			try
                			{
                				shootingmachineemfmodel.Receiver myReceiver =  (Receiver) mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l);
                				genc = genc + "DeclareEvent(" + myReceiver.getName() + "_EVENT);\n";
                				ReceiverList.add(myReceiver.getName() + "_EVENT");
                				//blockierend
                				if(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).isBlockierend() == true)
	                    		{
	                    			myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myReceiver.getName() + "(char *a)\n{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tWaitEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tstrcpy(*a,COMSERVICE_receive_package[" + PortToID.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName()) + "]);\n\t}\n";
	                    		}
	                    		//nicht blockierend
	                    		else
	                    		{
	                    			myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myReceiver.getName() + "(uint8_t *a)\n{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tEventMaskType event = 0;\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tGetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName())) + ",&event);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tif(event & " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT)\n\t{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\tstrcpy(*a,COMSERVICE_receive_package[" + PortToID.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName()) + "]);\n\t}\n";
	                    			myReceiverrtefunc = myReceiverrtefunc +"\telse\n\t{\n\t\tstrcpy(a*,\"\");\n\t}\n";
	                    		}
	                    		myReceiverrtefunc += "}\n";
                				System.out.print("\t\tReceiver einer Sender-Receiver Kommunikation ueber 2 Bricks\n");
                			}
                			catch(java.lang.ClassCastException e)
                        	{

                        	}
                			try
                			{
                				shootingmachineemfmodel.Server myServer = (Server) mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l);
                				/*
                				 *
                				 *
                				 * Vorbereitung fuer Client/Server Kommunikation ueber 2 Bricks (hier Server)
                				 *
                				 *
                				 */
                				System.out.print("\t\tServer einer Client/Server Kommunikation ueber 2 Bricks\n");
                			}
                			catch(java.lang.ClassCastException e)
                			{

                			}
        				}
        			}
        		}
        		//Kommunikation laeuft nur ueber einen Brick
        		if(mySystem.getHasConnections().get(j).getHasInterBrickCommunicationSystem() == null)
        		{
        			//EVENT KOMMUNIKATION
        			try
                	{
                		//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Eintrag ist Sender
                		shootingmachineemfmodel.SendEvent myEventSender =  (SendEvent) mySystem.getHasConnections().get(j).getHasSenderPorts();
                		if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasSenderPorts().getName()))))
                		{
                			mySenderrtefunc = mySenderrtefunc + "\ninline std_return " + myEventSender.getName() + "()\n{\n";
                			for(int k=0; k < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();k++)
                			{
                				genc = genc + "DeclareEvent(" + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                				SenderList.add(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT");
                				mySenderrtefunc = mySenderrtefunc + "\tSetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName())) + ", " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                			}
                			mySenderrtefunc = mySenderrtefunc + "}\n";
                			System.out.print("\t\tSender einer Eventbasierten Kommunikation ueber 1 Brick\n");
                		}

                	}
        			catch(java.lang.ClassCastException e)
                	{

                	}

        			for(int l = 0; l < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();l++)
        			{
        				if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName()))))
                		{
        					try
                        	{
                        		//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Eintrag ist Sender
                        		shootingmachineemfmodel.GetEvent myEventGetter =  (GetEvent) mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l);
                        		genc = genc + "DeclareEvent(" + myEventGetter.getName() + "_EVENT);\n";
                        		ReceiverList.add(myEventGetter.getName() + "_EVENT");
                    			//blockierend
                    			if(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).isBlockierend() == true)
    	                    	{
                            		myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myEventGetter.getName() + "(char *a)\n{\n";
                    				myReceiverrtefunc = myReceiverrtefunc + "\tWaitEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName())) + ", " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
                    				myReceiverrtefunc = myReceiverrtefunc + "\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
    	                    	}
                    			//nicht blockierend
                    			else
                    			{
                    				myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myEventGetter.getName() + "(uint8_t *a)\n{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tEventMaskType event = 0;\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tGetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName())) + ",&event);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tif(event & " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT)\n\t{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc	+ "\t\t*a = 1;\n\t}\n\telse\n\t\t*a = 0;\n\t}\n";
                    			}
                    			myReceiverrtefunc = myReceiverrtefunc + "}\n";

                        		System.out.print("\t\tReceiver einer Eventbasierten Kommunikation ueber 1 Brick\n");
                        	}
        					catch(java.lang.ClassCastException e)
        					{

        					}
                		}
        			}


        			//SENDER-RECEIVER KOMMUNIKATION UEBER 1 BRICK
        			try
                	{
                		//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Eintrag ist Sender
                		shootingmachineemfmodel.Sender mySender =  (Sender) mySystem.getHasConnections().get(j).getHasSenderPorts();
                		if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasSenderPorts().getName()))))
                		{
                			if(mySenderEinZweirtefunc == "")
                				mySenderEinZweirtefunc = mySenderEinZweirtefunc + "\ninline std_return " + mySender.getName() + "()\n{\n";
                			for(int k = 0; k < mySystem.getHasConnections().get(j).getHasReceiverPorts().size(); k++)
                			{
                				genc = genc + "DeclareEvent(" + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                				genc = genc + "U8 " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_SPEICHER;\n";
                				SenderList.add(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT");
                				mySenderEinZweirtefunc = mySenderEinZweirtefunc + "\tstrcpy(" + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_SPEICHER,*a);\n";
                				mySenderEinZweirtefunc = mySenderEinZweirtefunc + "\tSetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName())) + ", " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT);\n";
                       		}
                			System.out.print("\t\tSender einer Sender-Receiver Kommunikation ueber 1 Brick\n");
                		}

                	}
        			catch(java.lang.ClassCastException e)
                	{

                	}

        			for(int l = 0; l < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();l++)
        			{
        				if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName()))))
                		{
        					try
                        	{
                        		//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Eintrag ist Sender
                        		shootingmachineemfmodel.Receiver myReceiver =  (Receiver) mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l);
                        		genc = genc + "DeclareEvent(" + myReceiver.getName() + "_EVENT);\n";
                        		ReceiverList.add(myReceiver.getName() + "_EVENT");
                        		myReceiverrtefunc = myReceiverrtefunc + "\ninline std_return " + myReceiver.getName() + "(char *a)\n{\n";
                				//blockierend
                				if(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).isBlockierend() == true)
	                    		{
                					myReceiverrtefunc = myReceiverrtefunc + "\tWaitEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName())) + ", " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
                					myReceiverrtefunc = myReceiverrtefunc + "\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tstrcpy(*a," + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_SPEICHER);\n";
	                    		}
                				//nicht blockierend
                				else
                				{
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tEventMaskType event = 0;\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tGetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName())) + ",&event);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\tif(event & " + mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT)\n\t{\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\tClearEvent("+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_EVENT);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc + "\t\tstrcpy(*a,"+ mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName() + "_SPEICHER);\n";
	                    			myReceiverrtefunc = myReceiverrtefunc +"\telse\n\t{\n\t\tstrcpy(a*,\"\");\n\t}\n";
	                    		}
                				myReceiverrtefunc = myReceiverrtefunc + "}\n";
                        		System.out.print("\t\tReceiver einer Sender-Receiver Kommunikation ueber 1 Brick\n");
                        	}
        					catch(java.lang.ClassCastException e)
        					{

        					}
                		}
        			}
        			try
        			{
        				shootingmachineemfmodel.Client myClient =  (Client) mySystem.getHasConnections().get(j).getHasSenderPorts();
        				/*
        				 *
        				 *
        				 * Vorbereitung fuer Client/Server Kommunikation ueber 1 Brick (hier Client)
                		 *
                		 *
                		 */
                		 System.out.print("\t\tClient einer Client/Server Kommunikation ueber 1 Brick\n");
        			}
        			catch(java.lang.ClassCastException e)
        			{

        			}
        			for(int l = 0; l < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();l++)
        			{
        				if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l).getName()))))
                		{
        					try
                        	{
                        		//Aktueller Eintrag laesst sich nach SendEvent casten -> Kommunikation uber Events und aktueller Eintrag ist Sender
                        		shootingmachineemfmodel.Server myServer =  (Server) mySystem.getHasConnections().get(j).getHasReceiverPorts().get(l);
                        		/*
                        		 *
                        		 *
                        		 * Vorbereitung fuer Client/Server Kommunikation ueber 1 Brick (hier Server)
                        		 *
                        		 *
                        		 */
                        		System.out.print("\t\tServer einer Sender-Receiver Kommunikation ueber 1 Brick\n");
                        	}
        					catch(java.lang.ClassCastException e)
        					{

        					}
                		}
        			}
        		}
        	}

		if(mySenderEinZweirtefunc != "")
			mySenderEinZweirtefunc = mySenderEinZweirtefunc + "}\n";
		mySenderrtefunc = mySenderrtefunc + mySenderEinZweirtefunc;


		 //doppelte Declares entfernt

	    String[] parts = genc.split("\n");
	    String newString = "";
	    for(int i=0; i<parts.length; i++)
	    {
	    	if(!newString.contains(parts[i]))
	    		newString = newString + parts[i] + "\n";
	    }

	    genc = newString;

        retlist.add(genc);
    	retlist.add(mySenderrtefunc);
    	retlist.add(myReceiverrtefunc);

    	//Listen zu Listen zu Liste hinzufuegen
    	Bricklist.add(SenderList);
    	Bricklist.add(ReceiverList);

    	Brick_SR_Events.add(Bricklist);

        return retlist;
    }

    public static List<String> generateComService(ToplevelSystem mySystem, int Brickindex) throws IOException
    {
    	// alles nur f�r einen Brick
    	List<String> retlist = new ArrayList<String>();
    	String BT_Global_String = "";
    	String BT_Receiver_String = "";
    	String BT_Transmitter_String = "";

    	// abpr�fen wie viele logische Ports auf dem aktuellen Brick sind
    	// wie viel davon sind Sender und wie viele sind Receiver

    	shootingmachineemfmodel.Brick actBrick = mySystem.getHasBrick().get(Brickindex);
    	/*
    	 * setzten des globalen defines, wie gro�e der Speicherbereich fuer die Comschicht sein muss -> ist fuer beide Bricks gleich
    	 * zuordnung zwischen den Bricks erfolgt symmetrisch, d.h. auf beiden Bricks zwei Speicherbereiche, die gleich "gehalten" werden!
    	 */
    	BT_Global_String += "#define BT_COM_SERVICE " + (PortToID.size()) + "\n";

    	String loc_WaitEvents = "";
    	String if_bed = "";

    	String loc_red_string = "switch(id){";
    	for(int i = 0; i < mySystem.getHasConnections().size(); i++)
    	{
    		if(Brickindex == TaskBrick.get(RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(i).getHasSenderPorts().getName()))))
    		{
    			//Senderport auf aktuellem Brick
    			loc_WaitEvents += "WaitEvent(";
    			for(int j = 0; j < mySystem.getHasConnections().get(i).getHasReceiverPorts().size(); j++)
    			{
    				loc_WaitEvents += mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName() + "_EVENT | ";
    				if_bed += "if(event & " + mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName() + "_EVENT){";
    				if_bed += "ClearEvent(" + mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName() + "_EVENT);";
    				if_bed += "*transmit_pack_ptr = " + PortToID.get(mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName()) + ";" + "transmit_pack_ptr++;";
    				if_bed += "strcpy(BT_transmit_package, COMSERVICE_transmit_package[" + PortToID.get(mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName()) + "]);";
    				if(mySystem.getHasBrick().get(Brickindex).isIsMaster())
    					if_bed += "SetEvent(BT_IMPLIZIT_MASTER,BT_SEND_MY_MESSAGE);";
    				else
    					if_bed += "SetEvent(BT_IMPLIZIT_SLAVE,BT_SEND_MY_MESSAGE);";
    				if_bed += "}";
    			}
    		}
    		else
    		{
    			//Receiverport auf aktuellem Brick
    			for(int j = 0; j < mySystem.getHasConnections().get(i).getHasReceiverPorts().size(); j++)
    			{
    				loc_red_string += "case " + PortToID.get(mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName()) + ":";
    				loc_red_string += "strcpy(" + mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName() + "_SPEICHER, locBuffer_ptr);";
    				loc_red_string += "SetEvent(" + RunnablesToTask.get(PortRunnable.get(mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName()));
    				loc_red_string +=  "," + mySystem.getHasConnections().get(i).getHasReceiverPorts().get(j).getName() + "_EVENT);";
    				loc_red_string += "break;";
    			}

    		}

    	}
    	if(loc_WaitEvents.length() > 0)
    	{
    		loc_WaitEvents = loc_WaitEvents.substring(0, loc_WaitEvents.length() - 2) + ");";
    		BT_Transmitter_String = "#define BT_DYNAMIC_WRITER_CODE (" + loc_WaitEvents + "GetEvent(TASK_BT_INTERFACE_WRITER, &event);" + if_bed + ")";
    	}
    	else
    		BT_Transmitter_String = "#define BT_DYNAMIC_WRITER_CODE";

    	loc_red_string += "}";
    	BT_Receiver_String = "#define BT_DYNAMIC_READER_CODE ( "+ loc_red_string + ")";


    	retlist.add(BT_Global_String);
    	retlist.add(BT_Receiver_String);
    	retlist.add(BT_Transmitter_String);
    	return retlist;
    }

    public static String setPortDefines(ToplevelSystem mySystem, int Brickindex)
    {
    	String retstring = "";


    	for (int j = 0; j< mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().size(); j++)
    	{
    		try{
    			//Wenn Cast gut geht, ist des vom Typ HWExtern
    			shootingmachineemfmodel.HWExtern myHWExtern = (HWExtern) mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j);
    			retstring +=  "#define " + myHWExtern.getHas_OSPORTS_IN().getName() + "_PORT "+ mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname() + "\n"
    					+ "#define " + myHWExtern.getHas_OSPORTS_IN().getName() + "_In_IIC\n";

        	}catch (java.lang.ClassCastException e){

        	}
    		try{
    			shootingmachineemfmodel.HWIntern myHWIntern = (HWIntern) mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j);
    			retstring += "#define " + myHWIntern.getHas_OSPORTS_IN().getName() + "_PORT "+ mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname() + "\n"
    					+ "#define " + myHWIntern.getHas_OSPORTS_IN().getName() + "_In_" + myHWIntern.getType() + "\n";
    		}
    		catch (java.lang.ClassCastException e){

        	}
    		try{
    			shootingmachineemfmodel.Motor myMotor =  (Motor) mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j);
    			retstring += "#define " + myMotor.getHas_OSPORTS_OUT().getName() + "PORT "+ mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname() + "\n"
    					+ "#define " + myMotor.getHas_OSPORTS_OUT().getName() + "_Out_ENGINE\n";

    		}
    		catch (java.lang.ClassCastException e){

        	}
    		try{
    			shootingmachineemfmodel.Display myDisplay = (Display) mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j);
    			retstring += "#define " + myDisplay.getHas_OSPORTS_OUT().getName() + "PORT "+ mySystem.getHasBrick().get(Brickindex).getHasHWPortsBrick().get(j).getPortname() + "\n"
    					+ "#define " + myDisplay.getHas_OSPORTS_OUT().getName() + "_Out_DSIPLAY\n";
    		}
    		catch (java.lang.ClassCastException e){

        	}
    	}

    	System.out.print(retstring);

    	return retstring;
    }

    public static void main(String[] args) {
        // Create a resource set to hold the resources.
        //
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file extensions.
        //
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
            (Resource.Factory.Registry.DEFAULT_EXTENSION,
             new XMIResourceFactoryImpl());

        // Register the package to ensure it is available during loading.
        //
        resourceSet.getPackageRegistry().put
            (ShootingmachineemfmodelPackage.eNS_URI,
             ShootingmachineemfmodelPackage.eINSTANCE);

        File file = new File("C:\\Users\\Magee\\Documents\\YASA\\Modell\\runtime-EclipseApplication\\RemoteSystemsTempFiles\\My.shootingmachineemfmodel");
        URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI("My.shootingmachineemfmodel");




        try {
            // Demand load resource for this file.
            //
            Resource resource = resourceSet.getResource(uri, true);

            ToplevelSystem mySystem = (ToplevelSystem)resource.getContents().get(0);
        	//initialisierungen fuer die Hashes
            for(int i = 0; i < mySystem.getHasComponent().size(); i++)
            {
            	for(int j = 0; j < mySystem.getHasComponent().get(i).getHasRunnable().size(); j++)
            	{
            		 for(int k = 0; k < mySystem.getHasComponent().get(i).getHasRunnable().get(j).getHasSWPorts().size(); k++)
            		 {
            			 PortRunnable.put(mySystem.getHasComponent().get(i).getHasRunnable().get(j).getHasSWPorts().get(k).getName(), mySystem.getHasComponent().get(i).getHasRunnable().get(j).getName());
            		 }
            	}
            }

            //Weitere Initialisierungen
            for (int j = 0; j < mySystem.getHasConnections().size(); j++)
            {
            	for(int k = 0; k < mySystem.getHasConnections().get(j).getHasReceiverPorts().size();k++)
            	{
            		EventPort.put(mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName() + "_EVENT", mySystem.getHasConnections().get(j).getHasReceiverPorts().get(k).getName());
            	}
            }

            //Und noch mehr Hashes initialisieren
            for(int i = 0; i < mySystem.getHasBrick().size(); i++)
            {
            	int Brickindex = i;
	            for(int j = 0; j < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().size(); j++)
	            {
	            	for(int k = 0; k < mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().size(); k++)
	                {
	            		RunnablesToTask.put(mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getHasRunnable().get(k).getName(), mySystem.getHasBrick().get(Brickindex).getHasTaskBrick().get(j).getName());
	                }
	            }
            }

            for(int i = 0; i < mySystem.getHasConnections().size(); i++)
            {
            	//for(int j = 0; j < mySystem.getHasConnections().get(i).getHasInterBrickCommunicationSystem().size(); j++)
            	if(mySystem.getHasConnections().get(i).getHasInterBrickCommunicationSystem() != null)
            	{
            		System.out.print("Test");
            		for(int k = 0; k < mySystem.getHasConnections().get(i).getHasInterBrickCommunicationSystem().getHasReceiverPort().size(); k++)
            		{
            			if(!PortToID.containsKey(mySystem.getHasConnections().get(i).getHasInterBrickCommunicationSystem().getHasReceiverPort().get(k).getName()))
            				PortToID.put(mySystem.getHasConnections().get(i).getHasInterBrickCommunicationSystem().getHasReceiverPort().get(k).getName(), i + k );
            		}
            	}

            }
            for(int i = 0; i < mySystem.getHasBrick().size();i++)
            	for(int j = 0; j < mySystem.getHasBrick().get(i).getHasTaskBrick().size(); j++)
            		TaskBrick.put(mySystem.getHasBrick().get(i).getHasTaskBrick().get(j).getName(), i);

            //also making a hashmap with ID to port
            for(String key : PortToID.keySet())
            {
            	IDToPort.put(PortToID.get(key), key);
            }
            /*
             *
             * HASHES FERTIG
             *
             */


            //For Schleife in welcher die einzelnen Dateien und Ordner erstellt werden
            for(int i = 0; i<mySystem.getHasBrick().size(); i++)
            {

                String Brickname = mySystem.getHasBrick().get(i).getName();
                //Ordnername = Name des Bricks
                File BrickFolder = new File(Brickname);

                //Ordner erstellen, falls noch nicht vorhanden
                if(!BrickFolder.exists()){
                    BrickFolder.mkdir();
                    System.out.print("Ordner " + Brickname + " erstellt\n");
                }
                else //Wenn Ordner schon vorhanden ist, Ordner mit Dateien vorher loeschen
                {
                    deleteDir(BrickFolder);
                    BrickFolder.mkdir();
                    System.out.print("Ordner " + Brickname + " rekursiv geloescht und neu erstellt\n");
                }

                /*
                 *
                 *
                 * YASA_global_variables und implementation.oil kopieren
                 *
                 *
                 */

                File global_variables_src = new File("..\\..\\..\\Code\\include\\YASA_global_variables.h");
                File global_variables_dest = new File(Brickname + "\\YASA_global_variables.h");

                Files.copy(global_variables_src.toPath(), global_variables_dest.toPath());

                File implementation_oil_src = new File("..\\..\\..\\Code\\include\\implementation.oil");
                File implementation_oil_dest = new File(Brickname + "\\implementation.oil");

                Files.copy(implementation_oil_src.toPath(), implementation_oil_dest.toPath());


                setPortDefines(mySystem, i);

                /*
                *
                * Dynamischen C-Code Erzeugen
                *
                *
                */
               List <String> dynamiccStrings = generatedynamiccFile(mySystem, i, Brickname);


               String genc = dynamiccStrings.get(0);
               String mySenderrtefunc = dynamiccStrings.get(1);
               String myReceiverrtefunc = dynamiccStrings.get(2);


                /*
                 *
                 * Erzeugung oil File:
                 *
                 *
                 */
                List <String> oilStrings = generateOilFile(mySystem, i, Brickname);


                //Dateipfad + Dateiname
                File OilFile = new File(Brickname + "\\" + Brickname + ".oil");
                if (!OilFile.exists()) {
                    OilFile.createNewFile();
                }


                //BufferedWriter
                FileWriter oilFileWriter = new FileWriter(OilFile.getAbsoluteFile());
                BufferedWriter oilFileBuffer = new BufferedWriter(oilFileWriter);

                for(int listindex = 0; listindex < oilStrings.size(); listindex ++)
                {
                	oilFileBuffer.write(oilStrings.get(listindex));
                }

                oilFileBuffer.close();



                /*
                 *
                 * Erzeugung c File
                 *
                 *
                 */
                List <String> cStrings = generatecFile(mySystem, i, Brickname);

                //Dateipfad + Dateiname
            	File cFile = new File(Brickname + "\\" + Brickname + ".c");

            	//Datei erstellen, wenn noch nicht vorhanden
                if (!cFile.exists()) {
                    cFile.createNewFile();
                }

                //BufferedWriter
                FileWriter cFileWriter = new FileWriter(cFile.getAbsoluteFile());
                BufferedWriter cFileBuffer = new BufferedWriter(cFileWriter);

                //Sry Flo mir ist nichts besseres eingefallen
                cFileBuffer.write(cStrings.get(0));
                cFileBuffer.write(cStrings.get(1));
                cFileBuffer.write(cStrings.get(2));
                cFileBuffer.write(cStrings.get(3));
                cFileBuffer.write(cStrings.get(4));
                cFileBuffer.write(cStrings.get(5));
                cFileBuffer.write(cStrings.get(6));
                cFileBuffer.write(cStrings.get(7));
                cFileBuffer.write("\n//Ab hier werden alle Events und variablen zur Kommunikation eingefuegt:\n");
                cFileBuffer.write(genc);
                cFileBuffer.write(mySenderrtefunc);
                cFileBuffer.write(myReceiverrtefunc);
                cFileBuffer.write(cStrings.get(8));
                cFileBuffer.write(cStrings.get(9));
                cFileBuffer.write(cStrings.get(10));
                cFileBuffer.write(cStrings.get(11));
                cFileBuffer.write(cStrings.get(12));
                cFileBuffer.write(cStrings.get(13));
                cFileBuffer.write(cStrings.get(14));



                cFileBuffer.close();


                /*
                 *
                 * Com Service erzeugen
                 *
                 *
                 */
                List<String> comstrings = generateComService(mySystem,i);

                File genvarfile = new File(Brickname + "\\YASA_generated_variables.h");
                if (!genvarfile.exists()) {
                	genvarfile.createNewFile();
                    System.out.print("\tDatei YASA_generated_variables.c erstellt\n");
                }


                FileWriter genvarfileWriter = new FileWriter(genvarfile.getAbsoluteFile());
                BufferedWriter genvarfileBuffer = new BufferedWriter(genvarfileWriter);
                genvarfileBuffer.write(setPortDefines(mySystem, i));
                genvarfileBuffer.write(comstrings.get(0) + "\n");
                genvarfileBuffer.write(comstrings.get(1) + "\n");
                genvarfileBuffer.write(comstrings.get(2) + "\n");
                genvarfileBuffer.close();
            }
        }
        catch (RuntimeException exception) {
            System.out.println("Problem loading " + uri);
            exception.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
	 * <!-- begin-user-doc -->
     * Prints diagnostics with indentation.
     * <!-- end-user-doc -->
	 * @param diagnostic the diagnostic to print.
	 * @param indent the indentation for printing.
	 * @generated
	 */
    protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

} //ShootingmachineemfmodelExample