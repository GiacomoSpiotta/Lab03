package it.polito.tdp.spellchecker.model;

public class RichWord {

	public String word;
	public boolean isCorrect;
	
	public RichWord(String word, boolean isCorrect) {
		super();
		this.word = word;
		this.isCorrect = isCorrect;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
