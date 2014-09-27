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
				pattern.add(modifyParserOutput(parent.label().value(),leaf.label().value()));
			}
			pattn = (String[]) pattern.toArray(new String[pattern.size()]);
			System.out.println();
		}

		return pattn;
	}
//	public static void main(String[] args){
//		String sentence="His father has gone home with my brother";
//		String[] sentenceAsArray=ProcessLogic.splitSentence(sentence);
//		String[] pattern=getPattern(sentence);
//		for(int i=0;i<pattern.length;i++){
//			System.out.print(i+" "+sentenceAsArray[i]+"-"+pattern[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<4;i++){
//			System.out.print(predictTense(pattern)[i]+" ");
//		}
//		System.out.println();
//		String[][] finalOtpt= splitSentence(sentence,predictTense(pattern));
//		for(int i=0;i<finalOtpt.length;i++){
//			for(int j=0;j<finalOtpt[i].length;j++){
//				System.out.print(finalOtpt[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
	
	public static String[] predictTense(String[] pattern){
		String[] prediction=new String[4];
		//0-tense,1-index of RB in verb,2-vrb starting index,3-obj starting index
		for(int i=0;i<pattern.length;i++){
			
			//simple present tense-ASMPRT
			if(pattern[i].equals("VBP") || pattern[i].equals("VBZ")) {
				return  setPrediction("ASMPRT",0,i,i+1);
			}
			//simple past tense-ASMPST
			else if(pattern[i].equals("VBD")){
				return  setPrediction("ASMPST",0,i,i+1);
			}
			//simple future tense-ASMFT
			else if(pattern[i].equals("MDbe") && 
					(pattern[i+1].equals("VB") || (pattern[i+1].equals("RB") && pattern[i+2].equals("VB")))){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("ASMFT",i+1,i,i+3);
				}
				return  setPrediction("ASMFT",0,i,i+2);
			}
			

			//Present continuous tense-APRCT
			else if((pattern[i].equals("MDbe") || pattern[i].equals("VBZbe") || pattern[i].equals("VBPbe")) &&
					(pattern[i+1].equals("VBG") || (pattern[i+1].equals("RB") && pattern[i+2].equals("VBG")))
					){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("APRCT",i+1,i,i+3);
				}
				return  setPrediction("APRCT",0,i,i+2);
			}
			//past continuous tense-APSCT
			else if(pattern[i].equals("VBDbe") &&
					(pattern[i+1].equals("VBG") || (pattern[i+1].equals("RB") && pattern[i+2].equals("VBG")))
					){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("APSCT",i+1,i,i+3);
				}
				return  setPrediction("APSCT",0,i,i+2);
			}
			//future continuous tense-AFCT
			else if(pattern[i].equals("MDbe")  &&
					(pattern[i+1].equals("VBbe") && (pattern[i+2].equals("VBG")) || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBbe") && pattern[i+3].equals("VBG")))
					){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("AFCT",i+1,i,i+4);
				}
				return  setPrediction("AFCT",0,i,i+3);
			}
			//Present perfect continuous-APRPFCT
			else if((pattern[i].equals("VBPpos") || pattern[i].equals("VBZpos")) && 
					((pattern[i+1].equals("VBNbeen") && pattern[i+2].equals("VBG")) || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBNbeen") && pattern[i+3].equals("VBG")))
					){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("APRPFCT",i+1,i,i+4);
				}
				return  setPrediction("APRPFCT",0,i,i+3);
			}
			//Past perfect continuous-APSPFCT
			else if((pattern[i].equals("VBDpos") || pattern[i].equals("VBZpos")) && 
					((pattern[i+1].equals("VBNbeen") && pattern[i+2].equals("VBG")) || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBNbeen") && pattern[i+3].equals("VBG")))
					){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("APSPFCT",i+1,i,i+4);
				}
				return  setPrediction("APSPFCT",0,i,i+3);
			}
			//Future perfect continuous-AFPFCT
			else if(pattern[i].equals("MDbe") && (
				(pattern[i+1].equals("VBpos") && pattern[i+2].equals("VBNbeen") && pattern[i+3].equals("VBG")) || 
				(pattern[i+1].equals("RB") && pattern[i+2].equals("VBpos") && pattern[i+3].equals("VBNbeen") && pattern[i+4].equals("VBG"))
				)
				){
				
				if(pattern[i+1].equals("RB")){
					//System.out.println("came");
					return  setPrediction("AFPFCT",i+1,i,i+5);
				}
				System.out.println("came");
				return  setPrediction("AFPFCT",0,i,i+4);
			}
			//Present Perfect tense-APRPFT
			else if((pattern[i].equals("VBPpos") || pattern[i].equals("VBZpos")) 
					&& (pattern[i+1].equals("VBN") || 
							(pattern[i+1].equals("RB") && pattern[i+2].equals("VBN"))
							)){
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("APRPFT",i+1,i,i+3);
				}
				return  setPrediction("APRPFT",0,i,i+2);
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
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("APSPFT",i+1,i,i+3);
				}
				return  setPrediction("APSPFT",0,i,i+2);
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
				
				if(pattern[i+1].equals("RB")){
					return  setPrediction("AFPFT",i+1,i,i+4);
				}
				return  setPrediction("AFPFT",0,i,i+3);
			}
		}
