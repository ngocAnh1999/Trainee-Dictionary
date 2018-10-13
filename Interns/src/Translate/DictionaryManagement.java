package Translate;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Admin : Đặng Thị Ngọc Ánh
 */

public class DictionaryManagement {
    private final String file = "dictionaries.txt";
    
    public Scanner scan = new Scanner(System.in);
    
    // hàm đọc dữ liệu từ bàn phím
    public void insertFromCommandline() {
		System.out.println("Nhap vao so tu: ");
		int numberWord = scan.nextInt();
		scan.nextLine();
		//Dictionary diction = new Dictionary();
		
		for(int i = 0; i < numberWord; i++) {
			Words newWord = new Words(scan.nextLine() ,scan.nextLine());
			Dictionary.arraysWord.add(newWord);
		}
		scan.close();
	}
    
    // hàm đọc file txt
    public void insertFromFile() {
        BufferedReader br = null;
        try {
            FileInputStream fileInPutStream = new FileInputStream(this.file);
            Reader reader = new java.io.InputStreamReader(fileInPutStream, "UTF-8");
            br = new BufferedReader(reader);
            String ex;
            while ((ex = br.readLine()) != null) {
                if(!ex.contains("\t")) {
                    continue;
                }
                String[] part = ex.split("\t");
                Words word = new Words(part[0], part[1]);
                Dictionary.arraysWord.add(word);
            }
            br.close();
        }
        catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    // hàm tìm kiếm từ vựng xác định
    public void dictionaryLookup() {
        System.out.println("**ENTER your word**");
        String wordfind = scan.nextLine();
        System.out.println("Result : ");
        for (Words word : Dictionary.arraysWord) {
            if(word.getWordTarget().equals(wordfind.toLowerCase())) {
                System.out.println(word.toString());
                return;
            }
        }
        System.out.println("Xin lỗi từ diển của chúng tôi không có từ này,"
                + " bạn có thể nhấn phím 4 để cung cấp thêm nghĩa của từ vào kho từ vựng để phát triển từ điển!"
                + "\n Thanks you! ");
    }
    
    // hàm tìm kiếm danh sách các từ vựng
    public void dictionarySearcher() {
        System.out.println("**SEARCH**");
        String sub_str = scan.nextLine();
        int count = 0;
        for (Words word : Dictionary.arraysWord) {
            if(word.getWordTarget().indexOf(sub_str, 0) == 0) {
                System.out.println(word.toString());
                count++;
            } 
        }
        System.out.println("Find out "+ count + " word");
    }
    
    // hàm sửa từ tronng danh sách
    public void editWordInList() {
        System.out.println("Nhập vào từ cần sửa: ");
        String editWord = scan.nextLine();
        String explain ;
        for (Words word : Dictionary.arraysWord) {
            if(word.getWordTarget().equals(editWord)) {
                System.out.println("Nhập vào nghĩa tiếng việt: ");
                explain = scan.nextLine();
                word.setWordExplain(explain);
                return;
            }
        }
        System.out.println("Nhập vào nghĩa tiếng việt: ");
        explain = scan.nextLine();
        Dictionary.arraysWord.add(new Words(editWord, explain));
    }
    
    // hàm xóa từ tronng danh sách
    public void removeWordInList() {
        System.out.println("Nhập vào từ muốn xóa: ");
        String editWord = scan.nextLine();
        String explain ;
        for (int i = 0; i < Dictionary.arraysWord.size(); i++) {
            if(Dictionary.arraysWord.get(i).getWordTarget().equals(editWord)) {
                Dictionary.arraysWord.remove(i);
                System.out.println("Đã xóa!");
                return;
            }
        }
        System.out.println("Từ này không tồn tại trong từ điển.");
        
    }
    
    // hàm cập nhật dữ liệu ra file
    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file), "UTF-8"));
            for (Words word : Dictionary.arraysWord) {
                bw.write(word.getWordTarget() + "\t" + word.getWordExplain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
}
