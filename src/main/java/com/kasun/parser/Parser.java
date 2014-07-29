package com.kasun.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.process.Process;

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

}