/*		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)))) {
		    out.println("the text");
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
		*/
		return prediction;
	}
	public static String[] setPrediction(String tense,int RBIndex,int vrbIndex,int objIndex){
		//0-tense,1-index of RB in verb,2-vrb starting index,3-obj starting index
		String[] prediction=new String[4];
		prediction[0]=tense;
		prediction[1]=""+RBIndex;
		prediction[2]=""+vrbIndex;
		prediction[3]=""+objIndex;
		
		return prediction;
	}
	public static String modifyParserOutput(String wordDecript,String word){
                //in case of a be verb
                if(wordDecript.equals("VBZ")) {
                	if(ProcessParserOutput.isABeVerb(word)){
                		wordDecript= "VBZbe";
                	}
                	else if(ProcessParserOutput.isAPossesiveVerb(word)){
                		wordDecript= "VBZpos";
                	}
                }
                else if( wordDecript.equals("VBP")) {
                	if(ProcessParserOutput.isABeVerb(word)){
                		wordDecript= "VBPbe";
                	}
                	else if(ProcessParserOutput.isAPossesiveVerb(word)){
                		wordDecript= "VBPpos";
                	}
                }
                else if(wordDecript.equals("VB")){
                	//in case of verb 'be'
                	if(word.equals("be")){
                		wordDecript="VBbe";
                	}
                	//in case of has have
                	else if(ProcessParserOutput.isAPossesiveVerb(word)){
                		wordDecript="VBpos";
                	}
                	
                }
                else if(wordDecript.equals("VBN")){
                	if(word.equals("been"))
                		wordDecript="VBNbeen";
                }
                else if(wordDecript.equals("MD")){
                	if(ProcessParserOutput.isABeVerb(word)) 
                		wordDecript="MDbe";
                }
                else if (wordDecript.equals("VBD")){
                	if(word.equals("had")){
                		wordDecript="VBDpos";
                	}
                	else if(ProcessParserOutput.isABeVerb(word)){
                		wordDecript="VBDbe";
                	}
                }
                
                return wordDecript;
       }
	public static String[][] splitSentence(String sentence,String[] prediction){
		String[] words = ProcessLogic.splitSentence(sentence);
		String[][] sentenceDecrpt=new String[4][];
		String[] tense=new String[1];
		tense[0]=prediction[0];
		sentenceDecrpt[0]=tense;
		int i=0;
		int subIndex=Integer.parseInt(prediction[2]);
		String[] sub=new String[subIndex];
		
		//subject
		for(;i<subIndex;i++){
			sub[i]=words[i];
		}
		sentenceDecrpt[1]=sub;
		int vrbIndex=Integer.parseInt(prediction[3]);
		String[] vrb=new String[vrbIndex-subIndex];
		
		//verb
		for(;i<Integer.parseInt(prediction[3]);i++){
			vrb[i-subIndex]=words[i];
		}
		sentenceDecrpt[2]=vrb;
		int objIndex=words.length;
		String[] obj=new String[objIndex-vrbIndex];
		
		//object
		for(;i<words.length;i++){
			obj[i-vrbIndex]=words[i];
		}
		sentenceDecrpt[3]=obj;
	
		return sentenceDecrpt;
	}
}
