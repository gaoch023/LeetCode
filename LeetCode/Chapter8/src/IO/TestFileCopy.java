package IO;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
/**
 * Reader and Writer
 * @author Gaochao
 *
 */
public class TestFileCopy {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader bfr = null;
		FileWriter fw=null;
		BufferedWriter bfw=null;
		try {
			fr = new FileReader("F:\\FFOutput\\1.PNG");
			fw=new FileWriter("F:\\FFOutput\\2.PNG");
			/*
			 * int len=0; while((len=fr.read())!=-1){
			 * System.out.print((char)len); }
			 */

			bfr = new BufferedReader(fr);
			bfw=new BufferedWriter(fw);
			String str = null;
			/*
			 * int len = 0; char[] bytes = new char[1024]; while ((len =
			 * bfr.read(bytes)) != -1) { System.out.println(new String(bytes, 0,
			 * len)); }
			 */
			while ((str = bfr.readLine()) != null){
				bfw.write(str);
				bfw.newLine();
				bfw.flush();
			}
			
			
			
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bfr != null)
				try {
					bfr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (bfw != null)
				try {
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}