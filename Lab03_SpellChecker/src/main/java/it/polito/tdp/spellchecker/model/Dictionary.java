package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.text.AbstractDocument.BranchElement;

public class Dictionary {
	
	private LinkedList<String> dictionary;
	
	public Dictionary() {
		
		dictionary = new LinkedList<String>();
		
	}
	
	public void loadDictionary(String language) {
		
		String s;
		
		if(language.equals("English")) {
			s = "src/main/resources/English.txt";
		}else {
			s = "src/main/resources/Italian.txt";
		}
		
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine()) != null) {
				dictionary.add(word);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("Errore nella lettura del file");
		}
			
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		
		List<RichWord> checkWord = new LinkedList<RichWord>();
		
		for(String wi : inputTextList) {
			RichWord word = new RichWord(wi, false);
			for(String si : dictionary) {
				if(si.equals(word.getWord())) {
					word.setCorrect(true);
				}
			}
			checkWord.add(word);
		}
		
		return checkWord;
		
	}
}

