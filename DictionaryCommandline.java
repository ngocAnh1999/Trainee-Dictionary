
package Translate;

import java.util.Scanner;

/**
 *
 * @author Admin : Cao Thị Ngọc Huyền
 */
public class DictionaryCommandline {
    // hàm in ra danh sách từ điển
    public void showAllWords( ) {
		String s1 = "No", s2 = "|", s3 = "Eglish", s4 = "Vietnamese";
		      System.out.println("_:::::::::::: DANH SÁCH TỪ VỰNG TRONG KHO :::::::::::::_");
		System.out.printf("%-7s%-1s%-20s%-1s%-40s",s1 ,s2 ,s3 , s2, s4);
		System.out.println("");
		for(int i = 0; i < Dictionary.arraysWord.size(); i++)
		{
			Words getWord = Dictionary.arraysWord.get(i);
			System.out.printf("%-7d%-1s%-20s%-1s%-40s", i+1, s2 , getWord.getWordTarget(), s2 , getWord.getWordExplain() );
			System.out.println("");
		}
		System.out.println("____________________________________________________________________");
		
	}
	// gọi hàm nhập Words từ bàn phím và hàm in ra danh sách
	public void  dictionaryBasic() {
		DictionaryManagement dicM;
                dicM = new DictionaryManagement();
		dicM.insertFromCommandline();
		showAllWords();
	}
        
        // phiên bản cải tiến commandline verson 2
        public void dictionaryAdvanced() {
            DictionaryManagement dicM;
            dicM = new DictionaryManagement();
            Scanner scan = new Scanner(System.in);
            dicM.insertFromFile();
            System.out.println("Nhấn một trong các phím sau để lựa chọn chức năng mà bạn cần: "
                    + "\n Press 1 : in ra danh sách từ điển; \n Press 2 : Tra từ cụ thể; "
                    + "\n Press 3 : Tìm kiếm danh sách các từ bắt đầu với chuỗi vừa nhập;"
                    + "\n Press 4 : chỉnh sửa và thêm từ vào từ điển; "
                    + "\n Press 5 : xóa từ trong danh sách;"
                    + "\n Chọn 1 số bất kì để dừng chương trình trừ các phím chức năng trên.");
            
            int key = scan.nextInt();
            do{    
                
                switch(key) {
                                case 1: showAllWords(); break;
                                case 2: dicM.dictionaryLookup(); break;
                                case 3: dicM.dictionarySearcher(); break;
                                case 4: dicM.editWordInList(); break;
                                case 5: dicM.removeWordInList(); break;
                                case 6: dictionaryBasic(); break;
                                default: break;
                }
                dicM.dictionaryExportToFile();
                System.out.println("***********MENU*********"
                    + "\n Press 1 : in ra danh sách từ điển;"
                    + "\n Press 2 : Tra từ cụ thể; "
                    + "\n Press 3 : Tìm kiếm danh sách các từ bắt đầu với chuỗi vừa nhập;"
                    + "\n Press 4 : chỉnh sửa và thêm từ vào từ điển; "
                    + "\n Press 5 : xóa từ trong danh sách;"
                    + "\n Chọn 1 số bất kì để dùng chương trình trừ các phím chức năng trên.");
                key = scan.nextInt();
            }
            while(key == 1 || key == 2 || key == 3 || key == 4 || key == 5 || key == 6);
             /** in ra 1 bảng danh sách hướng dẫn sử dụng các hàm phía dưới
              * tạo 1 vòng do while lồng vào switch case để chạy từng hàm theo yêu cầu của đề bài 
              * gồm các hàm :
              * 1 : showAllWords();
              * 2 : dicM.dictionaryLookup();
              * 3 : dicM.dictionarySearcher();
              * 4 : dicM.editWordInList();
              * 5 : dicM.removeWordInList();
              * 6 :  dictionaryBasic();
              * default : thoát khỏi toàn bộ chương trình
              * trường hợp dừng while là số nhập vào không hợp lệ với các số ở trên
              * sau Switch thì cập nhật ra file bằng hàm:
              * dicM.dictionaryExportToFile();
              */
             
        }
}
