/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarymanagement;

/**
 *
 * @author Admin: Cao Thị Ngọc Huyền
 */
public class Words {
    private String word_target;
	private String word_explain;
	// ham setter line 7:13
	public void setWordTarget(String word_target) {
		this.word_target = word_target;
	}
	
	public void setWordExplain(String word_explain) {
		this.word_explain = word_explain;
	}
	// ham getter line 15:16
	public String getWordTarget() { return this.word_target; }
	public String getWordExplain() { return this.word_explain; }
	// khoi tao khong tham so
	public Words(String word_target, String word_explane) {
		this.word_target = word_target;
		this.word_explain = word_explane;
	}

    @Override
    public String toString() {
        return this.word_target + ": " + this.word_explain; 
    }
}
