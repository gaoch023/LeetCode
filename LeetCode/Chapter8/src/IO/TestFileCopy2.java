package IO;

import java.io.*;

public class TestFileCopy2 {

	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			fis=new FileInputStream("F:\\FFOutput\\1.PNG");
			fos=new FileOutputStream("F:\\FFOutput\\2.PNG");
			
			/*isr=new InputStreamReader(fis);
			osw=new OutputStreamWriter(fos);
			
			br=new BufferedReader(isr);
			bw=new BufferedWriter(osw);
			String str =null;
			while((str=br.readLine())!=null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}*/
			
			
			byte[] bytes=new byte[1024];
			int len=0;
			
			while((len=fis.read(bytes))!=-1){
				fos.write(bytes, 0, len);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			if(isr!=null)
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(osw!=null)
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			
			
		}
	}
}
