package file.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readValues();
	}
	static void readValues() throws IOException{
		BufferedReader b1 = new BufferedReader( new FileReader("C:\\my_git_repos\\1707_july05_java\\David_Vollmar_Code\\workspace\\Assignment1\\src\\file\\io\\names.txt"));
		String s1 = null;
		try{
			HashMap<Integer, Employee> hm = new HashMap<>();
			while((s1 = b1.readLine()) != null){
				StringTokenizer	st = new StringTokenizer(s1, ":");//string , delimiter
				while(st.hasMoreTokens()){
					Employee employee = new Employee(Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken() );
					hm.put(employee.getId(), employee);
				}
			}
			for(Entry<Integer, Employee> e : hm.entrySet()){
				System.out.println("Key:"+e.getKey() + " Values:" +e.getValue().getFirstName() +", " +e.getValue().getLastName()+", " +e.getValue().getRole());
			}
			//System.out.println(hm);
		}
		catch (IOException e){
			e.printStackTrace();
		}finally{
			b1.close();
		}
		
	}
}
