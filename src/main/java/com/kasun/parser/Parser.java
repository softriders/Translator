package com.kasun.parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.process.Process;
import com.kasun.process.logics.ProcessLogic;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.trees.Tree;

public class Parser {
	
	private static final Logger log = LoggerFactory.getLogger(Parser.class);
	
	private final static String PCG_MODEL = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";

	private final TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer
			.factory(new CoreLabelTokenFactory(), "invertible=true");

	private final LexicalizedParser parser = LexicalizedParser
			.loadModel(PCG_MODEL);

	public Tree parse(String str) {
		List<CoreLabel> tokens = tokenize(str);
		Tree tree = parser.apply(tokens);
		return tree;
	}

	private List<CoreLabel> tokenize(String str) {
		Tokenizer<CoreLabel> tokenizer = tokenizerFactory
				.getTokenizer(new StringReader(str));
		return tokenizer.tokenize();
	}

	public static String[] getPattern(String sentece) {
		String in = "I went home";
		String[] pattn = null;

		ArrayList<String> pattern = new ArrayList<String>();

		String[] str = new String[1];
		str[0] = sentece;

		Parser parser = new Parser();
		for (int j = 0; j < str.length; j++) {
			// Parser parser = new Parser();
			Tree tree = parser.parse(str[j]);

			List<Tree> leaves = tree.getLeaves();
			// Print words and Pos Tags
			for (Tree leaf : leaves) {
				Tree parent = leaf.parent(tree);
				log.info(leaf.label().value() + "-"
						+ parent.label().value() + " ");
				pattern.add(parent.label().value());
			}
			pattn = (String[]) pattern.toArray(new String[pattern.size()]);
			System.out.println();
		}

		return pattn;
	}
	public static void main(String[] args){
		String sentence="I just ate rice";
		String[] sentenceAsArray=ProcessLogic.splitSentence(sentence);
		String[] pattern=getPattern(sentence);
		for(int i=0;i<pattern.length;i++){
			System.out.print(sentenceAsArray[i]+"-"+pattern[i]+" ");
		}
		System.out.println(predictTense(pattern));
	}
	public static String predictTense(String[] pattern){
		for(int i=0;i<pattern.length;i++){
			//simple present tense-ASMPRT
			if(pattern[i].equals("VBP") || pattern[i].equals("VBP")) {
				return "ASMPRT" ;
			}
			//simple past tense-ASMPST
			else if(pattern[i].equals("VBD")){
				return "ASMPST";
			}
			//simple future tense-ASMFT
			else if(pattern[i].equals("MDbe") && 
					(pattern[i+1].equals("VB") || (pattern[i+1].equals("RB") && pattern[i+2].equals("VB")))){
				return "ASMFT";
			}
			//Present Perfect tense-APRPFT
			else if((pattern[i].equals("VBPpos") || pattern[i].equals("VBZpos")) 
					&& (pattern[i+1].equals("VBN") || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBN"))
							)){
				return "APRPFT";
			}
			//past Perfect tense-APSPFT
			else if(pattern[i].equals("VBDpos") && 
					(
							(pattern[i+1].equals("VBN") || pattern[i+1].equals("VBNbeen")) ||
							(
									(pattern[i+1].equals("RB") && 
											(pattern[i+2].equals("VBN") || pattern[i+2].equals("VBNbeen"))
									)
							)
					)
					){
				return "APSPFT";
			}
			//future Perfect tense- AFPFT
			else if(pattern[i].equals("MDbe") && 
					(
							(pattern[i+1].equals("VBpos") && (pattern[i+2].equals("VBN") || pattern[i+2].equals("VBNbeen"))) || 
							((pattern[i+1].equals("RB") && pattern[i+2].equals("VBpos")) && 
									(pattern[i+3].equals("VBN") || pattern[i+3].equals("VBNbeen"))
							)
					)
					){
				return "AFPFT";
			}

			//Present continuous tense-APRCT
			else if((pattern[i].equals("MDbe") || pattern[i].equals("VBZbe")) &&
					(pattern[i+1].equals("VBG") || (pattern[i+1].equals("RB") && pattern[i+2].equals("VBG")))
					){
				return "APRCT";
			}
			//past continuous tense-APSCT
			else if(pattern[i].equals("VBD") &&
					(pattern[i+1].equals("VBG") || (pattern[i+1].equals("RB") && pattern[i+2].equals("VBG")))
					){
				return "APSCT";
			}
			//future continuous tense-AFCT
			else if(pattern[i].equals("MDbe")  &&
					(pattern[i+1].equals("VBbe") && (pattern[i+2].equals("VBG")) || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBbe") && pattern[i+3].equals("VBG")))
					){
				return "AFCT";
			}
			//Present perfect continuous-APRPFCT
			else if((pattern[i].equals("VBPpos") || pattern[i].equals("VBZpos")) && 
					((pattern[i+1].equals("VBNbeen") && pattern[i+2].equals("VBG")) || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBNbeen") && pattern[i+3].equals("VBG")))
					){
				return "APRPFCT";
			}
			//Past perfect continuous-APSPFCT
			else if((pattern[i].equals("VBDpos") || pattern[i].equals("VBZpos")) && 
					((pattern[i+1].equals("VBNbeen") && pattern[i+2].equals("VBG")) || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBNbeen") && pattern[i+3].equals("VBG")))
					){
				return "APSPFCT";
			}
			//Future perfect continuous-AFPFCT
			else if(pattern[i].equals("MDbe") && (
				(pattern[i+1].equals("VBpos") && pattern[i+2].equals("VBNbeen") && pattern[i+3].equals("VBG")) || 
				(pattern[i+1].equals("RB") && pattern[i+2].equals("VBpos") && pattern[i+3].equals("VBNbeen") && pattern[i+4].equals("VBG"))
				)
				){
				return "AFPFCT";
			}
		}
/*		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)))) {
		    out.println("the text");
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
		*/
		return "NOT FOUND";
	}

}
