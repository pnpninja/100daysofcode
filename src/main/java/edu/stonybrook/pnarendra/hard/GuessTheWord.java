package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Master {
	 String secret;
	 
	 public Master(String secret) {
		 this.secret = secret;
	 }
     public int guess(String word) {
    	 int matches = 0;
         for(int i = 0; i < secret.length(); i++){
             if(secret.charAt(i) == word.charAt(i)){
                 matches++;
             }
         }
         return matches;
     }
}

public class GuessTheWord {
	
	public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new ArrayList<String>();
        for(int i = 0; i < wordlist.length; i++) {
        	words.add(wordlist[i]);
        }
        
        while(words.size() > 1) {
        	String t = words.remove(0);
        	int matchNos = master.guess(t);
        	if(matchNos == t.length()) {
        		break;
        	}else {
        		List<String> newWords = new ArrayList<String>();
        		for(int i = 0; i < words.size();i++) {
        			String x = words.get(i);
        			if(match(t,x) >= matchNos) {
        				newWords.add(x);
        			}
        		}
        		words = newWords;
        		Collections.shuffle(words);
                Collections.shuffle(words);
        	}
        	
        }

    }
    
    private int match(String word1, String word2){
        int matches = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) == word2.charAt(i)){
                matches++;
            }
        }
        return matches;
    }
    
    public static void main(String[] args) {
		Master master = new Master("ccoyyo");
		String[] wordlist = {"wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb","xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro","nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg","tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp","szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd","vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc","kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm","jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb","ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf","chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq"};
		new GuessTheWord().findSecretWord(wordlist, master);
	}

}
