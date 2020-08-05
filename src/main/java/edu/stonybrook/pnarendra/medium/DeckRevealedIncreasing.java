package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 950
// https://leetcode.com/problems/reveal-cards-in-increasing-order/
public class DeckRevealedIncreasing {
	public int[] deckRevealedIncreasing(int[] deck) {
        int[] answers = new int[deck.length];
        List<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i < deck.length; i++) {
        	positions.add(i);
        }
        Arrays.sort(deck);
        for(int card : deck) {
        	answers[positions.get(0)] = card;
        	positions.remove(0);
        	if(!positions.isEmpty()) {
        		positions.add(positions.remove(0));
        	}
        }
        return answers;
        
    }
	
}

