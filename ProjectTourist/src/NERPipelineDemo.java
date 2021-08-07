

import edu.stanford.nlp.pipeline.*;

import java.util.Properties;
import java.util.stream.Collectors;

public class NERPipelineDemo {

  public static void main(String[] args) {
    // set up pipeline properties
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
    // example customizations (these are commented out but you can uncomment them to see the results

    // disable fine grained ner
    // props.setProperty("ner.applyFineGrained", "false");

    // customize fine grained ner
    // props.setProperty("ner.fine.regexner.mapping", "example.rules");
    // props.setProperty("ner.fine.regexner.ignorecase", "true");

    // add additional rules, customize TokensRegexNER annotator
    // props.setProperty("ner.additional.regexner.mapping", "example.rules");
    // props.setProperty("ner.additional.regexner.ignorecase", "true");

    // add 2 additional rules files ; set the first one to be case-insensitive
    // props.setProperty("ner.additional.regexner.mapping", "ignorecase=true,example_one.rules;example_two.rules");

    // set document date to be a specific date (other options are explained in the document date section)
    // props.setProperty("ner.docdate.useFixedDate", "2019-01-01");

    // only run rules based NER
    // props.setProperty("ner.rulesOnly", "true");

    // only run statistical NER
    // props.setProperty("ner.statisticalOnly", "true");

    // set up pipeline
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    // make an example document
    CoreDocument doc = new CoreDocument("Joe Smith is from Seattle.");
    // annotate the document
    pipeline.annotate(doc);
    // view results
    System.out.println("---");
    System.out.println("entities found");
    for (CoreEntityMention em : doc.entityMentions())
      System.out.println("\tdetected entity: \t"+em.text()+"\t"+em.entityType());
    System.out.println("---");
    System.out.println("tokens and ner tags");
    String tokensAndNERTags = doc.tokens().stream().map(token -> "("+token.word()+","+token.ner()+")").collect(
        Collectors.joining(" "));
    System.out.println(tokensAndNERTags);
  }
}